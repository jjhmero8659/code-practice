package DP;

import java.io.*;


public class Solution_9659 {
    static long N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Long.parseLong(br.readLine()); //돌 개수

        bw.write(N % 2 == 0 ? "CY\n" : "SK\n");

        bw.flush();
        bw.close();
    }

    
}