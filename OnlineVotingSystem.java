import java.util.*;

public class OnlineVotingSystem {
    // Map to store voters and their details
    private static Map<String, Boolean> voters = new HashMap<>();
    // Map to store candidates and their votes
    private static Map<String, Integer> candidates = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize candidates
        initializeCandidates();

        System.out.println("Welcome to the Online Voting System!");

        boolean running = true;
        while (running) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Register Voter");
            System.out.println("2. Cast Vote");
            System.out.println("3. View Results");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerVoter(scanner);
                    break;
                case 2:
                    castVote(scanner);
                    break;
                case 3:
                    viewResults();
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using the Online Voting System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    // Initialize candidates for the election
    private static void initializeCandidates() {
        candidates.put("Alice", 0);
        candidates.put("Bob", 0);
        candidates.put("Charlie", 0);
    }

    // Register a voter
    private static void registerVoter(Scanner scanner) {
        System.out.print("Enter voter ID to register: ");
        String voterID = scanner.nextLine();

        if (voters.containsKey(voterID)) {
            System.out.println("Voter ID already registered.");
        } else {
            voters.put(voterID, false); // False indicates the voter hasn't voted yet
            System.out.println("Voter registered successfully.");
        }
    }

    // Cast a vote
    private static void castVote(Scanner scanner) {
        System.out.print("Enter your voter ID: ");
        String voterID = scanner.nextLine();

        if (!voters.containsKey(voterID)) {
            System.out.println("Voter ID not registered. Please register first.");
            return;
        }

        if (voters.get(voterID)) {
            System.out.println("You have already voted. Multiple votes are not allowed.");
            return;
        }

        System.out.println("\n--- Candidates ---");
        int i = 1;
        for (String candidate : candidates.keySet()) {
            System.out.println(i + ". " + candidate);
            i++;
        }

        System.out.print("Enter the number corresponding to your chosen candidate: ");
        int candidateChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (candidateChoice < 1 || candidateChoice > candidates.size()) {
            System.out.println("Invalid choice. Vote not cast.");
        } else {
            String selectedCandidate = (String) candidates.keySet().toArray()[candidateChoice - 1];
            candidates.put(selectedCandidate, candidates.get(selectedCandidate) + 1);
            voters.put(voterID, true); // Mark the voter as having voted
            System.out.println("Vote cast successfully for " + selectedCandidate + ".");
        }
    }

    // View election results
    private static void viewResults() {
        System.out.println("\n--- Election Results ---");
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " votes");
        }
    }
}
