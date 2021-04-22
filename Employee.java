package lesson5;

import java.util.Arrays;

public class Employee {
    private String name;
    private String position;
    private String mail;
    private String phone;
    private int sallary;
    private int age;


    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();

        Employee[] persArray = new Employee[5];

        persArray[0] = new Employee("Ivanov Ivan",
                "Engineer",
                "vanya@mail.ru",
                "89131233445",
                100000,
                42);

        persArray[1] = new Employee("Oboev Rulon",
                "Security",
                "RulonOboev@mail.ru",
                "89157124545",
                60000,
                39);

        persArray[2] = new Employee("Golovach Elena",
                "Accountant",
                "golovachlena@mail.ru",
                "89884615632",
                100000,
                41);

        persArray[3] = new Employee("Terentyev Mikhail",
                "Director",
                "KapitalProzhitocnogoMinimuma@mail.ru",
                "89117771369",
                100000,
                47);

        persArray[4] = new Employee("Khromoy Alexey",
                "Seller",
                "LexaXromoy@mail.ru",
                "89895467882",
                100000,
                35);
        for (int i = 0; i < persArray.length; i++) {
            if (persArray[i].age > 40) {
                str.append("name: " + persArray[i].name + "\n");
                str.append("position: " + persArray[i].position + "\n");
                str.append("mail: " + persArray[i].mail + "\n");
                str.append("phone: " + persArray[i].phone + "\n");
                str.append("sallary" + persArray[i].sallary + "\n");
                str.append("age: " + persArray[i].age + "\n");
                str.append("//////////////////////////////////////////\n");
            }
        }
        System.out.println(str.toString());
    }

    public Employee(String name, String position, String mail, String phone, int sallary, int age) {
        this.name = name;
        this.position = position;
        this.mail = mail;
        this.phone = phone;
        this.sallary = sallary;
        this.age = age;
    }
}
