package ru.geekbrains.lesson_3;

import java.util.*;

public class Phonebook {
    Map<String, Set<String>> phoneBook = new TreeMap<>();

    public void add(String surname, String phone){
        if (!surname.isEmpty() && !phone.isEmpty()) {
            Set<String> checkSurnames = phoneBook.get(surname);
            if (checkSurnames == null){
                Set<String> singlePhones = new HashSet<>();
                singlePhones.add(phone);
                phoneBook.put(surname, singlePhones);
            } else {
                checkSurnames.add(phone);
                phoneBook.put(surname, checkSurnames);
            }
        }
    }

    public Set<String> get(String surname){
        return phoneBook.get(surname);
    }
}
