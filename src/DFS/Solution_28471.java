package DFS;

import java.io.*;
import java.util.*;


public class Solution_28471 {
    static int N;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 1, 1, 0, -1, -1, -1}; //동 동남 남서 서 서북 북 북동  , 남 제외 , S키가 빠진 F
    static int[] dy = {1, 1, -1, -1, -1, 0, 1}; //동 동남 남서 서 서북 북 북동  , 남 제외
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 보드 가로 세로

        board = new char[N][N];
        visited = new boolean[N][N];
        int[] GOAL = new int[2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = line.charAt(j);
                board[i][j] = c;
                if (c == 'F') { //목표 지점
                    GOAL[0] = i;
                    GOAL[1] = j;
                }
            }
        }

        dfs(GOAL[0], GOAL[1]);

        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i=0; i<7; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0<=nx && nx <N && 0<=ny && ny<N){
                if (visited[nx][ny] == false && board[nx][ny] != '#'){
                    cnt++;
                    dfs(nx,ny);
                }
            }
        }
    }


}