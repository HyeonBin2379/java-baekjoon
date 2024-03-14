package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Exercise10420 {

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        int input = Integer.parseInt(br.readLine());

        Calendar cal = Calendar.getInstance();
        cal.set(2014, Calendar.APRIL, 2);
        cal.add(Calendar.DATE, input-1);
        System.out.println(format.format(cal.getTime()));
    }
}
