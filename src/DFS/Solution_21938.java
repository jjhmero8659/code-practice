
package DFS;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Solution_21938 {
    static int N, M, T;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북 x좌표
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북 y좌표
    static int cnt = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int sum = 0;
                for (int f = 0; f < 3; f++) {
                    sum += Integer.parseInt(stD.nextToken());
                }
                map[i][j] = sum / 3;
            }
        }

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] >= T) {
                    map[i][j] = 255;
                } else {
                    map[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == false && map[i][j] == 255) {
                    cnt++;
                    dfs(i, j);
                }
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0<=nx && nx<N && 0<=ny && ny<M){
                if (visited[nx][ny] == false && map[nx][ny] == 255) {
                    visited[nx][ny] = true;
                    dfs(nx, ny);
                }
            }
        }

    }


}