package DFS;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_4677 {
    static int N, M;
    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1}; //동 동남 남 남서 서 서북 북 북동 x
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1}; //동 동남 남 남서 서 서북 북 북동 y
    static char OIL = '@';
    static char[][] map;
    static boolean[][] visited;
    static int oilCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            StringTokenizer stL = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(stL.nextToken());
            M = Integer.parseInt(stL.nextToken());

            if (N == 0 && M == 0){
                break;
            }

            map = new char[N][M];
            visited = new boolean[N][M];
            oilCnt = 0;

            for (int i=0; i<N; i++){
                String line = br.readLine();
                for (int j=0; j<M; j++){
                    map[i][j] = line.charAt(j);
                }
            }

            for (int i=0; i<N; i++){
                for (int j=0; j<M; j++){
                    if (visited[i][j] == false && map[i][j] == OIL){
                        oilCnt++;
                        dfs(i,j);
                    }
                }
            }

            bw.write(oilCnt+"\n");
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i=0; i<8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0<=nx && nx<N && 0<=ny && ny<M){
                if (visited[nx][ny] == false && map[nx][ny] == OIL){
                    dfs(nx,ny);
                }
            }
        }
    }

}