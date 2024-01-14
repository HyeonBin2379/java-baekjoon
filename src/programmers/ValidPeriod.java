package programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

class ValidPeriodSolution {
    private final Map<String, Integer> termPeriod = new LinkedHashMap<>();
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");

    public int[] solution(String today, String[] terms, String[] privacies) throws ParseException {
        for (String term : terms) {
            String[] token = term.split(" ");
            termPeriod.put(token[0], Integer.parseInt(token[1]));
        }

        List<Integer> deletion = new ArrayList<>();
        Calendar todayCal = setDateInCalendar(today);
        for (int i = 0; i < privacies.length; i++) {
            String[] token = privacies[i].split(" ");
            Calendar deadline = setDateInCalendar(token[0]);
            setDeadline(deadline, token[1]);
            if (todayCal.after(deadline)) {
                deletion.add(i+1);
            }
        }

        int[] answer = deletion.stream().mapToInt(privacy -> privacy).toArray();
        Arrays.sort(answer);
        return answer;
    }

    public Calendar setDateInCalendar(String date) throws ParseException {
        Date todayDate = dateFormat.parse(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(todayDate);
        return cal;
    }
    public void setDeadline(Calendar calender, String termName) {
        calender.add(Calendar.MONTH, termPeriod.get(termName));
        calender.add(Calendar.DATE, -1);
    }
}
public class ValidPeriod {
    public static void main(String[] args) throws ParseException {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        System.out.println(Arrays.toString(new ValidPeriodSolution().solution(today, terms, privacies)));
    }
}
