package BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_7569 {
    static int N, M, Z;
    static int[][][] box;
    static boolean[][][] visited;

    static int[] dx = {0, 1, 0, -1}; //동 남 서 북 x
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북 y
    static int[] dz = {1, -1}; //위 아래 z

    static Queue<Tomato> q = new LinkedList<>();

    static class Tomato {
        int x;
        int y;
        int z;

        Tomato(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stL = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(stL.nextToken()); // 가로
        N = Integer.parseInt(stL.nextToken()); // 세로
        Z = Integer.parseInt(stL.nextToken()); // 높이

        box = new int[Z][N][M];
        visited = new boolean[Z][N][M];

        for (int z = 0; z < Z; z++) { //높이 만큼
            for (int n = 0; n < N; n++) {
                StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
                for (int m = 0; m < M; m++) {
                    int stat = Integer.parseInt(stD.nextToken());
                    box[z][n][m] = stat;

                    if (stat == 1) {
                        q.offer(new Tomato(n, m, z)); //익은 토마토 queue 추가
                        visited[z][n][m] = true; //visited true
                    }

                }
            }
        }

        if (checkTomato() == true) {
            bw.write("0\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        int day = bfs();

        if (checkTomato() == false) {
            bw.write("-1\n");
        } else {
            bw.write(day + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }

    static boolean checkTomato() {
        for (int z = 0; z < Z; z++) { //높이 만큼
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box[z][n][m] == 0) { //덜읽었다면
                        return false;
                    }
                }
            }
        }

        return true;
    }

    static int bfs() {
        int day = -1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Tomato nowT = q.poll(); //poll tomato
                int cx = nowT.x;
                int cy = nowT.y;
                int cz = nowT.z;

                for (int j = 0; j < 4; j++) { //현재 박스의 동 남 서 북
                    int nx = cx + dx[j];
                    int ny = cy + dy[j];

                    if (0 <= nx && 0 <= ny && nx < N && ny < M) {
                        if (visited[cz][nx][ny] == false && box[cz][nx][ny] == 0) { //덜 읽은 토마토
                            visited[cz][nx][ny] = true;
                            box[cz][nx][ny] = 1;
                            q.offer(new Tomato(nx, ny, cz));
                        }
                    }
                }

                for (int j=0; j<2; j++){
                    int nz = cz + dz[j];
                    if (0 <= nz && nz < Z) {
                        if (visited[nz][cx][cy] == false && box[nz][cx][cy] == 0) { //덜 읽은 토마토
                            visited[nz][cx][cy] = true;
                            box[nz][cx][cy] = 1;
                            q.offer(new Tomato(cx, cy, nz));
                        }
                    }
                }
            }

            day++; //1일 증가
        }

        return day;
    }

}