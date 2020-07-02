
/*

括号匹配问题

 */

import java.util.Stack;

public class Practice {
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //如果是左括号直接入栈
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }
            //如果是右括号 取栈顶元素和当前括号看是否匹配
            //取栈顶元素的时候 栈为空 返回false
            if (stack.empty()) {
                return false;
            }

            // 取栈顶元素出栈进行匹配
            Character top = stack.pop();
            if (top == '(' && top == ')') {
                continue;
            }
            if (top == '[' && top == ']') {
                continue;
            }
            if (top == '{' && top == '}') {
                continue;
            }

            //到最后如果栈为空 返回true
            if (stack.empty()) {
                return true;
            }

        }  return false;
    }
}
