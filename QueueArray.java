public class QueueArray {

    private long queueArray[];
    private int capacity, numItems, front, back;

    /*
        * Space Complexity - O(k) where k = size of the array
        * Time Complexity - O(1) for Enqueue, Dequeue, Peek, isEmpty, and isFull
        * This implementation of Dequeue does not remove the value and shift all array elements
        * It will shift the front pointer (so the value can't be seen) and overwrite in the next pass
     */

    public QueueArray(int capacity){
        this.capacity = capacity;
        this.queueArray = new long[capacity];
        numItems = 0;
        front = 0;
        back = -1;
    }

    public void enqueue(long data){

        //if the queue becomes full, then begin overwriting elements in the front (wraparound)
        if(back == capacity){
            back = -1;
        }

        queueArray[++back] = data;
        numItems++;
    }

    public long dequeue(){

        numItems--;

        //get the value at the front being removed, then increase the position of the queue's front
        long displayData = queueArray[front++];

        //the front pointer was moved all the way to the end.
        // To prevent going out of bounds, shift the front back to the first index of the array
        if(front == capacity){
            front = 0;
        }

        return displayData;
    }

    public long peek(){
        return queueArray[front];
    }

    public Boolean isEmpty(){
        return numItems == 0;
    }

    public boolean isFull(){
        return numItems == capacity;
    }

}
