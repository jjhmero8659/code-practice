package BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_11559 {
    static char[][] map;
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북
    static ArrayList<int[]> puyo;
    static boolean[][] visited;
    static ArrayList<Character> fallList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        map = new char[12][6];

        for (int i = 0; i < 12; i++) {
            String line = br.readLine();
            for (int j = 0; j < 6; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int count = 0;
        while (true) {
            boolean pop = false;

            visited = new boolean[12][6];

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (map[i][j] != '.') {
                        bfs(i, j, map[i][j]);

                        if (puyo.size() >= 4) {
                            pop = true; //연쇄가 발생 했을때
                            popPuyo(); //현재 차있는 puyo 를 터뜨린다.
                        }
                    }
                }
            }

            if (pop == false) {
                break;
            }

            fallPuyo();
            count++;
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
    }

    static void fallPuyo() {
        for (int i = 0; i < 6; i++) {
            fallList = new ArrayList<>();
            for (int j = 11; j >= 0; j--) {
                if (map[j][i] != '.') {
                    fallList.add(map[j][i]); //현재 세로 줄에 puyo 들을 새로 저장 함
                }
            }

            for (int k = 11; k > 11 - fallList.size(); k--) {
                map[k][i] = fallList.get(11 - k); //리스트의 개수만큼 변화
            }

            for (int k=0; k<12 - fallList.size(); k++){
                map[k][i] = '.';
            }

        }
    }

    static void popPuyo() {
        for (int[] puyoP : puyo) {
            map[puyoP[0]][puyoP[1]] = '.';
        }
    }

    static void bfs(int x, int y, char c) {
        Queue<int[]> q = new LinkedList<>();
        puyo = new ArrayList<>(); //터뜨릴 puyo list
        puyo.add(new int[]{x, y});

        q.offer(new int[]{x, y}); //다음 영역
        visited[x][y] = true; //방문 true

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int cx = poll[0];
            int cy = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (0 <= nx && nx < 12 && 0 <= ny && ny < 6) {
                    if (visited[nx][ny] == false && map[nx][ny] == c) {
                        visited[nx][ny] = true;
                        puyo.add(new int[]{nx, ny});
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}