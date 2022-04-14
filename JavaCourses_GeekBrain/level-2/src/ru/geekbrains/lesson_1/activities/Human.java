package ru.geekbrains.lesson_1.activities;

public class Human implements Activity{
    private int high;
    private int width;

    public Human(int high, int width) {
        this.high = high;
        this.width = width;
    }

    @Override
    public int jump() {
        return this.high;
    }

    @Override
    public int run() {
        return this.width;
    }
}
