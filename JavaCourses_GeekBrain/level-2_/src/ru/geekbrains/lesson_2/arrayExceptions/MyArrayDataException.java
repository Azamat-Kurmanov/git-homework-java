package ru.geekbrains.lesson_2.arrayExceptions;

public class MyArrayDataException extends NumberFormatException{

    private int i;
    private int j;

    public MyArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;
        System.out.println("The format of the value is not matched to int. Indexes are i: " + this.i + " j: " + this.j);
    }
}
