package timecomplexity;

public class PermMissingElem {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {2, 3, 1, 5}));   // 4
    }

    public static int solution(int[] A) {
        int[] occurrences = new int[A.length + 2];

        for (int value : A) {
            occurrences[value]++;
        }

        for (int i = 1; i < occurrences.length; i++) {
            if (occurrences[i] == 0)
                return i;
        }

        return 1;
    }
}
