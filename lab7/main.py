def generate_triangle_matrix(size, fill_char):
    """
    Генерує зубчатий список, що містить лише заштриховані області квадратної матриці з відступом вправо.

    :param size: Розмір квадратної матриці
    :param fill_char: Символ-заповнювач
    :return: Зубчатий список із заштрихованою областю
    """
    matrix = []
    for i in range(size):
        # Створюємо рядок з відступом і символами-заповнювачами
        row = [' '] * i + ["&"] + [fill_char] * (size - i - 1)
        matrix.append(row)
    return matrix


def display_matrix(matrix):
    """
    Виводить зубчатий список на екран у вигляді матриці.

    :param matrix: Зубчатий список для виведення
    """
    for row in matrix:
        print("".join(row))


def main():
    """
    Основна функція для запуску програми.
    """
    try:
        # Введення розміру квадратної матриці
        size = int(input("Введіть розмір квадратної матриці: "))

        # Введення символу-заповнювача
        fill_char = input("Введіть символ-заповнювач: ")

        # Перевірка введеного символу
        if len(fill_char) != 1:
            print("Помилка: необхідно ввести рівно один символ-заповнювач.")
            return

        # Генерація та виведення матриці
        matrix = generate_triangle_matrix(size, fill_char)
        display_matrix(matrix)

    except ValueError:
        print("Помилка: розмір матриці має бути цілим числом.")


if __name__ == "__main__":
    main()
