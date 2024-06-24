package bakjoon.bakjoon03XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise3029 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int[] now = Arrays.stream(s1.split(":")).mapToInt(Integer::parseInt).toArray();
        int[] boom = Arrays.stream(s2.split(":")).mapToInt(Integer::parseInt).toArray();
        boom[0] += (s1.equals(s2) || isNextDay(now, boom)) ? 24 : 0;

        int nowTime = now[0]*3600 + now[1]*60 + now[2];
        int waitTime = (boom[0]*3600 + boom[1]*60 + boom[2]) - nowTime;
        if (waitTime < 86400) {
            System.out.printf("%02d:%02d:%02d\n", (waitTime / 3600), (waitTime % 3600) / 60, waitTime % 60);
        } else {
            System.out.println("24:00:00");
        }
    }

    public static boolean isNextDay(int[] now, int[] boom) {
        return (now[0] > boom[0])
                || (now[0] == boom[0] && now[1] > boom[1])
                || (now[0] == boom[0] && now[1] == boom[1] && now[2] > boom[2]);
    }
}
