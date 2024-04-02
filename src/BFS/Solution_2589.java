package BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_2589 {
    static int N, M;
    static char[][] map;
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북
    static int maxDistance = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    //방문하지 않은 상태 이면서 육지 라면
                    bfs(i, j);
                }
            }
        }

        bw.write(maxDistance + "\n");

        bw.flush();
        bw.close();
        br.close();
    }


    

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        int depth = -1;
        visited[x][y] = true;
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int size = q.size();

            for (int j=0; j<size; j++){
                int[] poll = q.poll();
                int cx = poll[0];
                int cy = poll[1];

                for (int i = 0; i < 4; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                        if (visited[nx][ny] == false && map[nx][ny] == 'L'){
                            q.offer(new int[] {nx,ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }

            depth++;
        }

        maxDistance = Math.max(maxDistance , depth);
    }

}