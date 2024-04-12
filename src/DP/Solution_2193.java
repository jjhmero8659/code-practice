package DP;

import java.io.*;


public class Solution_2193 {
    static int N;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp = new long[N];

        for (int i = 0; i < N; i++) {
            if (i == 0) {
                dp[i] = 1;
                continue;
            } else if (i == 1) {
                dp[i] = 1;
                continue;
            }

            dp[i] = dp[i - 1] + dp[i - 2];
        }

        bw.write(dp[N - 1] + "\n");
        bw.flush();
        bw.close();
    }

}