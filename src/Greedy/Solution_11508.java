package Greedy;

import java.io.*;
import java.util.PriorityQueue;


public class Solution_11508 {
    static int N;
    static PriorityQueue<Integer> drinks = new PriorityQueue<>(
            (a,b) -> Integer.compare(b,a)
    );
    static long cost = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); //손님 수

        for (int i=0; i<N; i++){
            drinks.offer(Integer.parseInt(br.readLine()));
        }

        solution();
        bw.write( cost + "\n");
        bw.flush();
        br.close();
        bw.close();
    }


    static void solution() {
        int size = drinks.size() / 3;
        for (int i=0; i<size; i++){
            long first = drinks.poll();
            long second = drinks.poll();
            drinks.poll();

            cost += (first + second);
        }

        while (!drinks.isEmpty()){
            cost += drinks.poll();
        }
    }
}