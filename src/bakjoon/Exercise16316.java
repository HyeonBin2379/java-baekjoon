package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise16316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[count];
        for (int i = 1; i <= count; i++) {
            String spoken = st.nextToken();
            num[i-1] = (spoken.equals("mumble")) ? i : Integer.parseInt(spoken);
            if (num[i-1] != i) {
                System.out.println("something is fishy");
                return;
            }
        }
        System.out.println("makes sense");
    }
}
