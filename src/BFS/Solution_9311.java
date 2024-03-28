package BFS;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_9311 {
    static int T,N,M;
    static char[][] maze;
    static boolean[][] visited;

    static int[] dx = {0,1,0,-1}; //동 남 서 북 x
    static int[] dy = {1,0,-1,0}; //동 남 서 북 y

    static class Area {
        int x;
        int y;
        int d;

        Area(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            maze = new char[N][M];
            visited = new boolean[N][M];

            int[] sp = new int[2];

            for (int i = 0; i < N; i++) {
                String line = br.readLine();
                for (int j = 0; j < M; j++) {
                    char data = line.charAt(j);
                    maze[i][j] = data;
                    if (data == 'S'){ //시작 지점 get
                        sp[0] = i;
                        sp[1] = j;
                    }
                }
            }

            int result = bfs(sp[0], sp[1]);

            if (result == -1){
                bw.write("No Exit\n");
            }
            else{
                bw.write("Shortest Path: " + result + "\n");
            }

        }

        bw.flush();
        bw.close();
    }

    static int bfs(int x, int y) {
        Queue<Area> q = new LinkedList<>();
        int depth = 0;

        q.offer(new Area(x, y, depth)); //시작 지점 삽입
        visited[x][y] = true; //시작 지점은 depth = 0

        while (!q.isEmpty()){
            Area a = q.poll();
            int cx = a.x;
            int cy = a.y;
            int cd = a.d;

            if (maze[cx][cy] == 'G'){ //목적지에 도착
                return cd;
            }

            for (int i=0; i<4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nd = cd + 1;

                if (0<=nx && 0<=ny && nx<N && ny<M){
                    if (visited[nx][ny] == false && maze[nx][ny] != 'X'){
                        visited[nx][ny] = true;
                        q.offer(new Area(nx,ny,nd));
                    }
                }
            }

        }


        return -1;
    }
}