package bakjoon.bakjoon1XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Exercise1672 {
    private static final char[] change = {
            'A', 'C', 'A', 'G',
            'C', 'G', 'T', 'A',
            'A', 'T', 'C', 'G',
            'G', 'A', 'G', 'T'
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int len = Integer.parseInt(br.readLine());
        char[] dna = br.readLine().toCharArray();
        while (len > 1) {
            dna[len-2] = getLetter(dna[len-2], dna[len-1]);
            len -= 1;
        }
        bw.write(dna[0]);
        bw.flush();
        bw.close();
    }

    public static char getLetter(char a, char b) {
        int idx1 = (a == 'A') ? 0 : (a == 'G') ? 1 : (a == 'C') ? 2 : 3;
        int idx2 = (b == 'A') ? 0 : (b == 'G') ? 1 : (b == 'C') ? 2 : 3;
        return change[idx1*4+idx2];
    }
}
