import java.util.Scanner;

public class singledimension {
    public static void main(String[] args) 
    {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int size = scanner.nextInt();
        int[] array=new int[size];
        System.out.println("Enter "+size+" elements");
        for(int i=0;i<size;i++)
        {
            array[i]=scanner.nextInt();
        }
        System.out.println("The elements of the array are:");
        for(int i=0;i<size;i++)
        {
            System.out.println(array[i]+" ");
        }
        scanner.close();
    }
}
