package BFS;

import java.io.*;
import java.util.*;


public class Solution_20058 {
    static int N, Q;
    static int[] L;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북 x좌표
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북 y좌표
    static boolean[][] visited;
    static long maxIce = 0;
    static long maxLand = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //N
        Q = Integer.parseInt(st.nextToken()); //시전 횟수
        N = (int)Math.pow(2,N);

        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stD.nextToken());
            }
        }

        L = new int[Q];
        StringTokenizer stL = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < Q; i++) {
            L[i] = Integer.parseInt(stL.nextToken());
        }

        for (int i = 0; i < Q; i++) {
            map = divide(L[i]);
            map = melt();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxIce += map[i][j];
                if (map[i][j] != 0 && visited[i][j] == false){ //얼음 영역 이라면
                    bfs(i,j);
                }
            }
        }

        bw.write(maxIce + "\n");
        bw.write(maxLand + "\n");
        bw.flush();
        bw.close();
    }

    static int[][] divide(int l) { //구역을 나누기
        int[][] replaceArea = new int[N][N];
        int powL = (int) Math.pow(2, l); // 2^l 으로 제곱 연산

        for (int i = 0; i < N; i += powL) {
            for (int j = 0; j < N; j += powL) {
                rotateIce(i, j, powL, replaceArea);
            }
        }
        return replaceArea;
    }

    static void rotateIce(int x, int y, int powL, int[][] replaceArea) {
        for (int i = 0; i < powL; i++) {
            for (int j = 0; j < powL; j++) {
                replaceArea[j + x][powL - 1 - i + y] = map[x + i][y + j];
            }
        }
    }

    static int[][] melt() {
        int[][] replaceArea = new int[N][N];

        for (int i = 0; i < N; i++) {
            replaceArea[i] = Arrays.copyOf(map[i], N);
        }

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int cnt = 0;

                if (map[x][y] == 0) {
                    continue; //이미 얼음이 다녹은 칸
                }

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                        if (map[nx][ny] > 0) {
                            cnt++; //얼음이 주변에 있음
                        }
                    }
                }

                if (cnt < 3) {
                    replaceArea[x][y]--; //임시 배열 얼음 값 감소
                    //주변 3면 이상이 얼음 영역 아님
                }
            }
        }
        return replaceArea;

    }

    static void bfs(int x,int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y});

        visited[x][y] = true;
        long land = 1;

        while (!q.isEmpty()){
            int[] now = q.poll();

            for (int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    if (visited[nx][ny] == false && map[nx][ny] > 0){
                        land++;
                        visited[nx][ny] = true;
                        q.offer(new int[] {nx,ny});
                    }
                }
            }
        }
        maxLand = Math.max(land,maxLand);
    }

}