package arrays;

public class CyclicRotation {
    public static void main(String[] args) {
        printArray(solution(new int[] {3, 8, 9, 7, 6}, 3));
        printArray(solution(new int[] {1, 2, 3, 4}, 4));
    }

    public static int[] solution(int[] A, int K) {
        int N = A.length;
        if (K == N || N == 0)
            return A;

        int temp, next;
        for (int i = 0; i < K; i++) {
            temp = A[0];
            A[0] = A[N - 1];
            for (int j = 1; j < N; j++) {
                next = A[j];
                A[j] = temp;
                temp = next;
            }
        }

        return A;
    }

    public static void printArray(int[] array) {
        for (int value : array)
            System.out.print(value + " ");
        System.out.println();
    }
}
