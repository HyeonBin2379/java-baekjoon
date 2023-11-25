import java.util.List;
import java.util.Scanner;

public class Exercise4948 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int number = sc.nextInt();
            if (number == 0) {
                break;
            }

            List<Integer> sieve = new Sieve().getPrimeNumber(2*number);
            int[] primeNumber = sieve.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();

            int start = 0, end = primeNumber.length-1;
            while (primeNumber[start] <= number) {
                start++;
            }
            while (primeNumber[end] > number*2) {
                end++;
            }

            int count = end - start + 1;

            System.out.println(count);
        }
        sc.close();
    }
}
