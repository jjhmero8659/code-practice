package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_2847 {
    static int N;
    static int[] point;
    static long disCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        point = new int[N];

        for (int i = N - 1; i >= 0; i--) {
            point[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i < N; i++) {
            while (point[i] >= point[i-1]){
                point[i]--;
                disCnt++;
            }
        }

        bw.write(disCnt + "\n");
        bw.flush();
        bw.close();
    }

}