package ru.geekbrains.lesson_2.arrayExceptions;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException{

    public MyArraySizeException() {
        System.out.println("The length of the array is not matched to the array.length=4");
    }
}
