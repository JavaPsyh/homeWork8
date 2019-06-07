package tasks.cosplay.array.list;

public interface NotList<T> {

    void add(T value);

    void add(T value, int index);

    void addAll(NotList<T> notList);

    T get(int index);

    void set(T value, int index);

    T remove(int index); // возвращаем элемент, который удалили

    T remove(T t); // удалять первый, который встретится

    int size();

    boolean isEmpty();
}
