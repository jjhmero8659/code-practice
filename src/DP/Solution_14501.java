package DP;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_14501 {
    static int N;
    static Day[] days;
    static int[] dp;

    static class Day{
        int t;
        int p;

        public Day(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp = new int[N+1];
        days = new Day[N];

        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine() , " ");

            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            days[i] = new Day(t,p);
        }

        for (int i=0; i<N; i++){
            if (i + days[i].t <= N){
                dp[i + days[i].t] = Math.max(dp[i + days[i].t], dp[i] + days[i].p);
                //현재 날짜의 상담을 하지 않는 값이 더 크다면 하지 않는 값으로 진행
                //현재 날짜의 상담을 하는 값이 크다면 현재 dp 값에 상담 금액 추가
            }

            dp[i + 1] = Math.max(dp[i+1] , dp[i]);
            //현재 값을 누적
        }

        int max = Integer.MIN_VALUE;
        for (int dpN : dp){
            max = Math.max(dpN, max);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }

}