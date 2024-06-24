package bakjoon.bakjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise26906 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> code = new LinkedHashMap<>();
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String letter = st.nextToken();
            String binary = st.nextToken();
            code.put(binary, letter);
        }
        String input = br.readLine();
        br.close();

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < input.length(); i += 4) {
            String binary = input.substring(i, i+4);
            answer.append(code.getOrDefault(binary, "?"));
        }
        System.out.println(answer);
    }
}
