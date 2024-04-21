package Greedy;

import java.io.*;
import java.util.PriorityQueue;


public class Solution_1715 {
    static int N;
    static PriorityQueue<Long> pq = new PriorityQueue<>(
            (c1,c2) -> (Long.compare(c1,c2)) //오름차순 정렬
    );

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            pq.offer(Long.parseLong(br.readLine()));
            //우선 순위 큐 삽입
        }

        bw.write(solution() + "\n");
        bw.flush();
        bw.close();
    }

    static long solution(){
        long sum = 0; //초기 값

        while (!pq.isEmpty()){
            // 두개 씩 poll
            if (pq.size() >= 2){
                long c1 = pq.poll();
                long c2 = pq.poll();

                sum += (c1 + c2);
                pq.offer(c1 + c2);
            }
            else{
                return sum;
            }
        }
        return -1;
    }
}