public abstract class Animal {
    protected String name;
    protected String color;
    protected int age;
    public static int counter = 0;

    public Animal(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
        counter ++;
    }

    public Animal() {
    }

    public void info(){
        System.out.println("name: " + name + " color: " + color + " age: " + age);
    }


    public abstract void run(int distance);

    public abstract void swim(int distance);
}
