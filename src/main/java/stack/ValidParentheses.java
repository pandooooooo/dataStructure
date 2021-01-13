package stack;

//20. 有效的括号
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
// 有效字符串需满足：
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
// 注意空字符串可被认为是有效字符串。

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s){
        if(s.trim().equals(""))
            return true;

        Stack<Character> parenthesesStack = new Stack();
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for(char c:s.toCharArray()){
            char topChar = ' ';
            if(!parenthesesStack.empty()) {
                topChar = parenthesesStack.peek();
            }
            if(topChar==' '&&map.containsValue(c)){
                parenthesesStack.push(c);
            }else if(topChar!=' '&&topChar==map.get(c)){
                parenthesesStack.pop();
            }else if(map.containsKey(c)){
                return false;
            }
        }

        if(parenthesesStack.empty())
            return true;
        else
            return false;
    }
}
