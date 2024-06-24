package bakjoon.bakjoon17XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise17042 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> wandHistory = new ArrayList<>();
        String current = br.readLine();
        int n = Integer.parseInt(br.readLine());

        wandHistory.add(current);
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String won = st.nextToken();
            String lose = st.nextToken();
            if (lose.equals(current)) {
                current = won;
                wandHistory.add(current);
            }
        }
        System.out.println(wandHistory.get(wandHistory.size()-1));
        System.out.println(new HashSet<>(wandHistory).size());
    }
}
