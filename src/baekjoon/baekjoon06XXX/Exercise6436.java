package baekjoon.baekjoon06XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise6436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (true) {
            long size = Long.parseLong(br.readLine());
            if (size == 0){
                break;
            }
            size = (size % 2 == 1) ? (size + 1) / 2 : size / 2;
            size += (size/2);
            sb.append(String.format("File #%d\n", ++count));
            sb.append(String.format("John needs %d floppies.\n\n", (long) Math.ceil((double) size /1860000)));
        }
        System.out.print(sb);
    }
}
