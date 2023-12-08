package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import View.Printer;

public class Animal {
    int id;
    String name;
    String type;
    String command;
    String birthday;

    /**
     * @param id       - ID животного (не должен повторяться)
     * @param name     - кличка
     * @param type     - Кот, Собака, Хомяк, Лошадь, Верблюд, Осел...
     * @param command  - список комманд
     * @param birthday - дата рождения
     */
    public Animal(int id, String name, String type, String command, String birthday) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.command = command;
        this.birthday = birthday;
    }

    /**
     * Метод добавления нового животного в реестр
     * 
     * @param list            - список животных
     * @param listPets        - список домашних животных
     * @param listPackAnimals - список вьючных животных
     * @param printer         - объект класса Printer (для вывода информации в
     *                        консоль)
     * @return - обновленный список животных после добавления нового
     */
    public List<Animal> addNewAnimal(List<Animal> list, List<Pets> listPets, List<PackAnimals> listPackAnimals,
            Printer printer, Scanner scanner) {

        List<Animal> newAnimal = new ArrayList<Animal>();

        Pets newPets = new Pets(id, name, type, command, birthday);
        PackAnimals newPackAnimals = new PackAnimals(id, name, type, command, birthday);

        int maxId = getMaxId(list);
        newPets.id = maxId + 1;
        newPackAnimals.id = maxId + 1;

        int key = 0;
        boolean fl = true;
        while (fl) {
            printer.printMessage(
                    "\tВыберите класс животного: \n\n\t 1. Домашнее животное (Кошка, Собака, Хомяк...) \n\t 2. Вьючное живоное (Лошадь, Верблюд, Осел...) \n\t 0. Выход");
            if (scanner.hasNextInt()) {
                key = scanner.nextInt();
            } else {
                printer.printMessage("Введено не число!");
                scanner.next();
            }

            switch (key) {
                case 1:
                    printer.printMessage("Введите тип животного (Cat, Dog, Hamster...): ");
                    newPets.type = scanner.next();
                    printer.printMessage("Введите кличку животного: ");
                    newPets.name = scanner.next();
                    printer.printMessage("Введите дату рождения животного в формате yyyy-mm-dd: ");
                    newPets.birthday = scanner.next();
                    printer.printMessage("Введите команды, известные животному: ");
                    newPets.command = scanner.next();
                    listPets.add(newPets);
                    newAnimal.addAll(listPets);
                    newAnimal.addAll(listPackAnimals);
                    return newAnimal;

                case 2:
                    printer.printMessage("Введите тип животного (Horse, Camal, Donkey...): ");
                    newPackAnimals.type = scanner.next();
                    printer.printMessage("Введите кличку животного: ");
                    newPackAnimals.name = scanner.next();
                    printer.printMessage("Введите дату рождения животного в формате yyyy-mm-dd: ");
                    newPackAnimals.birthday = scanner.next();
                    printer.printMessage("Введите команды, известные животному: ");
                    newPackAnimals.command = scanner.next();
                    listPackAnimals.add(newPackAnimals);
                    newAnimal.addAll(listPets);
                    newAnimal.addAll(listPackAnimals);
                    return newAnimal;

                case 0:
                    fl = false;
            }
        }
        return list;
    }

    /**
     * @param list    - список животных
     * @param scanner - объект класса Scanner
     * @param printer - объект класса Printer
     */
    public void searchAnimal(List<Animal> list, Scanner scanner, Printer printer) {

        printer.printMessage("Введите ID животного из списка ниже.");
        printer.printList(list);
        int num = 0;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            printer.printMessage("Введено не число!");
            scanner.next();
        }

        int count = 0;
        for (Animal elem : list) {
            if (elem.id == num) {
                printer.printMessage("Список команд животного с ID " + elem.id + " и кличкой " + elem.name + ": ");
                System.out.println();
                System.out.println(elem.command);
            } else {
                count++;
            }
            if (count == list.size()) {
                printer.printMessage("Нет такого ID!");
            }
        }
    }

    /**
     * Поиск максимального id сдеди животных, чтобы позже внести неповторяющееся
     * значение для нового животного
     * 
     * @param list - список животных
     * @return значение максимального id
     */
    public Integer getMaxId(List<Animal> list) {

        int maxId = 0;
        for (Animal elem : list) {
            System.out.println(elem);
            if (elem.id > maxId) {
                maxId = elem.id;
            }
        }
        return maxId;
    }

    /**
     * Метод задания новых комманд животному
     * 
     * @param list    - список животных
     * @param printer - объект класса Printer
     * @param scanner - объект класса Scanner
     * @return обновленный список животных
     */
    public List<Animal> setCommand(List<Animal> list, Printer printer, Scanner scanner) {

        printer.printMessage("Введите ID животного из списка ниже, для которого необходимо изменить команду");
        printer.printList(list);
        int num = 0;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            printer.printMessage("Введено не число!");
            scanner.next();
        }

        int count = 0;
        for (Animal elem : list) {
            if (elem.id == num) {
                printer.printMessage("Введите новую комманду:");
                elem.command = scanner.next();
                break;
            } else {
                count++;
            }
        }
        if (count == list.size()) {
            printer.printMessage("Нет такого ID!");
        }
        return list;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getBirthday() {
        return birthday;
    }
}
