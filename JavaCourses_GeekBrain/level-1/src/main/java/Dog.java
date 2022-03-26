public class Dog extends Animal{
    private int runLimit = 500;
    private int swimLimit = 10;
    public static int counter = 0;

    public Dog(){
    }

    public Dog(String name, String color, int age){
        super(name, color, age);
        counter++;
    }

    @Override
    public void run(int distance){
        if (distance <= runLimit) {
            System.out.println("Собака пробежала " + distance + " метров");
        }else{
            System.out.println("Собака не может бежать более "+ runLimit+ " метров");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= swimLimit) {
            System.out.println("Собака проплыла "+distance+" метров");
        }else{
            System.out.println("Собака не может плыть более "+swimLimit+" метров");
        }
    }

}
