package DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_11726 {
    //2×n 타일링
    static int N;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp = new long[1001]; //2 * n 의 크기

        dp[1] = 1; // 2 * 1 직사각형
        dp[2] = 2; // 2 * 2 직사각형

        for (int i=3; i<=N; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
    }

}