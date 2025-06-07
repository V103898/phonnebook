package ru.netology;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в телефонную книгу!");
        printMenu();

        while (true) {
            System.out.print("\nВыберите действие (1-5): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            switch (choice) {
                case 1:
                    addContact(phoneBook, scanner);
                    break;
                case 2:
                    findByName(phoneBook, scanner);
                    break;
                case 3:
                    findByNumber(phoneBook, scanner);
                    break;
                case 4:
                    phoneBook.printAllNames();
                    break;
                case 5:
                    System.out.println("Выход из программы...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Добавить контакт");
        System.out.println("2. Найти номер по имени");
        System.out.println("3. Найти имя по номеру");
        System.out.println("4. Вывести все имена");
        System.out.println("5. Выход");
    }

    private static void addContact(PhoneBook phoneBook, Scanner scanner) {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите номер: ");
        String number = scanner.nextLine();

        int size = phoneBook.add(name, number);
        System.out.println("Контакт добавлен. Всего контактов: " + size);
    }

    private static void findByName(PhoneBook phoneBook, Scanner scanner) {
        System.out.print("Введите имя для поиска: ");
        String name = scanner.nextLine();
        String number = phoneBook.findByName(name);

        if (number != null) {
            System.out.println("Найден номер: " + number);
        } else {
            System.out.println("Контакт с таким именем не найден.");
        }
    }

    private static void findByNumber(PhoneBook phoneBook, Scanner scanner) {
        System.out.print("Введите номер для поиска: ");
        String number = scanner.nextLine();
        String name = phoneBook.findByNumber(number);

        if (name != null) {
            System.out.println("Найден контакт: " + name);
        } else {
            System.out.println("Контакт с таким номером не найден.");
        }
    }
}