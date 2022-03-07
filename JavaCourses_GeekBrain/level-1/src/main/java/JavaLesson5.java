public class JavaLesson5 {

    public static void main(String[] args) {
        Employee employee = new Employee("Kurmanov Azamat", "Java Developer", "a.kurmanov@gmail.com", "+7-555-55-55", 1000000, 37);
        employee.showInfo();
        System.out.println("---------------------------------------------------------\n");

        showEmployees();
    }

    private static Employee[] Employees(){
        Employee[] employees = new Employee[5];
        employees[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        employees[1] = new Employee("Sidorov Kiril", "Designer", "k.sidorov@mail.ru", "89432135465", 20000, 43);
        employees[2] = new Employee("Chirkov Vladimir", "Accounter", "v.chirkov@gmail.com", "84631230234", 50000, 36);
        employees[3] = new Employee("Chikachko Vitaliy", "Manager", "v.chikachko@yandex.ru", "85556456687", 70000, 37);
        employees[4] = new Employee("Smirnova Olga", "Director", "o.smirnova@mail.ru", "87775553322", 80000, 45);
        return employees;
    }

    private static void showEmployees(){
        Employee[] employees = Employees();
        for (int i = 0; i < employees.length; i++){
            if (employees[i].getAge()>40){
                employees[i].showInfo();
                if (i<employees.length-1) {
                    System.out.println("//-------------------//");
                }
            }
        }
    }
}
