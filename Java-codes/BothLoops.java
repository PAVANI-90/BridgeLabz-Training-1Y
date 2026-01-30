public class BothLoops {
    public static void main(String[] args) {
        System.out.println("While Loop");
        int i = 1;
        while (i <= 3) {
            System.out.println("While: " + i);
            i++;
        }
        
        System.out.println("\n Do-While Loop");
        int j = 1;
        do {
            System.out.println("Do-While: " + j);
            j++;
        } while (j <= 3);
    }
}
