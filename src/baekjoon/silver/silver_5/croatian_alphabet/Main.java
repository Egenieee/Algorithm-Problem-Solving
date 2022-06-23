package baekjoon.silver.silver_5.croatian_alphabet;

import java.io.*;

// č	c=
// ć	c-
// dž	dz=
// đ	d-
// lj	lj
// nj	nj
// š	s=
// ž	z=

// ljes=njak 6
// ddz=z= 3
// nljj 3


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String word = br.readLine();

        int alphabetCount = 0;
        String two;
        String three;

        while (word.length() > 0) {
            two = word.substring(0, 1);
            three = word.substring(0, 1);

            if (word.length() > 1) {
                two = word.substring(0, 2);
            }

            if (word.length() > 2) {
                three = word.substring(0, 3);
            }

            if (three.equals("dz=")) {

                alphabetCount++;
                word = word.substring(3);

            } else if (two.equals("c=")) {

                alphabetCount++;
                word = word.substring(2);

            } else if (two.equals("c-")) {

                alphabetCount++;
                word = word.substring(2);

            } else if (two.equals("d-")) {

                alphabetCount++;
                word = word.substring(2);

            } else if (two.equals("lj")) {

                alphabetCount++;
                word = word.substring(2);

            } else if (two.equals("nj")) {

                alphabetCount++;
                word = word.substring(2);

            } else if (two.equals("s=")) {

                alphabetCount++;
                word = word.substring(2);

            } else if (two.equals("z=")) {

                alphabetCount++;
                word = word.substring(2);

            } else {

                alphabetCount++;
                word = word.substring(1);

            }
        }

        bw.write(String.valueOf(alphabetCount));
        bw.flush();
        bw.close();

    }
}
