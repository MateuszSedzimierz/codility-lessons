package countingelements;

public class FrogRiverOne {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[] {1, 3, 1, 4, 2, 3, 5, 4}));    // 6
        System.out.println(solution(3, new int[] {1, 3, 1, 3, 2, 1, 3}));       // 4
    }

    public static int solution(int X, int[] A) {
        if (X > A.length)
            return -1;

        int[] occurrences = new int[X + 1];
        int checked = 0;
        for (int i = 0; i < A.length; i++) {
            if (occurrences[A[i]] == 0) {
                checked++;
                occurrences[A[i]] = 1;
                if (checked == X)
                    return i;
            }
        }
        return -1;
    }
}
