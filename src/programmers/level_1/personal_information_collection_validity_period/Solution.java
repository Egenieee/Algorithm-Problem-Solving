package programmers.level_1.personal_information_collection_validity_period;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("2022.05.19",
                new String[]{"A 6", "B 12", "C 3"},
                new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"}));
    }

    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> informationToDestroy = new ArrayList<>();

        LocalDate todayDate = getLocalDateFormat(today);
        Map<String, Integer> validityPeriod = getValidityPeriodTable(terms);

        for (int i = 0; i < privacies.length; i++) {
            if (isExpiredInformation(privacies[i], validityPeriod, todayDate)) {
                informationToDestroy.add(i + 1);
            }
        }

        return informationToDestroy;
    }

    private boolean isExpiredInformation(String eachPrivacy, Map<String, Integer> validityPeriod, LocalDate todayDate) {
        String[] privacy = eachPrivacy.split(" ");

        LocalDate date = getLocalDateFormat(privacy[0]);
        int monthToAdd = validityPeriod.get(privacy[1]);

        LocalDate addedDate = date.plusMonths(monthToAdd).minusDays(1);

        return addedDate.isBefore(todayDate);
    }

    private LocalDate getLocalDateFormat(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
        LocalDate localDate = null;

        try {
            Date todayDate = simpleDateFormat.parse(date);

            // Date -> LocalDate 변환
            localDate = todayDate.toInstant()   // Date -> Instant
                    .atZone(ZoneId.systemDefault())  // Instant -> ZonedDateTime
                    .toLocalDate(); // ZonedDateTime -> LocalDate

        } catch (ParseException exception) {
            exception.printStackTrace();
        }

        return localDate;
    }

    private Map<String, Integer> getValidityPeriodTable(String[] terms) {
        Map<String, Integer> validityPeriod = new HashMap<>();

        for (String term : terms) {
            String[] validity = term.split(" ");

            validityPeriod.put(validity[0], Integer.valueOf(validity[1]));
        }

        return validityPeriod;
    }
}
