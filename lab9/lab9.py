class Gun:
    """
    Базовий клас, що описує пістолет.
    """

    def __init__(self, manufacturer, model, caliber):
        """
        Ініціалізує пістолет.
        :param manufacturer: Виробник пістолета.
        :param model: Модель пістолета.
        :param caliber: Калібр пістолета.
        """
        self.manufacturer = manufacturer
        self.model = model
        self.caliber = caliber

    def shoot(self):
        """
        Симулює постріл.
        """
        return f"{self.manufacturer} {self.model}: Постріл із калібру {self.caliber}!"

    def reload(self):
        """
        Симулює перезарядку.
        """
        return f"{self.manufacturer} {self.model}: Перезарядка виконана!"


class AutomaticGun(Gun):
    """
    Похідний клас, що описує автоматичний пістолет.
    """

    def __init__(self, manufacturer, model, caliber, fire_rate):
        """
        Ініціалізує автоматичний пістолет.
        :param manufacturer: Виробник пістолета.
        :param model: Модель пістолета.
        :param caliber: Калібр пістолета.
        :param fire_rate: Швидкість стрільби (пострілів за секунду).
        """
        super().__init__(manufacturer, model, caliber)
        self.fire_rate = fire_rate

    def shoot_burst(self, shots):
        """
        Симулює чергу з кількох пострілів.
        :param shots: Кількість пострілів.
        """
        return f"{self.manufacturer} {self.model}: Черга з {shots} пострілів за {shots/self.fire_rate:.2f} секунд!"


def main():
    """
    Точка входу в програму.
    """
    # Створюємо звичайний пістолет
    pistol = Gun("Glock", "G19", "9mm")
    print(pistol.shoot())
    print(pistol.reload())

    # Створюємо автоматичний пістолет
    auto_pistol = AutomaticGun("Beretta", "93R", "9mm", fire_rate=10)
    print(auto_pistol.shoot())
    print(auto_pistol.shoot_burst(5))
    print(auto_pistol.reload())


if __name__ == "__main__":
    main()
