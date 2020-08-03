package countingelements;

public class PermCheck {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {4, 1, 3, 2}));   // 1
        System.out.println(solution(new int[] {4, 1, 3}));      // 0
    }

    public static int solution(int[] A) {
        int[] occurrences = new int[A.length + 1];
        for (int index: A) {
            if (index >= occurrences.length)
                return 0;
            if (++occurrences[index] > 1)
                return 0;
        }
        return 1;
    }
}
