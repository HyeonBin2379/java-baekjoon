package baekjoon.baekjoon10XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.StringTokenizer;

public class Exercise10426 {

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dtFormat.parse(st.nextToken());
        int days = Integer.parseInt(st.nextToken());

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days-1);
        System.out.println(dtFormat.format(cal.getTime()));
    }
}
