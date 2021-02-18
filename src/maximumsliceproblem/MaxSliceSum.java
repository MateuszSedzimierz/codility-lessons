package maximumsliceproblem;

public class MaxSliceSum {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 2, -6, 4, 0}));    // 5
        System.out.println(solution(new int[]{-10}));               // -10
        System.out.println(solution(new int[]{-2, 1}));             // 1
    }

    public static int solution(int[] A) {
        int slice = 0;
        int maxSlice = A[0];
        for (int value : A) {
            slice = Math.max(value, slice + value);
            maxSlice = Math.max(maxSlice, slice);
        }

        return maxSlice;
    }
}