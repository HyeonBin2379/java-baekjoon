import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Exercise9375 {
    private static final Map<String, Set<String>> closet = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int total = Integer.parseInt(br.readLine());
            for (int j = 0; j < total; j++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String category = st.nextToken();
                if (!closet.containsKey(category)) {
                    closet.put(category, new HashSet<>());
                }
                closet.get(category).add(name);
            }

            int totalCase = 1;
            for (String category : closet.keySet()) {
                totalCase *= closet.get(category).size() + 1;
            }

            System.out.println(totalCase-1);
            closet.clear();
        }
        br.close();
    }
}
