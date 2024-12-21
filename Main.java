public class Main {
    public static void main(String[] args) {
    Main m1 = new Main();
    Main m2 = m1;
    m1 = null;
    System.gc();
    System.out.println("Done");
    }
    protected void finalize() {
    System.out.println("Finalize method");
    }
   }