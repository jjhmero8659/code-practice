package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_1743 {
    static int N, M, K;
    static char[][] costco;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북
    static int maxD = 0;
    static int tempD = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        costco = new char[N][M];
        visited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                costco[i][j] = '.';
            }
        }

        for (int i = 0; i < K; i++) {
            StringTokenizer stL = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(stL.nextToken()) - 1; //문제 좌표 값은 1부터 시작
            int y = Integer.parseInt(stL.nextToken()) - 1; //0부터 시작하기 위함

            costco[x][y] = '#';
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == false && costco[i][j] == '#'){
                    //방문하지 않은 상태 이면서 음식물 영역 이라면
                    tempD = 0;
                    dfs(i,j); //거리 증가 후 재귀
                }
            }
        }

        bw.write(maxD + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true; //현재 위치 true
        tempD++;
        maxD = Math.max(tempD,maxD); //비교 후 큰값


        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0<=nx && 0<=ny && nx<N && ny<M){
                if (visited[nx][ny] == false && costco[nx][ny] == '#'){
                    //방문하지 않은 상태 이면서 음식물 영역 이라면
                    dfs(nx,ny); //거리 증가 후 재귀
                }
            }
        }
    }

}