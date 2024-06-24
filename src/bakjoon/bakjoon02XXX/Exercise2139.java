package bakjoon.bakjoon02XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Exercise2139 {

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat dtFormat = new SimpleDateFormat("dd MM yyyy");
        while (true) {
            String input = br.readLine();
            if (input.equals("0 0 0")) {
                break;
            }
            Date start = dtFormat.parse("01 01 " + input.substring(input.length()-4));
            Date end = dtFormat.parse(input);
            int diff = (int) ((end.getTime()-start.getTime()) / (24*60*60*1000));
            System.out.println(diff+1);
        }
    }
}
