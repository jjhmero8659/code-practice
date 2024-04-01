package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_10026 {
    static int N;
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북 x좌표
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북 y좌표
    static char[][] paint;
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        paint = new char[N][N];
        visited = new boolean[N][N];


        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                paint[i][j] = line.charAt(j);
            }
        }

        int nArea = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == false) { //방문 상태가 false라면
                    char c = paint[i][j];
                    nArea++;
                    dfs(i, j, c);
                }
            }
        }

        for (int i = 0; i < N; i++) { //방문 배열 초기화
            Arrays.fill(visited[i], false);
        }

        int bArea = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == false) { //방문 상태가 false
                    char c = paint[i][j];

                    bArea++;
                    if (c == 'G' || c == 'R') {
                        redGreenDfs(i, j);
                    } else {
                        dfs(i, j, c);
                    }
                }
            }
        }

        bw.write(nArea + " " + bArea + "\n");
        bw.flush();
        bw.close();
    }

    static void redGreenDfs(int x, int y) {
        visited[x][y] = true; //방문 true

        for (int i = 0; i < 4; i++) { //동 남 서 북 반복
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < N && 0 <= ny && ny < N) { //영역 안에서 이동 여부 확인
                if (visited[nx][ny] == false && (paint[nx][ny] == 'R' || paint[nx][ny] == 'G')) {
                    //다음 이동 공간이 방문하지 않은 상태
                    //R 과 G는 동일하게 취급
                    redGreenDfs(nx, ny);
                }
            }
        }
    }

    static void dfs(int x, int y, char targetC) {
        visited[x][y] = true; //방문 true

        for (int i = 0; i < 4; i++) { //동 남 서 북 반복
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < N && 0 <= ny && ny < N) { //영역 안에서 이동 여부 확인
                if (visited[nx][ny] == false && paint[nx][ny] == targetC) { //다음 이동 공간이 방문하지 않은 상태라면
                    dfs(nx, ny, targetC);
                }
            }
        }
    }
}