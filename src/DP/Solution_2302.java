package DP;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_2302 {
    static int N,M;
    static long[] dp;
    static long answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); //좌석 개수
        M = Integer.parseInt(br.readLine()); //고정석 개수

        dp = new long[41];

        dp[0] = 1; // vip 가 붙어있는 경우 dp[0] 계산 , 1로 해줘야 곱연산 시 0으로 초기화 되지 않음
        dp[1] = 1;
        dp[2] = 2;

        for (int i=3; i<=N; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        int beforeIdx = 0;

        for (int i=0; i<M; i++){
            int vip = Integer.parseInt(br.readLine()); // vip 좌석

            answer *= dp[vip - 1 - beforeIdx]; // vip 이전 좌석 까지의 경우의 수 곱해주기

            beforeIdx = vip; // 이전 vip 좌석 위치 저장
        }
        answer *= dp[N - beforeIdx];

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    
}