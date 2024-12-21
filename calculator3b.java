import java.util.*;
public class calculator3b {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter 2 numbers:");
        int a=sc.nextInt();
        int b=sc.nextInt();
        System.out.println("Enter 1 for addition,2 for subtraction,3 for multiplication and 4 for division:");
        int ch=sc.nextInt();
        switch(ch)
        {
            case 1:
               System.out.println(a+"+"+b+"="+(a+b));
               break;
            case 2:
                System.out.println(a+"-"+b+"="+(a-b));
                break;
            case 3:
                System.out.println(a+"*"+b+"="+(a*b));
                break;
            case 4:
                if(b==0)
                {
                    System.out.println("The denominator can't be zero...");
                }
                else
                {
                    System.out.println(a+"/"+b+"="+(double)a/b);
                }
                break;
            default:
                System.out.println("Invalid input......");
                break;
        }
        sc.close();
    }
}
