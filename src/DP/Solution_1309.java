package DP;

import java.io.*;


public class Solution_1309 {
    static int N;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp = new long[N + 1][3];
        // 1치원 = N의 깊이
        // 2차원 = ( 0 == 사자 없음 , 1 == 왼쪽 사자 , 2 == 오른쪽 사자)

        for (int i = 0; i < 3; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][0]) % 9901;
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][0]) % 9901;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][0]) % 9901;
        }

        long sum = 0;

        for (long dpN : dp[N]){
            sum += dpN;
        }

        bw.write(sum % 9901 + "\n");
        bw.flush();
        bw.close();
    }

}