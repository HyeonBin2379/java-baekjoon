package baekjoon.baekjoon26XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise26310 {

    private static class Country{
        String name;
        double score;

        public Country(String name, double score) {
            this.name = name;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Country> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            double pt = Double.parseDouble(st.nextToken())*0.24;
            double pu = Double.parseDouble(st.nextToken())*0.14;
            double rt = Double.parseDouble(st.nextToken())*0.06;
            double ru = Double.parseDouble(st.nextToken())*0.3;
            list.add(new Country(name, pt+pu+rt+ru));
        }
        list.sort((o1, o2) -> Double.compare(o2.score, o1.score));

        int[] teamSlotCnt = new int[list.size()];
        for (int i = 0; i < n; i++) {
            teamSlotCnt[i % list.size()]++;
        }
        System.out.println(teamSlotCnt[list.indexOf(list.stream()
                .filter(country -> country.name.equals("Taiwan"))
                .findFirst()
                .get())]);
    }
}
