package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Exercise25757 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String type = st.nextToken();
        int p = type.charAt(0) == 'Y' ? 2 : type.charAt(0) == 'F' ? 3 : 4;

        Set<String> players = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            players.add(br.readLine());
        }
        System.out.println(players.size() / (p-1));
    }
}
