package Greedy;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_11497 {
    static int N,T;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> pq = new PriorityQueue<>(
                    (c1,c2) -> (Integer.compare(c2,c1)) //내림 차순 정렬
            );

            StringTokenizer stD = new StringTokenizer(br.readLine()," ");

            for (int i=0; i<N; i++){
                pq.offer(Integer.parseInt(stD.nextToken()));
            }

            Deque<Integer> dq = new LinkedList<>();

            for (int i=0; i<N; i++){
                if (i % 2 == 0){
                    dq.addLast(pq.poll());
                }
                else{
                    dq.addFirst(pq.poll());
                }
            }
            int[] wood = new int[N];

            for (int i=0; i<N; i++){
                wood[i] = dq.pollFirst();
            }

            int maxNum = 0;

            for (int i=0; i<N; i++){
                if (i == N-1){
                    maxNum = Math.max(maxNum , Math.abs(wood[N-1] - wood[0]));
                }
                else{
                    maxNum = Math.max(maxNum , Math.abs(wood[i] - wood[i+1]));
                }
            }

            bw.write(maxNum + "\n");
        }

        bw.flush();
        bw.close();
    }

}