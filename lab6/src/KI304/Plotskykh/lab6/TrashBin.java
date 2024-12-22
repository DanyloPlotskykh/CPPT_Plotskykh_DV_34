package KI304.Plotskykh.lab6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Параметризований клас TrashBin, що представляє бак для сміття.
 *
 * @param <T> тип елементів у баці для сміття
 */
public class TrashBin<T, U> {
    private List<T> elements;
    private List<U> elementsU;

    /**
     * Конструктор, що ініціалізує пустий бак для сміття.
     */
    public TrashBin() {
        elements = new ArrayList<>();
    }

    /**
     * Метод для додавання елементу до бака.
     *
     * @param element елемент, який додається в бак
     */
    public void addElement(T element) {
        elements.add(element);
        System.out.println("Елемент додано: " + element);
    }

    public void addTwoElements(T element, U element2)
    {
        elements.add(element);
        elementsU.add(element2);
        System.out.println("Added two elements: " + element + " and " + element2);
    }
    /**
     * Метод для видалення елементу з бака.
     *
     * @param element елемент, який потрібно видалити
     * @return true, якщо елемент було видалено, інакше false
     */
    public boolean removeElement(T element) {
        boolean removed = elements.remove(element);
        if (removed) {
            System.out.println("Елемент видалено: " + element);
        } else {
            System.out.println("Елемент не знайдено: " + element);
        }
        return removed;
    }

    /**
     * Повертає максимальний елемент у баці (для непарного варіанту реалізації).
     *
     * @param comparator компаратор для порівняння елементів
     * @return максимальний елемент у баці
     */
    public T getMaxElement(Comparator<T> comparator) {
        return elements.stream().max(comparator).orElse(null);
    }

    /**
     * Повертає мінімальний елемент у баці (для парного варіанту реалізації).
     *
     * @param comparator компаратор для порівняння елементів
     * @return мінімальний елемент у баці
     */
    public T getMinElement(Comparator<T> comparator) {
        return elements.stream().min(comparator).orElse(null);
    }

    /**
     * Повертає кількість елементів у баці.
     *
     * @return кількість елементів
     */
    public int getSize() {
        return elements.size();
    }

    /**
     * Метод для виведення всіх елементів у баці.
     */
    public void displayElements() {
        System.out.println("Елементи у баці:");
        for (T element : elements) {
            System.out.println(element);
        }
    }
}
