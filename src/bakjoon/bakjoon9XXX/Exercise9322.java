package bakjoon.bakjoon9XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Exercise9322 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            List<String> publicKey1 = Arrays.stream(br.readLine().split(" ")).toList();
            List<String> publicKey2 = Arrays.stream(br.readLine().split(" ")).toList();
            String[] encrypted = br.readLine().split(" ");

            Map<Integer, Integer> code = new LinkedHashMap<>();
            for (int j = 0; j < n; j++) {
                code.put(j, publicKey2.indexOf(publicKey1.get(j)));
            }
            String[] decrypted = new String[n];
            for (int j = 0; j < n; j++) {
                decrypted[j] = encrypted[code.get(j)];
            }
            sb.append(String.join(" ", decrypted)).append("\n");
        }
        System.out.print(sb);
    }
}
