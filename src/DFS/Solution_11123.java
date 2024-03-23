package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution_11123 {
    static int H,W,T;
    static char[][] greed;
    static boolean[][] visited;
    static int count = 0;
    static int[] dx = {0,1,0,-1}; //동 남 서 북 x좌표
    static int[] dy = {1,0,-1,0}; //동 남 서 북 y좌표

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++){
            StringTokenizer stF = new StringTokenizer(br.readLine()," ");

            H = Integer.parseInt(stF.nextToken()); //greed 세로
            W = Integer.parseInt(stF.nextToken()); //greed 가로

            count = 0;
            greed = new char[H][W];
            visited = new boolean[H][W];
            
            for (int h=0; h<H; h++){ //greed 초기화
                String line = br.readLine();
                for (int w=0; w<W; w++){
                    greed[h][w] = line.charAt(w);
                }
            }

            for (int h=0; h<H; h++){ //greed 초기화
                for (int w=0; w<W; w++){
                    if (visited[h][w] == false && greed[h][w] == '#'){
                        count++;
                        dfs(h,w);
                    }
                }
            }

            bw.write(count + "\n");
        }


        bw.flush();
        bw.close();
    }

    static void dfs(int x , int y){ // x, y
        visited[x][y] = true;

        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0<=nx && nx<H && 0<=ny && ny<W){
                if (visited[nx][ny] == false && greed[nx][ny] == '#'){ //방문 하지 않은 상태 이면서 양
                    dfs(nx,ny);
                }
            }
        }
    }


}