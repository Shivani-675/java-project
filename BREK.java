public class BREK {
    public static void main(String[] args) {
        for(int i=0;i<10;i++)
        {
            if(i==5)
            {
                break;
            }
            System.out.println(i);
        }
        System.out.println("\n");
        for(int j=0;j<10;j++)
        {
            if(j%2==0)
            {
                continue;
            }
            System.out.println(j);
        }
    }
}
