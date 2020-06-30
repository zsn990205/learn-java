

/*

减少圈复杂度写出的第二个括号匹配的代码

 */


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MystakePractice {
    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Map<Character, Character> map = new HashMap<>();
        //给定key能找到value
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        Stack<Character> stack=new Stack<>();
        for (int i = 0; i <s.length() ; i++) {
            char c = s.charAt(i); //循环遍历符号的字符串
            if (map.get(c) != null) {
                stack.push(c);//进栈
                continue;
            }

            if (stack.empty()) {
                return false;
            }
            Character top = stack.pop();  //出栈
            if (map.get(top).equals(c)) {
                continue;
            }
            //以上情况若都不满足 return false
            return false;
        }
        if(stack.empty()) {
            return true;
        }
        return false;

        }
    }
