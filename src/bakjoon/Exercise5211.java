package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5211 {

    // 가단조와 다장조의 중심음
    private static final String aMinorCenters = "ADE";
    private static final String cMajorCenters = "CFG";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String music = br.readLine();
        int aMinorCount = 0, cMajorCount = 0;
        char lastNote = ' ';

        // 각 마디의 첫 음을 추출하여 중심음 개수 세기
        for (String measure : music.split("\\|")) {
            if (!measure.isEmpty()) {
                char firstNote = measure.charAt(0);
                lastNote = measure.charAt(measure.length() - 1); // 마지막 음 저장

                if (aMinorCenters.indexOf(firstNote) != -1) {
                    aMinorCount++;
                }
                if (cMajorCenters.indexOf(firstNote) != -1) {
                    cMajorCount++;
                }
            }
        }

        // 중심음 개수가 같은 경우, 마지막 음으로 결정
        if (aMinorCount == cMajorCount) {
            System.out.println(aMinorCenters.indexOf(lastNote) != -1 ? "A-minor" : "C-major");
        } else {
            System.out.println(aMinorCount > cMajorCount ? "A-minor" : "C-major");
        }
    }
}
