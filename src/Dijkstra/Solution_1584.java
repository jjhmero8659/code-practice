package Dijkstra;

import java.io.*;
import java.util.*;


public class Solution_1584 {
    static int N, M;
    static boolean[][] visited = new boolean[500][500];
    static char[][] map = new char[500][500];
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); //위험구역 개수

        for (int i=0; i<N; i++){
            StringTokenizer stP = new StringTokenizer(br.readLine()," ");

            int x1 = Integer.parseInt(stP.nextToken());
            int y1 = Integer.parseInt(stP.nextToken());

            int x2 = Integer.parseInt(stP.nextToken());
            int y2 = Integer.parseInt(stP.nextToken());

            int lx = Math.min(x1,x2);
            int hx = Math.max(x1,x2);

            int ly = Math.min(y1,y2);
            int hy = Math.max(y1,y2);

            for (int x = lx; x < hx; x++){
                for (int y = ly; y < hy; y++){

                }
            }
        }

        M = Integer.parseInt(br.readLine()); //죽음구역 개수

        

        bw.flush();
        bw.close();
    }

    static void dijkstra() {
        
    }

}