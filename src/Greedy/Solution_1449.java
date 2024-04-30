package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_1449 {
    static int N,L;
    static int[] water;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken()); //테이프 길이

        water = new int[N];

        StringTokenizer stD = new StringTokenizer(br.readLine()," ");
        for (int i=0; i<N; i++){
            water[i] = Integer.parseInt(stD.nextToken());
        }

        Arrays.sort(water);

        int range = (int)(water[0] - 0.5 + L);

        int count = 1;

        for (int i=1; i<water.length; i++){
            if (range < (int)(water[i] + 0.5)){
                range = (int) (water[i] - 0.5 + L);
                count++;
            }
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }

}