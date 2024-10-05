package baekjoon.baekjoon23XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Exercise23826 {

    private static class Room {
        int x, y, energy;

        public Room(int x, int y, int energy) {
            this.x = x;
            this.y = y;
            this.energy = energy;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Room> roomlist = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int energy = Integer.parseInt(st.nextToken());
            roomlist.add(new Room(x, y, energy));
        }

        int[] power = new int[n+1];
        for (int i = 1; i <= n; i++) {
            power[i] = calculatePower(roomlist.get(0), roomlist.get(i));
            for (int j = 1; j <= n; j++) {
                if (power[i] <= 0) {
                    break;
                }
                power[i] -= calculatePower(roomlist.get(j), roomlist.get(i));
            }
        }
        int max = Arrays.stream(power).reduce(0, Integer::max);
        System.out.println(max == 0 ? "IMPOSSIBLE" : max);
    }

    private static int calculatePower(Room from, Room to) {
        return Math.max(from.energy - (Math.abs(from.x-to.x) + Math.abs(from.y-to.y)), 0);
    }
}
