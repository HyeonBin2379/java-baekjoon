package algorithm.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Exercise2751 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }

        StringBuilder sb = new StringBuilder();
        list.stream().sorted().forEach(num -> sb.append(num).append("\n"));
        bw.write(sb.toString());
        bw.close();
    }
}
