package bakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise28682 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] lectures = {"swimming", "bowling", "soccer"};
        Map<String, Integer> lectureNum = new LinkedHashMap<>();
        for (int i = 0; i < lectures.length; i++) {
            lectureNum.put(lectures[i], i);
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            bw.write(lectures[1] + " ");
        }
        bw.write("\n");
        bw.flush();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String failed = st.nextToken();
            int index = lectureNum.get(failed) == 0 ? 2 : 0;
            bw.write(lectures[index] + " ");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
