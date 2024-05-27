
package BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_1261 {
    static int N, M;
    static char[][] map;
    static int[] dx = {0, 0, 1, -1}; //동 서 남 북
    static int[] dy = {1, -1, 0, 0}; //동 서 남 북

    static class Status {
        int x;
        int y;
        int crash;

        public Status(int x, int y, int crash) {
            this.x = x;
            this.y = y;
            this.crash = crash;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken()); //가로
        N = Integer.parseInt(st.nextToken()); //세로

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        bw.write(bfs() + "\n");
        bw.flush();
        bw.close();
    }

    static int bfs() {
        PriorityQueue<Status> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.crash, b.crash)
        );

        boolean[][] visited = new boolean[N][M];

        pq.offer(new Status(0, 0, 0));
        visited[0][0] = true;

        while (!pq.isEmpty()) {
            Status now = pq.poll();
            int x = now.x;
            int y = now.y;
            int crash = now.crash;

            if (x == N-1 && y == M-1){
                return crash;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (range(nx, ny)){
                    if (visited[nx][ny] == false){
                        visited[nx][ny] = true;

                        if (map[nx][ny] == '1'){
                            pq.offer(new Status(nx,ny,crash + 1));
                        }
                        else if (map[nx][ny] == '0'){
                            pq.offer(new Status(nx,ny,crash));
                        }
                    }
                }
            }
        }

        return -1;
    }

    static boolean range(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

}