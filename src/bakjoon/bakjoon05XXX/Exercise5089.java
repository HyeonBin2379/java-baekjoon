package bakjoon.bakjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Exercise5089 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int week = 0;
        while (true) {
            int cities = Integer.parseInt(br.readLine());
            if (cities == 0) {
                break;
            }

            Set<String> visited = new HashSet<>();
            for (int i = 0; i < cities; i++) {
                String name = br.readLine();
                visited.add(name);
            }
            sb.append(String.format("Week %d %d\n", ++week, visited.size()));
        }
        System.out.print(sb);
    }
}
