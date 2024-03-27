package BFS;

import java.io.*;
import java.util.*;


public class Solution_25416 {
    static int R,C;
    static int[][] board = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    static int[] dx = {0,1,0,-1}; //동 남 서 북 x
    static int[] dy = {1,0,-1,0}; //동 남 서 북 y

    static class Info{
        int x;
        int y;
        int d;
        Info(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i=0; i<5; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=0; j<5; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringTokenizer stP = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(stP.nextToken());
        C = Integer.parseInt(stP.nextToken());

        bw.write(bfs() + "\n");

        bw.flush();
        bw.close();
    }

    static int bfs() {
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(R,C,0)); //시작 정점 , depth = 0 시작
        visited[R][C] = false;

        while (!q.isEmpty()){
            Info pD = q.poll();
            int cx = pD.x; //x좌표
            int cy = pD.y; //y좌표
            int cd = pD.d; //depth

            if (board[cx][cy] == 1){
                return cd;
            }

            for (int i=0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nd = cd + 1;

                if (0<=nx && nx<5 && 0<=ny && ny<5){
                    if (visited[nx][ny] == false && board[nx][ny] != -1){
                        q.offer(new Info(nx,ny,nd));
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return -1;
    }

}