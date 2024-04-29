package Greedy;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_1049 {
    static int N,M;
    static long minSet = Integer.MAX_VALUE;
    static long minEach = Integer.MAX_VALUE;
    static long costA = 0;
    static long costB = 0;
    static long costC = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine() ," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i=0; i<M; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");

            minSet = Math.min(minSet, Long.parseLong(stD.nextToken()));
            minEach = Math.min(minEach, Long.parseLong(stD.nextToken()));
        }

        long minResult = 0;

        costA = (N / 6) * minSet;
        costA += (N % 6) * minEach;

        if (N % 6 != 0){
            costB = ((N / 6) + 1) * minSet;
        }
        else{
            costB = (N / 6) * minSet;
        }

        minResult = Math.min(costA, costB);

        costC = N * minEach;

        bw.write(Math.min(minResult , costC) + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

}