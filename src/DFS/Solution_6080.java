package DFS;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_6080 {
    static int R, C;
    static int[][] farm; //농장
    static boolean[][] visited;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1}; //동 동남 남 남서 서 서북 북 북동 x
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1}; //동 동남 남 남서 서 서북 북 북동 y
    static int island = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stL = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(stL.nextToken());
        C = Integer.parseInt(stL.nextToken());

        farm = new int[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < C; j++) {
                farm[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visited[i][j] == false && farm[i][j] != 0) {
                    island++;
                    dfs(i, j);
                }
            }
        }


        bw.write(island + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y) {

        visited[x][y] = true;


        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < R && 0 <= ny && ny < C) {
                if (visited[nx][ny] == false && farm[nx][ny] != 0) {
                    //다음 영역이 방문하지 않았고 섬 영역이라면
                    //0은 질 좋은 잔디 영역임
                    dfs(nx, ny);
                }
            }
        }

    }


}