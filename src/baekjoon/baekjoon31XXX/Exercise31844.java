package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise31844 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String map = br.readLine();
        int robot = map.indexOf("@");
        int box = map.indexOf("#");
        int dest = map.indexOf("!");

        if ((robot < box && box < dest) || (dest < box && box < robot)) {
            System.out.println(Math.abs(robot-dest)-1);
            return;
        }
        System.out.println(-1);
    }
}
