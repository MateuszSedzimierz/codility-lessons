package primeandcompositenumbers;

public class MinPerimeterRectangle {
    public static void main(String[] args) {
        System.out.println(solution(30));       // 22
        System.out.println(solution(4));        // 8
        System.out.println(solution(1));        // 4
        System.out.println(solution(48));       // 28
        System.out.println(solution(101));      // 204
        System.out.println(solution(1234));     // 1238
    }

    public static int solution(int N) {
        int min = 2 * (1 + N);
        int A = 2;
        while (A * A <= N) {
            if (N % A == 0)
                min = Math.min(min, 2 * (A + N / A));
            A++;
        }
        return min;
    }
}