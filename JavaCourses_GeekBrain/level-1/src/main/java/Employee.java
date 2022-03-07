public class Employee {
    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    public Employee() {

    }

    public Employee(String name, String position, String email, String phoneNumber, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void showInfo(){
        System.out.println("name: " + this.name + "\nposition: " + this.position + "\nemail: " + this.email + "\nphoneNumber: " + this.phoneNumber + "\nsalary: " + this.salary + "\nage: " + this.age);
    }
}
