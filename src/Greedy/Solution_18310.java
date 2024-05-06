package Greedy;

import java.io.*;
import java.util.*;


public class Solution_18310 {
    static int N;
    static int[] home;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        home = new int[N];

        StringTokenizer stD = new StringTokenizer(br.readLine()," ");
        for (int i=0; i<N; i++){
            home[i] = Integer.parseInt(stD.nextToken());
        }

        Arrays.sort(home);

        bw.write(home[(N-1)/2] + "\n");
        bw.flush();
        bw.close();
    }

}