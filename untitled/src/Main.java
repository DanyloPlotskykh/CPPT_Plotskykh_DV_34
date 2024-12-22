import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    /**
     * A function that initializes a matrix and fills it with a symbol according to the algorithm.
     * @param size size of matrix
     * @param  fillChar symbol, that user has entered from keyboard
     * @return matrix, fill accordin' to the algorithm
     */
    public static char[][] generateArray(int size, char fillChar) {
        char[][] jaggedArray = new char[size][];
        for (int i = 0; i < size; i++) {
            jaggedArray[i] = new char[size];  // Створення масиву змінної довжин
        }
        int half = size / 2;
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j < size; j++) {
                // Умови для заповнення всередині ромба
                if ((i + j >= half) && (i + j <= 3 * half) && (i - j <= half) && (j - i <= half)) {
                    jaggedArray[i][j] = ' ';  // Порожнє місце всередині ромба
                } else {
                    jaggedArray[i][j] = fillChar;  // Заштриховане місце зовні ромба
                }
            }
        }
        return jaggedArray;
    }
    // Метод для виведення масиву на екран
    /**
     *printArray() -  function, that print the matrix in the output
     * @param array - matrix that we want to print
     * @return void
     * */
    public static void printArray(char[][] array) {
        for (char[] row : array) {
            for (char ch : row) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
    // Метод для запису масиву в текстовий файл
    public static void writeArrayToFile(char[][] array, String fileName) throws IOException {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (char[] row : array) {
                for (char ch : row) {
                    writer.write(ch + " ");
                }
                writer.write("\n");
            }
        }
    }
    /**
     * Main function of class; implements input logic from user and prepare data to generate matrix.
     * <p></p>
     * <b>It has 4 parameters inside</b>:
     * <li><b>size</b> - amount of rows (get from user)</li>
     * <li><b>fillChar</b> - character to fill matrix (get from user)</li>
     * <li><b>jaggedArray</b> - matrix</li>
     * <li><b>printArray(jaggedArray);</b> - printer to print result</li>
     * <p></p>
     * Program output result in console and file.<p></p>
     * <pre><b>First step - prepare file</b></pre>
     * <p></p>
     * Program connects file to PrintWriter. If it doesn't exist, program try to create new file. If creating was failed, program exits with code -4. <p></p>
     * <pre><b>Second step - get data from user</b></pre>
     * <p></p>
     * Program informs user to input amount of rows and check if his input is correct and checks if input data is an int and only one int.
     * If user input more int data or it has one char, program exit with code -1.<p></p>
     * <p></p>
     * After successfully rows input, program informs user to input symbol to fill matrix.
     * If user input more symbols or single word, program will exit with code -3.
     * @param args default for main
     * @throws IOException required to output data in file
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення розміру матриці
        System.out.print("Введіть розмір квадратної матриці: ");
        int size = scanner.nextInt();
        scanner.nextLine();  // Очищення буфера

        // Введення символу-заповнювача
        System.out.print("Введіть символ-заповнювач: ");
        String input = scanner.nextLine();

        // Перевірка введення одного символу
        if (input.length() != 1) {
            System.out.println("Помилка: потрібно ввести рівно один символ.");
            return;
        }

        char fillChar = input.charAt(0);

        // Генерація зубчастого масиву
        char[][] jaggedArray = generateArray(size, fillChar);

        // Виведення масиву на екран
        System.out.println("Сформований масив:");
        printArray(jaggedArray);

        // Запис масиву у файл
        try {
            writeArrayToFile(jaggedArray, "output.txt");
            System.out.println("Масив успішно записаний у файл output.txt.");
        } catch (IOException e) {
            System.out.println("Сталася помилка під час запису у файл: " + e.getMessage());
        }
    }
}