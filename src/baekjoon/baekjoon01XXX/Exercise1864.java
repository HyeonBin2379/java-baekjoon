package baekjoon.baekjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Exercise1864 {
    private static final Map<String, Long> codeTable = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        makeCode();
        while (true) {
            String input = br.readLine();
            if (input.equals("#")) {
                break;
            }
            long[] digit = Arrays.stream(input.split(""))
                    .map(codeTable::get)
                    .mapToLong(value -> value)
                    .toArray();
            int len = digit.length-1;
            long answer = 0L;
            for (int i = len; i >= 0; i--) {
                answer += digit[len-i]*(int) Math.pow(8, i);
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }

    public static void makeCode() {
        codeTable.put("-", 0L);
        codeTable.put("\\", 1L);
        codeTable.put("(", 2L);
        codeTable.put("@", 3L);
        codeTable.put("?", 4L);
        codeTable.put(">", 5L);
        codeTable.put("&", 6L);
        codeTable.put("%", 7L);
        codeTable.put("/", (long) -1);
    }
}
