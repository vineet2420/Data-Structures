import java.util.ArrayList;

public class GenericStack<T> {

    //using an ArrayList under the hood for dynamic memory allocation, will increase 50% when capacity reached
    private ArrayList<T> stackArr = new ArrayList<T>();
    //store a pointer to the last element in the stack
    private int top = 0;

    /**
     * add operation, amortized O(1)
     * since only one element being added, it is constant time
     */
    public void push(T data){
        stackArr.add(top, data);
        top++;
    }

    /**
     * remove operation cost is O(1) since the last element of the array is removed
     * no elemental shifts will occur.. if the first element removed, then O(n) since all values shift left
     */
    public T pop(){
        top--;
        T data = stackArr.get(top);
        stackArr.remove(top);
        return data;
    }

    /**
     * O(1) since an Arraylist is an array under the hood, not looping through values
     */
    public T peek(){
       return stackArr.get(top-1);
    }

    public Boolean isEmpty(){
        return top == 0;
    }

    public String print(){
        return stackArr.toString();
    }


}
