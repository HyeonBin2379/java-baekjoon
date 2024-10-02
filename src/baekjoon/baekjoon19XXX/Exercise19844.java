package baekjoon.baekjoon19XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Exercise19844 {

    private static final String regex = "^(c|j|n|m|t|s|l|d|qu)(')[aeiouh]";
    private static final Pattern pattern = Pattern.compile(regex);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().split("[\\s-]");

        Matcher matcher;
        int count = words.length;
        for (String word : words) {
            matcher = pattern.matcher(word);
            while (matcher.find()) {
                count++;
            }
        }
        System.out.println(count);
    }
}
