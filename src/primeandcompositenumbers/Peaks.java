package primeandcompositenumbers;

public class Peaks {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));    // 3
        System.out.println(solution(new int[]{5}));    // 0
        System.out.println(solution(new int[]{1, 3, 2, 1}));    // 1
        System.out.println(solution(new int[]{1, 3, 11, 7, 5, 11, 9}));    // 1
    }

    public static int solution(int[] A) {
        int N = A.length;

        boolean[] peaks = new boolean[N];
        int allPeaks = 0;
        for (int i = 1; i < N - 1; i++) {
            if (A[i - 1] < A[i] && A[i + 1] < A[i]) {
                peaks[i] = true;
                allPeaks++;
            }
        }

        if (allPeaks <= 1)
            return allPeaks;

        int result = 1;
        int size = 2;
        while (size <= N / 2) {
            if (N % size == 0) {
                int end = size;
                int blocks = 0;
                while (end <= N) {
                    if (!isPeakIn(peaks, end - size, end))
                        break;
                    else
                        blocks++;
                    end += size;
                }

                if (blocks > result && N / size == blocks)
                    result = blocks;
            }
            size++;
        }

        return result;
    }

    public static boolean isPeakIn(boolean[] peaks, int start, int end) {
        for (int i = start; i < end; i++) {
            if (peaks[i])
                return true;
        }
        return false;
    }
}