package me.mordariy;

import me.mordariy.utils.CrazyLinkedList;

public class Main {

    public static void main(String[] args) {
        CrazyLinkedList<Integer> crazyLinkedList = new CrazyLinkedList<>();
        CrazyLinkedList<Integer> crazyLinkedList2 = new CrazyLinkedList<>();

        crazyLinkedList.add(325);
        crazyLinkedList2.add(325);

        System.out.println(crazyLinkedList.hashCode());
        System.out.println(crazyLinkedList2.hashCode());

        System.out.println(crazyLinkedList.equals(crazyLinkedList2));

    }
}
