package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Solution_2583 {
    static int N,M,K;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북 x좌표
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북 y좌표
    static int count;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        N = Integer.parseInt(st.nextToken()); //map 세로 길이
        M = Integer.parseInt(st.nextToken()); //map 가로 길이
        K = Integer.parseInt(st.nextToken()); //분리 영역 좌표 개수

        map = new int[N][M];


        for (int i=1; i<=K; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine() , " ");
            int x1 = Integer.parseInt(stD.nextToken());
            int y1 = Integer.parseInt(stD.nextToken());
            int x2 = Integer.parseInt(stD.nextToken());
            int y2 = Integer.parseInt(stD.nextToken());

            for (int j=x1; j<x2;j++){
                for (int p = y1; p<y2; p++){
                    map[p][j] = 1;
                }
            }
        }

        ArrayList<Integer> areaCount = new ArrayList<>();
        for (int i=0; i<N; i++){
            for (int j=0; j<M; j++){ //2차원 map 전체 탐색 하면서 빈공간 있는지 확인
                if (map[i][j] == 0){
                    count = 0;
                    dfs(i,j);
                    areaCount.add(count);
                }
            }
        }

        Collections.sort(areaCount);
        bw.write(areaCount.size() + "\n");
        for (int result : areaCount){
            bw.write(result + " ");
        }
 
        bw.flush();
        bw.close();
    }
    
    static void dfs(int x , int y){
        map[x][y] = 1; //현재 자리를 벽으로
        count++; //개수 증가

        for (int i=0; i<4; i++){

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < N && ny < M && 0 <= ny){
                if (map[nx][ny] == 0){
                    dfs(nx,ny);
                }
            }
        }
    }
}