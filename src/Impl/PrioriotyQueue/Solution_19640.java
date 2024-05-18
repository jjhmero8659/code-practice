package Impl.PrioriotyQueue;

import java.io.*;
import java.util.*;


public class Solution_19640 {
    static int N,M,K;
    static int pCnt = 0;
    static PriorityQueue<Employee> pq = new PriorityQueue<>(
            (a,b) -> (a.workDay != b.workDay ? Integer.compare(b.workDay, a.workDay) //근무일 순
                    : (a.pain != b.pain) ? Integer.compare(b.pain,a.pain) //고통 순
                    : Integer.compare(a.line , b.line)) //낮은 번호 순
    );

    static Queue<Employee>[] qArr;

    static class Employee{
        int line;
        int workDay;
        int pain;
        boolean deca;

        public Employee(int line, int workDay, int pain, boolean deca) {
            this.line = line;
            this.workDay = workDay;
            this.pain = pain;
            this.deca = deca;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken()); //사원 수
        M = Integer.parseInt(st.nextToken()); //줄 수
        K = Integer.parseInt(st.nextToken()) + 1; //데카 위치

        qArr = new Queue[M+1];

        for (int i=1; i<=M; i++){
            qArr[i] = new LinkedList<>();
        }

        int lineN = 1;

        for (int i=1; i<=N; i++){

            StringTokenizer stD = new StringTokenizer(br.readLine()," ");
            int day = Integer.parseInt(stD.nextToken());
            int pain = Integer.parseInt(stD.nextToken());

            if (i == K){
                qArr[lineN].add(new Employee(lineN , day , pain , true));
            }
            else{
                qArr[lineN].add(new Employee(lineN , day , pain , false));
            }

            lineN++;

            if (lineN > M){
                lineN = 1;
            }
        }

        solution();

        bw.write(pCnt + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static void solution(){
        for (int i=1; i<=M; i++){
            if (!qArr[i].isEmpty()){
                pq.offer(qArr[i].poll());
            }
        }

        while (!pq.isEmpty()){
            Employee now = pq.poll();

            if (now.deca == true){
                return;
            }
            pCnt++;

            if (!qArr[now.line].isEmpty()){
                pq.offer(qArr[now.line].poll());
            }
        }
    }


}