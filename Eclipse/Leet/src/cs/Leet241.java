package cs;

import java.util.*;

public class Leet241 {
	public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        bt(new Stack<Integer>(), new Stack<Character>(), 0, input, res);
        return res;
    }

    private void bt(Stack<Integer> s1, Stack<Character> s2, int index, String input, List<Integer> result) {
        if (index == input.length()) {
            Stack<Integer> sc1 = (Stack<Integer>)s1.clone();
            Stack<Character> sc2 = (Stack<Character>)s2.clone();
            
            System.out.println(sc1);
            System.out.println(sc2);
            
            while (!sc2.empty()) {
                sc1.push(calTop(sc1, sc2));
            }
            System.out.println("Adding result " + sc1.peek());
            result.add(sc1.pop());
            return;
        }

        if (index == 0) {
            int first = Character.getNumericValue(input.charAt(0));
            s1.push(first);
            bt(s1, s2, index + 1, input, result);
        } else {
            // option 1, direct add
            char op = input.charAt(index);
            int num = Character.getNumericValue(input.charAt(index + 1));
            s1.push(num);
            s2.push(op);
            bt(s1, s2, index + 2, input, result);
            // clean up
            s1.pop();
            s2.pop();

            // option 2, cal right now
            if (!s2.empty()) {
            	System.out.println("s11: " + s1);
                System.out.println("s12: " + s2);
                
                char op1 = s2.pop();
                int num1 = s1.pop();
                int num2 = s1.pop();
                
                System.out.println("s21: " + s1);
                System.out.println("s22: " + s2);
                System.out.println("n1: " + num2 + "   n2: " + num1 + "    op: " + op1);
                System.out.println("cal result: " + cal(num2, num1, op1));
                
                s1.push(cal(num2, num1, op1));
                bt(s1, s2, index, input, result);
                
                System.out.println("s31: " + s1);
                System.out.println("s32: " + s2);
                
                // clean up
                s1.pop();
                s1.push(num2);
                s1.push(num1);
                s2.push(op1);
                
                System.out.println("s41: " + s1);
                System.out.println("s42: " + s2);
            }
        }
    }

    private int calTop(Stack<Integer> s1, Stack<Character> s2) {
        char op = s2.pop();
        int n1 = s1.pop();
        int n2 = s1.pop();

        return cal(n2, n1, op);
    }

    private int cal(int n1, int n2, char op) {
        if (op == '*') {
            return n1 * n2;
        } else if (op == '+') {
            return n1 + n2;
        } else {
            return n1 - n2;
        }
    }
}
