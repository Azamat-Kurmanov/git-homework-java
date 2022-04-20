package ru.geekbrains.lesson_2.arrayExceptions;

public class ArrayValidation {
    public static void main(String[] args) {
        String[][] array = {
                            {"1", "2", "3", "5"},
                            {"1", "2", "6", "4"},
                            {"1", "8", "5", "4"},
                            {"5", "2", "3", "1"}
//                            , {"1", "2", "3", "4"}
                           };
        checkArray(array);
    }

    //----Проверка размера массива
    public static void checkArray(String[][] array) {
        int length = 4*4;
        int countElements = 0;
        for (String[] elements : array) {
            countElements+=elements.length;
        }
//        System.out.println("countElements = " + countElements + " length: " + length);
        if (length != countElements){
            throw new MyArraySizeException();
        } else {
            System.out.println("sum = " + goThrowArray(array));
        }
    }

    //------Проход по всему массиву и суммирование значений
    public static int goThrowArray(String[][] array){
        int counter = 0;
        for(int i=0;i<array.length;i++) {
            for(int j=0; j<array.length; j++){
                counter += checkFormat(i, j, array[i][j]);
            }
        }
        return counter;
    }

    //-----Проверка на соответствие типа значения
    public static int checkFormat(int i, int j, String arrayValue){
        int indexes;
        try {
            indexes = Integer.parseInt(arrayValue);
        } catch (NumberFormatException exception){
            throw new MyArrayDataException(i, j);
        }
        return indexes;
    }
}
