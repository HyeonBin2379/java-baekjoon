package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise29094 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> result = new LinkedHashMap<>();
        int player = Integer.parseInt(br.readLine());
        for (int i = 0; i < player; i++) {
            String name = br.readLine();
            result.put(name, 0);
        }

        int first = 0, second = 0;
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] score = Arrays.stream(st.nextToken().split(":")).mapToInt(Integer::parseInt).toArray();
            String name = st.nextToken();

            int sum = score[0]-first + score[1]-second;
            first = score[0];
            second = score[1];
            result.put(name, result.get(name)+sum);
        }
        List<String> nameList = new ArrayList<>(result.keySet());
        nameList.sort((o1, o2) -> result.get(o2) - result.get(o1));
        System.out.println(nameList.get(0) + " " + result.get(nameList.get(0)));
    }
}
