package cn.merryyou.stackandqueue.stack01;

import java.util.Stack;

/**
 * Created on 2018/6/21.
 *
 * @author zlf
 * @since 1.0
 */
public class SolutionArrayStack {

    public boolean isValid(String s){
        ArrayStack<Character> stack = new ArrayStack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(c=='('||c=='['||c=='{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }

                char topChar = stack.pop();
                if(c == ')' && topChar != '(')
                    return false;
                if(c == ']' && topChar != '[')
                    return false;
                if(c == '}' && topChar != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println((new SolutionArrayStack()).isValid("()[]{}"));
        System.out.println((new SolutionArrayStack()).isValid("([)]"));
    }
}
