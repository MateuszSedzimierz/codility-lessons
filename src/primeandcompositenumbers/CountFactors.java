package primeandcompositenumbers;

public class CountFactors {
    public static void main(String[] args) {
        System.out.println(solution(24));   // 8
    }

    public static int solution(int N) {
        int factors = 0;
        long i = 1L;

        while (i * i < N) {
            if (N % i == 0)
                factors += 2;
            i++;
        }

        return i * i == N ? ++factors : factors;
    }
}