import java.util.Arrays;

public class ArrayStack {

    private int arr[];
    private int top = 0;

    //require an initial value constructor to know how large to make the stack
    public ArrayStack(int capacity){
        arr = new int[capacity];
    }

    //O(1) since the memory location of the element is known/computable
    public void push(int data){
        arr[top] = data;
        top ++;
    }

    //Still O(1) since doing an address lookup and replacing the element
    public void pop(){
        top--;
        arr[top] = 0;
    }

    //O(1) constant look up time for the top element in the stack
    public int peek(){
        return arr[top-1];
    }

    public String print(){
        return Arrays.toString(arr);
    }

}
