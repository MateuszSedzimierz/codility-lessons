package sorting;

import java.util.Arrays;

public class NumberOfDiscIntersections {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1, 5, 2, 1, 4, 0}));     // 11
        System.out.println(solution(new int[] {1, 2147483647, 0}));     // 2
    }

    /**
     * Score: 100%
     */
    public static int solution(int[] A) {
        int N = A.length;
        long[] leftPoints = new long[N];
        long[] rightPoints = new long[N];
        for (int i = 0; i < N; i++) {
            leftPoints[i] = (long) i - A[i];
            rightPoints[i] = (long) i + A[i];
        }
        Arrays.sort(leftPoints);
        Arrays.sort(rightPoints);

        int intersectedPairs = 0;
        int openCircles = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < N) {
            if (leftPoints[leftIndex] <= rightPoints[rightIndex]) {
                if ((intersectedPairs += openCircles) > 10_000_000)
                    return -1;
                leftIndex++;
                openCircles++;
            } else {
                rightIndex++;
                openCircles--;
            }
        }
        return intersectedPairs;
    }

    /**
     * Score: 87%
     */
    public static int solution2(int[] A) {
        int N = A.length;
        Segment[] segments = new Segment[N];
        for (int i = 0; i < N; i++) {
            segments[i] = new Segment((long) i - A[i], (long) i + A[i]);
        }
        Arrays.sort(segments);

        int intersectedPairs = 0;
        long rightMax;
        for (int i = 0; i < N - 1; i++) {
            rightMax = segments[i].y;
            for (int j = i + 1; j < N && segments[j].x <= rightMax; j++)
                intersectedPairs++;
            if (intersectedPairs > 10_000_000)
                return -1;
        }
        return intersectedPairs;
    }

    private static class Segment implements Comparable<Segment> {
        long x;
        long y;

        public Segment(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Segment segment) {
            if (x == segment.x) {
                if (y < segment.y)
                    return 1;
                else
                    return -1;
            }
            if (x > segment.x)
                return 1;
            else
                return -1;
        }
    }
}
