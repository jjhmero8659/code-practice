package BFS;

import java.io.*;
import java.util.*;


public class Solution_1941 {
    static final int SIZE = 5;
    static char[][] map;
    static boolean[][] visited;
    static boolean[][] bfsVisited;
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북
    static long result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new char[SIZE][SIZE];
        visited = new boolean[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            String line = br.readLine();
            map[i] = line.toCharArray();
        }

        getPrincess(0, 0,0);

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    static void getPrincess(int num, int pY, int start) {
        if (pY >= 4) { //임도연 파가 4명 이상이면 return
            return;
        }

        if (num == 7) { //이다솜 파가 4명 이상인 상태
            checkLinked(start - 1);
        } else {
            for (int i = start; i < (SIZE * SIZE); i++) {
                visited[i / SIZE][i % SIZE] = true;
                getPrincess(num + 1, map[i / SIZE][i % SIZE] == 'Y' ? pY + 1 : pY, i+1);
                visited[i / SIZE][i % SIZE] = false;
            }
        }
    }

    static void checkLinked(int start) {
        bfsVisited = new boolean[SIZE][SIZE];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start / SIZE, start % SIZE});

        bfsVisited[start / SIZE][start % SIZE] = true;
        int cnt = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                int[] poll = q.poll();
                int x = poll[0];
                int y = poll[1];

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (0 <= nx && nx < SIZE && 0 <= ny && ny < SIZE) {
                        if (visited[nx][ny] == true && bfsVisited[nx][ny] == false){
                            q.offer(new int[] {nx,ny});
                            cnt++;
                            bfsVisited[nx][ny] = true;
                        }
                    }
                }

            }
        }

        if (cnt == 7){
            result++;
        }
    }
}