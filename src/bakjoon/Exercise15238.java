package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Exercise15238 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        Map<Character, Integer> letterCnt = new LinkedHashMap<>();
        for (int i = 0; i < len; i++) {
            letterCnt.put(input[i], letterCnt.getOrDefault(input[i], 0)+1);
        }

        List<Character> letter = new ArrayList<>(letterCnt.keySet());
        letter.sort((o1, o2) -> letterCnt.get(o2)-letterCnt.get(o1));
        System.out.println(letter.get(0) + " " + letterCnt.get(letter.get(0)));
    }
}
