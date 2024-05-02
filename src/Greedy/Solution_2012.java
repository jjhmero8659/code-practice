package Greedy;

import java.io.*;
import java.util.PriorityQueue;


public class Solution_2012 {
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int rank = 1;
    static long sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        solution();

        bw.write(sum + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static void solution() {
        while (!pq.isEmpty()){
            Integer poll = pq.poll();
            sum += Math.abs(poll - rank++);
        }
    }
}