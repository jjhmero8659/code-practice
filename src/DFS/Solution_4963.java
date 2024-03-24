package DFS;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_4963 {
    static int W, H;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1}; //동 동남 남 남서 서 서북 북 북동 x
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1}; //동 동남 남 남서 서 서북 북 북동 y
    static int ISLAND = 1;
    static int[][] map;
    static boolean[][] visited;
    static int islandCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer stL = new StringTokenizer(br.readLine(), " ");

            W = Integer.parseInt(stL.nextToken());
            H = Integer.parseInt(stL.nextToken());

            if (W == 0 && H == 0){
                break;
            }

            map = new int[H][W];
            visited = new boolean[H][W];
            islandCnt = 0;

            for (int i=0; i<H; i++){
                StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
                for (int j=0; j<W; j++){
                    map[i][j] = Integer.parseInt(stD.nextToken());
                }
            }

            for (int i=0; i<H; i++){
                for (int j=0; j<W; j++){
                    if (visited[i][j] == false && map[i][j] == ISLAND){
                        islandCnt++;
                        dfs(i,j);
                    }
                }
            }

            bw.write(islandCnt+"\n");
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i=0; i<8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0<=nx && nx<H && 0<=ny && ny<W){
                if (visited[nx][ny] == false && map[nx][ny] == ISLAND){
                    dfs(nx,ny);
                }
            }
        }
    }

}