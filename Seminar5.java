// Конструируем калькулятор, применяя архитектуру MVP (Model-View-Presenter), 
// с возможностью выполнения базовых математических операций, таких как сложение, вычитание, умножение и деление, работающий с дробными числами.




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