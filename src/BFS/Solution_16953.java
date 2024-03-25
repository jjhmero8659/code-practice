package BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_16953 {
    static long A, B;
    static long calCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stL = new StringTokenizer(br.readLine(), " ");

        A = Long.parseLong(stL.nextToken()); // A
        B = Long.parseLong(stL.nextToken()); // B


        bw.write(bfs() + "\n");
        bw.flush();
        bw.close();
    }

    static long bfs() {
        Queue<Long> q = new LinkedList<>();
        q.offer(A); //A를 대입 , A를 계산하여 B로 변환

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Long pollData = q.poll();
                if (pollData == B) {
                    return ++calCnt;
                }

                if (pollData * 2 <= B) {
                    q.offer(pollData * 2);
                }

                if (pollData * 10 + 1 <= B) {
                    q.offer(pollData * 10 + 1);
                }

            }
            calCnt++;
        }

        return -1;
    }

}