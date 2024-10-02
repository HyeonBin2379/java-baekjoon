package baekjoon.baekjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Exercise10545 {

    private static final String[] letters = {"", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)-1).toArray();

        StringBuilder sb = new StringBuilder();
        String[] str = br.readLine().split("");
        for (String letter : str) {
            int idx = IntStream.range(0, 9)
                    .filter(i -> letters[num[i]].contains(letter))
                    .findFirst()
                    .getAsInt();
            if (!sb.isEmpty() && sb.charAt(sb.length()-1)-'0' == idx+1) {
                sb.append("#");
            }
            sb.append(Integer.toString(idx+1).repeat(letters[num[idx]].indexOf(letter)+1));
        }
        System.out.println(sb);
    }
}
