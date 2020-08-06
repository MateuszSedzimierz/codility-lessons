package sorting;

import java.util.Arrays;

public class MaxProductOfThree {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {-3, 1, 2, -2, 5, 6}));   // 60
    }

    public static int solution(int[] A) {
        Arrays.sort(A);
        int N = A.length;
        int tripletWithMaxNumbers = A[N - 3] * A[N - 2] * A[N - 1];
        // Multiplied the smallest negative numbers can be bigger
        int tripletWithNegatives = A[0] * A[1] * A[N - 1];
        return Math.max(tripletWithMaxNumbers, tripletWithNegatives);
    }
}
