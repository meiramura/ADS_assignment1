import java.util.Scanner;

public class Main{
    public static void main(String[] args) {

    MyList<String> arrayList = new MyArrayList<>();

    arrayList.add("Aman");
    arrayList.add("Temir");
    arrayList.add("Bauyr");


    System.out.println("Size of MyArrayList: " + arrayList.size());


    System.out.println("Element at index 1: " + arrayList.get(1));

    arrayList.remove(0);
        System.out.println("The rest guys:");

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }
    arrayList.sort();
        System.out.println("Sorted:");

        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i));
        }




    MyList<String> list = new MyLinkedList<>();
    list.add("Aman");
    list.add("Temir");
    list.add("Jandarbek");
    list.add("Make");
    System.out.println("Initial List:");
    printList(list);
    list.sort();
    System.out.println("\nSorted List:");
    printList(list);
    list.remove(2);
    System.out.println("\nList after removing element at index 2:");
    printList(list);
    list.add("Eve", 1);
    System.out.println("\nList after adding Eve at index 1:");
    printList(list);
    System.out.println("\nElement at index 2: " + list.get(2));
    }
    private static void printList(MyList<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

}


