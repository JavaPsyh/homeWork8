package tasks.cosplay.array.list;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private T[] array;
    private int size = 0;

    public MyArrayList() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void arrayGrower() {
        int tempLength = array.length + (array.length >> 1);
        T[] temp = (T[]) new Object[tempLength];
        System.arraycopy(array, 0, temp, 0, array.length);
        array = temp;
    }

    @Override
    public void add(T value) {
        if (size == array.length) {
            arrayGrower();
        }
        add(value, size);
    }

    @Override
    public void add(T value, int index) {
        addIndexValidation(index);
        T[] temp = (T[]) new Object[size - index];
        System.arraycopy(array, index, temp, 0, temp.length);
        array[index] = value;
        System.arraycopy(temp, 0, array, index + 1, temp.length);
        size++;
    }

    @Override
    public void addAll(MyList<T> myList) {
        if (myList != null) {
            while (size + myList.size() >= array.length) {
                arrayGrower();
            }
            for (int i = 0; i < myList.size(); i++) {
                add(myList.get(i));
            }
        }
    }

    @Override
    public T get(int index) {
        indexValidation(index);
        return array[index];
    }

    @Override
    public void set(T value, int index) {
        indexValidation(index);
        array[index] = value;
    }

    @Override
    public T remove(int index) {
        indexValidation(index);
        T value = array[index];
        System.arraycopy(array, index + 1, array, index, size() - index);
        size--;
        return value;
    }

    @Override
    public T remove(T t) {
        int index = 0;
        for (int i = 0; i < size; i++) {
            if (t.equals(array[i])) {
                index = i;
            }
        }
        return remove(index); // Yes, array[size-1] and array[size] are the same,
//but array[size] throws IndexOutOfBoundsException, so it will never be read.
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "array = " + Arrays.toString(Arrays.copyOf(array, size())) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyArrayList<?> that = (MyArrayList<?>) o;
        return Arrays.equals(array, that.array);
    }

    private void indexValidation(int index) {
        if (index >= size()) {
            throw new IndexOutOfBoundsException("Incorrect index: " + index);
        }
    }

    private void addIndexValidation(int index) {
        if (index > size()) {
            throw new IndexOutOfBoundsException("Incorrect index: " + index);
        }
    }
}
