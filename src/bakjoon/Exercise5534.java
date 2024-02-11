package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5534 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] oldName = new String[n];
        String newName = br.readLine();
        int count = 0;
        for (int i = 0; i < n; i++) {
            oldName[i] = br.readLine();
            count += check(oldName[i], newName);
        }
        br.close();
        System.out.println(count);
    }

    public static int check(String oldName, String newName) {
        for (int start = 0; start < oldName.length(); start++) {
            if (oldName.charAt(start) == newName.charAt(0)) { // 첫 글자 위치 확인
                for (int end = start; end < oldName.length(); end++) {
                    if (oldName.charAt(end) == newName.charAt(newName.length()-1)) { // 마지막 글자 위치 확인
                        int avg_gap = (end - start) / (newName.length()-1); // 간격 설정
                        int cnt = 0;
                        while (cnt < newName.length()) {
                            if (oldName.charAt(start+avg_gap*cnt) != newName.charAt(cnt)) {
                                break;
                            }
                            cnt++;
                        }
                        if (cnt == newName.length()) { // 중간 글자 모두 확인 & 간격 일정
                            return 1;
                        }
                    }
                }
            }
        }
        return 0;
    }
}
