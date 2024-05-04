package BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_17141 {
    static int N, M;
    static int[][] laboratory;
    static boolean[][] labVisited;
    static ArrayList<Virus> virusArr = new ArrayList<>();
    static boolean[] virusVisited;
    static int[] dx = {0, 0, 1, -1}; //동 서 남 북
    static int[] dy = {1, -1, 0, 0}; //동 서 남 북
    static int[][] tempLab;
    static long result = Integer.MAX_VALUE;

    static class Virus {
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        laboratory = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int stat = Integer.parseInt(stD.nextToken());
                laboratory[i][j] = stat;

                if (stat == 2) {
                    virusArr.add(new Virus(i, j));
                }

                if (stat == 1) {
                    laboratory[i][j] = -1;
                } else {
                    laboratory[i][j] = -2;
                }
            }
        }

        virusVisited = new boolean[virusArr.size()];

        selectVirus(0,0);

        bw.write(result == Integer.MAX_VALUE ? "-1\n" : result + "\n");
        bw.flush();
        bw.close();
    }

    static void selectVirus(int cnt, int start) {
        //virus 중에서 M개 만큼 지정 하기
        //dfs 탐색
        if (cnt == M) {
            virusExtend();
            return;
        }

        for (int i = start; i < virusArr.size(); i++) {
            virusVisited[i] = true;
            selectVirus(cnt + 1, i + 1);
            virusVisited[i] = false;
        }
    }

    static void virusExtend() {
        initTemp(); //현재 선택한 바이러스로 탐색할 임시 연구소
        labVisited = new boolean[N][N]; //연구소 방문 유무 배열
        Queue<Virus> q = new LinkedList<>();
        int time = 0;

        for (int i = 0; i < virusVisited.length; i++) {
            if (virusVisited[i] == true) { //선택 된 virus 라면
                Virus selectedV = virusArr.get(i); //dfs 를 통해 선택 한 virus
                tempLab[selectedV.x][selectedV.y] = time;
                labVisited[selectedV.x][selectedV.y] = true; //방문 true
                q.offer(selectedV); // q에 삽입
            }
        }

        while (!q.isEmpty()) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                Virus poll = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = poll.x + dx[i];
                    int ny = poll.y + dy[i];

                    if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                        if (tempLab[nx][ny] == -2 && labVisited[nx][ny] == false) {   //빈 공간 이고 방문 기록이 없다면
                            tempLab[nx][ny] = time + 1; //현재 경과 시간을 대입
                            labVisited[nx][ny] = true;
                            q.offer(new Virus(nx, ny));
                        }
                    }
                }
            }

            time++;
        }

        long check = checkPossible();

        if (check != -1) { //전부 감염 된 상태
            result = Math.min(check, result);
        }
    }

    static long checkPossible() { //전부 퍼뜨렸는지 확인
        long max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (tempLab[i][j] == -2) {
                    return -1;
                }
                max = Math.max(max, tempLab[i][j]);
            }
        }
        return max;
    }

    static void initTemp(){
        tempLab = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tempLab[i][j] = laboratory[i][j];
            }
        }
    }

}