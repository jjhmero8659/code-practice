package DP;

import java.io.*;


public class Solution_9656 {
    static int N; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); //돌 개수

        bw.write(N % 2 == 0 ? "SK\n" : "CY\n");

        bw.flush();
        bw.close();
    }

    
}