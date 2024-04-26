public class MyQueue<T> {
    private T[] arr;
    private int front;
    private int rear;
    private int size;

    public MyQueue() {
        arr = (T[]) new Object[10];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(T item) {
        if (size == arr.length) {
            resize();
        }
        rear = (rear + 1) % arr.length;
        arr[rear] = item;
        size++;
    }

    public T dequeue() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = arr[front];
        front = (front + 1) % arr.length;
        size--;
        if (size == arr.length / 4) {
            resize();
        }
        return item;
    }

    public T peek() {
        if (size == 0) {
            throw new IllegalStateException("Queue is empty");
        }
        return arr[front];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void resize() {
        T[] newArr = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[(front + i) % arr.length];
        }
        arr = newArr;
        front = 0;
        rear = size - 1;
    }
}
