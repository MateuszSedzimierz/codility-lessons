package countingelements;

import java.util.Arrays;

public class MaxCounters {
    public static void main(String[] args) {
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        int N = 5;
        int[] result = solution(N, A);
        System.out.println(Arrays.toString(result));    // 3, 2, 2, 4, 2
    }

    public static int[] solution(int N, int[] A) {
            int[] counters = new int[N];
            int previousMax = 0;
            int max = 0;
            int index;

            for (int value: A) {
                index = value - 1;

                if (value != N + 1) {
                    if (counters[index] < previousMax) {
                        counters[index] = previousMax + 1;
                    } else {
                        counters[index]++;
                    }

                    if (counters[index] > max) {
                        max = counters[index];
                    }
                } else {
                    previousMax = max;
                }
            }

            for (int i = 0; i < counters.length; i++) {
                if (counters[i] < previousMax)
                    counters[i] = previousMax;
            }

            return counters;
    }
}
