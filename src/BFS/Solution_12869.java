
package BFS;

import java.io.*;
import java.util.*;


public class Solution_12869 {
    static int N;
    static int[][] attack = {{9, 3, 1}, {9, 1, 3}, {1, 9, 3}, {1, 3, 9}, {3, 1, 9}, {3, 9, 1}};
    static Queue<SCV> q = new LinkedList<>();
    static class SCV {
        int f;
        int s;
        int t;
        int cnt;

        public SCV(int f, int s, int t, int cnt) {
            this.f = f;
            this.s = s;
            this.t = t;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] init = new int[3];

        for (int i=0; i<N; i++){
            init[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(bfs(init[0],init[1],init[2]) + "\n");
        bw.flush();
        bw.close();
    }

    static int bfs(int first,int second , int third) {
        boolean[][][] visited = new boolean[61][61][61];
        visited[first][second][third] = true;
        q.offer(new SCV(first,second,third,0));

        while (!q.isEmpty()) {
            //scv 가 전부 파괴 되지 않았다면
            SCV poll = q.poll();

            if (poll.f == 0 && poll.s == 0 && poll.t == 0){
                return poll.cnt;
            }

            for (int i = 0; i < 6; i++) {
                int nextF = poll.f - attack[i][0];
                int nextS = poll.s - attack[i][1];
                int nextT = poll.t - attack[i][2];
                int nextCnt = poll.cnt + 1;

                if (nextF < 0) {
                    nextF = 0;
                }
                if (nextS < 0) {
                    nextS = 0;
                }
                if (nextT < 0) {
                    nextT = 0;
                }

                if (visited[nextF][nextS][nextT] == false){
                    visited[nextF][nextS][nextT] = true;
                    q.offer(new SCV(nextF,nextS,nextT,nextCnt));
                }
            }
        }

        return -1;
    }

}