// Данный код реализует принцип проектирования Model-View-Presenter (MVP):

public class Model {
    public double calculate(double num1, double num2, String operator) {
        switch(operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    throw new ArithmeticException("Деление на ноль не допускается");
                }
            default:
                throw new IllegalArgumentException("Недопустимый оператор: " + operator);
        }
    }
}

import java.util.Scanner;

public class View {
    private Presenter presenter;
    private Scanner scanner;

    public View(Presenter presenter) {
        this.presenter = presenter;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.print("Введите первый номер: ");
            double num1 = scanner.nextDouble();
            System.out.print("Введите оператор (+, -, *, /): ");
            String operator = scanner.next();
            System.out.print("Введите второй номер: ");
            double num2 = scanner.nextDouble();

            double result = presenter.calculate(num1, num2, operator);
            System.out.println("Результат: " + result);

            System.out.print("Вы хотите продолжить? (да/нет): ");
            String choice = scanner.next();
            if (!choice.equalsIgnoreCase("y")) {
                break;
            }
        }
    }

    public String getOperatorInput() {
        System.out.print("Введите оператор (+, -, *, /): ");
        return scanner.next();
    }

    public double getNumberInput() {
        System.out.print("Введите номер: ");
        return scanner.nextDouble();
    }
}

public class Presenter {
    private Model model;
    private View view;

    public Presenter(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        view.start();
    }

    public double calculate(double num1, double num2, String operator) {
        return model.calculate(num1, num2, operator);
    }
}

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        View view = new View(new Presenter(model, view));
        view.start();
    }
}

// MVP - это шаблон проектирования, который разделяет код на три основных компонента: Model (модель), View (представление) и Presenter (презентер). 

// 1. Модель (Model) - это компонент, отвечающий за бизнес-логику приложения. В данном случае, класс Model содержит метод calculate,
// который выполняет арифметические операции на числах, в зависимости от переданного оператора.

// 2. Представление (View) - это компонент, отображающий данные пользователю и обрабатывающий пользовательский ввод. 
// Класс View содержит методы для ввода чисел и оператора из консоли, а также для вывода результата.

// 3. Презентер (Presenter) - это компонент, который связывает модель и представление, обрабатывает пользовательский ввод 
// и передает данные модели для их обработки. Класс Presenter имеет метод calculate, который вызывает метод calculate модели и возвращает результат.

// Главный класс Main является точкой входа в программу и создает экземпляры классов Model, View и Presenter. 
// Он также вызывает метод start у объекта View для начала работы программы.

// Принцип MVP позволяет разделить логику приложения на независимые компоненты (Модель, Представление, Презентер), что упрощает поддержку, 
// тестирование и расширение кода.