
import math

def calculate(x):
    numerator = math.sin(3 * x - 5)
    denominator = 1 / math.tan(2 * x)

    if math.isinf(denominator):
        raise ZeroDivisionError("Ділення на нескінченність у виразі ctg(2x).")

    return numerator / denominator


def openf(text):
    try:
        with open("example.txt", "w") as file:
            file.write(text)
    except FileNotFoundError:
        print("Файл не знайдено.")
    except IOError:
        print("Помилка доступу до файлу.")



def readf():
    try:
        with open("example.txt", "r") as file:
            content = file.read()
            print(content)
    except FileNotFoundError:
        print("Файл не знайдено.")
    except IOError:
        print("Помилка доступу до файлу.")


if __name__ == '__main__':
    try:
        res = calculate(2)
        openf(f"Результат обчислення: {res}")
    except ZeroDivisionError as e:
        print("Помилка обчислення:", e)

    readf()
