//Circular Queue
import java.util.Arrays;

public class Waiting_Queue {
    private int SIZE = 8; // Size of Circular Queue
    String[] Name = new String[SIZE];
    int[] Number = new int[SIZE];
    private int front, rear;

    public Waiting_Queue() {
        front = -1;
        rear = -1;
    }

    // Check if the queue is full
    public boolean isFull() {
        if (front == 0 && rear == SIZE - 1) {
            return true;
        }
        if (front == rear + 1) {
            return true;
        }
        return false;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }

    // Adding an String element
    public void enQueueString(String name) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % SIZE;
            Name[rear] = name;
        }
    }

    // Adding an Integer element
    public void enQueueNumber(int num) {
        if (isFull()) {
            System.out.println("Queue is full");
        } else {
            if (front == -1)
                front = 0;
            rear = (rear + 1) % SIZE;
            Number[rear] = num;
        }
    }

    // Removing a String element
    public String deQueueString() {
        String name = null;
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            // de-queuing room name array.
            name = Name[front];
            Name[front] = null;
            front = (front + 1)% Name.length;
        }
        return (name);
    }

    // Removing a Number element
    public int deQueueNumber() {
        int num = 0;
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            // de-queuing room name array.
            num = Number[front];
            Number[front] = 0;
            front = (front + 1)% Number.length;
        }
        return (num);
    }
}