package practice.ds;

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
    public static class Node<T>{
        T data;
        Node<T> next;

        Node(T data,Node<T> next){
            this.data=data;
            this.next=next;
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

    private boolean hasLoop(Linkedlist<T> linkedlist){
        Node<T> fast,slow;
        fast = slow = linkedlist.head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }
        return false;
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

    private Linkedlist<T> pairWiseSwap(Linkedlist<T> linkedlist){
        Node<T> newHead = linkedlist.head.next;
        Node<T> curr = linkedlist.head;

        while(curr!=null && curr.next!=null){
            Node<T> temp = curr.next.next;
            curr.next.next=curr;
            curr.next=temp;
            curr=temp;
        }
        linkedlist.head=newHead;
        return linkedlist;
    }

    public static void main(String[] args) {
        Linkedlist linkedlist = new Linkedlist();
        Node<Integer> integerNode1 = new Node<>(1,null);
        Node<String> integerNode2 = new Node<>("2",null);
        Node<Integer> integerNode3 = new Node<>(3,null);
        Node<Integer> integerNode4 = new Node<>(4,null);
        Node<Integer> integerNode5 = new Node<>(5,null);
        //Node<Integer> integerNode5 = new Node<>(5,integerNode4);

        linkedlist.createList(integerNode1, linkedlist);
        linkedlist.createList(integerNode2, linkedlist);
        linkedlist.createList(integerNode3, linkedlist);
        linkedlist.createList(integerNode4, linkedlist);
        linkedlist.createList(integerNode5, linkedlist);
        linkedlist.printList(linkedlist);
        System.out.println("Middle:"+linkedlist.findMiddle(linkedlist));
        System.out.println("Has loop:"+linkedlist.hasLoop(linkedlist));
        linkedlist.reverseList(linkedlist);
        linkedlist.printList(linkedlist);
        linkedlist.pairWiseSwap(linkedlist);
        linkedlist.printList(linkedlist);
    }
}
