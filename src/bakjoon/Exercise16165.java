package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise16165 {
    private static final Map<String, ArrayList<String>> girlGroup = new LinkedHashMap<>();
    private static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++) {
            String groupName = br.readLine();
            girlGroup.put(groupName, new ArrayList<>());
            int memberCount = Integer.parseInt(br.readLine());
            for (int j = 0; j < memberCount; j++) {
                String memberName = br.readLine();
                girlGroup.get(groupName).add(memberName);
            }
            Collections.sort(girlGroup.get(groupName));
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            int quiz = Integer.parseInt(br.readLine());
            switch (quiz) {
                case 0 -> printMember(name);
                case 1 -> printGroup(name);
            }
        }
        br.close();
        System.out.println(sb);
    }

    public static void printGroup(String memberName) {
        for (String groupName : girlGroup.keySet()) {
            if (girlGroup.get(groupName).contains(memberName)) {
                sb.append(groupName).append("\n");
                break;
            }
        }
    }
    public static void printMember(String groupName) {
        for (String memberName : girlGroup.get(groupName)) {
            sb.append(memberName).append("\n");
        }
    }
}
