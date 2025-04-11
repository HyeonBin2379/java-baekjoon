package algorithm.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise16165 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, List<String>> memberByTeam = new HashMap<>();
        Map<String, String> teamByMember = new HashMap<>();
        while (n-- > 0) {
            String team = br.readLine();
            int cnt = Integer.parseInt(br.readLine());

            memberByTeam.put(team, new ArrayList<>());
            while (cnt-- > 0) {
                String member = br.readLine();
                memberByTeam.get(team).add(member);
                teamByMember.put(member, team);
            }
        }

        while (m-- > 0) {
            String name = br.readLine();
            int quizType = Integer.parseInt(br.readLine());

            switch (quizType) {
                case 0 -> memberByTeam.get(name).stream().sorted().forEach(System.out::println);
                case 1 -> System.out.println(teamByMember.get(name));
            }
        }
    }
}
