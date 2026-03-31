public class WrapperUnboxTask {
    public static void main(String[] args){

        // Float → float
        Float val1 = 10f;
        float a = val1;
        System.out.println("Float Value: " + a);

        // Double → double
        Double val2 = 20.0;
        double b = val2;
        System.out.println("Double Value: " + b);

        // Character → char
        Character val3 = 'A';
        char str = val3;
        System.out.println("Character Value: " + str);

        // Byte → byte
        Byte val4 = 30;
        byte bb = val4;
        System.out.println("Byte Value: " + bb);

        // Short → short
        Short val5 = 34;
        short d = val5;
        System.out.println("Short Value: " + d);

        // Long → long
        Long val6 = 37L;
        long x = val6;
        System.out.println("Long Value: " + x);

        // Boolean → boolean
        Boolean val7 = true;
        boolean z = val7;
        System.out.println("Boolean Value: " + z);
    }
}