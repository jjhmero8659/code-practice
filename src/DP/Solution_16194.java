package DP;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_16194 {
    static int N;
    static long[] card;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); //카드 팩 개수

        card = new long[N+1];
        dp = new long[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i=1; i<=N; i++){
            card[i] = Integer.parseInt(st.nextToken()); //상자 크기 입력
            dp[i] = Integer.MAX_VALUE; // 최소 값을 구하기 위해 최대값 입력
        }

        for (int i=1; i<=N; i++){
            for (int j=0; j<i; j++){
                dp[i] = Math.min(dp[i] , card[i-j] + dp[j]);
            }
        }

        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    
}