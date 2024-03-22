package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Solution_3184 {
    static int N, M;
    static boolean visited[][];
    static char map[][];
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북 x좌표
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북 x좌표

    static int totalSheep = 0;
    static int totalWolf = 0;
    static int tempSheep = 0;
    static int tempWolf = 0;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로

        visited = new boolean[N][M];
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != '#' && (visited[i][j] == false)) { //해당 영역이 울타리가 아니라면
                    tempSheep = 0;
                    tempWolf = 0;
                    dfs(i, j);

                    if (tempSheep > tempWolf) { //탐색 구역의 양의 수가 늑대보다 많다면
                        totalSheep += tempSheep;
                    } else {
                        totalWolf += tempWolf;
                    }
                }
            }
        }

        bw.write(totalSheep + " " + totalWolf + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y) {

        if (map[x][y] == '.') {
        } else if (map[x][y] == 'o') { //현재 영역 = 양
            tempSheep++;
        } else if (map[x][y] == 'v') { //현재 영역 = 늑대
            tempWolf++;
        }
        visited[x][y] = true; //현재 영역 방문

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                if (
                        (visited[nx][ny] == false)
                                &&
                                (map[nx][ny] != '#')
                ) {
                    dfs(nx, ny);
                }
            }
        }

    }
}