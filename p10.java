public class p10 {
    public static void main(String[] args) {
        int[] a={10,20,30};
        for(int x:a)
        {
            x= x+5;
            System.out.println(a[1]);
            System.out.println(a[2]);
        }
        System.out.println(a[0]);
        System.out.println(a[4]);
    }
}
