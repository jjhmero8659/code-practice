package BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_1245 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int minHeight = Integer.MAX_VALUE;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1}; //동 동남 남 남서 서 서북 북 북동 x
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1}; //동 동남 남 남서 서 서북 북 북동 y
    static int peakCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stL = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stL.nextToken()); // 세로
        M = Integer.parseInt(stL.nextToken()); // 가로

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stD.nextToken());
                minHeight = Math.min(minHeight,map[i][j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == false) {
                    bfs(i, j);
                }
            }
        }

        bw.write(peakCnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int x, int y) {
        int startHeight = map[x][y];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        boolean isPeak = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (possibleArea(nx,ny)){
                    if (map[nx][ny] == startHeight && visited[nx][ny] == false){
                        visited[nx][ny] = true;
                        q.offer(new int[] {nx,ny});
                    }
                    else if(map[nx][ny] > startHeight){
                        isPeak = false;
                    }
                }
            }
        }

        if (isPeak == true && startHeight > minHeight){
            peakCnt++;
        }
    }

    static boolean possibleArea(int nx, int ny) {
        return 0 <= nx && nx < N && 0 <= ny && ny < M;
    }
}