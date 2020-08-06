package sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Distinct {

    public static void main(String[] args) {
        System.out.println(solution(new int[] {2, 1, 1, 2, 3, 1}));     // 3
        System.out.println(solutionWithSort(new int[] {2, 1, 1, 2, 3, 1}));     // 3
    }

    public static int solution(int[] A) {
        Map<Integer, Integer> elements = new HashMap<>();
        for (int element: A)
            elements.put(element, 0);
        return elements.size();
    }

    public static int solutionWithSort(int[] A) {
        if (A.length == 0)
            return 0;

        Arrays.sort(A);
        int counter = 1;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i - 1])
                counter++;
        }
        return counter;
    }
}
