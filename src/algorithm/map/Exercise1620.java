package algorithm.map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, Integer> pokemonName = new HashMap<>();
        String[] pokemonList = new String[n];
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            pokemonName.put(name, i);
            pokemonList[i-1] = name;
        }

        while (m-- > 0) {
            String input = br.readLine();
            try {
                System.out.println(pokemonList[Integer.parseInt(input)-1]);
            } catch (NumberFormatException e) {
                System.out.println(pokemonName.get(input));
            }
        }
    }
}
