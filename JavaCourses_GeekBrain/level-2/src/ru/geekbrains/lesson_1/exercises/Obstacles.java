package ru.geekbrains.lesson_1.exercises;

import ru.geekbrains.lesson_1.activities.Activity;

public interface Obstacles {
    String treadmillTitle = "Беговой дорожке";
    String wallTitle = "Стену";
    boolean getResult(Activity activity);
}
