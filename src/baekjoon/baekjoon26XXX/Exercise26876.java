package baekjoon.baekjoon26XXX;

import java.util.*;

public class Exercise26876 {

    static class Time {
        int hours, minutes, presses;

        Time(int hours, int minutes, int presses) {
            this.hours = hours;
            this.minutes = minutes;
            this.presses = presses;
        }
    }

    public static void bfs(int startH, int startM, int targetH, int targetM) {
        Queue<Time> queue = new LinkedList<>();
        boolean[][] visited = new boolean[24][60];

        queue.add(new Time(startH, startM, 0));
        visited[startH][startM] = true;

        while (!queue.isEmpty()) {
            Time currentTime = queue.poll();

            if (currentTime.hours == targetH && currentTime.minutes == targetM) {
                System.out.println(currentTime.presses);
                return;
            }

            // 버튼 A를 눌러 1분 앞으로
            int newMinutesA = (currentTime.minutes + 1) % 60;
            int newHoursA = currentTime.hours + (newMinutesA == 0 ? 1 : 0);
            newHoursA %= 24;
            if (!visited[newHoursA][newMinutesA]) {
                queue.add(new Time(newHoursA, newMinutesA, currentTime.presses + 1));
                visited[newHoursA][newMinutesA] = true;
            }

            // 버튼 B를 눌러 1시간 앞으로
            int newHoursB = (currentTime.hours + 1) % 24;
            if (!visited[newHoursB][currentTime.minutes]) {
                queue.add(new Time(newHoursB, currentTime.minutes, currentTime.presses + 1));
                visited[newHoursB][currentTime.minutes] = true;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] start = Arrays.stream(scanner.next().split(":")).mapToInt(Integer::parseInt).toArray();
        int[] end = Arrays.stream(scanner.next().split(":")).mapToInt(Integer::parseInt).toArray();
        bfs(start[0], start[1], end[0], end[1]);
    }
}