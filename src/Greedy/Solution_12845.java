package Greedy;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Solution_12845 {
    static Integer N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int highLevel = 0;

        StringTokenizer stC = new StringTokenizer(br.readLine()," ");

        long sum = 0;
        for (int i=0; i<N; i++){
            int cardNum = Integer.parseInt(stC.nextToken());

            sum += cardNum;

            highLevel = Math.max(cardNum , highLevel);
        }

        sum += (highLevel * (N-2));
        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }

}