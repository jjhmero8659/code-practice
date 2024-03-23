package PrefixSum;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_12847 {
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
        long[] money = new long[N+1];

        for (int i=1; i<=N; i++){
            money[i] = Long.parseLong(stD.nextToken());
        }

        long sum = 0;
        for (int i=1; i<=M; i++){
            sum += money[i];
        }

        long max = sum;

        for (int i=M+1; i<=N; i++){
            sum -= money[i-M];
            sum += money[i];

            max = Math.max(max,sum);
        }

        bw.write(max+"\n");
        bw.flush();
        bw.close();
    }

}