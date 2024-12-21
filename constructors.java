class rectangle
{
    private double l;
    private double w;
    public rectangle(double l,double w)
    {
        this.l=l;
        this.w=w;
    }
    public double area()
    {
        return l*w;
    }
    public double peri()
    {
        return 2*(l+w);
    }
    public void displayinfo()
    {
        System.out.println("Rectangle[Length:"+l+",Width:"+w+"]");
        System.out.println("Area:"+area());
        System.out.println("Perimeter:"+peri());
    }
}
public class constructors
{
    public static void main(String[] args) {
        rectangle r1=new rectangle(5, 3);
        rectangle r2=new rectangle(7, 4);
        System.out.println("Rectangle 1:");
        r1.displayinfo();
        System.out.println("Rectangle 2:");
        r2.displayinfo();
    }
}