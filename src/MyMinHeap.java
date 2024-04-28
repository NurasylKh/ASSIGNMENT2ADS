import interfaces.MyList;

public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> list;

    public MyMinHeap() {
        list = new MyArrayList<>();
    }

    public void add(T item) {
        list.add(item);
        int index = list.size() - 1;
        while (index > 0 && list.get(parent(index)).compareTo(list.get(index)) > 0) {
            list.set(index, list.get(parent(index)));
            list.set(parent(index), item);
            index = parent(index);
        }
    }

    public T remove() {
        if (list.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        T result = list.get(0);
        T last = list.get(list.size() - 1);
        list.removeLast();
        if (list.size() > 0) {
            list.set(0, last);
            heapifyDown(0);
        }
        return result;
    }

    public T peek() {
        if (list.size() == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public int size() {
        return list.size();
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void heapifyDown(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int smallest = index;
        if (left < list.size() && list.get(left).compareTo(list.get(smallest)) < 0) {
            smallest = left;
        }
        if (right < list.size() && list.get(right).compareTo(list.get(smallest)) < 0) {
            smallest = right;
        }
        if (smallest != index) {
            T temp = list.get(index);
            list.set(index, list.get(smallest));
            list.set(smallest, temp);
            heapifyDown(smallest);
        }
    }
}
