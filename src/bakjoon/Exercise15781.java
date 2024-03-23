package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise15781 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] helmet = Arrays.stream(br.readLine().split(" ", n)).mapToInt(Integer::parseInt).toArray();
        int[] vest = Arrays.stream(br.readLine().split(" ", m)).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(helmet);
        Arrays.sort(vest);
        System.out.println(helmet[n-1] + vest[m-1]);
    }
}
