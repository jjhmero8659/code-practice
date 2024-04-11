package DP;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_11727 {
    static int N;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp = new long[N + 1];

        dp[1] = 1;
        dp[2] = 3;

        for (int i=3; i<=N; i++){
            dp[i] = (dp[i-1] + (2 * dp[i-2])) % 10007;
        }

        bw.write(dp[N] + "\n");

        bw.flush();
        bw.close();
    }

}