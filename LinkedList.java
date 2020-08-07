import java.util.Map;
import java.util.HashMap;
import java.util.*;

public class LinkedList {

    //Node object to make up the linked list
    private class Node{
        Node next;
        int data;
        public Node(int data){
            this.data = data;
        }
    }

    private Node head;


    //Time complexity: O(n) - appending to the end of the linked list requires traversal of n items to reach the last null node
    public void append(int data){
        Node current  = head;

        //if the head is null, create the first node
        if(head == null){
            head = new Node(data);
        }
        else{
            //traverse all elements to shift the pointer to the end
            while(current.next != null){
                current = current.next;
            }
            //create the new node
            current.next = new Node(data);
        }
    }

    //Time complexity: O(1) - creating a new node and shifting a pointer does not create a lot of overhead
    public void prepend(int data){
        //create the new head
        Node tempNewHead = new Node(data);
        tempNewHead.next = head; //the current head becomes the new head's next node
        head = tempNewHead; //re-route the head to be the first node

    }

    //Time complexity: Best: O(1) - delete the head being the first data node. Worst: O(n) - iterating through all the elements to find the data node for deletion
    public void delete(int data){
        Node current = head;

        //no nodes in the linked list
        if(current == null) return;

        //if the data is at the head, just make the next node the head pointer effectively removing visibility to the head (data is still stored in memory)
        if(current.data == data){
            current = current.next;
        } else{
            //iterate through elements until data is found
            while(current.next != null ){

                if(current.next.data == data){
                    //re-assign the next pointer
                    current.next = current.next.next;
                    return; //stop after the first data containing node is found
                }
                current = current.next;

            }

        }
    }


//    public void print(){
//        Node current = head;
//        System.out.println(current.data);
//
//       while(current.next != null){
//           current = current.next;
//           System.out.println(current.data);
//        }
//    }

}
