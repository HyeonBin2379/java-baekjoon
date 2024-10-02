package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Exercise31994 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> seminar = new TreeMap<>();

        for (int i = 0; i < 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int applicant = Integer.parseInt(st.nextToken());
            seminar.put(name, seminar.getOrDefault(name, 0) + applicant);
        }
        System.out.println(seminar.keySet().stream()
                .max(Comparator.comparingInt(seminar::get))
                .get());
    }
}
