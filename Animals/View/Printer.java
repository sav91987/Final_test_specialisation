package View;

import java.util.List;

import Models.Animal;

public class Printer {
    /**
     * Метод для вывода в консоль элементов списка животных
     * 
     * @param list - список животных
     */
    public void printList(List<Animal> list) {
        for (Animal elem : list) {
            System.out.println("ID: " + elem.getId() + " | Тип: " + elem.getType() + " | Кличка: " + elem.getName()
                    + " | Комманды: " + elem.getCommand() + " | Дата рождения "
                    + elem.getBirthday());
        }
    }

    /**
     * Метод вывода различный сообщений, информирующих пользователя
     * 
     * @param message - любое входное соощение
     */
    public void printMessage(String message) {
        System.out.println("***********************************************************************\n");
        System.out.println("\t" + message);
        System.out.println("\n***********************************************************************");
    }
}
