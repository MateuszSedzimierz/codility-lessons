package prefixsums;

import java.util.Arrays;

public class GenomicRangeQuery {
    public static void main(String[] args) {
        int[] result = solution("CAGCCTA", new int[] {2, 5, 0}, new int[] {4, 5, 6});
        int[] result2 = solution("A", new int[] {0}, new int[] {0});
        int[] result3 = solution("AC", new int[] {0, 0, 1}, new int[] {0, 1, 1});
        
        System.out.println(Arrays.toString(result));    // {2, 4, 1}
        System.out.println(Arrays.toString(result2));    // {1}
        System.out.println(Arrays.toString(result3));    // {1, 1, 2}
    }

    public static int[] solution(String S, int[] P, int[] Q) {
        int[] impactFactors = new int[P.length];
        int[][] occurrences = getOccurrences(S);
        int left, right;

        for (int i = 0; i < impactFactors.length; i++) {
            left = P[i];
            right = Q[i];
            if (isSignInRange(1, left, right, occurrences))
                impactFactors[i] = 1;
            else if (isSignInRange(2, left, right, occurrences))
                impactFactors[i] = 2;
            else if (isSignInRange(3, left, right, occurrences))
                impactFactors[i] = 3;
            else
                impactFactors[i] = 4;
        }

        return impactFactors;
    }

    public static int[][] getOccurrences(String sequence) {
        int size = sequence.length() + 1;
        int[][] occurrences = new int[size][5];
        int[] values = convertCharsToIntegers(sequence);

        for (int i = 1; i < size; i++) {
            occurrences[i] = Arrays.copyOf(occurrences[i - 1], 5);
            occurrences[i][values[i - 1]]++;
        }

        return occurrences;
    }

    public static int[] convertCharsToIntegers(String sequence) {
        return sequence
                .chars()
                .map(sign -> sign == 'A' ? 1 : sign == 'C' ? 2 : sign == 'G' ? 3 : 4)
                .toArray();
    }

    public static boolean isSignInRange(int symbol, int left, int right, int[][] occurrences) {
        int size = occurrences.length;
        if (occurrences[size - 1][symbol] == 0)
            return false;
        return occurrences[right + 1][symbol] - occurrences[left][symbol] > 0;
    }
}
