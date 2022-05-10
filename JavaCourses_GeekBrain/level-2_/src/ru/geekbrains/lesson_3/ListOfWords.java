package ru.geekbrains.lesson_3;

import java.util.*;

public class ListOfWords {

    public static void main(String[] args) {
        List<String> words = listOfWords();
        uniqList(words);

        System.out.println("\n //----------------------------------// \n");

        Phonebook phonebook = new Phonebook();
        phonebook.add("Serikov", "87774788838");
        phonebook.add("Serikov", "87014788838");
        phonebook.add("Serikov", "87024755838");
        phonebook.add("Baitasov", "87473688838");
        phonebook.add("Abilov", "87774778645");
        phonebook.add("Safronov", "87015618838");
        phonebook.add("Abilov", "87478833838");
        phonebook.add("Bastaubayev", "87024788412");
        phonebook.add("Bastaubayev", "87777872836");
        phonebook.add("Serikov", "87024762842");

        if (!phonebook.phoneBook.keySet().isEmpty()){
            //---Первая реализация вывода
            for (String surnames : phonebook.phoneBook.keySet()) {
                System.out.println("Person with surname " + surnames + " has:");
                for (String numbers : phonebook.get(surnames)) {
                    System.out.println("    phone number: " + numbers);
                }
            }
        //---Вторая реализация вывода (Честно признаюсь, эту реализацию вывод, я подсмотрел в видеоуроке, и она мне показалась тоже хорошей поэтому ее я тоже реализовал)
//            for (String surname : phonebook.phoneBook.keySet()) {
//                System.out.printf("Контакт по фамилии %s найден и имеет следующий(ие) номер(а): %s %n", surname, phonebook.get(surname));
//            }
        }

    }

    private static List<String> listOfWords(){
        List<String> words = new ArrayList<>();
        words.add("стул");
        words.add("стол");
        words.add("тумба");
        words.add("стул");
        words.add("кофе");
        words.add("стул");
        words.add("тумба");
        words.add("стул");
        words.add("кофе");
        words.add("чай");
        words.add("сахар");
        words.add("стол");
        words.add("сахар");
        words.add("печь");
        words.add("кофе");
        words.add("кофе");
        words.add("матрас");
        words.add("печь");
        words.add("сахар");
        words.add("стул");

        return words;
    }

    private static Set<String> uniqList(List<String> words) {
        List<String> duplicates = new ArrayList<>();
        Set<String> uniq = new HashSet<>();
        for (int i=0; i<words.size(); i++) {
            if (!uniq.add(words.get(i))){
                duplicates.add(words.get(i));
            }
        }

        for (String uniqWords : uniq) {
            int counter = 1;
            for (String duplicate : duplicates) {
                if (uniqWords.equals(duplicate)){
                    counter += 1;
                }
            }
            System.out.println("Cколько раз встречается каждое слово: " + uniqWords + " = " + counter);
        }
        return uniq;
    }
}
