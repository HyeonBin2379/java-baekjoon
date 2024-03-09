package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Exercise2864 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        String b = st.nextToken();

        int min = Integer.parseInt(a.replace("6", "5"))
                + Integer.parseInt(b.replace("6", "5"));
        int max = Integer.parseInt(a.replace("5", "6"))
                + Integer.parseInt(b.replace("5", "6"));
        System.out.println(min + " " + max);
    }
}
