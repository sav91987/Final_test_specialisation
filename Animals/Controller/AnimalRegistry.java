package Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Models.Animal;
import Models.Camal;
import Models.Cat;
import Models.Dog;
import Models.Donkey;
import Models.Hamster;
import Models.Horse;
import Models.PackAnimals;
import Models.Pets;
import View.Printer;

public class AnimalRegistry {

    /**
     * Конструктор класса AnimalRegistry (Реестр животных)
     */
    public AnimalRegistry() {

    }

    public static void main(String[] args) {

        // Создание объектов класса. Создаем изначально, чтобы было с чем работать
        Dog dog1 = new Dog(1, "Reuben", "Dog", "Sit", "2022-01-10");
        Dog dog2 = new Dog(2, "Frederik", "Dog", "Stay", "2021-04-07");
        Dog dog3 = new Dog(3, "Unique", "Dog", "Fetch", "2020-01-12");

        Cat cat1 = new Cat(4, "Click", "Cat", "Sit", "2023-03-05");
        Cat cat2 = new Cat(5, "Ping", "Cat", "Pounce", "2018-02-11");
        Cat cat3 = new Cat(6, "Pack", "Cat", "Sit", "2022-07-10");

        Hamster ham1 = new Hamster(7, "Chip", "Hamster", "Roll", "2022-01-10");
        Hamster ham2 = new Hamster(8, "Dale", "Hamster", "Hide", "2021-03-12");
        Hamster ham3 = new Hamster(9, "Rockfor", "Hamster", "Roll, Hide", "2021-05-05");

        Horse hor1 = new Horse(10, "Faster", "Horse", "Trot, Canter, Gallop", "2015-02-02");
        Horse hor2 = new Horse(11, "Harder", "Horse", "Canter, Gallop", "2020-03-04");
        Horse hor3 = new Horse(12, "Scooter", "Horse", "Gallop", "2022-01-01");

        Camal cam1 = new Camal(13, "Knight", "Camal", "Walk, Carry Load", "2023-01-10");
        Camal cam2 = new Camal(14, "Rider", "Camal", "Walk", "2020-02-03");
        Camal cam3 = new Camal(15, "Spiner", "Camal", "Walk, Sit", "2015-03-02");

        Donkey don1 = new Donkey(16, "Fat", "Donkey", "Walk, Carry Load, Bray", "2021-06-05");
        Donkey don2 = new Donkey(17, "Boy", "Donkey", "Walk, Carry Load", "2022-03-02");
        Donkey don3 = new Donkey(18, "Slim", "Donkey", "Carry Load, Bray", "2019-01-02");

        // Заполняем список созданными объектами, которые будут входить в класс домашних животных
        List<Pets> petsList = new ArrayList<Pets>();
        petsList.add(dog1);
        petsList.add(dog2);
        petsList.add(dog3);
        petsList.add(cat1);
        petsList.add(cat2);
        petsList.add(cat3);
        petsList.add(ham1);
        petsList.add(ham2);
        petsList.add(ham3);

        // Заполняем список созданными объектами, которые будут входить в класс вьючных животных
        List<PackAnimals> packAnimalsList = new ArrayList<PackAnimals>();
        packAnimalsList.add(hor1);
        packAnimalsList.add(hor2);
        packAnimalsList.add(hor3);
        packAnimalsList.add(cam1);
        packAnimalsList.add(cam2);
        packAnimalsList.add(cam3);
        packAnimalsList.add(don1);
        packAnimalsList.add(don2);
        packAnimalsList.add(don3);

        //Объединяем два списка в общий по всем животным
        List<Animal> allAnimals = new ArrayList<Animal>();

        allAnimals.addAll(petsList);
        allAnimals.addAll(packAnimalsList);

        Scanner scanner = new Scanner(System.in);
        Printer printer = new Printer();
        Animal animals = new Animal(0, null, null, null, null);

        printer.printMessage("Вас приветствует реестр животных 'Рога и копыта'!");

        int key = 0;
        boolean flag = true;
        while (flag) {
            printer.printMessage(
                    "\tВыберите пункт меню: \n\n\t1. Показать реестр животных.\n\t2. Завести новое животное.\n\t3. Увидеть список команд животного "
                            + "\n\t4. Добавить новую команду \n\t0. Выход.");
            if (scanner.hasNextInt()) {
                key = scanner.nextInt();
            } else {
                printer.printMessage("Введено не число!");
                scanner.next();
            }

            switch (key) {
                case 1:
                    printer.printList(allAnimals);
                    break;
                case 2:
                    allAnimals = animals.addNewAnimal(allAnimals, petsList, packAnimalsList, printer, scanner);
                    break;
                case 3:
                    animals.searchAnimal(allAnimals, scanner, printer);
                    break;
                case 4:
                    allAnimals = animals.setCommand(allAnimals, printer, scanner);
                    break;
                case 0:
                    flag = false;
            }
        }
    }
}
