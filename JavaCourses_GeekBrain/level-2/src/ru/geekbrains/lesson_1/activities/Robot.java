package ru.geekbrains.lesson_1.activities;

public class Robot implements Activity{

    @Override
    public String jump() {
        return this.getClass().getSimpleName() + " прыгает";
    }

    @Override
    public String run() {
        return this.getClass().getSimpleName() + " бегает";
    }

}
