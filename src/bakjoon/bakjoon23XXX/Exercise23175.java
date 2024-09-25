package bakjoon.bakjoon23XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercise23175 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] height = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();

        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            result.add(String.valueOf(height[i]));
            i += height[i]-1;
        }
        bw.write(String.join(" ", result) + "\n");
        bw.close();
    }
}
