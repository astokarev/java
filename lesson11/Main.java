package lesson11;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Phonebook book1 = new Phonebook();
        book1.add(12345, "Саша");
        book1.add(54321, "Саша");
        book1.add(123565, "Борис Бреча");
        System.out.println(book1.get("Саша"));
        }
    }
