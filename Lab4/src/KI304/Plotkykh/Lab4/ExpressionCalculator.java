package KI304.Plotkykh.Lab4;

import java.io.*;

public class ExpressionCalculator  {
    /**
     * Обчислює вираз y = sin(3x - 5) / ctg(2x).
     *
     * @param x значення x для обчислення виразу
     * @return результат обчислення
     * @throws ArithmeticException якщо виникає ділення на нуль
     */
    public double calculate(double x) throws ArithmeticException {
        double numerator = Math.sin(3 * x - 5);
        double denominator = 1 / Math.tan(2 * x); // ctg(2x) = 1 / tan(2x)

        if (denominator == 0) {
            throw new ArithmeticException("Ділення на нуль в виразі ctg(2x).");
        }
        if (Double.isInfinite(denominator)) {
            throw new ArithmeticException("Ділення на infinity в виразі.");
        }

        return numerator / denominator;
    }

    /**
     * Записує результат обчислення у текстовий файл.
     *
     * @param result результат, який потрібно записати
     * @param filename назва файлу для запису
     * @throws IOException якщо виникає помилка запису
     */
    public void writeResultToFile(double result, String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Результат обчислення: " + result);
        }
    }

    /**
     * Записує результат обчислення у двійковий файл.
     *
     * @param result результат, який потрібно записати
     * @param filename назва файлу для запису
     * @throws IOException якщо виникає помилка запису
     */
    public void writeBinaryResultToFile(double result, String filename) throws IOException {
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(filename))) {
            out.writeDouble(result);
        }
    }

    /**
     * Зчитує результат з текстового файлу.
     *
     * @param filename назва файлу для зчитування
     * @return результат обчислення
     * @throws IOException якщо виникає помилка зчитування
     */
    public double readResultFromTextFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            return Double.parseDouble(line.replace("Результат обчислення: ", "").trim());
        }
    }

    /**
     * Зчитує результат з двійкового файлу.
     *
     * @param filename назва файлу для зчитування
     * @return результат обчислення
     * @throws IOException якщо виникає помилка зчитування
     */
    public double readResultFromBinaryFile(String filename) throws IOException {
        try (DataInputStream in = new DataInputStream(new FileInputStream(filename))) {
            return in.readDouble();
        }
    }
}
