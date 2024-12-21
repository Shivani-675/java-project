import java.util.Scanner;

public class matrixmul {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of rows for the 1st matrix:");
        int row1=sc.nextInt();
         System.out.println("Enter the number of columns for the 1st matrix:");
        int col1=sc.nextInt();
        int[][] matrix1=new int[row1][col1];
        System.out.println("Enter the matrix elements:");
        for(int i=0;i<row1;i++)
        {
            for(int j=0;j<col1;j++)
            {
               matrix1[i][j]= sc.nextInt();  
            }
        }
        System.out.println("Enter the number of rows for the 2nd matrix:");
        int row2=sc.nextInt();
        System.out.println("Enter the number of columns for the 2nd matrix:");
        int col2=sc.nextInt();
        int[][] matrix2=new int[row2][col2];
        System.out.println("Enter the matrix elements:");
        for(int p=0;p<row2;p++)
        {
            for(int q=0;q<col2;q++)
            {
              matrix2[p][q]=sc.nextInt();
            }
        }
        sc.close();
    }
}
