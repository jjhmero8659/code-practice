package DP;

import java.io.*;


public class Solution_2579 {
    static int N;
    static int[] step;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        step = new int[N + 1];
        dp = new int[N + 1];

        for (int i=1; i<=N; i++){
            step[i] = Integer.parseInt(br.readLine());
        }

        for (int i=1; i<=N; i++){
            if (i == 1){
                dp[i] = step[i];
                continue;
            }
            else if(i == 2){
                dp[i] = dp[1] + step[i];
                continue;
            }

            dp[i] = Math.max(dp[i-2] + step[i], dp[i-3] + step[i-1] + step[i]) ;
        }

        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
    }

}