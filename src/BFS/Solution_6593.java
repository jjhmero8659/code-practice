package BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_6593 {
    static int L, R, C;
    static Point startPoint;
    static char[][][] map;
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북
    static int[] dz = {1,-1}; //위 아래
    static long depth = 0;

    static class Point {
        int z;
        int x;
        int y;
        int d;

        public Point(int z, int x, int y, int d) {
            this.z = z;
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            L = Integer.parseInt(st.nextToken()); //층 수 z축
            R = Integer.parseInt(st.nextToken()); //세로
            C = Integer.parseInt(st.nextToken()); //가로

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            map = new char[L][R][C];



            for (int z = 0; z < L; z++) {
                for (int r = 0; r < R; r++) {
                    String line = br.readLine();
                    for (int c = 0; c < C; c++) {
                        char data = line.charAt(c);

                        map[z][r][c] = data;
                        if (data == 'S') {
                            startPoint = new Point(z, r, c, 0);
                        }
                    }
                }
                br.readLine();
            }

            bw.write(bfs() ? "Escaped in " + depth + " minute(s).\n" : "Trapped!\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }


    static boolean bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(startPoint);

        boolean visited[][][] = new boolean[L][R][C];
        visited[startPoint.z][startPoint.x][startPoint.y] = true;
        
        while (!q.isEmpty()){
            Point now = q.poll();

            if (map[now.z][now.x][now.y] == 'E'){
                depth = now.d;
                return true;
            }

            //현재 층 수 에서 상 하 좌 우 이동
            for (int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (0<=nx && nx<R && 0<=ny && ny<C){
                    if (visited[now.z][nx][ny] == false && map[now.z][nx][ny] != '#'){
                        q.offer(new Point(now.z,nx,ny,now.d + 1)); //depth 1증가
                        visited[now.z][nx][ny] = true;
                    }
                }
            }
            
            //현재 위치 에서 층수만 이동
            for (int i=0; i<2; i++){
                int nz = now.z + dz[i];

                if (0<=nz && nz<L){
                    if (visited[nz][now.x][now.y] == false && map[nz][now.x][now.y] != '#'){
                        q.offer(new Point(nz,now.x,now.y,now.d + 1)); //depth 1증가
                        visited[nz][now.x][now.y] = true;
                    }
                }
            }
        }

        return false;
    }

}