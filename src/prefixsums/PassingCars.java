package prefixsums;

public class PassingCars {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {0, 1, 0, 1, 1}));    // 5
    }

    public static int solution(int[] A) {
        int carsToWest = 0;
        int pairs = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] == 1)
                carsToWest++;
            else
                pairs += carsToWest;
        }
        return pairs > 1_000_000_000 || pairs < 0 ? -1 : pairs;
    }
}
