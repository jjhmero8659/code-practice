package DFS;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_14502 {
    static int N, M;
    static int map[][];
    static boolean visited[][];
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북 x
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북 y
    static int maxSafeCnt = 0;

    static class Virus {
        int x;
        int y;

        Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로

        visited = new boolean[N][M];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(stD.nextToken());
            }
        }

        dfs(0);

        bw.write(maxSafeCnt + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int depth) {
        if (depth == 3) {
            bfs(); //벽이 완성 된 상태의 바이러스 안전지대 확인
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) { //벽을 세울 수 있는 빈 공간 이라면
                    map[i][j] = 1; //현재 위치에 벽을 세우고
                    dfs(depth + 1); //depth 1 추가 후 재귀
                    map[i][j] = 0; //현재 위치를 다시 빈공간으로 복귀
                    //이어서 반복분
                }
            }
        }
    }

    static void bfs() {
        int[][] virusMap = new int[N][M]; //virus Map
        //bfs 로 탐색하면서 내부 값을 변경 하기 때문에 임시 map 생성
        boolean[][] visited = new boolean[N][M]; //방문

        Queue<Virus> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) { //맵 복사
            for (int j = 0; j < M; j++) {
                virusMap[i][j] = map[i][j];
                if (map[i][j] == 2) { //virus 영역 이라면
                    q.offer(new Virus(i, j)); //큐에 추가
                    visited[i][j] = true;
                }
            }
        }

        //현재 까지 Queue 에 모든 virus 좌표 값이 저장 되어 있음

        while (!q.isEmpty()) {
            Virus virus = q.poll();
            int cx = virus.x; //현재 x좌표
            int cy = virus.y; //현재 y좌표

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i]; //next x
                int ny = cy + dy[i]; //next y

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (visited[nx][ny] == false && virusMap[nx][ny] == 0) { //방문하지 않은 상태 , 빈공간 이라면
                        visited[nx][ny] = true; //다음 영역 visited true
                        virusMap[nx][ny] = 2; //다음 영역을 virus로 변경
                        q.offer(new Virus(nx, ny));
                    }
                }
            }
        }

        //virus 전부 변환 후
        //안전 영역 숫자 check
        int safeCnt = checkSafeArea(virusMap);

        maxSafeCnt = Math.max(safeCnt, maxSafeCnt);
    }

    static int checkSafeArea(int[][] virusMap) {
        int safeCnt = 0;

        for (int i = 0; i < N; i++) { //맵 복사
            for (int j = 0; j < M; j++) {
                if (virusMap[i][j] == 0) {
                    safeCnt++;
                }
            }
        }

        return safeCnt;
    }

}