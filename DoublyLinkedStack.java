import java.util.EmptyStackException;

public class DoublyLinkedStack<T>{

    //Node object which will be pushed onto the stack
    private class Node<T>{
        private T data;
        private Node<T> next;
        private Node<T> prev;
        public Node(T data){
            this.data = data;
        }
    }

    //reference to the top of the stack
    private Node<T> head;

    //O(1) time complexity for inserting an element and moving pointers
    public void push(T data){
        //first element added
        if(head == null){
            head = new Node<>(data); //create the new Node object with data
            head.next = null; //no next element
            head.prev = null; //no previous element
        }
        //adding to the end/top of the stack
        else{
            head.next = new Node<>(data); //shift the current pointer's next to the new Node instead of null
            head.next.prev = head; //the new Node's previous value should point to the current head which is being pushed down in the stack
            head = head.next; //make the new Node the top of the stack as the new head

            head.next = null; //at the top of the stack, no next element, only previous
        }
    }

    //O(1) for top element retrieval, pointer shifts
    public T pop(){
        //get reference to the data being removed
        T data = head.data;
        //only 1 element
        if(head.prev == null){
            head = null;
        }
        else {
            head.prev.next = null; //remove the previous Node's pointer to the current top element in the stack
            head = head.prev; //the previous Node is now the top element
        }
        return data; //display the data just removed
    }

    //O(1) to return the top element's data, no searching involved
    public T peek(){
      if(head == null){
        throw new EmptyStackException();
      }
      return head.data;

    }

    //O(1) to check if the known memory address of head exists or not
    public Boolean isEmpty(){
        return head == null;
    }

//    public void print(){
//        Node copy = head;
//        while(copy != null){
//            System.out.print(copy.data + ", ");
//            copy = copy.prev;
//        }
//    }
}
