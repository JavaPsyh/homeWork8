package tasks;

//Реализовать свой ArrayNotList исходя из интерфейса
// https://pastebin.com/wMsifZSt
// + почитать PECS

import tasks.cosplay.array.list.ArrayNotList;
import tasks.cosplay.array.list.NotList;

public class Application {
    public static void main(String[] args) {
        NotList<String> notList = new ArrayNotList<>();
        NotList<String> listTAdd = new ArrayNotList<>();

        listTAdd.add("fghtff");
        listTAdd.add("fuuuuuuu");

        System.out.println(notList.size());//1
        System.out.println(notList.isEmpty());//2
        System.out.println();

        notList.add("zero", 0);
        notList.add("0ne", 1);
        notList.add("two", 2);
        notList.add("three", 3);
        System.out.println(notList.size());//3
        System.out.println();

        System.out.println(notList.get(0));//4
        System.out.println();

        notList.add("Smth");
        System.out.println(notList.size());// 5
        System.out.println();

        for (int i = 0; i < notList.size(); i++) {
            System.out.println(notList.get(i));//6.7.8.9.10
        }
        System.out.println();

        notList.add("New zero", 0);
        notList.add("New zero", 6);
        for (int i = 0; i < notList.size(); i++) {
            System.out.println(notList.get(i));//
        }
        System.out.println();

        notList.addAll(listTAdd);
        for (int i = 0; i < notList.size(); i++) {
            System.out.println(notList.get(i));
        }
        System.out.println();

        notList.set("smth else", 1);
        System.out.println(notList.get(1));
        System.out.println();

        System.out.println(notList.remove(1)); // возвращаем элемент, который удалили
        System.out.println();

        for (int i = 0; i < notList.size(); i++) {
            System.out.println(notList.get(i));
        }
        System.out.println();

        System.out.println(notList.remove("New zero")); // возвращаем элемент, который удалили
        for (int i = 0; i < notList.size(); i++) {
            System.out.println(notList.get(i));
        }

        System.out.println();

        System.out.println(notList.size());
        System.out.println(notList.isEmpty());
    }
}
