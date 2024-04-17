package DP;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_10844 {
    static int N;
    static long[][] dp; // 각 숫자가 마지막에 위치하는 경우의 수 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());

        dp = new long[N + 1][10]; // N 자리 수 , 0 ~ 9


        for (int j = 0; j <= 9; j++) {
            if (j == 0){
                dp[1][0] = 0; // 첫째 자리는 0이 올 수 없다
                continue;
            }
            dp[1][j] = 1;
        }


        for (int i = 2; i <= N; i++) {
            for (int j = 0; j <= 9; j++) {
                if ((j-1) >= 0){
                    dp[i][j] += dp[i-1][j-1] % 1000000000;
                }

                if ((j+1) <= 9){
                    dp[i][j] += dp[i-1][j+1] % 1000000000;
                }
            }
        }

        long sum = 0;

        for (long num : dp[N]){
            sum += num % 1000000000;
        }

        bw.write(sum % 1000000000 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }


}