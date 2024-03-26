package BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_16948 {
    static int N, SX, SY, EX, EY;
    static boolean[][] visited;

    static int[] dx = {-2, -2, 0, 2, 2, 0}; // x
    static int[] dy = {-1, 1, 2, 1, -1, -2}; // y

    static class Point {
        int x;
        int y;
        int depth;
        public Point(int x, int y , int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        SX = Integer.parseInt(st.nextToken());
        SY = Integer.parseInt(st.nextToken());
        EX = Integer.parseInt(st.nextToken());
        EY = Integer.parseInt(st.nextToken());

        visited = new boolean[N][N];

        bw.write(bfs(SX,SY) + "\n");
        bw.flush();
        bw.close();
    }

    static long bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        int depth = 0; //시작 depth 는 0부터
        q.add(new Point(x,y,depth));
        visited[x][y] = true; //현재 위치 true

        while (!q.isEmpty()){
            Point pD = q.poll();
            int cx = pD.x;
            int cy = pD.y;
            int cD = pD.depth;

            if (cx == EX && cy == EY){
                return cD;
            }

            for (int i=0; i<6; i++){
                int nx = cx + dx[i]; //next x
                int ny = cy + dy[i]; //next y

                if (0<=nx && 0<=ny && nx<N && ny<N){ //보드 안에 있다면
                    if (visited[nx][ny] == false){
                        visited[nx][ny] = true; //다음 영역 visited
                        q.offer(new Point(nx,ny,cD+1)); //next Point Class Queue Offer
                    }
                }
            }
        }

        return -1;
    }

}