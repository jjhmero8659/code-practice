package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_3187 {
    static int R, C;
    static char[][] farm;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1}; //동남서북 x
    static int[] dy = {1, 0, -1, 0}; //동남서북 y
    static long rSheep = 0;
    static long rWolf = 0;
    static long tSheep = 0;
    static long tWolf = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        farm = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                farm[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (visited[i][j] == false && farm[i][j] != '#') { //울타리가 아니고 방문하지 않았다면
                    tSheep = 0; //임시 양 초기화
                    tWolf = 0; //임시 늑대 초기화

                    dfs(i, j);

                    if (tSheep > tWolf) { //양의 수가 많다면
                        rSheep += tSheep;
                    } else {
                        rWolf += tWolf;
                    }
                }
            }
        }

        bw.write(rSheep + " " + rWolf + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        if (farm[x][y] == 'v'){ //늑대
            tWolf++;
        }
        else if (farm[x][y] == 'k'){ //양
            tSheep++;
        }

        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0<=nx && 0<= ny && nx<R && ny<C){
                if (visited[nx][ny] == false && farm[nx][ny] != '#'){
                    dfs(nx,ny);
                }
            }
        }
    }

}