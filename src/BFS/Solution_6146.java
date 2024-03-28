package BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_6146 {
    static int N, X, Y;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북 x
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북 y
    private static final int SIZE = 500;
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

        Y = Integer.parseInt(st.nextToken()) + SIZE; //Y
        X = Integer.parseInt(st.nextToken()) + SIZE; //X
        N = Integer.parseInt(st.nextToken()); //웅덩이 개수

        map = new int[SIZE * 2 + 1][SIZE * 2 + 1];
        visited = new boolean[SIZE * 2 + 1][SIZE * 2 + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
            int wy = Integer.parseInt(stD.nextToken()) + SIZE;
            int wx = Integer.parseInt(stD.nextToken()) + SIZE;

            map[wx][wy] = -1;
        }

        bw.write(bfs() + "\n");

        bw.flush();
        bw.close();
    }

    static int bfs() {
        Queue<Info> q = new LinkedList<>();
        q.offer(new Info(SIZE, SIZE, 0)); //시작 (0,0) depth 0
        visited[SIZE][SIZE] = true;

        while (!q.isEmpty()) {

            Info pI = q.poll();
            int cx = pI.x; // x
            int cy = pI.y; // y
            int cd = pI.d;

            if (cx == X && cy == Y) {
                return cd;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nd = cd + 1;

                if (0 <= nx && 0 <= ny && nx <= (SIZE*2) && ny <= (SIZE*2)) {
                    if (visited[nx][ny] == false && map[nx][ny] != -1){
                        q.offer(new Info(nx,ny,nd));
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return -1;
    }

}