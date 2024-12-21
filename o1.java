class Demo 
{
    int x = 10;
    Demo(int x)
    {
        this.x = x;
    }
    void print() 
    {
        System.out.println(x);
    }
}
public class o1 
{
    public static void main(String[] args) 
    {
        Demo obj = new Demo(20);
    }
}
