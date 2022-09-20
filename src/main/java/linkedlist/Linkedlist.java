package linkedlist;

import java.util.Scanner;

public class Linkedlist<T> {

    class Node<T>{
        T data;
        Node next;

        Node(T data){
            this.data=data;
        }
    }

    Node head;

    //insertion
    private Linkedlist<T> insertNodeAtTheEnd(T data,Linkedlist<T> linkedlist){
        Node newnode = new Node(data);
        if(linkedlist.head==null){
            linkedlist.head=newnode;
        }else{
            Node temp=linkedlist.head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newnode;
        }
        return linkedlist;
    }

    private Linkedlist<T> insertNodeAtMiddle(T data, Linkedlist<T> linkedlist, int position){
        Node temp= linkedlist.head;
        Node newnode = new Node(data);
        if(position>1){
            for(int i=1;i<position-1;i++){
                temp=temp.next;
            }
            newnode.next=temp.next;
            temp.next=newnode;
        }else{
            newnode.next=head;
            head=newnode;
        }
        return linkedlist;
    }

    //deletion
    private void deleteNode(int position, Linkedlist<T> linkedlist){}

    //reversal
    private void reverseList(Linkedlist<T> linkedlist){}

    //middle
    private void findMiddle(Linkedlist<T> linkedlist){}

    //search
    private void searchList(Linkedlist<T> linkedlist){}

    //print
    private void printList(Linkedlist<T> linkedlist){
        Node temp= linkedlist.head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Linkedlist linkedlist = new Linkedlist();
        Linkedlist buildList=null;
        Scanner scanner = new Scanner(System.in);
        String element = null;
        for(int i=0;i<5;i++){
            System.out.println("Enter the element for the list: ");
            element = scanner.next();
            buildList = linkedlist.insertNodeAtTheEnd(element,linkedlist);
        }
        linkedlist.printList(buildList);
        buildList = linkedlist.insertNodeAtMiddle(element,buildList,1);
        linkedlist.printList(buildList);
        /*AtomicReference<Linkedlist> createdList = new AtomicReference<>();
        IntStream.range(0,5).forEach(i->{
            System.out.println("Enter the element for the list: ");
            int element = scanner.nextInt();
            Node<Integer> newnode = new Node(element);
            createdList.set(linkedlist.insertNodeAtTheEnd(newnode, linkedlist));
        });
        linkedlist.printList(createdList.get());*/
    }
}
