package iterations;

public class BinaryGap {

    public static void main(String[] args) {
        System.out.println(solution(32));           // 0
        System.out.println(solution(529));          // 4
        System.out.println(solution(9));            // 2
        System.out.println(solution(20));           // 1
        System.out.println(solution(2147483647));   // 0
    }


    public static int solution(int N) {
        int[] bits = new int[32];
        int i = 0;
        while (N > 0) {
            bits[i++] = N % 2 == 0 ? 0 : 1;
            N /= 2;
        }

        int longestGap = 0;
        int currentGap = 0;
        for (int j = i - 2; j >= 0; j--) {
            if (bits[j] == 0)
                currentGap++;
            else {
                if (currentGap > longestGap)
                    longestGap = currentGap;
                currentGap = 0;
            }
        }

        return longestGap;
    }
}
