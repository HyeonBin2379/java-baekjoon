package bakjoon.bakjoon30XXX;

import java.io.*;
import java.util.*;

public class Exercise30394 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<int[]> position = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int[] pos = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            position.add(pos);
        }
        position.sort((o1, o2) -> o2[1]-o1[1]);
        System.out.println(position.get(0)[1]-position.get(n-1)[1]);
    }
}
