import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Exercise11723 {
    private static final Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "add" -> set.add(Integer.parseInt(st.nextToken()));
                case "remove" -> set.remove(Integer.parseInt(st.nextToken()));
                case "check" -> {
                    int flag = (set.contains(Integer.parseInt(st.nextToken()))) ? 1 : 0;
                    sb.append(flag).append("\n");
                }
                case "toggle" -> {
                    int value = Integer.parseInt(st.nextToken());
                    if (set.contains(value)) {
                        set.remove(value);
                    } else {
                        set.add(value);
                    }
                }
                case "all" -> {
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                }
                case "empty" -> set.clear();
            }
        }
        br.close();
        System.out.println(sb);
    }
}
