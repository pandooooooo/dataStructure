package stackQueue;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author liukx
 * @version 1.0
 * @date 2021/2/19 5:11 PM
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        Map<Character, Character> pattern = new HashMap<>();

        pattern.put('(', ')');
        pattern.put('[', ']');
        pattern.put('{', '}');

        for(char c : s.toCharArray()){
            if(pattern.containsKey(c)){
                stack.push(c);
            }else{
                if(stack.isEmpty() || pattern.get(stack.pop()) != c)
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
