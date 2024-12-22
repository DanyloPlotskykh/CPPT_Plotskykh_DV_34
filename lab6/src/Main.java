import KI304.Plotskykh.lab6.TrashBin;


public class Main {
    /**
     * Головний метод для тестування класу TrashBin.
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        // Створення двох різних типів об'єктів, які можна зберігати у баку для сміття
        TrashBin<Integer, String> integerBin = new TrashBin<>();
        TrashBin<String, String> stringBin = new TrashBin<>();


        integerBin.addTwoElements(10, "323");
        // Додавання та видалення елементів у баку для цілочисельних значень
        integerBin.addElement(10);
        integerBin.addElement(20);
        integerBin.addElement(5);
        integerBin.displayElements();

        System.out.println("Максимальний елемент у integerBin: " + integerBin.getMaxElement(Integer::compare));
        integerBin.removeElement(10);
        integerBin.displayElements();

        // Додавання та видалення елементів у баку для рядків
        stringBin.addElement("Apple");
        stringBin.addElement("Banana");
        stringBin.addElement("Cherry");
        stringBin.displayElements();

        System.out.println("Мінімальний елемент у stringBin: " + stringBin.getMinElement(String::compareTo));
        stringBin.removeElement("Apple");
        stringBin.displayElements();
    }
}