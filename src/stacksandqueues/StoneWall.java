package stacksandqueues;

import java.util.Stack;

public class StoneWall {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8}));     // 7
    }

    public static int solution(int[] H) {
        Stack<Integer> stack = new Stack<>();
        int blocks = 0;

        for (int i = 0; i < H.length; i++) {
            while (!stack.isEmpty() && stack.peek() > H[i])
                stack.pop();
            if (stack.isEmpty() || stack.peek() != H[i]) {
                blocks++;
                stack.push(H[i]);
            }
        }

        return blocks;
    }
}
