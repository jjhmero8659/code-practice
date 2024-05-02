
package DFS;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Solution_16724 {
    static Integer N, M;
    static char[][] map;

    static int[] dx = {-1, 1, 0, 0}; // U D L R
    static int[] dy = {0, 0, -1, 1}; // U D L R
    static int[][] visited;
    static long safeCnt = 0;
    static int paint = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0) {
                    dfs(i, j);
                }
            }
        }

        bw.write(N == 1 && M == 1 ? "1\n" : safeCnt + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = paint;

        int nx = 0;
        int ny = 0;
        if (map[x][y] == 'U') {
            nx = x + dx[0];
            ny = y + dy[0];
        } else if (map[x][y] == 'D') {
            nx = x + dx[1];
            ny = y + dy[1];
        } else if (map[x][y] == 'L') {
            nx = x + dx[2];
            ny = y + dy[2];
        } else if (map[x][y] == 'R') {
            nx = x + dx[3];
            ny = y + dy[3];
        }

        if (0 <= nx && nx < N && 0 <= ny && ny < M) { //범위 내 이동
            if (visited[nx][ny] == 0) { //방문하지 않은 영역 이라면
                dfs(nx, ny);
            } else {
                if (visited[nx][ny] == paint){
                    safeCnt++;
                    map[x][y] = 'S';
                    paint++;
                }
                else {
                    paint++;
                }
            }
        }
    }
}