package tasks;

//Реализовать свой ArrayNotList исходя из интерфейса
// https://pastebin.com/wMsifZSt
// + почитать PECS

import tasks.cosplay.array.list.ArrayNotList;
import tasks.cosplay.array.list.NotList;

public class Application {
    public static void main(String[] args) {
        String[] strings = new String[]{"1", "2", "3"};
        NotList<String> notList = new ArrayNotList<String>();

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

        notList.add("Fuck");
        System.out.println(notList.size());// 5
        System.out.println();

        for (int i = 0; i < notList.size(); i++) {
            System.out.println(notList.get(i));//6.7.8.9.10
        }
        System.out.println();

        notList.add("Fucking zero", 0);
        notList.add("Fucking zero", 6);
        for (int i = 0; i < notList.size(); i++) {
            System.out.println(notList.get(i));//
        }
        System.out.println();

        notList.addAll(strings);
        for (int i = 0; i < notList.size(); i++) {
            System.out.println(notList.get(i));
        }
        System.out.println();

        notList.set("Fucking life", 1);
        System.out.println(notList.get(1));
        System.out.println();

        System.out.println(notList.remove(1)); // возвращаем элемент, который удалили
        System.out.println();

        for (int i = 0; i < notList.size(); i++) {
            System.out.println(notList.get(i));
        }
        System.out.println();

        System.out.println(notList.remove("Fucking zero")); // возвращаем элемент, который удалили
        for (int i = 0; i < notList.size(); i++) {
            System.out.println(notList.get(i));
        }

        System.out.println();

        System.out.println(notList.size());
        System.out.println(notList.isEmpty());
    }
}
