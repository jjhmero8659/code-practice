
package DFS;

import java.io.*;
import java.util.*;


public class Solution_2234 {
    static int N, M;
    static int maze[][];
    static int[][] visited;
    static int roomCnt = 0;
    static long tempMaxRoom = 0;
    static long maxRoom = 0;
    static int[] dx = {0, 0, 1, -1}; //동 서 남 북
    static int[] dy = {1, -1, 0, 0}; //동 서 남 북
    static ArrayList<Room> rooms = new ArrayList<>();
    static long resultRoomCnt = 0;
    static boolean[][] wallVisited;

    static class Room {
        int num;
        long roomCnt;

        public Room(int num, long roomCnt) {
            this.num = num;
            this.roomCnt = roomCnt;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken()); //가로
        N = Integer.parseInt(st.nextToken()); //세로

        maze = new int[N][M];
        visited = new int[N][M];
        wallVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(stD.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0) {
                    roomCnt++;
                    tempMaxRoom = 0;
                    dfs(i, j);
                    rooms.add(new Room(roomCnt, tempMaxRoom));
                    maxRoom = Math.max(maxRoom, tempMaxRoom);
                }
            }
        }

        breakWall();

        bw.write(roomCnt + "\n");
        bw.write(maxRoom + "\n");
        bw.write(resultRoomCnt + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = roomCnt;
        tempMaxRoom++;

        int stat = maze[x][y];
        int[] dir = new int[4];
        Arrays.fill(dir, 1);

        if (stat >= 8) { // 남
            stat -= 8;
            dir[2] = 0; // dx,dy 의 i번째
        }

        if (stat >= 4) { //동
            stat -= 4;
            dir[0] = 0;
        }

        if (stat >= 2) { //북
            stat -= 2;
            dir[3] = 0;
        }

        if (stat >= 1) { //서
            stat -= 1;
            dir[1] = 0;
        } //해당 영역 값 전달
        //이동 할 수 있는 방향 탐색

        for (int i = 0; i < 4; i++) {
            if (dir[i] == 1) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (range(nx, ny)) {
                    if (visited[nx][ny] == 0) {
                        dfs(nx, ny);
                    }
                }
            }
        }
    }

    static boolean range(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

    static void breakWall() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int d=0; d<4; d++){
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (range(nx,ny)){
                        if (visited[i][j] != visited[nx][ny]){
                            long nowRoom = rooms.get(visited[i][j] - 1).roomCnt;
                            long nextRoom = rooms.get(visited[nx][ny] - 1).roomCnt;
                            long sum = nowRoom + nextRoom;

                            resultRoomCnt = Math.max(resultRoomCnt, sum);
                        }
                    }
                }
            }
        }

    }

}