package bakjoon.bakjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise3282 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int g = Integer.parseInt(st.nextToken());

        int[] rooms = new int[n];
        for (int i = 0; i < g; i++) {
            int count = Integer.parseInt(br.readLine());
            int min = 0;
            while (count > 0) {
                int index = getIndex(rooms, min);
                if (index == -1) {
                    min = 1;
                    continue;
                }
                int inc = (count >= 2) ? 2-min : 1;
                rooms[index] += inc;
                count -= inc;
            }
        }
        Arrays.stream(rooms).forEach(System.out::println);
    }

    private static int getIndex(int[] rooms, int min) {
        for (int i = 0; i < rooms.length; i++) {
            if (rooms[i] == min) {
                return i;
            }
        }
        return -1;
    }
}
