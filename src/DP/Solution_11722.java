package DP;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_11722 {
    static int N; //수열의 개수
    static long[] num;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        num = new long[N];
        dp = new long[N];


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            num[i] = Long.parseLong(st.nextToken());
            dp[i] = 1;
        }


        bw.write(dp() + "\n");

        bw.flush();
        bw.close();
    }

    static long dp(){
        long maxResult = -1;

        for (int i = 1; i < N; i++) {
            for (int j=0; j<i; j++){
                if (num[j] > num[i]){ //이전 값이 현재 값보다 큰 값이라면
                    //제일 큰값 + 현재 숫자 개수 1 증가해서 MAX 넣어주기
                    dp[i] = Math.max(dp[j] + 1 , dp[i]);
                }
            }
        }

        for (long dpN : dp){
            maxResult = Math.max(maxResult , dpN);
        }

        return maxResult;
    }
}