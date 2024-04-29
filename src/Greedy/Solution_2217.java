package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_2217 {
    static int N;
    static Integer[] rope;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        rope = new Integer[N];

        for (int i=0; i<N; i++){
            rope[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(rope, Collections.reverseOrder());

        long maxAvg = 0;

        for (int i=0; i<N; i++){
            maxAvg = Math.max(maxAvg,(rope[i] * (i+1)));
        }

        bw.write(maxAvg + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

}