import interfaces.MyList;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {

    private T[] arr;//array that stores elements of list
    private int size;//current size of list

    public MyArrayList() {
        arr = (T[]) new Object[10];//array size of 10
        size = 0;//set the initial size
    }
    private void increaseBuffer(){//a private method to increase size
        T[] newArr = (T[]) new Object[size*2];//new array with double size
        for(int i = 0; i < size; i++){//copy elements of current array to new
            newArr[i] = arr[i];
        }
        arr = newArr;//set new array as current

    }

    @Override
    public void add(T item) {
        System.out.println(arr.length);// Print current size of array
        if(size >= arr.length){// Check if array is full
            increaseBuffer();// Increase size of array if it's full
        }
        arr[size++] = item;// Add new element to the end of array and increment size of the list
    }

    @Override
    public void set(int index, T item) {
        if(index < 0 || index >= size){// Check if index is out of range
            System.out.println("Index out ot range");// Print a message if index is out of range
        }else{
            arr[index] = item;// Set element at the specified index to the new value
        }

    }

    @Override
    public void add(int index, T item) {//inserts an element at specified index

    }

    @Override
    public void addFirst(T item) {//inserts element at the beginning of  list

    }

    @Override
    public void addLast(T item) {//inserts element at the end of list

    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {// Check if the index is out of range
            return null;
        }
        return arr[index];
    }

    @Override
    public T getFirst(T item) {//returns first element of the list
        return null;
    }

    @Override
    public T getLast(T item) {//returns last element of the list
        return null;
    }

    @Override
    public void remove(int index) {//removes element at the specified index

    }

    @Override
    public void removeFirst() {//removes first element of the list

    }

    @Override
    public void removeLast() {//removes last element of the list

    }

    @Override
    public void sort() {//sorts elements of list

    }

    @Override
    public int indexOf(T item) {//index of the first occurrence of the specified element
        return 0;
    }

    @Override
    public int lastIndexOf(T item) {//index of last occurrence of specified element in the list
        return 0;
    }

    @Override
    public boolean exists(T item) {//checks if list contains the specified element
        return false;
    }

    @Override
    public T[] toArray() {
        T[] result = (T[]) new Object[size]; // Create a new array of type T with equal size to current size of list
        System.arraycopy(arr, 0, result, 0, size); // Copy all elements of the list to new array
        return result; // return new array of type T
    }

    @Override
    public void clear() {//removes all elements from the list

    }

    @Override
    public int size() {//current size of the list
        return 0;
    }

    @Override
    public Iterator iterator() {//an iterator over the elements in the list
        return null;
    }
}