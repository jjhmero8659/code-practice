package BFS;

import java.io.*;
import java.util.*;


public class Solution_16234 {
    static int N, L, R;
    static int[][] map;
    static int[] dx = {-1, 0, 0, 1}; //북 서 동 남
    static int[] dy = {0, -1, 1, 0}; //북 서 동 남
    static int population = 0;
    static int countryCnt = 0;
    static int time = 0;
    static boolean[][] visited;
    static ArrayList<int[]> changeCountry;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stD.nextToken());
            }
        }

        search:
        while (true){
            boolean flag = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == false){
                        int population = bfs(i, j);

                        if (changeCountry.size() > 1){
                            changePopulation(population);
                            flag = true;
                        }
                    }
                }
            }

            if (flag == false){
                break search;
            }
            else{
                time++;
            }
        }


        bw.write(time + "\n");
        bw.flush();
        bw.close();
    }

    static void changePopulation(int population){
        int avg = population / changeCountry.size();

        for (int[] countryP : changeCountry){
            map[countryP[0]][countryP[1]] = avg;
        }
    }
    static int bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        changeCountry = new ArrayList<>();
        q.offer(new int[]{x, y});
        changeCountry.add(new int[] {x,y});
        visited[x][y] = true;

        int population = map[x][y]; //처음 시작 국가 인구

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int cx = poll[0];
            int cy = poll[1];
            int nowP = map[cx][cy];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                    //범위 안에 있어야 하고
                    int nextP = map[nx][ny];
                    int diff = Math.abs(nextP - nowP); //인구 차이

                    if (visited[nx][ny] == false && L <= diff && diff <= R) {
                        q.offer(new int[] {nx,ny});
                        visited[nx][ny] = true;
                        population += map[nx][ny];
                        changeCountry.add(new int[] {nx,ny});
                    }
                }
            }
        }

        return population;
    }
}