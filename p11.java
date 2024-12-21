public class p11 {
  public static void main(String[] args) {
     int[] a={1,2,3,4,5};
    for(int i=0;i<a.length;i++)
    {
     a[i] = a[i] * 2;
     System.out.println(a[3]);
     a[i]=a[i]+1;
     System.out.println(a[2]);
    }
    System.out.println(a[3]);
  }
}
