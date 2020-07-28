package timecomplexity;

public class TapeEquilibrium {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {3, 1, 2, 4, 3}));    // 1
    }

    public static int solution(int[] A) {
        int leftSum = A[0];
        int rightSum = 0;
        for (int i = 1; i < A.length; i++) {
            rightSum += A[i];
        }

        int minimalDifference = Math.abs(leftSum - rightSum);
        int difference;
        for (int i = 1; i < A.length - 1; i++) {
            leftSum += A[i];
            rightSum -= A[i];
            difference = Math.abs(leftSum - rightSum);

            if (difference < minimalDifference)
                minimalDifference = difference;
        }
        return minimalDifference;
    }
}
