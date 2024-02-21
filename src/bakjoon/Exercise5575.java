package bakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Exercise5575 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] workTime = new int[3][];
        for (int i = 0; i < workTime.length; i++) {
            workTime[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        br.close();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] totalSec = new int[3];
        for (int i = 0; i < totalSec.length; i++) {
            totalSec[i] = getTotalSec(workTime[i][3], workTime[i][4], workTime[i][5])
                    - getTotalSec(workTime[i][0], workTime[i][1], workTime[i][2]);
            int hour = totalSec[i] / 3600;
            int min = (totalSec[i] % 3600) / 60;
            int sec = totalSec[i] % 60;
            bw.write(hour + " " + min + " " + sec + "\n");
        }
        bw.flush();
        bw.close();
    }

    public static int getTotalSec(int hour, int min, int sec) {
        return hour*3600 + min*60 + sec;
    }
}