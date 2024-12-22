import KI304.Plotkykh.Lab4.ExpressionCalculator;
import java.io.IOException;

public class Main {

    /**
     * Програма-драйвер для тестування класу ExpressionCalculator.
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        ExpressionCalculator calculator = new ExpressionCalculator();
        double x = 2.0; // тестове значення
        String textFilename = "result.txt";
        String binaryFilename = "result.bin";

        try {
            double result = calculator.calculate(x);

            // Запис у текстовий і двійковий файли
            calculator.writeResultToFile(result, textFilename);
            calculator.writeBinaryResultToFile(result, binaryFilename);
            System.out.println("Результат обчислення записано у файли: " + textFilename + " і " + binaryFilename);

            // Читання результатів з файлів
            double textResult = calculator.readResultFromTextFile(textFilename);
            double binaryResult = calculator.readResultFromBinaryFile(binaryFilename);

            System.out.println("Прочитаний результат з текстового файлу: " + textResult);
            System.out.println("Прочитаний результат з двійкового файлу: " + binaryResult);
        } catch (ArithmeticException e) {
            System.err.println("Помилка обчислення: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Помилка роботи з файлом: " + e.getMessage());
        }
    }
}