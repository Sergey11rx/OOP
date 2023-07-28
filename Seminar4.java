// Задача 1 : Напишите обобщенный метод printElement, который принимает один параметр типа T и выводит его на консоль.
// В этом примере мы объявляем обобщенный метод printElement, который принимает один параметр типа T. Мы просто выводим этот элемент на консоль 
// с помощью метода System.out.println().
// В методе main мы вызываем printElement с различными типами данных: целое число (Integer), строку (String)
// и число с плавающей запятой (Double). Компилятор автоматически выводит тип параметра T на основе переданных аргументов.
// Таким образом, обобщенные методы позволяют нам писать код, который может работать с различными типами данных, обеспечивая простоту
// и гибкость использования.


public class Main {
    public static void main(String[] args) {
        DataContainer<String> dataContainer = new DataContainer<>();
        dataContainer.add("car");
        dataContainer.add("macbook");
        dataContainer.add("ruller");
        dataContainer.print();

        dataContainer.sort((element1, element2) -> element2.compareTo(element1));
        System.out.println();
        dataContainer.print();
        System.out.println(dataContainer.get(2));
        dataContainer.sort((element1, element2) -> element1.compareTo(element2));
        System.out.println();
        dataContainer.print();
        System.out.println();
        System.out.println(dataContainer.get(2));
    }
}



// Задача 2 : Напишите обобщенный метод printArray, который принимает массив любого типа и выводит его элементы на консоль.
// В этом примере мы объявляем обобщенный метод printArray, который принимает массив типа T. Затем мы используем цикл for-each, 
// чтобы пройти по всем элементам массива и вывести их на консоль.
// В методе main мы создаем массивы типов Integer и String и вызываем printArray для каждого из них. 
// В результате мы получаем вывод на консоль элементов каждого массива.
// Таким образом, обобщенные методы позволяют нам создавать код, который может работать с разными типами данных, 
// обеспечивая повторное использование и гибкость.

// Полезные материалы
// https://metanit.com/java/tutorial/3.11.php



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DataContainer<T> {
    private List<T> data;

    public DataContainer(){
        data = new ArrayList<>();
    }

    public void add(T element){
        data.add(element);
    }

    public T get(int index){
        return this.data.get(index);
    }

    public void sort(Comparator<T> comparator){
        data.sort(comparator);
    }

    public void print(){
        for (T element : data){
            System.out.println(element);
        }
    }
}