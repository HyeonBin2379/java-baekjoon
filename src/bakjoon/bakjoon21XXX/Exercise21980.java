package bakjoon.bakjoon21XXX;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Exercise21980 {

    private static final Map<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testcase = Integer.parseInt(br.readLine());

        while (testcase-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            String[] str = br.readLine().split(" ", n);
            map.clear();
            for (String s : str) {
                int upperCnt = (int) s.chars().filter(ch -> Character.isUpperCase((char)ch)).count();
                String newStr = Arrays.stream(s.toLowerCase().split("", k)).sorted().collect(Collectors.joining());
                map.put(newStr+upperCnt, map.getOrDefault(newStr+upperCnt, 0)+1);
            }
            int answer = map.values().stream()
                    .map(cnt -> cnt*(cnt-1)/2)
                    .reduce(0, Integer::sum);
            bw.write(answer + "\n");
        }
        br.close();
        bw.close();
    }
}
