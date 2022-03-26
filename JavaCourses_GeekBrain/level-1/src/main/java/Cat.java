public class Cat extends Animal{
    public static int counter = 0;
    private int runLimit = 200;

    public Cat(){}

    public Cat(String name, String color, int age){
        super(name, color, age);
        counter ++;
    }

    @Override
    public void run(int distance) {
        if (distance <= runLimit) {
            System.out.println("Кот пробежал " + distance + " метров");
        }else{
            System.out.println("Кот не может бежать более "+ runLimit+ " метров");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот не умеет плавать");
    }

}
