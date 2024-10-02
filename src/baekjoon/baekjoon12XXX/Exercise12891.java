package baekjoon.baekjoon12XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.StringTokenizer;

public class Exercise12891 {
    private static int checkSecret = 0;
    private static int count = 0;
    private static final Map<String, Integer> checkChar = new LinkedHashMap<>() {{
        put("A", 0);
        put("C", 0);
        put("G", 0);
        put("T", 0);
    }};
    private static final Map<String, Integer> myString = new LinkedHashMap<>(){{
        putAll(checkChar);
    }};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int dnaLen = Integer.parseInt(st.nextToken());
        int subStrLen = Integer.parseInt(st.nextToken());

        String input = br.readLine();
        String[] dna = input.split("", dnaLen);

        st = new StringTokenizer(br.readLine());
        StringTokenizer finalSt = st;
        checkChar.replaceAll((c, v) -> Integer.parseInt(finalSt.nextToken()));
        for (Integer dnaChar : checkChar.values()) {
            if (dnaChar == 0) {
                checkSecret++;
            }
        }

        for (int i = 0; i < subStrLen; i++) {
            myAdd(dna[i]);
        }
        countString();

        for (int i = subStrLen; i < dnaLen; i++) {
            int start = i - subStrLen;
            myAdd(dna[i]);
            myRemove(dna[start]);
            countString();
        }

        System.out.println(count);
        br.close();
    }

    public static void myAdd(String dna) {
        myString.put(dna, myString.get(dna)+1);
        if (Objects.equals(myString.get(dna), checkChar.get(dna))) {
            checkSecret++;
        }
    }
    public static void myRemove(String dna) {
        if (Objects.equals(myString.get(dna), checkChar.get(dna))) {
            checkSecret--;
        }
        myString.put(dna, myString.get(dna)-1);
    }
    public static void countString() {
        if (checkSecret == 4) {
            count++;
        }
    }
}
