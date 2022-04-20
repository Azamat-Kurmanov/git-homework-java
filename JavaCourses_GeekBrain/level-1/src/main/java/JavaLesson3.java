import java.util.Arrays;

public class JavaLesson3 {
    public static void main(String[] args) {
        changeValuesInArr();                       // Задание 1
        listWithHundredElements();                 // Задание 2
        listWithElementsLessSix();                 // Задание 3
        listWithDiagonals();                       // Задание 4
        oneDimensionalArray(8, 5);                 // Задание 5
        findMaxAndMin();                           // Задание 6
        checkBalance(new int[]{1, 1, 1, 2, 1});    // Задание 7
        shiftingArr(new int[]{1,2,3,4,5}, 3);      // Задание 8
    }

    public static void changeValuesInArr() {
        int [] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==1){
                arr[i] = 0;
            }else {
                arr[i]=1;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void listWithHundredElements() {
        int[] elements = new int[100];
        for (int i = 0; i < elements.length; i++){
            elements[i] = i+1;
        }
        System.out.println(Arrays.toString(elements));
    }

    public static void listWithElementsLessSix() {
        int[] elements = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < elements.length; i++){
            if (elements[i]<6){
                elements[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(elements));
    }

    public static void listWithDiagonals() {
        int [][] arr = new int[5][5];
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[i].length; j++){
                if (i==j) {
                    arr[i][j] = 1;
                }
                if (j==arr[i].length - 1 - i){
                    arr[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[] oneDimensionalArray(int len, int initialValue){
        int[] arr = new int[len];
        for (int i=0; i<len; i++){
            arr[i] = initialValue;
        }
//        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static void findMaxAndMin() {
        int[] arr = {65,9,86,92,64,28,1,72,6,33,0,3,8,2,198,10,14};
        int min = arr[0];
        int max = arr[0];

        for (int i=0; i<arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }else if (arr[i]<min){
                min = arr[i];
            }
        }
        System.out.println("max: " + max + " min: " + min);
    }

    public static boolean checkBalance(int[] arr){
        int firstPart = 0;
        int secondPart = 0;

        for (int i=0; i<arr.length; i++){
            if (i<=arr.length-3){
                firstPart += arr[i];
            }else{
                secondPart += arr[i];
            }
        }
//        System.out.println(firstPart == secondPart);
        return firstPart == secondPart;
    }

    public static void shiftingArr(int[] arr, int n) {
        int temp;
            for (int i = 0; i < arr.length; i++) {
                if (n<0 && i<=((n * (-1))-1)) {     //---n = минус число
                    temp = arr[0];

                    for (int j=0; j<arr.length-1; j++) {
                        arr[j] = arr[j + 1];
                    }
                    arr[arr.length - 1] = temp;
                }else if (i<=n-1) {                 //---n = положительное число
                        temp = arr[(arr.length-1)];

                        for (int j=0; j<(arr.length-1)-i; j++){
                            arr[arr.length-1-j] = arr[(arr.length-1)-(j+1)];
                        }
                        arr[i]=temp;
                }
            }

        System.out.println(Arrays.toString(arr) + " " + " n = " + n);
    }
}
