package DFS;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_16174 {
    static int N;
    static int[] dx = {0,1}; //동 남 x좌표
    static int[] dy = {1,0}; //동 남 y좌표
    static int[][] field;
    static boolean visited[][];
    static boolean possible = false;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        field = new int[N][N];
        visited = new boolean[N][N];

        for (int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<N; j++){
               field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);

        if (possible){
            bw.write("HaruHaru\n");
        }
        else {
            bw.write("Hing\n");
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y) {
        if (field[x][y] == -1){
            possible = true;
            return;
        }

        visited[x][y] = true;

        for (int i=0; i<2; i++){
            int nx = x + (dx[i] * field[x][y]);
            int ny = y + (dy[i] * field[x][y]);

            if (0<=nx && nx <N && 0<=ny && ny<N){
                if (visited[nx][ny] == false){
                    dfs(nx,ny);
                }
            }
        }
    }
}