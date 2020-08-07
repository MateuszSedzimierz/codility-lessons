package sorting;

import java.util.Arrays;

public class Triangle {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {10, 2, 5, 1, 8, 20}));       // 1

        // Overflow test
        int max = Integer.MAX_VALUE;
        System.out.println(solution(new int[] {max, max, max}));            // 1
    }

    public static int solution(int[] A) {
        Arrays.sort(A);
        for (int i = 2; i < A.length; i++) {
            if (isTriangular(A[i - 2], A[i - 1], A[i]))
                return 1;
        }
        return 0;
    }

    public static boolean isTriangular(long a, long b, long c) {
        return (a + b > c && a + c > b && b + c > a);
    }
}
