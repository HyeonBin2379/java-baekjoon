package bakjoon.bakjoon01XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise1946 {

    private static class Rank implements Comparable<Rank> {
        int resume, interview;

        public Rank(int resume, int interview) {
            this.resume = resume;
            this.interview = interview;
        }

        @Override
        public int compareTo(Rank o) {
            return resume != o.resume ? Integer.compare(resume, o.resume) : Integer.compare(interview, o.interview);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        while (testcase-- > 0) {
            int n = Integer.parseInt(br.readLine());
            Rank[] attendee = new Rank[n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int resumeRank = Integer.parseInt(st.nextToken());
                int interviewRank = Integer.parseInt(st.nextToken());
                attendee[i] = new Rank(resumeRank, interviewRank);
            }
            Arrays.sort(attendee);

            int maxRank = n+1;
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (attendee[i].interview < maxRank) {
                    count++;
                    maxRank = attendee[i].interview;
                }
            }
            System.out.println(count);
        }
    }
}
