package Impl.PrioriotyQueue;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_1374 {
    static int N;

    static class Lecture{
        int time;
        char stat;
        Lecture(int time , char stat){
            this.time = time;
            this.stat = stat;
        }
    }

    static PriorityQueue<Lecture> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(a.time, b.time)
    );

    static long maxCnt = 0;
    static long lectureCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int lecN = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.offer(new Lecture(start , 'S'));
            pq.offer(new Lecture(end , 'E'));
        }

        solution();

        bw.write(maxCnt + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static void solution(){
        while (!pq.isEmpty()){
            Lecture now = pq.poll();
            int sCnt = 0;
            int eCnt = 0;

            if (now.stat == 'S'){
                sCnt++;
            }
            else{
                eCnt++;
            }

            while (!pq.isEmpty()){
                Lecture peek = pq.peek();
                if (peek.time == now.time){
                    if (peek.stat == 'S'){
                        pq.poll();
                        sCnt++;
                    }
                    else{
                        pq.poll();
                        eCnt++;
                    }
                }
                else if (peek.time != now.time){
                    break;
                }
            }

            lectureCnt += Math.abs(sCnt);
            lectureCnt -= Math.abs(eCnt);

            maxCnt = Math.max(lectureCnt , maxCnt);
        }
    }


}