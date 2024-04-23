package Greedy;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_1931 {
    static int N;

    static PriorityQueue<Meet> pq = new PriorityQueue<>(
            (m1,m2) -> (
                    m1.end != m2.end ? Long.compare(m1.end,m2.end) //종료 시간이 같지 않으면 종료시간에 따른 오름차순 정렬
                            : Long.compare(m1.start , m2.start))
            //종료 시간이 같으면 시작 시간에 따른 오름 차순 정렬
    );

    static class Meet{
        long start;
        long end;

        public Meet(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); //회의 개수

        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine() ," ");
            long s = Long.parseLong(st.nextToken());
            long e = Long.parseLong(st.nextToken());

            pq.offer(new Meet(s,e));
            //우선순위 큐 추가
        }

        bw.write(solution() + "\n");
        bw.flush();
        bw.close();
    }

    public static long solution(){
        long lastEnd = 0;
        long resultCnt = 0;
        while (!pq.isEmpty()){
            Meet poll = pq.poll();

            if (lastEnd <= poll.start){
                //마지막 종료 회의 시간이
                //다음 회의 시작 시간보다 작거나 같아야 한다.

                lastEnd = poll.end;
                resultCnt++;
            }
        }

        return resultCnt;
    }
}