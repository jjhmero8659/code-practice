package DFS;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_14716 {
    static int M, N;
    static int[] dx = {0,1,1,1,0,-1,-1,-1}; //동 동남 남 남서 서 서북 북 북동 x좌표
    static int[] dy = {1,1,0,-1,-1,-1,0,1}; //동 동남 남 남서 서 서북 북 북동 y좌표
    static int[][] banner;
    static boolean visited[][];
    static int charNum = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        banner = new int[N][M];
        visited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                banner[i][j] = Integer.parseInt(stD.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == false) { //방문 하지 않은 상태
                    if (banner[i][j] == 1) { //글자
                        charNum++;
                        dfs(i, j);
                    }
                }
            }
        }

        bw.write(charNum + "\n");

        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y) {

        visited[x][y] = true;

        for (int i = 0; i < 8; i++) { //동 동남 남 남서 서 서북 북 북동 반복
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < N && 0 <= ny && ny < M) { //영역 안에서 이동 여부 확인
                if (visited[nx][ny] == false && banner[nx][ny] == 1) { //다음 이동 공간이 방문하지 않은 상태라면
                    dfs(nx, ny);
                }
            }
        }

    }
}