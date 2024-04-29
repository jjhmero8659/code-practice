package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;


public class Solution_1789 {
    static long N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Long.parseLong(br.readLine());

        long sum = 0;
        long i = 1;

        while (true){
            if (sum > N){
                break;
            }
            sum += i++;
        }

        bw.write((i-2) + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

}