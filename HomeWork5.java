/**
 *Java 1. HomeWork5
 *
 *@author teacher end Lazarev Alexei
 *@version 19.11.2021
 */

class HomeWork5 {

    public static void main(String[] args) {
        Employee[] employees = {
            new Employee("Demonov Ivan", "Engineer",
                "mail@mail.ru", "78785555", 60000, 38),
            new Employee("Zlobny Pavel", "Top Engineer",
                "ythhh@mail.ru", "7878755", 260000, 50),
            new Employee("Alkach Igor", "Janitor",
                "yhtu@mail.ru", "786787855", 30000, 39),
            new Employee("Durnov Vitaly", "Top Janitor",
                "i8ii@mail.ru", "78855555", 40000, 28),
            new Employee("Zernov Gena", "Gatekeeper",
                "8iii@mail.ru", "55567885", 55000, 68),
        };

        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                System.out.println(employee);
            }
        }
    }
}

class Employee {
    private String name;
    private String position;
    private String email;
    private String phone;
    private int salary;
    private int age;

    public Employee(String name, String position, String email, String phone,
            int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return (name +
            "\n| Position: " + position +
            "\n| Email: " + email +
            "\n| Phone: " + phone +
            "\n| Salary: " + salary +
            "\n| Age: " + age);
    }
}