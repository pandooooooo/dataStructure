package stackQueue;

import java.util.Stack;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/19 4:27 PM
 */
public class ImplementQueueUsingStacks {
    class MyQueue{
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;
        private int front;

        public MyQueue(){
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int x){
            if(stack1.isEmpty()){
                front = x;
            }

            stack1.push(x);
        }

        public int pop(){
            if(stack2.isEmpty()){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }

            return stack2.pop();
        }

        public int peek(){
            if(stack2.isEmpty())
                return front;

            return stack2.peek();
        }

        public boolean empty(){
            return stack1.isEmpty() && stack2.isEmpty();
        }
    }
}
