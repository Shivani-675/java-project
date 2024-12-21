public class factoriall
{
    static int factorial(int n)
    {
        int res=1,j;
        for(int i=2;i<+n;i++)
        {
            res=res*i;
            return res; 
        }
    }
    public static void main(String[] args)
    {
        int num=7;
        System.out.println("factorial of 5 is "+factorial(num));
    }
}