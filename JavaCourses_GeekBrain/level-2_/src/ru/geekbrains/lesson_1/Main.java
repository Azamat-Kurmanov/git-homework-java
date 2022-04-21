package ru.geekbrains.lesson_1;

import ru.geekbrains.lesson_1.activities.Activity;
import ru.geekbrains.lesson_1.activities.Cat;
import ru.geekbrains.lesson_1.activities.Human;
import ru.geekbrains.lesson_1.activities.Robot;
import ru.geekbrains.lesson_1.exercises.Obstacles;
import ru.geekbrains.lesson_1.exercises.Treadmill;
import ru.geekbrains.lesson_1.exercises.Wall;

public class Main {

    public static void main(String[] args) {
        Obstacles treadmill = new Treadmill(50);
        Obstacles wall = new Wall(20);
        Obstacles[] obstacles = new Obstacles[2];
        obstacles[0] = treadmill;
        obstacles[1] = wall;

	    Activity human = new Human(5, 50);
        Activity cat = new Cat(15, 20);
        Activity robot = new Robot(30, 150);

        whoRunOrJump(obstacles, human, cat, robot);

    }

    public static void whoRunOrJump(Obstacles[] obstacles, Activity ...someone){

        for (Obstacles obstacle : obstacles) {
            for (Activity activity : someone) {
                System.out.println(activity.getClass().getSimpleName() + " пробегает дистанцию в " + activity.run() + " км, прыгает в высоту " + activity.jump() + " м");
                    System.out.println(obstacle.getResult(activity));
            }
            System.out.println("---------End-----------");
        }
    }
}
