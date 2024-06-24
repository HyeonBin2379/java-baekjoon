package bakjoon.bakjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise29602 {

    private static class Document implements Comparable<Document> {
        int dueDate, docuNum;
        public Document(int dueDate, int docuNum) {
            this.dueDate = dueDate;
            this.docuNum = docuNum;
        }

        @Override
        public int compareTo(Document o) {
            return dueDate - o.dueDate;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Document[] workList = new Document[n];
        for (int i = 0; i < n; i++) {
            int dueDate = Integer.parseInt(st.nextToken());
            workList[i] = new Document(dueDate, i);
        }
        Arrays.sort(workList);

        int[] answer = new int[n];
        for (int i = 1; i <= n; i++) {
            answer[workList[i-1].docuNum] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
    }
}
