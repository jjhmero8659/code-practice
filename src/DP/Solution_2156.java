package DP;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_2156 {
    static int N;
    static int[] wine;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        wine = new int[N + 1];
        dp = new int[N + 1];

        for (int i=1; i<=N; i++){
            wine[i] = Integer.parseInt(br.readLine());
        }

        for (int i=1; i<=N; i++){
            
            if (i == 1){
                dp[i] = wine[1];
                continue;
            }
            else if (i == 2){
                dp[i] = wine[1] + wine[2];
                continue;
            }
            
            // 3 부터는 연결 되서 마실 수 없음
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i-3] + wine[i-1], dp[i-2]) + wine[i]);
        }

        int max = 0;
        for (int dpN : dp){
            max = Math.max(max, dpN);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }

}