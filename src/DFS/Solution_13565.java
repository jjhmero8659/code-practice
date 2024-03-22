package DFS;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_13565 {
    static int N, M;
    static boolean visited[][];
    static int board[][];
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북 x좌표
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북 x좌표
    static boolean possible = false;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로

        visited = new boolean[N][M];
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == '0'){
                    board[i][j] = 0;
                }
                else{
                    board[i][j] = 1;
                }
            }
        }

        for (int i=0; i<M; i++){
            if (visited[0][i] == false && board[0][i] == 0){
                dfs(0,i);
            }
        }

        if (possible){
            bw.write("YES\n");

        }
        else{
            bw.write("NO\n");
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        if (x == N-1){
            possible = true;
            return;
        }

        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0<=nx && nx<N && 0<=ny && ny<M){
                if (visited[nx][ny] == false && board[nx][ny] == 0){
                    dfs(nx,ny);
                }
            }
        }

    }
}