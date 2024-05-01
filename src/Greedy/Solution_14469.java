package Greedy;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_14469 {
    static int N;
    static PriorityQueue<Cow> waitingLine = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.arrive, b.arrive)
    );

    static class Cow {
        int arrive;
        int processT;

        public Cow(int arrive, int processT) {
            this.arrive = arrive;
            this.processT = processT;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); //소 숫자


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int arrive = Integer.parseInt(st.nextToken());
            int processT = Integer.parseInt(st.nextToken());
            waitingLine.offer(new Cow(arrive, processT));
        }

        bw.write(solution() + "\n");
        bw.flush();
        bw.close();
    }

    static long solution() {
        long resultT = 0;

        while (!waitingLine.isEmpty()) {
            Cow poll = waitingLine.poll();

            if (resultT < poll.arrive) {
                //다음 검문 할 소가 현재 시간보다 늦게 온다면
                resultT = poll.arrive + poll.processT; //도착 시간 , 실행 시간
            } else {
                resultT += poll.processT;
            }
        }

        return resultT;
    }

}