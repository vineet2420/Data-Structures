public class BinarySearchTreeNode {

    BinarySearchTreeNode left, right;
    int data;

    public BinarySearchTreeNode(int data){
        this.data = data;
    }

    //Time complexity: Avg: O(h) h = height of the tree. Worst: O(n) n = number of nodes in the tree (similar to a linkedlist)
    public void insert(int value){
        //check which side to insert the new node
        //Left:
        if(data <= value){
            if(left == null){
                //inserting a new node
                left = new BinarySearchTreeNode(value);
            }
            else{
                //recursively find the left most node that is null, position to insert
                left.insert(value);
            }
        }
        //Right:
        else{
            if(right == null){
                //insert a new node
                right = new BinarySearchTreeNode(value);
            }
            else{
                //recursively find the right most node that is null, position to insert
                right.insert(value);
            }
        }
    }

    //Time complexity: Best: O(1), the root node was searched. Avg: O(h), depending on max depth of the tree in the left or right. Worst: O(n), unbalance can create a linear structure
    public Boolean contains(int value){
        //base case, also could find the data at the root initially giving O(1) time for search
        if(data == value){
            return true;
        }

        //Search the left subtree
        if(data < value){
            //no left subtree, value does not exist
            if(left == null){
                return false;
            }
            else{
                //iterate through the left subtree recursively and stop when the data is found (base case)
                return left.contains(value);
            }
        }
        //Search the right subtree
        else{
            //no right subtree, value does not exist
            if(right == null){
                return false;
            }
            else{
                //iterate through the right subtree recursively and stop when the data is found (base case)
                return right.contains(value);
            }
        }
    }


    /**
     * Time Complexity for the following depth first traversals:
     * Conceptually: O(n) - Have to traverse each node to print the value, amount work done on each node to print its data is the same operation
     * Analytically: O(n+e), n = # of nodes, e = # of edges.
        * The max # of edges on a single binary node is 2. Max # of edges in a BST = (total nodes - 1).
        * The time complexity can then be re-written: O(n + (n-1)) = O(n).
     */


    public void printInOrder(){
        if(left != null){
            left.printInOrder();
        }

        System.out.println(data);

        if(right != null){
            right.printInOrder();
        }
    }

    public void printPreOrder(){
        System.out.println(data);

        if(left != null){
            left.printInOrder();
        }

        if(right != null){
            right.printInOrder();
        }
    }

    public void printPostOrder(){
        if(left != null){
            left.printInOrder();
        }

        if(right != null){
            right.printInOrder();
        }

        System.out.println(data);
    }


}
