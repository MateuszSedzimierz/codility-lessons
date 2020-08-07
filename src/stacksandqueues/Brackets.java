package stacksandqueues;

import java.util.Stack;

public class Brackets {
    public static void main(String[] args) {
        System.out.println(solution("{[()()]}"));   // 1
        System.out.println(solution("([)()]"));     // 0
        System.out.println(solution(""));           // 1
        System.out.println(solution("{{{{"));       // 0
    }

    public static int solution(String S) {
        if (S.length() % 2 == 1)
            return 0;

        Stack<Character> stack = new Stack<>();
        for (char sign: S.toCharArray()) {
            if (sign == '(' || sign == '{' || sign == '[') {
                stack.push(sign);
            } else if (!checkSign(sign, stack))
                return 0;
        }

        return stack.size() > 0 ? 0 : 1;
    }

    public static boolean checkSign(char sign, Stack<Character> stack) {
        if (stack.size() == 0)
            return false;

        char lastOne = stack.pop();
        if (sign == ')' && lastOne == '(')
            return true;
        else if (sign == '}' && lastOne == '{')
            return true;
        else
            return sign == ']' && lastOne == '[';
    }
}
