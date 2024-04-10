package DP;

import java.io.*;


public class Solution_1003 {
    static int T;
    static final int SIZE = 40;
    static Num[] dp = new Num[SIZE + 1];

    static class Num{
        long zero;
        long one;

        public Num(long zero, long one) {
            this.zero = zero;
            this.one = one;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine()); //테스트 케이스

        dp[0] = new Num(1,0);
        dp[1] = new Num(0,1);
        for (int i=2; i<=SIZE; i++){
            Num sub1 = dp[i - 1];
            Num sub2 = dp[i - 2];
            dp[i] = new Num(
                    sub1.zero + sub2.zero,
                    sub1.one + sub2.one
            );
        }

        for (int i=0; i<T; i++){
            int data = Integer.parseInt(br.readLine());

            bw.write(dp[data].zero + " " + dp[data].one + "\n");
        }

        bw.flush();
        bw.close();
    }

}