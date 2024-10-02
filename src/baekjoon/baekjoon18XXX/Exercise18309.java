package baekjoon.baekjoon18XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Exercise18309 {
    private static final Set<Integer> temp = new TreeSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(input);
            String date = st.nextToken();
            while (st.hasMoreTokens()) {
                temp.add(Integer.parseInt(st.nextToken()));
            }
        }
        List<Integer> result = temp.stream().toList();
        System.out.println(result.get(0) + " " + result.get(result.size()-1));
    }
}
