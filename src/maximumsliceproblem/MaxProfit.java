package maximumsliceproblem;

public class MaxProfit {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{23171, 21011, 21123, 21366, 21013, 21367}));  // 356
        System.out.println(solution(new int[]{1, 2, 3, 4, 5}));                             // 4
        System.out.println(solution(new int[]{1, 2, 5, 4, 3}));                             // 4
        System.out.println(solution(new int[]{5, 2, 1, 5, 3}));                             // 4
        System.out.println(solution(new int[]{3, 3, 3, 1}));                                // 0
        System.out.println(solution(new int[]{8, 9, 3, 6, 1, 2}));                          // 3
    }

    public static int solution(int[] A) {
        int[] dailyProfits = new int[A.length];
        for (int i = 1; i < A.length; i++) {
            dailyProfits[i] = A[i] - A[i - 1];
        }

        int maxEnding = 0;
        int maxProfit = 0;
        for (int value : dailyProfits) {
            maxEnding = Math.max(0, maxEnding + value);
            maxProfit = Math.max(maxProfit, maxEnding);
        }

        return maxProfit;
    }
}