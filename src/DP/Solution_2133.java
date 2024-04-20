package DP;

import java.io.*;


public class Solution_2133 {
    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];

        dp[0] = 1; //3 * 0 => 1가지

        for (int i = 2; i <= N; i += 2) {
            dp[i] = dp[i-2] * 3;
            for (int j = i-4; j>=0; j -= 2){
                dp[i] += dp[j] * 2;
            }
        }


        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
    }

}