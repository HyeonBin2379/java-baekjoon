package bakjoon.bakjoon31XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercise31216 {

    private static final List<Integer> superPrime = getPrimeNum();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            bw.write(superPrime.get(n-1) + "\n");
        }
        br.close();
        bw.close();
    }

    private static List<Integer> getPrimeNum() {
        boolean[] isPrimeNum = new boolean[500001];
        Arrays.fill(isPrimeNum, true);
        isPrimeNum[1] = isPrimeNum[0] = false;
        for (int i = 2; i*i <= 500000; i++) {
            if (!isPrimeNum[i]) {
                continue;
            }
            for (int j = i*i; j <= 500000; j += i) {
                isPrimeNum[j] = false;
            }
        }
        List<Integer> primeNum = IntStream.rangeClosed(2, isPrimeNum.length-1)
                .filter(i -> isPrimeNum[i])
                .boxed()
                .toList();
        return IntStream.rangeClosed(0, primeNum.size())
                .filter(i -> isPrimeNum[i+1])
                .map(primeNum::get)
                .boxed()
                .limit(3000)
                .collect(Collectors.toList());
    }
}
