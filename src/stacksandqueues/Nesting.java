package stacksandqueues;

import java.util.Stack;

public class Nesting {
    public static void main(String[] args) {
        System.out.println(solution("(()(())())"));     // 1
        System.out.println(solution("())"));            // 0
    }

    public static int solution(String S) {
        if (S.length() % 2 == 1)
            return 0;

        Stack<Character> stack = new Stack<>();
        for (char sign: S.toCharArray()) {
            if (sign == '(') {
                stack.push(sign);
            } else  {
                if (stack.isEmpty())
                    return 0;
                else
                    stack.pop();
            }
        }
        
        return stack.size() > 0 ? 0 : 1;
    }
}
