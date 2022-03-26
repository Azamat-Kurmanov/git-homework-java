public class Activity {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Tom", "white", 5);
        Cat cat2 = new Cat("Barsik", "Grey", 3);
        Cat cat3 = new Cat("Moly", "Grey and white", 3);
        Cat cat4 = new Cat("Kuzya", "white", 8);

        Dog dog1 = new Dog("Graph", "Black", 2);
        Dog dog2 = new Dog("Rex", "Brown", 4);
        Dog dog3 = new Dog("Sharik", "Grey", 6);

        Animal[] animals = {cat1, cat2, cat3, cat4, dog1, dog2, dog3};
        countOfAnimals(animals, Dog.counter, Cat.counter, Animal.counter);  //---Задание 4, имеет 2 реализации

        runAndSwim(); //---Задание 2 и 3
    }

    private static void runAndSwim() {
        Animal cat = new Cat();
        Animal dog = new Dog();

        cat.run(150);
        dog.run(250);

        cat.swim(100);
        dog.swim(50);
    }

    private static void countOfAnimals(Animal[] animals, int dogCount, int catCount, int animalCount) {
        //-----Реализация счетчика 1 (счетчик установлен в самом классе):
        System.out.println("Реализация счетчика 1. Количество кошек: " + catCount + "\nКоличество собак: "+ dogCount +"\nКоличество животных: "+ animalCount);


        //-----Реализация счетчика 2 через цикл:
        int dogCounter = 0;
        int catCounter = 0;
        int animalsCounter = 0;

        for (Animal animal: animals){
            if (Cat.class.getName().equals(animal.getClass().getName())) {
                catCounter++;
            }else if(Dog.class.getName().equals(animal.getClass().getName())) {
                dogCounter++;
            }
            animalsCounter++;
        }
        System.out.println("Реализация счетчика 2. Количество кошек: " + catCounter + "\nКоличество собак: "+ dogCounter +"\nКоличество животных: "+ animalsCounter);
    }
}
