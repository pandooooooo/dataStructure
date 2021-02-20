package stackQueue;

import java.util.Stack;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/20 2:50 PM
 */
public class BaseCalculatorII {
    public int calculate(String s){
        Stack<Integer> numStack = new Stack<>();
        int res = 0;

        char lastOp = '+';
        int num = 0;
        for(int i = 0; i<=s.length(); i++) {
            char c;
            if(i<s.length())
                c = s.charAt(i);
            else
                c = 'e';

            if(c == ' ')
                continue;
            if(Character.isDigit(c)){
                num = num * 10 + (c - '0');
                continue;
            }

            switch (lastOp){
                case '*':
                    numStack.push(num * numStack.pop());
                    break;
                case '/':
                    numStack.push(numStack.pop() / num);
                    break;
                case '+':
                    numStack.push(num);
                    break;
                case '-':
                    numStack.push(-num);
                    break;
            }

            lastOp = c;
            num = 0;
        }

        while(!numStack.isEmpty()){
            res += numStack.pop();
        }
        return res;
    }
}
