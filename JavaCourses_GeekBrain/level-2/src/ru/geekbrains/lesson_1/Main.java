package ru.geekbrains.lesson_1;

import ru.geekbrains.lesson_1.activities.Activity;
import ru.geekbrains.lesson_1.activities.Cat;
import ru.geekbrains.lesson_1.activities.Human;
import ru.geekbrains.lesson_1.activities.Robot;

public class Main {

    public static void main(String[] args) {
	    Activity human = new Human();
        Activity cat = new Cat();
        Activity robot = new Robot();

        whoRunOrJump(human, cat, robot);

    }

    public static void whoRunOrJump(Activity ...someone){
        for (Activity activity : someone) {
            System.out.println("Действие: " + activity.run() + ", " + activity.jump());
        }
    }
}
