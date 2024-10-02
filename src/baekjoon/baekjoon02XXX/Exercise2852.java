package baekjoon.baekjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise2852 {

    private static class Record {
        int team, time;

        public Record(int team, int time) {
            this.team = team;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Record[] records = new Record[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());
            int[] time = Arrays.stream(st.nextToken().split(":")).mapToInt(Integer::parseInt).toArray();
            records[i] = new Record(team, time[0]*60+time[1]);
        }

        int[] score = new int[2];
        int[] answer = new int[2];
        int lastTime = records[0].time;
        score[records[0].team-1]++;
        for (int i = 1; i < n; i++) {
            if (score[0] > score[1]) {
                answer[0] += (records[i].time-lastTime);
            } else if (score[0] < score[1]) {
                answer[1] += (records[i].time-lastTime);
            }
            score[records[i].team-1]++;
            lastTime = records[i].time;
        }
        if (score[0] > score[1]) {
            answer[0] += (2880-lastTime);
        } else if (score[0] < score[1]) {
            answer[1] += (2880-lastTime);
        }

        for (int time : answer) {
            System.out.printf("%02d:%02d\n", time / 60, time % 60);
        }
    }
}
