package Greedy;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_1246 {
    static int N,M;
    static PriorityQueue<Integer> consumer = new PriorityQueue<>(
            (a,b) -> Integer.compare(b,a)
    );

    static Egg maxEgg = new Egg(0,0);
    static class Egg{
        int price;
        long totalCost;

        public Egg(int price, long totalCost) {
            this.price = price;
            this.totalCost = totalCost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //달걀 개수
        M = Integer.parseInt(st.nextToken()); //고객 명 수

        for (int i=0; i<M; i++){
            consumer.offer(Integer.parseInt(br.readLine()));
        }

        solution();

        bw.write(maxEgg.price + " ");
        bw.write(maxEgg.totalCost + "\n");
        bw.flush();
        br.close();
        bw.close();
    }


    static void solution() {
        int size = Math.min(N,consumer.size());

        for (int i=1; i<=size; i++){
            Integer poll = consumer.poll();
            int nowCost = poll * i;

            if (maxEgg.totalCost <= nowCost){
                maxEgg = new Egg(poll,nowCost);
            }
        }
    }
}