public class LinkedQueue {

    /**
     * Enqueue, Dequeue, Peek, and isEmpty are all O(1) constant time compelxity
     * The head and tail pointers are implemented to avoid traversing the queue in a linear fashion
     */

    private class Node{
        private int data;
        private Node next;
        public Node(int data){ this.data = data; }
    }
    //Head pointer to keep track of the first element added to the queue
    private Node head;
    //tail pointer is where elements are added, to the back of the queue
    private Node tail;

    public void enqueue(int data){
        //new Node object with data
        Node node = new Node(data);
        //first element added
        if(head == null){
            //head and tail equal each other
            head = node;
            tail = head;
        }
        else{
            //more than 1 element..
            tail.next = node; //add to the tail's next (tail is at the prev element right now)
            tail = tail.next; //make the tail equal the next node (last element added to the queue)
        }
    }

    //remove from the head/front
    public int dequeue(){
        //retrieve data
        int displayData = head.data;
        //not deleting data but shifting the head pointer to the next node
        head = head.next;
        //removing the first element makes the queue empty
        if(head == null){
            tail = null;
        }
        return displayData;
    }

    public int peek(){
        if(head == null){
            throw new NullPointerException();
        }
        else{
            return head.data;
        }
    }

    public Boolean isEmpty(){return head == null;};
}
