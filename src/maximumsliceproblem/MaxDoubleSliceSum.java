package maximumsliceproblem;

public class MaxDoubleSliceSum {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 2, 6, -1, 4, 5, -1, 2}));  // 17
        System.out.println(solution(new int[]{5, 17, 0, 3}));               // 17
        System.out.println(solution(new int[]{5, 0, 1, 0, 5}));             // 1
    }

    public static int solution(int[] A) {
        int N = A.length;
        int[] fromLeft = new int[N];
        int[] fromRight = new int[N];

        for (int i = 1; i < N - 1; i++) {
            fromLeft[i] = Math.max(0, fromLeft[i - 1] + A[i]);
        }

        for (int i = N - 2; i > 0; i--) {
            fromRight[i] = Math.max(0, fromRight[i + 1] + A[i]);
        }

        int maxSum = 0;
        for (int Y = 1; Y < N - 1; Y++) {
            maxSum = Math.max(maxSum, fromLeft[Y - 1] + fromRight[Y + 1]);
        }

        return maxSum;
    }
}