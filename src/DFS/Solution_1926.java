package DFS;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_1926 {
    static int N, M;
    static boolean visited[][];
    static int board[][];
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북 x좌표
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북 x좌표
    static int paint = 0;
    static int tempArea = 0;
    static int maxArea = 0;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로

        visited = new boolean[N][M];
        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(stD.nextToken());
            }
        }
        
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){
                if (visited[i][j] == false && board[i][j] == 1){
                    paint++;
                    tempArea = 0;
                    dfs(i,j);
                    maxArea = Math.max(tempArea,maxArea); //최대값 비교
                }
            }
        }

        bw.write(paint + "\n");
        bw.write(maxArea + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        tempArea++;

        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0<=nx && nx<N && 0<=ny && ny<M){
                if (visited[nx][ny] == false && board[nx][ny] == 1){
                    dfs(nx,ny);
                }
            }
        }

    }
}