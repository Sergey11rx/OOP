// Создать проект калькулятора комплексных чисел (достаточно сделать сложение, умножение и деление).
// Применить при создании программы архитектурные паттерны, добавить логирование калькулятора.
// Соблюдать принципы SOLID, паттерны проектирования.


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// Класс комплексного числа
class ComplexNumber {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    // Метод сложения комплексных чисел
    public ComplexNumber add(ComplexNumber other) {
        double resultReal = this.real + other.getReal();
        double resultImaginary = this.imaginary + other.getImaginary();
        return new ComplexNumber(resultReal, resultImaginary);
    }

    // Метод умножения комплексных чисел
    public ComplexNumber multiply(ComplexNumber other) {
        double resultReal = this.real * other.getReal() - this.imaginary * other.getImaginary();
        double resultImaginary = this.real * other.getImaginary() + this.imaginary * other.getReal();
        return new ComplexNumber(resultReal, resultImaginary);
    }

    // Метод деления комплексных чисел
    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.getReal() * other.getReal() + other.getImaginary() * other.getImaginary();
        double resultReal = (this.real * other.getReal() + this.imaginary * other.getImaginary()) / denominator;
        double resultImaginary = (this.imaginary * other.getReal() - this.real * other.getImaginary()) / denominator;
        return new ComplexNumber(resultReal, resultImaginary);
    }
}

// Интерфейс калькулятора
interface Calculator {
    ComplexNumber calculate(ComplexNumber num1, ComplexNumber num2);
}

// Конкретная реализация калькулятора
class ComplexCalculator implements Calculator {
    private static final Logger logger = LogManager.getLogger(ComplexCalculator.class);

    @Override
    public ComplexNumber calculate(ComplexNumber num1, ComplexNumber num2) {
        ComplexNumber result = num1.add(num2);
        logger.info("Результат сложения: " + result.getReal() + " + " + result.getImaginary() + "i");

        result = num1.multiply(num2);
        logger.info("Результат умножения: " + result.getReal() + " + " + result.getImaginary() + "i");

        result = num1.divide(num2);
        logger.info("Результат деления: " + result.getReal() + " + " + result.getImaginary() + "i");

        return result;
    }
}

// Пример использования калькулятора
public class Main {
    public static void main(String[] args) {
        ComplexNumber num1 = new ComplexNumber(2, 3);
        ComplexNumber num2 = new ComplexNumber(4, -5);

        Calculator calculator = new ComplexCalculator();
        calculator.calculate(num1, num2);
    }
}
