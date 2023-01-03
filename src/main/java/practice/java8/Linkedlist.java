package practice.java8;

/**
 * Linkedlist
 * create
 * print
 * find middle
 * reverse
 * @param <T>
 */
public class Linkedlist<T> {

    private Node<T> head;
    private static class Node<T>{
        T data;
        Node<T> next;

        Node(T data){
            this.data=data;
        }
    }

    private Linkedlist<T> createList(Node<T> newnode,Linkedlist<T> list){
        if(list.head==null){
            list.head=newnode;
        }else{
            Node<T> temp = list.head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next=newnode;
        }
        return list;
    }

    private void printList(Linkedlist<T> linkedlist){
        for(Node<T> temp = linkedlist.head;temp!=null;temp=temp.next){
            System.out.print(temp.data+"->");
        }
        System.out.print("null ");
        System.out.println();
    }

    private T findMiddle(Linkedlist<T> linkedlist){
        Node<T> fast,slow;
        fast = slow = linkedlist.head;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    private Linkedlist<T> reverseList(Linkedlist<T> linkedlist){
        Node<T> curr=linkedlist.head,prev = null,temp;
        while(curr!=null){
            temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        head = prev;
        return linkedlist;
    }

    public static void main(String[] args) {
        Linkedlist linkedlist = new Linkedlist();
        Node<Integer> integerNode1 = new Node<>(1);
        Node<String> integerNode2 = new Node<>("2");
        Node<Integer> integerNode3 = new Node<>(3);
        Node<Integer> integerNode4 = new Node<>(4);

        linkedlist.createList(integerNode1, linkedlist);
        linkedlist.createList(integerNode2, linkedlist);
        linkedlist.createList(integerNode3, linkedlist);
        linkedlist.createList(integerNode4, linkedlist);
        linkedlist.printList(linkedlist);
        System.out.println(linkedlist.findMiddle(linkedlist));
        linkedlist.reverseList(linkedlist);
        linkedlist.printList(linkedlist);
    }
}
