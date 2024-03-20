package DFS;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_16173 {
    static int N;
    static int[] dx = {0,1}; //동 남
    static int[] dy = {1,0}; //동 남
    static int[][] map;
    static boolean possible = false;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); //세로 , 가로 길이

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i=0; i<N; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");
            for (int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(stD.nextToken());
            }
        }

        dfs(0,0);

        if (possible){
            bw.write("HaruHaru\n");
        }
        else{
            bw.write("Hing\n");
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int x , int y){
        if (map[x][y] == -1){
            possible = true;
            return;
        }


        int nextJump = map[x][y];

        for (int i=0; i<2; i++){
            int nx = x + (dx[i] * nextJump);
            int ny = y + (dy[i] * nextJump);

            if (0<=nx && nx<N && 0<=ny && ny<N && !visited[nx][ny]){
                visited[nx][ny] = true;
                dfs(nx,ny);
            }
        }
    }

}