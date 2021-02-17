package leader;

import java.util.HashMap;
import java.util.Map;

public class EquiLeader {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4, 3, 4, 4, 4, 2}));     // 2
        System.out.println(solution(new int[]{1, 2, 3, 4, 5}));        // 0
    }

    public static int solution(int[] A) {
        int N = A.length;

        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int i : A) {
            int value = occurrences.getOrDefault(i, 0);
            occurrences.put(i, ++value);
        }

        int leader = -1;
        int leaderCount = 0;
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            if (entry.getValue() > N / 2) {
                leader = entry.getKey();
                leaderCount = entry.getValue();
                break;
            }
        }

        if (leader == -1)
            return 0;

        int equiLeaders = 0;
        int currentLeaderCount = 0;
        for (int i = 1; i < N; i++) {
            if (A[i - 1] == leader)
                currentLeaderCount++;
            if (currentLeaderCount > i / 2 && leaderCount - currentLeaderCount > (N - i) / 2)
                equiLeaders++;
        }

        return equiLeaders;
    }
}