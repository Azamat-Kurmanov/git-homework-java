public class Activity {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Max", 15);
        Cat cat2 = new Cat("Tosha", 12);
        Cat cat3 = new Cat("Barsik", 16);
        Cat cat4 = new Cat("Pushok", 11);
        Cat cat5 = new Cat("Molyan", 13);
        Cat[] cats = {cat1, cat2, cat3, cat4, cat5};
        Plate plate = new Plate(50);

        plate.info();
        System.out.println("-----------");
        for (Cat cat : cats) {
            if (plate.getFoodQuantity() < cat.getAppetite()) {  // Если коту не хватило еды, то в миску добавляется кол-во еды согласно его аппетиту
                plate.increaseFoodQuantity(cat.getAppetite() - plate.getFoodQuantity());
            }
            cat.eat(plate, cat.getName());
            if (cat.isWellFed()) {  // Если текущее кол-во еды меньше необходимого кол-ва, то повторно данная инф-ия не отображается
                plate.info();
            }
            System.out.println("----------");
        }
    }
}
