package tasks.cosplay.array.list;

public class ArrayNotList<T> implements NotList<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private NotList<T>[] array;
    private int indexForNextPut = 0;

    public ArrayNotList() {
        array = (NotList<T>[]) new ArrayNotList[DEFAULT_CAPACITY];
    }

    public int getIndexForNextPut() {
        return indexForNextPut;
    }

    public void arrayGrower() {
        NotList<T>[] temp;
        temp = (NotList<T>[]) new ArrayNotList[array.length + (array.length >> 1)];
        System.arraycopy(array, 0, temp, 0, array.length);
        array = temp;
    }

    @Override
    public void add(T value) {
        if (indexForNextPut == array.length) {
            arrayGrower();
        }
        array[indexForNextPut] = (NotList<T>) value;
        indexForNextPut++;

    }

    @Override
    public void add(T value, int index) {
        if (index > indexForNextPut) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds");
        }
        NotList<T>[] temp = (NotList<T>[]) new ArrayNotList[indexForNextPut - index];
        System.arraycopy(array, index, temp, 0, temp.length);
        array[index] = (NotList<T>) value;
        System.arraycopy(temp, 0, array, index + 1, temp.length);
        indexForNextPut++;
    }

    @Override
    public void addAll(NotList<T> notList) {
        while (indexForNextPut + notList.size() >= array.length) {
            arrayGrower();
        }
        System.arraycopy(notList, 0, array, indexForNextPut, notList.size());
        indexForNextPut += notList.size();
    }

    @Override
    public T get(int index) {
        if (index >= indexForNextPut) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds");
        }
        return (T) array[index];
    }

    @Override
    public void set(T value, int index) {
        if (index >= indexForNextPut) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds");
        }
        array[index] = (NotList<T>) value;
    }

    @Override
    public T remove(int index) {
        if (index >= indexForNextPut) {
            throw new IndexOutOfBoundsException("Index Out Of Bounds");
        }
        T value = null;
        for (int i = index; i < indexForNextPut; i++) {
            if (value == null) {
                value = (T) array[i];
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
                if (array[i] == t) {
                    value = (T) array[i];
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
}
