package BFS;

import java.io.*;
import java.util.*;


public class Solution_16197 {
    static int N, M;
    static int[] dx = {0, 0, 1, -1};//동 서 남 북
    static int[] dy = {1, -1, 0, 0};//동 서 남 북
    static char[][] map;
    static ArrayList<Coin> initCoin = new ArrayList<>();

    static class Coin {
        int x;
        int y;
        boolean status = true;

        public Coin(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void dropCoin() {
            this.status = false;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                if (line.charAt(j) == 'o') {
                    initCoin.add(new Coin(i, j));
                }

                map[i][j] = line.charAt(j);
            }
        }


        bw.write(bfs() + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static int bfs() {
        int btnCnt = 0;

        Queue<ArrayList<Coin>> q = new LinkedList<>();

        Coin firstC = initCoin.get(0);
        Coin secondC = initCoin.get(1);

        ArrayList<Coin> startCoins = new ArrayList<>();
        startCoins.add(firstC);
        startCoins.add(secondC);

        q.offer(startCoins);


        while (!q.isEmpty()) {
            if (btnCnt > 10){
                return -1;
            }

            int size = q.size();

            for (int s = 0; s < size; s++) {
                ArrayList<Coin> poll = q.poll();
                Coin c1 = poll.get(0);
                Coin c2 = poll.get(1);

                if (
                        (c1.status == false && c2.status == true) || (c1.status == true && c2.status == false)
                ){
                    //코인이 하나만 드랍 된 상태
                    return btnCnt;
                }

                if (c1.status == false && c2.status == false){
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int fixed = 0;
                    int nx1 = c1.x + dx[i];
                    int ny1 = c1.y + dy[i];

                    int nx2 = c2.x + dx[i];
                    int ny2 = c2.y + dy[i];

                    ArrayList<Coin> nextCoin = new ArrayList<>();

                    if (0 <= nx1 && nx1 < N && 0 <= ny1 && ny1 < M) {
                        if (map[nx1][ny1] != '#') {
                            // 첫번째 코인 중복 진입 방지
                            //이동 하려는 영역이 벽이 아니여야 함
                            nextCoin.add(new Coin(nx1,ny1));
                        }
                        else{
                            fixed++;
                            //벽 또는 중복 영역 이라면 위치 고정
                            nextCoin.add(new Coin(c1.x,c1.y));
                        }
                    }
                    else{
                        Coin nextC1 = new Coin(c1.x, c1.y);
                        nextC1.dropCoin();
                        //coin drop
                        nextCoin.add(nextC1);
                    }

                    if (0 <= nx2 && nx2 < N && 0 <= ny2 && ny2 < M) {
                        if (map[nx2][ny2] != '#') {
                            // 두번째 코인 중복 진입 방지
                            //이동 하려는 영역이 벽이 아니여야 함
                            nextCoin.add(new Coin(nx2,ny2));
                        }
                        else{
                            fixed++;
                            //벽 또는 중복 영역 이라면 위치 고정
                            nextCoin.add(new Coin(c2.x,c2.y));
                        }
                    }
                    else{
                        Coin nextC2 = new Coin(c2.x, c2.y);
                        nextC2.dropCoin();
                        //coin drop
                        nextCoin.add(nextC2);
                    }

                    if (fixed == 2){
                        continue;
                    }

                    q.offer(nextCoin);
                }

            }

            btnCnt++;
        }

        return -1;
    }

}