public class Stack<T> {
    static class Node<T>{
        T data;
        Node<T> next;
        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }
    Node<T> top;
    public Stack(){
        this.top = null;
    }
    public boolean isEmpty(){
        return top == null;
    }
    public void push(T data){
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }
    public T pop(){
        if(isEmpty()) {
            System.out.println("Error: list is already empty");
            return null;
        }

        T temp = top.data;
        top = top.next;
        return temp;
    }
    public T peek(){
        if(isEmpty()){
            System.out.println("Error: Stack Empty");
            return null;
        }
        else
            return top.data;
    }
}
