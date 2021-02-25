package primeandcompositenumbers;

public class Flags {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}));    // 3
        System.out.println(solution(new int[]{1, 2, 1, 1, 2, 1, 3, 1, 1}));             // 2
        System.out.println(solution(new int[]{1, 1, 1}));                               // 0
        System.out.println(solution(new int[]{1, 3, 2}));                               // 1
    }

    /**
     * About solution:
     * https://codility.com/media/train/solution-flags.pdf
     */
    public static int solution(int[] A) {
        int N = A.length;
        boolean[] peaks = getPeaks(A);
        int[] nextPeaks = getNextPeaks(peaks);

        int result = 0;
        int i = 1;
        while ((i - 1) * i <= N) {
            int position = 0;
            int num = 0;
            while (position < N && num < i) {
                position = nextPeaks[position];
                if (position == -1)
                    break;
                num++;
                position += i;
            }
            result = Math.max(result, num);
            i++;
        }
        return result;
    }

    public static boolean[] getPeaks(int[] A) {
        boolean[] peaks = new boolean[A.length];
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i + 1] < A[i])
                peaks[i] = true;
        }
        return peaks;
    }

    public static int[] getNextPeaks(boolean[] peaks) {
        int N = peaks.length;
        int[] nextPeaks = new int[N];
        nextPeaks[N - 1] = -1;
        for (int i = N - 2; i >= 0; i--) {
            if (peaks[i])
                nextPeaks[i] = i;
            else
                nextPeaks[i] = nextPeaks[i + 1];
        }
        return nextPeaks;
    }
}