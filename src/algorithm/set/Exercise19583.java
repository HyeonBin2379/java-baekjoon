package algorithm.set;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Exercise19583 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = getTime(st.nextToken());
        int end = getTime(st.nextToken());
        int streamEnd = getTime(st.nextToken());

        Set<String> entered = new HashSet<>();
        Set<String> left = new HashSet<>();

        String line;
        while ((line = br.readLine()) != null) {
            st = new StringTokenizer(line);
            int time = getTime(st.nextToken());
            String name = st.nextToken();

            if (time <= start) {
                entered.add(name);
            } else if (end <= time && time <= streamEnd) {
                left.add(name);
            }
        }

        entered.retainAll(left);

        System.out.println(entered.size());
    }

    private static int getTime(String time) {
        String[] tokens = time.split(":");
        return Integer.parseInt(tokens[0])*60 + Integer.parseInt(tokens[1]);
    }
}
