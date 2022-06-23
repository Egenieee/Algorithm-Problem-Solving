package baekjoon.silver.silver_5.sort_inside;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String number = br.readLine();

        String sortedNumber = getSortedNumber(number);

        bw.write(sortedNumber);
        bw.flush();
        bw.close();
    }

    private static String getSortedNumber(String number) {
        List<String> numbers = Arrays.stream(number.split(""))
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());

        return String.join("", numbers);
    }
}
