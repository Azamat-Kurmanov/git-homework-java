package ru.geekbrains.lesson_1.exercises;

import ru.geekbrains.lesson_1.activities.Activity;

public class Wall implements Obstacles {

    private int high;

    public Wall(int high) {
        this.high = high;
    }

    @Override
    public boolean getResult(Activity activity) {
        if (activity.jump() >= high) {
            System.out.println("Успешно прыгнул через " + Obstacles.wallTitle + " с высотой " + this.high + " м");
        } else {
            System.out.println("Не смог прыгнуть через " + Obstacles.wallTitle + " с высотой " + this.high + " м");
        }
        return activity.jump() >= high;
    }
}
