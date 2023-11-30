import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Exercise17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalCount = Integer.parseInt(st.nextToken());
        int testCase = Integer.parseInt(st.nextToken());

        Map<String, String> passwordTable = new LinkedHashMap<>();
        for (int i = 0; i < totalCount; i++) {
            st = new StringTokenizer(br.readLine());
            String url = st.nextToken();
            String pwd = st.nextToken();
            passwordTable.put(url, pwd);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < testCase; i++) {
            String target = br.readLine();
            bw.write(passwordTable.get(target)+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
