package DFS;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_1303 {
    static int M, N;
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북 x좌표
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북 y좌표
    static char[][] field;
    static boolean visited[][];
    static int tempCnt = 0;
    static int whiteCnt = 0;
    static int blueCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        field = new char[N][M];
        visited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                field[i][j] = line.charAt(j);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == false) { //방문 하지 않은 상태
                    if (field[i][j] == 'W') { //백군
                        tempCnt = 0;
                        dfs(i, j,'W');
                        whiteCnt += (tempCnt * tempCnt);
                    } else if (field[i][j] == 'B') { //청군
                        tempCnt = 0;
                        dfs(i, j,'B');
                        blueCnt += (tempCnt * tempCnt);
                    }
                }
            }
        }

        bw.write(whiteCnt + " " + blueCnt + "\n");

        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y, int team) {

        if (field[x][y] != team){
            return;
        }

        tempCnt++;

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) { //동 남 서 북 반복
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < N && 0 <= ny && ny < M) { //field 영역 안에서 이동 여부 확인
                if (visited[nx][ny] == false) { //다음 이동 공간이 방문하지 않은 상태라면
                    dfs(nx, ny,team);
                }
            }
        }

    }
}