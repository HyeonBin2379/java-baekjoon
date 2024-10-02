package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise2037 {
    private static final List<List<Character>> alphabet = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        char[] input = br.readLine().toCharArray();
        int prevNum = -1;
        int answer = 0;
        setMap();

        for (char c : input) {
            if (c == ' ') {
                answer += p;
                prevNum = 1;
                continue;
            }
            for (List<Character> charList : alphabet) {
                if (charList.contains(c)) {
                    if (prevNum == alphabet.indexOf(charList)) {
                        answer += w;
                    }
                    answer += (1 + charList.indexOf(c)) * p;
                    prevNum = alphabet.indexOf(charList);
                }
            }
        }
        System.out.println(answer);
    }

    private static void setMap() {
        alphabet.add(0, Collections.emptyList());
        alphabet.add(1, Arrays.asList(' '));
        alphabet.add(2, Arrays.asList('A', 'B', 'C'));
        alphabet.add(3, Arrays.asList('D', 'E', 'F'));
        alphabet.add(4, Arrays.asList('G', 'H', 'I'));
        alphabet.add(5, Arrays.asList('J', 'K', 'L'));
        alphabet.add(6, Arrays.asList('M', 'N', 'O'));
        alphabet.add(7, Arrays.asList('P', 'Q', 'R', 'S'));
        alphabet.add(8, Arrays.asList('T', 'U', 'V'));
        alphabet.add(9, Arrays.asList('W', 'X', 'Y', 'Z'));
    }
}
