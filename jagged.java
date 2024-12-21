public class jagged {
    public static void main(String[] args) {
        int[][] jaggedarray=new int[3][];
        jaggedarray[0]=new int[3];
        jaggedarray[1]=new int[2];
        jaggedarray[2]=new int[4];
        jaggedarray[0][0]=1;
        jaggedarray[0][1]=2;
        jaggedarray[0][2]=3;
        jaggedarray[1][0]=4;
        jaggedarray[1][1]=5;
        jaggedarray[2][0]=6;
        jaggedarray[2][1]=7;
        jaggedarray[2][2]=8;
        jaggedarray[2][3]=9;
        for(int i=0;i<jaggedarray.length;i++)
        {
            for(int j=0;j<jaggedarray[i].length;j++)
            {
              System.out.println(jaggedarray[i][j]+" ");
            }
            System.out.println("\n");
        }
    
    }
}
