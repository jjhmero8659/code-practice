
package DFS;

import java.io.*;
import java.util.*;


public class Solution_14497 {
    static int N, M;
    static char map[][];
    static boolean[][] visited;
    static Loc junan;
    static Loc target;
    static int[] dx = {0, 0, 1, -1}; //동 서 남 북
    static int[] dy = {1, -1, 0, 0}; //동 서 남 북
    static boolean find = false;

    static class Loc {
        int x;
        int y;

        public Loc(int x, int y) {
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
        map = new char[N][M];

        StringTokenizer stP = new StringTokenizer(br.readLine(), " ");

        int jX = Integer.parseInt(stP.nextToken()) - 1;
        int jY = Integer.parseInt(stP.nextToken()) - 1;
        junan = new Loc(jX, jY);

        int tX = Integer.parseInt(stP.nextToken()) - 1;
        int tY = Integer.parseInt(stP.nextToken()) - 1;
        target = new Loc(tX, tY);

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int jumpCnt = 0;

        while (true) {
            jumpCnt++;

            jump();

            if (find == true) {
                bw.write(jumpCnt + "\n");
                break;
            }
        }

        bw.flush();
        bw.close();
    }

    static void jump() {
        visited = new boolean[N][M];
        Queue<Loc> q = new LinkedList<>();

        visited[junan.x][junan.y] = true;
        q.offer(junan);

        while (!q.isEmpty()) {
            Loc poll = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (range(nx, ny)) {
                    if (visited[nx][ny] == false) {
                        if (map[nx][ny] == '1') {
                            visited[nx][ny] = true;
                            map[nx][ny] = '0'; //쓰러뜨리기
                        } else if (map[nx][ny] == '0') {
                            visited[nx][ny] = true;
                            q.offer(new Loc(nx, ny));
                        } else if (map[nx][ny] == '#') {
                            find = true;
                        }
                    }
                }
            }
        }
    }

    static boolean range(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}