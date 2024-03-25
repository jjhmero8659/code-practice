package BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_7562 {
    static long T, N, SX, SY, EX, EY;
    static long[][] board;
    static boolean[][] visited;

    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1}; // x
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2}; // y

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stL = new StringTokenizer(br.readLine(), " ");

        T = Long.parseLong(stL.nextToken()); // 테스트 케이스

        for (int i = 0; i < T; i++) {
            N = Long.parseLong(br.readLine());
            board = new long[(int) N][(int) N];
            visited = new boolean[(int) N][(int) N];


            StringTokenizer stS = new StringTokenizer(br.readLine(), " ");

            SX = Long.parseLong(stS.nextToken());
            SY = Long.parseLong(stS.nextToken());

            StringTokenizer stE = new StringTokenizer(br.readLine(), " ");

            EX = Long.parseLong(stE.nextToken());
            EY = Long.parseLong(stE.nextToken());


            bfs(SX, SY);

            bw.write(board[(int) EX][(int) EY] + "\n");
        }


        bw.flush();
        bw.close();
    }

    static void bfs(long x, long y) {
        Queue<Long[]> queue = new LinkedList<>();
        queue.offer(new Long[]{x, y});
        board[(int) x][(int) y] = 0;
        visited[(int) x][(int) y] = true;


        while (!queue.isEmpty()) { //큐 전체가 빈다면 break
            Long[] pollData = queue.poll(); //현재 위치, x,y 좌표값을 보유
            long cx = pollData[0];
            long cy = pollData[1];
            if (cx == EX && cy == EY) {
                return;
            }

            for (int i = 0; i < 8; i++) {
                long nx = cx + dx[i];
                long ny = cy + dy[i];

                if (0 <= nx && 0 <= ny && nx < N && ny < N) {
                    if (visited[(int) nx][(int) ny] == false) {
                        board[(int) nx][(int) ny] = board[(int) cx][(int) cy] + 1;
                        visited[(int) nx][(int) ny] = true;
                        queue.offer(new Long[]{nx, ny});
                    }
                }
            }
        }
    }

}