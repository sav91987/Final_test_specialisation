package Models;

public class Hamster extends Pets {

    /**
     * @param id       - ID животного (не должен повторяться)
     * @param name     - кличка
     * @param type     - Кот, Собака, Хомяк, Лошадь, Верблюд, Осел...
     * @param command  - список комманд
     * @param birthday - дата рождения
     */
    public Hamster(int id, String name, String type, String command, String birthday) {
        super(id, name, type, command, birthday);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Hamster [id=" + id + ", name=" + name + ", command=" + command + ", birthday=" + birthday + ", type="
                + type + "]";
    }
}