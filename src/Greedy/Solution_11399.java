package Greedy;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_11399 {
    static int N;
    static class User{
        int num;
        int time;

        public User(int num, int time) {
            this.num = num;
            this.time = time;
        }
    }

    static PriorityQueue<User> pq = new PriorityQueue<>(
            (a,b) -> (Integer.compare(a.time , b.time))
    );
    //인출 시간에 따른 오름 차순 정렬

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); //사람의 수

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for (int i=1; i<=N; i++){
            int time = Integer.parseInt(st.nextToken());
            pq.offer(new User(i,time));
        }

        bw.write(solution() + "\n");

        bw.flush();
        bw.close();
    }

    static long solution(){
        long sum = 0;
        long wTime = 0;
        while (!pq.isEmpty()){
            //우선순위 큐가 비어질때 까지

            User poll = pq.poll();
            long tTime = wTime + poll.time;
            sum += tTime;
            wTime = tTime;
        }

        return sum;
    }
}