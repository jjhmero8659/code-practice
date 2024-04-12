package DP;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_11052 {
    static int N; //사야하는 카드 개수
    static long[] p;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        p = new long[N + 1];
        dp = new long[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            p[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(p[j] + dp[i - j] , dp[i]);
            }
        }

        bw.write(dp[N] + "\n");

        bw.flush();
        bw.close();
    }

}