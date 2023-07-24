// Задача 1:
// Создайте класс "Кот" (Cat) со следующими свойствами:

// Приватное поле "имя" (name) типа String для хранения имени кота.
// Приватное поле "возраст" (age) типа int для хранения возраста кота.
// Публичные методы доступа (геттеры и сеттеры) для полей "имя" и "возраст".
// Публичный метод "приветствие" (greet), который выводит на консоль приветствие вида "Мяу! Меня зовут <имя>. Мне <возраст> года(лет).".
// Дополнительное задание:
// Создайте класс "Владелец" (Owner) со свойством "имя" (name) типа String. Добавьте соответствующее поле в классе "Кот" и методы доступа для него. 
// Измените метод "приветствие" класса "Кот", чтобы он выводил приветствие вида "Мяу! Меня зовут <имя>. Мне <возраст> года(лет). Мой владелец - <имя владельца>.".

public class Cat
{
    String name;
    int weight = 5;
    int age = 5;
    String color;
    String adress;
    
public void initialize(String name) 
{
    this.name = name;
}
public void initialize(String name,int weight,int age)
{
    this.name = name;
    this.weight = weight;
    this.age = age;
}
public void initialize(String name,int age) 
{
    this.name = name;
    this.age = age;
}
public void initialize(int weight, String color)
{
    this.weight = weight;
    this.color = color;
}
public void initialize(int age,String color,String adress)
{
    this.age = age;
    this.color = color;
    this.adress = adress;
}
}


// Реализуйте класс "Прямоугольник" (Rectangle), который имеет свойства ширина (width) и высота (height). 
// Класс должен обладать следующими методами:

// Конструктор без параметров, который создает прямоугольник с шириной и высотой по умолчанию.
// Конструктор, который принимает значения ширины и высоты и создает прямоугольник с заданными значениями.
// Методы доступа (геттеры и сеттеры) для свойств ширины и высоты.
// Метод "вычислить площадь" (calculateArea), который возвращает площадь прямоугольника (ширина * высота).
// Метод "вычислить периметр" (calculatePerimeter), который возвращает периметр прямоугольника (2 * (ширина + высота)).

class Rectangle {

  private int left, top, width, height;

  public void initialize(int left, int top, int width, int height) {
    this.left = left;
    this.top = top;
    this.width = width;
    this.height = height;
  }

  public void initialize(int left, int top) {
    this.left = left;
    this.top = top;
  }

  public void initialize(int left, int top, int width) {
    this.left = left;
    this.top = top;
    this.width = width;
    height = width;
  }

  public void initialize(Rectangle anotherRectangle) {
    this.left = anotherRectangle.left;
    this.top = anotherRectangle.top;
    this.width = anotherRectangle.width;
    this.height = anotherRectangle.width;
  }
}