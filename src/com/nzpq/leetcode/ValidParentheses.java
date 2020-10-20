package com.nzpq.leetcode;

import java.util.Stack;

/**
 * @author 鹏
 * @Date 2020-10-14 22:26
 *
 * 括号匹配
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *      左括号必须用相同类型的右括号闭合。
 *      左括号必须以正确的顺序闭合。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidParentheses {

    public static void main(String[] args) {
        String s = "{[()]}";

        System.out.println(isValid(s));

    }


    public static boolean isValid(String s){
        //使用java.util下的栈
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char topChar = stack.pop();
                if(c == ')' && topChar != '('){
                    return false;
                }
                if(c == ']' && topChar != '['){
                    return false;
                }
                if(c == '}' && topChar != '{'){
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    /**
     * leetCode大神的写法
     * @param s
     * @return
     */
    public boolean isValidLeetCode(String s) {
        Stack<Character>stack = new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='('){
                stack.push(')');
            } else if(c=='['){
                stack.push(']');
            }else if(c=='{'){
                stack.push('}');
            }else if(stack.isEmpty() || c != stack.pop()){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
