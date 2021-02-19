package stackQueue;

import java.util.Stack;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/19 4:08 PM
 */
public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack(){
    }

    public void push(int x){
        stack.push(x);
        if(minStack.size()==0 ||x<=minStack.peek())
            minStack.push(x);
        else
            minStack.push(minStack.peek());
    }

    public void pop(){
        stack.pop();
        minStack.pop();
    }

    public int top(){
        return stack.peek();
    }

    public int getMin(){
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
