package leader;

import java.util.HashMap;
import java.util.Map;

public class Dominator {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 4, 3, 2, 3, -1, 3, 3}));   // 0, 2, 4, 6 or 7 (index)
        System.out.println(solution(new int[]{2, 3, 4, 2, 3, 4}));          // -1
    }

    public static int solution(int[] A) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int i : A) {
            int value = occurrences.getOrDefault(i, 0);
            occurrences.put(i, ++value);
        }

        int dominator = -1;
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            if (entry.getValue() > A.length / 2) {
                dominator = entry.getKey();
                break;
            }
        }

        if (dominator != -1) {
            for (int i = 0; i < A.length; i++) {
                if (dominator == A[i])
                    return i;
            }
        }

        return -1;
    }
}