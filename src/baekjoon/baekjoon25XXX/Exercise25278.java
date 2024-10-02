package baekjoon.baekjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise25278 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> environment = new LinkedHashMap<>(Map.of(
                "ocean", 0,
                "oxygen", 0,
                "temperature", -30
        ));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String env = st.nextToken();
            int change = Integer.parseInt(st.nextToken());
            environment.put(env, environment.get(env) + change);
        }

        if (environment.get("ocean") >= 9
                && environment.get("oxygen") >= 14
                && environment.get("temperature") >= 8) {
            System.out.println("liveable");
        } else {
            System.out.println("not liveable");
        }
    }
}
