package BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_16236 {
    static int N;
    static int[][] map;
    static long fish = 0;
    static Shark start;
    static int[] dx = {-1, 0, 1, 0}; //북 서 남 동 반시계
    static int[] dy = {0, -1, 0, 1}; //북 서 남 동 반시계

    static class Shark {
        int x;
        int y;
        int level;
        int levelCnt;
        long d;

        public Shark(int x, int y, int level, int levelCnt, long d) {
            this.x = x;
            this.y = y;
            this.level = level;
            this.levelCnt = levelCnt;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    start = new Shark(i, j, 2,2,0);
                } else if (map[i][j] != 9 && map[i][j] != 0) {
                    fish++;
                }
            }
        }

        while (fish != 0) { //모든 물고기가 없어질 때 까지

            Shark S = bfs(start);

            if(S == null){
                break;
            }
            else{
                start = S;
            }
        }

        bw.write(start.d + "\n");
        bw.flush();
        bw.close();
    }

    static Shark bfs(Shark start) {
        Queue<Shark> q = new LinkedList<>();
        q.offer(start);
        map[start.x][start.y] = 0; //처음 시작 위치는 빈공간으로 변경

        boolean[][] visited = new boolean[N][N];
        visited[start.x][start.y] = true;

        while (!q.isEmpty()) {
            Shark nowS = q.poll();

            if (map[nowS.x][nowS.y] != 0  && map[nowS.x][nowS.y] < nowS.level){
                //상어보다 level 이 낮은 물고기 공간

                fish--; //전체 물고기 감소
                map[nowS.x][nowS.y] = 0; //빈 공간으로 취급

                if (nowS.levelCnt - 1 == 0){ //업그레이드에 필요한 물고기 수 1 감소
                    //업그레이드에 필요한 물고기 개수를 다 채웠다면

                    //현재 level 증가
                    //level 증가한 만큼 cnt 도 변화
                    return new Shark(nowS.x,nowS.y, nowS.level + 1, nowS.level + 1 , nowS.d);
                }
                else{
                    return new Shark(nowS.x,nowS.y, nowS.level, nowS.levelCnt - 1 , nowS.d);
                    //물고기 먹은 개수만 줄여준다
                }
            }
            
            //물고기 영역이 아니라면
            for (int i=0; i<4; i++){
                int nx = nowS.x + dx[i];
                int ny = nowS.y + dy[i];
                
                if (0<=nx && nx<N && 0<=ny && ny<N){
                    if (visited[nx][ny] == false && map[nx][ny] <= nowS.level){
                        //방문하지 않았던 영역이어야 하고
                        //상어의 level 보다 낮거나 같은 영역으로 이동 가능

                        q.offer(new Shark(nx,ny, nowS.level, nowS.levelCnt, nowS.d+1));
                        visited[nx][ny] = true;
                    }
                }
            }
            
        }

        return null;
    }

}