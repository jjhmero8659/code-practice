package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution_26170 {
    static int R, C;
    static int[][] board = new int[5][5]; //5x5 보드 판
    static boolean[][] visited = new boolean[5][5];

    static int targetCnt = 3;
    static long minDistance = Long.MAX_VALUE;
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북 x
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북 y


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 5; i++) {
            StringTokenizer stL = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(stL.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        R = Integer.parseInt(st.nextToken()); //x 좌표
        C = Integer.parseInt(st.nextToken()); //y 좌표

        dfs(R,C,0,0); //dfs 재귀

        if (minDistance == Long.MAX_VALUE){
            bw.write( "-1\n");
        }
        else{
            bw.write(minDistance + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y , int appleCnt, int d) {

        int currentApple = appleCnt;
        visited[x][y] = true;

        if (board[x][y] == 1){ //사과 영역
            currentApple++;
            if (currentApple == targetCnt){ //3개가 되었다면
                minDistance = Math.min(minDistance , d); //현재 까지의 거리와 비교하여 최소값 저장
            }
        }

        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (0<=nx && nx < 5 && 0<=ny && ny < 5){
                if (visited[nx][ny] == false && board[nx][ny] != -1){ //다음 영역이 방문하지 않았고 장애물이 아니라면
                    dfs(nx,ny,currentApple,d+1);
                    visited[nx][ny] = false;
                }
            }
        }

    }


}