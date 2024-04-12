package DP;

import java.io.*;


public class Solution_1904 {
    static int N;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            if (i == 1) {
                dp[i] = 1 % 15746;
                continue;
            } else if (i == 2) {
                dp[i] = 2 % 15746;
                continue;
            }

            dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
        }

        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
    }

}