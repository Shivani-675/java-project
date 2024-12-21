public class incre2 {
    public static void main(String[] args) {
        int a=1,b=2,c,d;
        c=++b;
        d=a++;
        c++;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        int x=2;
        x+=x++ + ++x/2;
        System.out.println(x);
        int y=5;
        y+=--y + y-- + --y;
        System.out.println(y);
   }
}
