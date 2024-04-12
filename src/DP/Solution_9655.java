package DP;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_9655 {
    static int N; 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); //돌 개수

        bw.write(N % 2 == 0 ? "CY\n" : "SK\n");

        bw.flush();
        bw.close();
    }

    
}