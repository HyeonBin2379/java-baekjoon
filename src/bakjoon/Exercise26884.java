package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Exercise26884 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> artist = new LinkedHashMap<>();
        int totalCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < totalCount; i++) {
            String name = br.readLine();
            artist.put(name, artist.getOrDefault(name, 0)+1);
        }
        System.out.println(artist.values().stream().filter(count -> count > 1).count());
    }
}
