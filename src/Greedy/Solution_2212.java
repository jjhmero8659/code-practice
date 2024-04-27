package Greedy;

import java.io.*;
import java.util.*;


public class Solution_2212 {
    static int N,K;
    static int[] sensor;
    static Integer[] sDistance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); //센서의 개수
        K = Integer.parseInt(br.readLine()); //집중국 개수

        sensor = new int[N];
        sDistance = new Integer[N-1];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i=0; i<N; i++){
            sensor[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sensor);

        for (int i=0; i<N-1; i++){
            sDistance[i] = sensor[i+1] - sensor[i];
        }

        Arrays.sort(sDistance,Collections.reverseOrder());

        long sum = 0;
        for (int i=K-1; i<N-1; i++){
            sum += sDistance[i];
        }

        bw.write( sum + "\n");
        bw.flush();
        bw.close();
    }
}