package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercise2870 {
    private static final List<BigInteger> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            String str = br.readLine();
            BigInteger[] numbers = Arrays.stream(str.split("\\D"))
                    .filter(s -> s.length() > 0)
                    .map(BigInteger::new)
                    .toArray(BigInteger[]::new);
            result.addAll(Arrays.stream(numbers).toList());
        }
        br.close();

        Collections.sort(result);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (BigInteger num : result) {
            bw.write(num.toString() + "\n");
        }
        bw.flush();
        bw.close();
    }
}
