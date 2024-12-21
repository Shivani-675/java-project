public class expli1b {
     public static void main(String[] arg)
    {
        //implicit conversion
        //byte to int ()
        byte byteval=10;
        int intval=byteval;
        System.out.println("byte to int "+intval); 
        //explicit conversion
        //target datatype=(targetdatatype)expression;

        //double to float 
        double doubleval=9.76666666;
        float floatval=(float) doubleval;
        System.out.println("double to float"+floatval);
        //float to long
        long longval=(long)floatval;
        System.out.println("float to long "+longval);
        //int to byte
        int intvalue1=140;
        byte byteval1=(byte)intvalue1;
        System.out.println("INT TO BYTE "+byteval1);

    }
}
