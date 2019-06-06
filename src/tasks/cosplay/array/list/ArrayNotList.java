package tasks.cosplay.array.list;

import java.util.Arrays;

public class ArrayNotList<T> implements NotList<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private T[] array;
    private int indexForNextPut = 0;

    public ArrayNotList() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public int getIndexForNextPut() {
        return indexForNextPut;
    }

    public void arrayGrower() {
        T[] temp;
        temp = (T[]) new Object[array.length + (array.length >> 1)];
        System.arraycopy(array, 0, temp, 0, array.length);
        array = temp;
    }

    @Override
    public void add(T value) {
        if (indexForNextPut == array.length) {
            arrayGrower();
        }
        array[indexForNextPut] = (T) value;
        indexForNextPut++;
    }

    @Override
    public void add(T value, int index) {
        if (index > indexForNextPut) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds");
        }
        T[] temp = (T[]) new Object[indexForNextPut - index];
        System.arraycopy(array, index, temp, 0, temp.length);
        array[index] = (T) value;
        System.arraycopy(temp, 0, array, index + 1, temp.length);
        indexForNextPut++;
    }

    @Override
    public void addAll(T[] notList) {
        while (indexForNextPut + notList.length >= array.length) {
            arrayGrower();
        }
        System.arraycopy(notList, 0, array, indexForNextPut, notList.length);
        indexForNextPut += notList.length;
    }

    @Override
    public T get(int index) {
        if (index >= indexForNextPut) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds");
        }
        return array[index];
    }

    @Override
    public void set(T value, int index) {
        if (index >= indexForNextPut) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds");
        }
        array[index] = value;
    }

    @Override
    public T remove(int index) {
        if (index >= indexForNextPut) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds");
        }
        T value = null;
        for (int i = index; i < indexForNextPut; i++) {
            if (value == null) {
                value = array[i];
            }
            array[i - 1] = array[i];
        }
        indexForNextPut--;
        return value;
    }

    @Override
    public T remove(T t) {
        T value = null;
        for (int i = 0; i < indexForNextPut; i++) {
            if (value == null) {
                if (array[i].equals(t)) {
                    value = array[i];
                }
            } else {
                array[i - 1] = array[i];
            }
        }
        indexForNextPut--;
        return value;
    }

    @Override
    public int size() {
        return getIndexForNextPut();
    }

    @Override
    public boolean isEmpty() {
        return getIndexForNextPut() == 0;
    }


    @Override
    public String toString() {
        return "ArrayNotList{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayNotList<?> that = (ArrayNotList<?>) o;
        return Arrays.equals(array, that.array);
    }
}
