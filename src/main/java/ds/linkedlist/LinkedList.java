package ds.linkedlist;

/**
 * Contents:
 * 1 - Insert newnode at the end of the list.
 * 2 - Insert newnode at the beginning of the list.
 * 3 - Insert a newnode in the middle of the linkedlist.
 * 4 - Reverse a linkedlist.
 * 5 - Find the middle of a linked list.
 * 6 - Find the length of a linked list.
 * 7 - Print the contents of the linked list.
 * @param <T>
 */
public class LinkedList<T> {
    static class Node<T>{ //nested class or an inner class
        T data;
        Node<T> next;

        public Node(T data){
            this.data=data;
        }
    }

    Node<T> head;

    /**
     * Create a new linked list, by inserting a newnode at the end.
     * @param linkedList
     * @return
     */
    public LinkedList<T> createLinkedList(T data,LinkedList<T> linkedList){
        Node<T> newnode = new Node<>(data);
        if(linkedList.head==null){
            linkedList.head = newnode;
        }else{
            Node<T> temp = linkedList.head;
            while(temp.next!=null){
                temp = temp.next;
            }
            temp.next=newnode;
        }
        return linkedList;
    }

    /**
     * Insert a newnode at the beginning of the linkedlist.
     * @param data
     * @param linkedList
     * @return
     */
    public LinkedList<T> insertNodeAtBeginning(T data,LinkedList<T> linkedList){
        Node<T> newnode = new Node<>(data);
        newnode.next= linkedList.head;
        linkedList.head=newnode;
        return linkedList;
    }

    /**
     * Insert a newnode in the middle of the linkedlist.
     * @param data
     * @param position
     * @param linkedList
     * @return
     */
    public LinkedList<T> insertNodeInMiddle(T data,int position,LinkedList<T> linkedList){
        Node<T> newnode = new Node<>(data);
        Node<T> temp = linkedList.head;
        for (int i = 1; i < position-1; i++) {
            if(temp.next!=null){ //incase we reach the end of the linkedlist.
                temp = temp.next;
            }
        }
        newnode.next=temp.next;
        temp.next=newnode;
        return linkedList;
    }

    /**
     * Reverse a linkedlist.
     * @param linkedList
     * @return
     */
    public LinkedList<T> reverseList(LinkedList<T> linkedList){
        Node<T> previous = null, temp, current = linkedList.head;
        while(current!=null){
            temp = current.next;
            current.next=previous;
            previous = current;
            current = temp;
        }
        head = previous;
        return linkedList;
    }

    /**
     * Find the middle of a linked list.
     * @param linkedList
     * @return
     */
    public T findMiddle(LinkedList<T> linkedList){
        Node<T> fast,slow;
        fast = slow = linkedList.head;
        while(fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }

    /**
     * Find count of linked list.
     * @param linkedList
     * @return
     */
    public int findLength(LinkedList<T> linkedList){
        Node<T> temp = linkedList.head;
        int count = 0;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        return count;
    }

    /**
     * Print the contents of the linked list.
     * @param linkedList
     */
    public void printLinkedList(LinkedList<T> linkedList){
        Node<T> temp = linkedList.head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        integerLinkedList.createLinkedList(1,integerLinkedList);
        integerLinkedList.createLinkedList(2,integerLinkedList);
        integerLinkedList.createLinkedList(3,integerLinkedList);
        integerLinkedList.insertNodeAtBeginning(4,integerLinkedList);
        integerLinkedList.insertNodeInMiddle(5,5,integerLinkedList);
        System.out.println("Before Linkedlist Reversal: ");
        integerLinkedList.printLinkedList(integerLinkedList);
        integerLinkedList.reverseList(integerLinkedList);
        System.out.println("After Linkedlist Reversal: ");
        integerLinkedList.printLinkedList(integerLinkedList);
        System.out.println("Middle of Linkedlist: "+integerLinkedList.findMiddle(integerLinkedList));
        System.out.println("Length of Linkedlist: "+integerLinkedList.findLength(integerLinkedList));
    }
}
