package arrays;

import java.util.Arrays;

public class OddOccurrencesInArray {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {9, 3, 9, 3, 9, 7, 9}));  // 7
        System.out.println(solution(new int[] {42}));                   // 42
    }

    public static int solution(int[] A) {
        if (A.length == 1)
            return A[0];

        Arrays.sort(A);
        for (int i = 1; i < A.length; i+= 2)
            if (A[i] != A[i - 1])
                return A[i - 1];

            return A[A.length - 1];
    }
}
