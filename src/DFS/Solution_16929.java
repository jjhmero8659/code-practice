package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution_16929 {
    static int N, M;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북
    static boolean possible = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //세로 크기
        M = Integer.parseInt(st.nextToken()); //가로 크기

        board = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            board[i] = line.toCharArray();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] != true) {
                    dfs(i, j, board[i][j], new int[]{0, 0, 0, 0});
                }
            }
        }

        bw.write(possible ? "Yes\n" : "No\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y, char color, int direct[]) {
        visited[x][y] = true; //방문 기록 true

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int[] nextDirect = direct.clone();
            nextDirect[i]++;

            if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                if (board[nx][ny] == color) { //색깔이 같아야 이동 가능
                    if (visited[nx][ny] == true){ // 4방향 전부 돌았는지 확인

                        boolean status = true;
                        for (int dir : nextDirect){
                            if (dir == 0){
                                status = false;
                                break;
                            }
                        }
                        if (status){
                            possible = true;
                        }
                    }
                    else{
                        dfs(nx,ny,color,nextDirect);
                    }
                }
            }

        }
    }
}