package BFS;

import java.io.*;
import java.util.*;


public class Solution_18404 {
    static int N, M;
    static int[] KNIGHT = new int[2];
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2}; // x
    static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1}; // y


    static class Info {
        int x;
        int y;
        int d;

        Info(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); //세로 가로 길이
        M = Integer.parseInt(st.nextToken()); //Enemy Num

        board = new int[N][N]; // 0 ~ N-1까지 가로 세로
        visited = new boolean[N][N]; // 0 ~ N-1까지 가로 세로

        StringTokenizer stK = new StringTokenizer(br.readLine(), " ");
        KNIGHT[0] = Integer.parseInt(stK.nextToken()) - 1; //Knight X
        KNIGHT[1] = Integer.parseInt(stK.nextToken()) - 1; //Knight Y

        Queue<int[]> enemy = new LinkedList<>();

        for (int i = 1; i <= M; i++) {
            StringTokenizer stE = new StringTokenizer(br.readLine(), " ");
            int ex = Integer.parseInt(stE.nextToken()) - 1;
            int ey = Integer.parseInt(stE.nextToken()) - 1;

            enemy.offer(new int[]{ex, ey});
        }

        bfs();

        for (int[] p : enemy) {
            bw.write(board[p[0]][p[1]] + " ");
        }
        bw.flush();
        bw.close();
    }

    static void bfs() {
        Queue<Info> q = new LinkedList<>();
        int kx = KNIGHT[0];
        int ky = KNIGHT[1];
        q.add(new Info(kx, ky, 0)); //시작 지점은 knight 영역
        visited[kx][ky] = true;
        board[kx][ky] = 0;

        while (!q.isEmpty()) {
            Info pi = q.poll();
            int cx = pi.x;
            int cy = pi.y;
            int cd = pi.d;

            for (int i = 0; i < 8; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nd = cd + 1;

                if (0 <= nx && 0 <= ny && nx < N && ny < N) {
                    if (visited[nx][ny] == false) {
                        visited[nx][ny] = true;
                        board[nx][ny] = nd;
                        q.offer(new Info(nx, ny, nd));
                    }
                }
            }
        }
    }

}