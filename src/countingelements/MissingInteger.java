package countingelements;

public class MissingInteger {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 3, 6, 4, 1, 2}));     // 5
        System.out.println(solution(new int[] {1, 2, 3}));              // 4
        System.out.println(solution(new int[] {-1, -3}));               // 1
    }

    public static int solution(int[] A) {
        int[] occurrences = new int[A.length + 1];
        for (int value: A) {
            if (value > 0 && value < occurrences.length)
                occurrences[value]++;
        }

        if (occurrences[1] == 0)
            return 1;

        for (int i = 1; i < A.length; i++) {
            if (occurrences[i] == 0)
                return i;
        }

        return A.length + 1;
    }
}
