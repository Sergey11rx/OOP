// 3)(Опционально,по желанию) Задача: Написать функцию, которая принимает список объектов и компаратор для сортировки объектов по заданному критерию.
// Функция должна возвращать отсортированный список объектов. Это может быть реализовано, например, 
// с использованием метода Collections.sort() и переданного компаратора.

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ObjectSorter {

    public static <T> List<T> sort(List<T> objects, Comparator<? super T> comparator) {
        Collections.sort(objects, comparator);
        return objects;
    }
    
    public static void main(String[] args) {
        // Создаем список объектов
        List<Integer> numbers = List.of(5, 2, 10, 1, 8);

        // Создаем компаратор для сортировки чисел в порядке возрастания
        Comparator<Integer> ascendingComparator = Comparator.naturalOrder();

        // Сортируем список чисел
        List<Integer> sortedNumbers = sort(numbers, ascendingComparator);

        // Выводим отсортированный список
        for (Integer number : sortedNumbers) {
            System.out.println(number);
        }
    }
}