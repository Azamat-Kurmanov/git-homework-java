package ru.geekbrains.lesson_1.exercises;

import ru.geekbrains.lesson_1.activities.Activity;

public class Treadmill implements Obstacles{

    private int width;

    public Treadmill(int width) {
        this.width = width;
    }

    @Override
    public boolean getResult(Activity activity) {
        if (activity.run() >= width){
            System.out.println("Успешно пробежал по " + Obstacles.treadmillTitle + " в длину " + this.width + " км");
        }else{
            System.out.println("Не смог пробежать по " + Obstacles.treadmillTitle + " в длину " + this.width + " км");
        }
        return activity.run() >= width;
    }
}
