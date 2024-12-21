import java.util.Scanner;

public class quadratic2a {
    public static void main(String[] args)
    {
        int a,b,c;
        double r1,r2;
        System.out.println("Enter the coefficients:");
        Scanner in = new Scanner(System.in);
        a=in.nextInt();
        b=in.nextInt();
        c=in.nextInt();
        double d=(b*b)-(4*a*c);
        System.out.println("Determinant="+d);
        if(d>0)
        {
            System.out.println("Roots are real and distinct");
            r1=(b+Math.sqrt(d))/(2*a);
            r2=(b-Math.sqrt(d))/(2*a);
            System.out.println("Root1="+r1);
            System.out.println("Root2="+r2);
        }
        else if(d==0)
        {
            System.out.println("Roots are real and equal");
            r1=b/(2*a);
            r2=b/(2*a);
            System.out.println("Root1="+r1);
            System.out.println("Root2="+r2);
        }
        else
        {
           System.out.println("Roots are imaginary and complex");
           r1=b/(2*a);
           r2=Math.sqrt(Math.abs(d))/(2*a);
           System.out.println("Root1="+r1+"+i"+r2);
           System.out.println("Root1="+r1+"-i"+r2); 
        }
        in.close();
    }
}
