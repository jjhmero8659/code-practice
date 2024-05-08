package BFS;

import java.io.*;
import java.util.*;


public class Solution_16469 {
    static int N, M;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1}; //동 서 남 북
    static int[] dy = {1, -1, 0, 0}; //동 서 남 북
    static long minTime = Integer.MAX_VALUE;
    static int[][][] visited;
    static ArrayList<Integer> area = new ArrayList<>();

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

        StringTokenizer stM = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stM.nextToken());
        M = Integer.parseInt(stM.nextToken());

        map = new int[N][M];
        visited = new int[3][N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    visited[i][j][k] = -1;
                }
            }
        }


        for (int i = 0; i < 3; i++) {
            StringTokenizer stN = new StringTokenizer(br.readLine(), " ");
            Loc villain = new Loc(
                    Integer.parseInt(stN.nextToken()) - 1,
                    Integer.parseInt(stN.nextToken()) - 1,
                    0
            );

            bfs(villain, i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[0][i][j] >= 0 && visited[1][i][j] >= 0 && visited[2][i][j] >= 0){
                    int filter = Math.max(visited[0][i][j], visited[1][i][j]);
                    filter = Math.max(filter, visited[2][i][j]);

                    minTime = Math.min(filter,minTime);

                    area.add(filter);
                }
            }
        }

        long areaCnt = 0;

        for (int num : area){
            if (num == minTime){
                areaCnt++;
            }
        }

        if (minTime == Integer.MAX_VALUE){
            bw.write("-1\n");
        }
        else{
            bw.write(minTime + "\n");
            bw.write(areaCnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }


    static void bfs(Loc villain, int num) {
        Queue<Loc> q = new LinkedList<>();
        q.offer(villain);

        visited[num][villain.x][villain.y] = 0;

        while (!q.isEmpty()) {
            Loc poll = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];

                if (isRange(nx, ny)) {
                    if (map[nx][ny] == 0 && visited[num][nx][ny] == -1) {
                        visited[num][nx][ny] = poll.moveCnt + 1;
                        q.offer(new Loc(nx, ny, poll.moveCnt + 1));
                    }
                }
            }
        }
    }

    static boolean isRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

}