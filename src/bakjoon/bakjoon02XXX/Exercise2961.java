package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise2961 {

    private static class Flavor {
        int sour, bitter;

        public Flavor(int sour, int bitter) {
            this.sour = sour;
            this.bitter = bitter;
        }
    }
    private static int n, answer;
    private static final List<Flavor> ingredients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sweet = Integer.parseInt(st.nextToken());
            int bitter = Integer.parseInt(st.nextToken());
            ingredients.add(new Flavor(sweet, bitter));
        }

        answer = Integer.MAX_VALUE;
        dfs(0, 1, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(int level, int sour, int bitter, int selected) {
        if (level == n) {
            if (selected > 0 && Math.abs(sour-bitter) < answer) {
                answer = Math.abs(sour-bitter);
            }
            return;
        }
        Flavor ingredient = ingredients.get(level);
        dfs(level+1, sour*ingredient.sour, bitter+ingredient.bitter, selected+1);
        dfs(level+1, sour, bitter, selected);
    }
}
