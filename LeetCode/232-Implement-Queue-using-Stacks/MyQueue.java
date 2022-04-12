import java.util.Stack;

/*********************************************************************************************************
 * Task 232. Implement Queue using Stacks
 * 
 * Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should 
 * support all the functions of a normal queue (push, peek, pop, and empty).
 * 
 * Implement the MyQueue class:
 *  - void push(int x) Pushes element x to the back of the queue.
 *  - int pop() Removes the element from the front of the queue and returns it.
 *  - int peek() Returns the element at the front of the queue.
 *  - boolean empty() Returns true if the queue is empty, false otherwise.
 * 
 * Notes:
 *  - You must use only standard operations of a stack, which means only push to top, peek/pop from top, 
 *    size, and is empty operations are valid.
 *  - Depending on your language, the stack may not be supported natively. You may simulate a stack using 
 *    a list or deque (double-ended queue) as long as you use only a stack's standard operations.
 */


class MyQueue {

    private Stack<Integer> myStack;

    public MyQueue() {
        myStack = new Stack<>();
    }
    
    public void push(int x) {
        myStack.push(x);
    }
    
    public int pop() {
        return myStack.remove(0);
    }
    
    public int peek() {
        return myStack.firstElement();

    }
    
    public boolean empty() {
        return myStack.empty();
    }

    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        int param_5 = obj.pop();
        boolean param_6 = obj.empty();

        System.out.println( "param_2 = " + param_2 + ", param_3 = " + param_3 + ", param_4 = " +  param_4 +
                            ", param_5 = " + param_5 + ", param_6 = " + param_6 );
    }
}