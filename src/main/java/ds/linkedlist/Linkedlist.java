package ds.linkedlist;

/**
 * Incase of even numbers: eg: 1->2->3->4->NULL
 * For O/P=2 => while(fast.next!=null && fast.next.next!=null)
 * For O/P=3 => while(fast!=null && fast.next!=null)
 */
public class Linkedlist {

    Node head;

    private Node findMiddleNode(Linkedlist linkedlist){
        Node fastPtr=linkedlist.head,slowPtr=linkedlist.head;
        while(fastPtr!=null && fastPtr.next!=null){
            fastPtr=fastPtr.next.next;
            slowPtr=slowPtr.next;
        }
        return slowPtr;
    }

    private Linkedlist reverseLinkedlist(Linkedlist linkedlist){
        Node curr=linkedlist.head;
        Node prev=null,temp=null;

        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        linkedlist.head=prev;
        return linkedlist;
    }

    private Linkedlist buildLinkedlist(Node newnode,Linkedlist list){
        if(list.head==null){
            list.head=newnode;
            newnode.next=null;
        }else{
            Node temp=list.head;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newnode;
        }
        return list;
    }

    private void printLinkedList(Linkedlist list){
        Node temp=list.head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Linkedlist list = new Linkedlist();
        Node newnode = new Node(1);
        Node secondNode = new Node(2);
        Node thirdNode = new Node(3);
        Node fourthNode = new Node(4);
        list.buildLinkedlist(newnode,list);
        list.buildLinkedlist(secondNode,list);
        list.buildLinkedlist(thirdNode,list);
        list.buildLinkedlist(fourthNode,list);
        list.printLinkedList(list);
        System.out.println();
        System.out.println(list.findMiddleNode(list).data);
        System.out.println();
        list.reverseLinkedlist(list);
        list.printLinkedList(list);
    }
}
