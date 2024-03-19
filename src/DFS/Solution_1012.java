package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution_1012 {
    static int M,N,K,T;
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북 x좌표
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북 y좌표
    static int[][] field;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        T = Integer.parseInt(br.readLine()); //테스트 케이스 개수
        
        for (int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            M = Integer.parseInt(st.nextToken()); //가로 길이
            N = Integer.parseInt(st.nextToken()); //세로 길이
            K = Integer.parseInt(st.nextToken()); //배추 개수

            int warm = 0;

            field = new int[N][M];

            for (int j=0; j<K; j++){
                StringTokenizer stD = new StringTokenizer(br.readLine()," ");
                int x = Integer.parseInt(stD.nextToken());
                int y = Integer.parseInt(stD.nextToken());

                field[y][x] = 1;
            }
            
            for (int n=0; n<N; n++){
                for (int m=0; m<M; m++){
                    if (field[n][m] == 1){ //해당 자리가 배추 영역 이라면
                        warm++;
                        dfs(n,m);
                    }
                }
            }

            bw.write(warm + "\n");

        }

        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y){
        field[x][y] = -1; //배추 영역을 빈 땅으로 취급 , visited = true

        for (int i=0; i<4; i++){

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < N && 0 <=ny && ny < M){
                if (field[nx][ny] == 1){
                    dfs(nx,ny);
                }
            }
        }
    }


}