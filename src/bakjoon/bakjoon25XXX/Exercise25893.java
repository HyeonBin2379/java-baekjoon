package bakjoon.bakjoon25XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Exercise25893 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int player = Integer.parseInt(br.readLine());
        for (int i = 0; i < player; i++) {
            String input = br.readLine();
            StringTokenizer st = new StringTokenizer(input);
            int count = 0;
            for (int j = 0; j < 3; j++) {
                if (Integer.parseInt(st.nextToken()) >= 10) {
                    count++;
                }
            }
            bw.write(input + "\n");
            switch (count) {
                case 0 -> bw.write("zilch\n");
                case 1 -> bw.write("double\n");
                case 2 -> bw.write("double-double\n");
                case 3 -> bw.write("triple-double\n");
            }
            if (i < player-1) {
                bw.write("\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
