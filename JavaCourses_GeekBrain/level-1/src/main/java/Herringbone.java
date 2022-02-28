public class Herringbone {
    public static void main(String[] args) {
        int rowCount = 6;
        for (int i = 0; i < rowCount; i++){
            for (int j = 0; j < rowCount - i; j++){
                System.out.print(" ");
            }
            for (int j = 0; j < (i*2); j++){
                System.out.print("*");
            }
            System.out.println("*");
        }

    }
}
