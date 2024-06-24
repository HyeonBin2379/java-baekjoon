package bakjoon.bakjoon22XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Exercise22477 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<String> user = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String id = br.readLine();
            user.add(id);
        }

        int m = Integer.parseInt(br.readLine());
        boolean opened = false;
        for (int i = 0; i < m; i++) {
            String id = br.readLine();
            if (!user.contains(id)) {
                sb.append("Unknown ").append(id).append("\n");
                continue;
            }
            if (!opened) {
                opened = true;
                sb.append("Opened by ").append(id).append("\n");
            } else {
                opened = false;
                sb.append("Closed by ").append(id).append("\n");
            }
        }
        System.out.print(sb);
    }
}
