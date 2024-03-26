package BFS;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_17086 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1}; //동 남동 남 남서 서 서북 북 북동 x
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1}; //동 남동 남 남서 서 서북 북 북동 y
    static int maxD = 0;

    static class Area {
        int x;
        int y;
        int d;

        Area(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stD.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) { //상어가 없는 공간에서 상어 까지
                    for (int c=0; c<N; c++){ //방문 배열 초기화
                        Arrays.fill(visited[c],false);
                    }
                    bfs(i, j);
                }
            }
        }

        bw.write(maxD + "\n");
        bw.flush();
        bw.close();
    }

    static void bfs(int x, int y) {
        Queue<Area> q = new LinkedList<>();
        int depth = 0;

        q.offer(new Area(x, y, depth)); //시작 지점 삽입
        visited[x][y] = true; //시작 지점은 depth = 0

        while (!q.isEmpty()) {
            Area pA = q.poll();
            int cx = pA.x;
            int cy = pA.y;
            int cd = pA.d;

            if (map[cx][cy] == 1) {
                //현재 영역이 1이라면 인접 아기 상어
                maxD = Math.max(maxD, cd);
                break;
            }

            for (int i = 0; i < 8; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nd = cd + 1;
                if (0 <= nx && 0 <= ny && nx < N && ny < M) {
                    if (visited[nx][ny] == false) { // 방문하지 않은 영역
                        visited[nx][ny] = true;
                        q.offer(new Area(nx, ny, nd));
                    }
                }
            }

        }
    }
}