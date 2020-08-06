package prefixsums;

import java.util.Arrays;

public class MinAvgTwoSlice {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {4, 2, 2, 5, 1, 5, 8}));      // 1
    }

    public static int solution(int[] A) {
        int[] sums = calculateSums(A);
        int leftIndex = 0;
        int bestIndex = 0;
        double avg;
        double minAvg = Double.MAX_VALUE;

        for (int i = 2; i < sums.length; i++) {
            avg = 1.0 * (sums[i] - sums[leftIndex]) / (i - leftIndex);
            if (avg < minAvg) {
                bestIndex = leftIndex;
                minAvg = avg;
            }
            if (A[i - 1] < minAvg)
                leftIndex = i - 1;
        }
        return bestIndex;
    }

    public static int[] calculateSums(int[] A) {
        int[] sums = new int[A.length + 1];
        for (int i = 1; i < sums.length; i++)
            sums[i] = sums[i - 1] + A[i - 1];
        return sums;
    }
}
