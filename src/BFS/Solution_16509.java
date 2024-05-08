package BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_16509 {
    static int[] moveDx = {-2, -3, -3, -2, 2, 3, 3, 2}; //Sang 이동
    static int[] moveDy = {-3, -2, 2, 3, 3, 2, -2, -3}; //Sang 이동
    static boolean[][] visited;
    static Loc King, Sang;

    static class Loc {
        int x;
        int y;
        int moveCnt;

        public Loc(int x, int y, int moveCnt) {
            this.x = x;
            this.y = y;
            this.moveCnt = moveCnt;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        visited = new boolean[10][9];

        StringTokenizer stS = new StringTokenizer(br.readLine(), " ");
        int sX = Integer.parseInt(stS.nextToken());
        int sY = Integer.parseInt(stS.nextToken());

        Sang = new Loc(sX, sY, 0);

        StringTokenizer stK = new StringTokenizer(br.readLine(), " ");
        int kX = Integer.parseInt(stK.nextToken());
        int kY = Integer.parseInt(stK.nextToken());

        King = new Loc(kX, kY, 0);


        bw.write(bfs() + "\n");
        bw.flush();
        bw.close();
    }

    static int bfs() {
        Queue<Loc> q = new LinkedList<>();
        q.offer(Sang);
        visited[Sang.x][Sang.y] = true;

        while (!q.isEmpty()) {
            Loc poll = q.poll();

            if (poll.x == King.x && poll.y == King.y) {
                return poll.moveCnt;
            }

            for (int i = 0; i < 8; i++) {
                if (isPossible(i, poll.x, poll.y) == false) {
                    continue;
                }
                int nx = poll.x + moveDx[i];
                int ny = poll.y + moveDy[i];
                int nC = poll.moveCnt + 1;

                if (range(nx, ny)) {
                    if (visited[nx][ny] == false) {
                        visited[nx][ny] = true;
                        q.offer(new Loc(nx, ny, nC));
                    }
                }
            }
        }

        return -1;
    }

    static boolean isPossible(int i, int x, int y) {
        int nowX = x;
        int nowY = y;
        if (i == 0 || i == 7) {
            nowY -= 1;
            if (blocked(nowX, nowY)) {
                return false;
            }

            if (i == 0) {
                nowX -= 1;
                nowY -= 1;
                if (blocked(nowX, nowY)) {
                    return false;
                }

            } else {
                nowX += 1;
                nowY -= 1;
                if (blocked(nowX, nowY)) {
                    return false;
                }

            }
        } else if (i == 1 || i == 2) {
            nowX -= 1;
            if (blocked(nowX, nowY)) {
                return false;
            }

            if (i == 1) {
                nowX -= 1;
                nowY -= 1;
                if (blocked(nowX, nowY)) {
                    return false;
                }
            } else {
                nowX -= 1;
                nowY += 1;
                if (blocked(nowX, nowY)) {
                    return false;
                }
            }
        } else if (i == 3 || i == 4) {
            nowY += 1;
            if (blocked(nowX, nowY)) {
                return false;
            }
            if (i == 3) {
                nowX -= 1;
                nowY += 1;
                if (blocked(nowX, nowY)) {
                    return false;
                }
            } else {
                nowX += 1;
                nowY += 1;
                if (blocked(nowX, nowY)) {
                    return false;
                }
            }
        } else if (i == 5 || i == 6) {
            nowX += 1;
            if (i == 5) {
                nowX += 1;
                nowY += 1;
                if (blocked(nowX, nowY)) {
                    return false;
                }
            } else {
                nowX += 1;
                nowY -= 1;
                if (blocked(nowX, nowY)) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean blocked(int x, int y) {
        return x == King.x && y == King.y;
    }

    static boolean range(int x, int y) {
        return 0 <= x && x < 10 && 0 <= y && y < 9;
    }
}