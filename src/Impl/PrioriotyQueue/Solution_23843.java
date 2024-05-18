package Impl.PrioriotyQueue;

import java.io.*;
import java.util.*;


public class Solution_23843 {
    static int N,M;

    static Integer[] time;
    static PriorityQueue<Integer> powerSocket = new PriorityQueue<>();
    static PriorityQueue<Integer> remainSocket = new PriorityQueue<>(
            (a,b) -> Integer.compare(b,a)
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        time = new Integer[N];
        StringTokenizer stD = new StringTokenizer(br.readLine()," ");
        for (int i=0; i<N; i++){
            time[i] = Integer.parseInt(stD.nextToken());
        }

        Arrays.sort(time, Collections.reverseOrder());

        for (int i=0; i<N; i++){
            if (i < M){
                powerSocket.add(time[i]);
            }
            else{
                remainSocket.add(time[i]);
            }
        }

        while (!remainSocket.isEmpty()){
            Integer pMin = powerSocket.poll(); //현재 최소
            Integer rMax = remainSocket.poll(); //잔여 최대

            powerSocket.offer(pMin + rMax);
        }

        int max = 0;
        while (!powerSocket.isEmpty()){
            max = Math.max(powerSocket.poll() , max);
        }

        bw.write(max + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}