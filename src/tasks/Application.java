package tasks;

//Реализовать свой ArrayNotList исходя из интерфейса
// https://pastebin.com/wMsifZSt
// + почитать PECS

import tasks.cosplay.array.list.ArrayNotList;
import tasks.cosplay.array.list.NotList;

public class Application {
    public static void main(String[] args) {

        NotList<String> notList = new ArrayNotList<String>();
        System.out.println(notList.size());
        notList.add("zero", 0);
        notList.add("0ne", 1);
        notList.add("two", 2);
        notList.add("three", 3);

        System.out.println(notList.size());
        System.out.println(notList.get(0));
//        System.arraycopy(notList, 1, notList, 1+1, 2);
    }
}
