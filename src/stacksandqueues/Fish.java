package stacksandqueues;

import java.util.Stack;

public class Fish {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {4, 3, 2, 1, 5}, new int[] {0, 1, 0, 0, 0}));     // 2
    }

    public static int solution(int[] A, int[] B) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty())
                stack.push(i);
            else {
                while (!stack.isEmpty() && B[i] < B[stack.peek()] && A[stack.peek()] < A[i])
                    stack.pop();

                if (stack.isEmpty() || !(B[i] == 0 && B[stack.peek()] == 1))
                    stack.push(i);
            }
        }
        return stack.size();
    }
}
