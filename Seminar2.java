// Реализовать класс Market и все его обязательные методы(Придумайте любые). Этот класс должен реализовывать методы из интерфейса QueueBehaviour, 
// которые имитируют работу очереди. Кроме того, класс должен содержать методы, соответствующие интерфейсу MarketBehaviour, 
// которые добавляют и удаляют людей из очереди, а также метод update, который обновляет состояние магазина путем принятия и отдачи заказов.


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

interface QueueBehaviour<T> {
    void enqueue(T item);
    T dequeue();
}

interface MarketBehaviour<T> {
    void addPerson(T person);
    T removePerson();
    void update();
}

class Market<T> implements QueueBehaviour<T>, MarketBehaviour<T> {
    private Queue<T> queue;
    private ArrayList<T> orders;

    public Market() {
        queue = new LinkedList<>();
        orders = new ArrayList<>();
    }

    // QueueBehaviour 
    public void enqueue(T item) {
        queue.add(item);
    }

    public T dequeue() {
        return queue.poll();
    }

    // MarketBehaviour
    public void addPerson(T person) {
        enqueue(person);
    }

    public T removePerson() {
        return dequeue();
    }

    public void update() {
        while (!orders.isEmpty()) {
            T order = orders.remove(0);
            deliverOrder(order);
        }
    }

    public void acceptOrder(T order) {
        orders.add(order);
    }

    public void deliverOrder(T order) {
        System.out.println("Delivering order: " + order);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}