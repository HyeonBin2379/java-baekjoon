package baekjoon.baekjoon31XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Exercise31097 {

    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    private enum Zodiac {
        AQUARIUS("Aquarius", 1, 20, 2, 18),
        PISCES("Pisces", 2, 19, 3, 20),
        ARIES("Aries", 3, 21, 4, 19),
        TAURUS("Taurus", 4, 20, 5, 20),
        GEMINI("Gemini", 5, 21, 6, 20),
        CANCER("Cancer", 6, 21, 7, 22),
        LEO("Leo", 7, 23, 8, 22),
        VIRGO("Virgo", 8, 23, 9, 22),
        LIBRA("Libra", 9, 23, 10, 22),
        SCORPIO("Scorpio", 10, 23, 11, 22),
        SAGITTARIUS("Sagittarius", 11, 23, 12, 21),
        CAPRICORN("Capricorn", 12, 22, 12, 31);

        private final String name;
        private final int startMonth;
        private final int startDay;
        private final int endMonth;
        private final int endDay;

        Zodiac(String name, int startMonth, int startDay, int endMonth, int endDay) {
            this.name = name;
            this.startMonth = startMonth;
            this.startDay = startDay;
            this.endMonth = endMonth;
            this.endDay = endDay;
        }

        public static String getName(int year, Date date) {
            return Arrays.stream(Zodiac.values())
                    .filter(zodiac -> {
                        try {
                            return zodiac.findZodiac(year, date);
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .findFirst()
                    .orElse(CAPRICORN)
                    .name;
        }
        public boolean findZodiac(int year, Date date) throws ParseException {
            Date startDate = formatter.parse(getFormat(year, startMonth, startDay));
            Date endDate = formatter.parse(getFormat(year, endMonth, endDay));
            return !date.before(startDate) && !date.after(endDate);
        }
    }

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] date = Arrays.stream(br.readLine().split("-")).mapToInt(Integer::parseInt).toArray();
        Date birthday = formatter.parse(getFormat(date[0], date[1], date[2]));
        System.out.println(Zodiac.getName(date[0], birthday));
    }

    public static String getFormat(int year, int month, int day) {
        return String.format("%d-%02d-%02d", year, month, day);
    }
}
