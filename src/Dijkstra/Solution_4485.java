package Dijkstra;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_4485 {
    static int N;
    static int[][] map;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] dx = {0, 0, 1, -1}; //동 서 남 북
    static int[] dy = {1, -1, 0, 0}; //동 서 남 북
    static final int INF = 987654321;

    static class Node {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        int roop = 1;
        while (true) {
            N = Integer.parseInt(br.readLine());

            if (N == 0) break;

            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            bw.write("Problem " + roop + ": " + dijkstra() + "\n");

            roop++;
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.cost, b.cost)
        );

        int[][] move = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(move[i], INF);
        }

        pq.offer(new Node(0, 0, map[0][0]));
        move[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            if (now.x == N - 1 && now.y == N - 1) {
                return now.cost;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (range(nx, ny)) {
                    if (move[nx][ny] > move[now.x][now.y] + map[nx][ny]){
                        move[nx][ny] = move[now.x][now.y] + map[nx][ny];
                        pq.offer(new Node(nx,ny,move[nx][ny]));
                    }
                }
            }
        }

        return -1;
    }

    static boolean range(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < N;
    }

}