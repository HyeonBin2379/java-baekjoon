package bakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Exercise4589 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("Gnomes:\n");

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            int[] gnome = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            bw.write(isOrdered(gnome) ? "Ordered\n" : "Unordered\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static boolean isOrdered(int[] gnome) {
        return ((gnome[0] <= gnome[1]) && (gnome[1] <= gnome[2]))
                || ((gnome[1] <= gnome[0]) && (gnome[2] <= gnome[1]));
    }
}
