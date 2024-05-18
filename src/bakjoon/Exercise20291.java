package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Exercise20291 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> expansion = new TreeMap<>();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String fileName = br.readLine();
            int index = fileName.indexOf(".");
            String exp = fileName.substring(index+1);
            expansion.put(exp, expansion.getOrDefault(exp, 0)+1);
        }
        expansion.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
