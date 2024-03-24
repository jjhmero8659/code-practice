package DFS;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_27737 {
    static int N, M, K,initM;
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북 x좌표
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북 y좌표
    static int[][] map;
    static int POSSIBLE = 0;
    static boolean[][] visited;
    static int stack = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stL = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stL.nextToken()); // N x N 영역
        M = Integer.parseInt(stL.nextToken()); // 포자 개수
        K = Integer.parseInt(stL.nextToken()); // 포자 당 버섯 개수
        initM = M;

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stD.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == false && map[i][j] == POSSIBLE) {
                    stack = 0;
                    dfs(i, j);
                }
            }
        }

        if (M >= 0 && M != initM){
            bw.write("POSSIBLE\n");
            bw.write(M +"\n");
        }else{
            bw.write("IMPOSSIBLE\n");
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        stack++;

        if (1 == K){
            M--;
        }
        else if (stack == 1){
            M--;
        }
        else if (stack == K){
            stack = 0;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                if (visited[nx][ny] == false && map[nx][ny] == POSSIBLE) {
                    dfs(nx, ny);
                }
            }
        }
    }

}