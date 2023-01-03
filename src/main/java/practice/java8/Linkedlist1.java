package practice.java8;

public class Linkedlist1<T> {

    private Node<T> head;

    private static class Node<T>{
        T data;
        Node<T> next;

        Node(T data){
            this.data = data;
        }
    }

    private Linkedlist1<T> createList(Node<T> newnode, Linkedlist1<T> list){
        if(list.head == null){
            list.head = newnode;
        }else{
            Node<T> temp = list.head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newnode;
        }
        return list;
    }

    private void printList(Linkedlist1<T> list){
        System.out.println("Linked list is: ");
        for(Node<T> temp = list.head;temp!=null;temp=temp.next){
            System.out.print(temp.data+"->");
        }
        System.out.print("null");
        System.out.println();
    }

    private T findMiddle(Linkedlist1<T> list){
        Node<T> fast,slow;
        fast=slow=list.head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    private Linkedlist1<T> reverseList(Linkedlist1<T> list){
        Node<T> curr=list.head,prev = null,temp = null;
        while(curr!=null){
            temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        head = prev;
        return list;
    }

    public static void main(String[] args) {
        Linkedlist1<Character> list = new Linkedlist1<>();
        Node<Character> characterNode1 = new Node<>('a');
        Node<Character> characterNode2 = new Node<>('b');
        Node<Character> characterNode3 = new Node<>('c');

        list.createList(characterNode1,list);
        list.createList(characterNode2,list);
        list.createList(characterNode3,list);

        list.printList(list);

        System.out.println("Middle of the linked list: "+list.findMiddle(list));
        System.out.println("Reverse List:");
        list.reverseList(list);
        list.printList(list);
    }
}
