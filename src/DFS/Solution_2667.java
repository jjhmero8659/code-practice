package DFS;

import java.io.*;
import java.util.*;


public class Solution_2667 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static ArrayList<Integer> depth;
    static int depthLen = 0;
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); //가로 세로 길이
        map = new int[N][N];
        visited = new boolean[N][N];
        depth = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (visited[i][j] == false && map[i][j] == 1) {
                    depthLen = 0;
                    dfs(i, j);
                    depth.add(depthLen);
                }
            }
        }

        Collections.sort(depth); //오름 차순 정렬

        bw.write(depth.size()+"\n");

        for (int n : depth) {
            bw.write(n + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true; //현재 영역 방문
        depthLen++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && nx < N && 0 <= ny && ny < N) {
                if (visited[nx][ny] == false && map[nx][ny] == 1){
                    dfs(nx,ny);
                }
            }
        }
    }


}