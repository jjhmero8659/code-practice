package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Solution_20115 {
    static int N;
    static Double[] drink;
    static double result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        drink = new Double[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++){
            drink[i] = Double.parseDouble(st.nextToken());
        }

        Arrays.sort(drink, Collections.reverseOrder());

        result = drink[0];

        for (int i=1; i<N; i++){
            double add = drink[i] / 2;
            result += add;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

}