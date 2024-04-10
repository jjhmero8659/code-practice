package DP;

import java.io.*;


public class Solution_9095 {
    static int N;
    static final int SIZE = 10;
    static long dp[] = new long[SIZE + 1];
    static long sumDp[] = new long[SIZE + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i=4; i<=SIZE; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        for (int i=0; i<N; i++){
            int data = Integer.parseInt(br.readLine());

            bw.write(dp[data] + "\n");
        }

        bw.flush();
        bw.close();
    }

}