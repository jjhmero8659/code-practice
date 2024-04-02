package BFS;

import java.io.*;
import java.util.*;


public class Solution_9205 {
    static int T, N;
    static int SX, SY, FX, FY;
    static ArrayList<Store> store;

    static class Store {
        int x, y;

        public Store(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine()); //테스트 케이스

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());

            StringTokenizer stS = new StringTokenizer(br.readLine(), " ");

            SX = Integer.parseInt(stS.nextToken()); //상근 x
            SY = Integer.parseInt(stS.nextToken()); //상근 y

            store = new ArrayList<>();

            for (int i = 1; i <= N; i++) { //편의점
                StringTokenizer stC = new StringTokenizer(br.readLine(), " ");

                int storeX = Integer.parseInt(stC.nextToken());
                int storeY = Integer.parseInt(stC.nextToken());

                store.add(new Store(storeX, storeY)); //편의점 좌표 저장
            }

            StringTokenizer stF = new StringTokenizer(br.readLine(), " ");

            FX = Integer.parseInt(stF.nextToken()); //festival x
            FY = Integer.parseInt(stF.nextToken()); //festival y

            bw.write(bfs() ? "happy\n" : "sad\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }


    static boolean bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{SX, SY}); //상근 집 좌표 입력
        boolean visited[] = new boolean[store.size()];

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int nowX = poll[0];
            int nowY = poll[1];

            long festivalD = Math.abs(FX - nowX) + Math.abs(FY - nowY);
            //현재 지점 에서 festival 까지 거리 

            if (festivalD <= 1000) {
                return true; //festival 참여 가능
            }

            //현재 거리에서 참여 불가능 하다면 편의점 탐색
            int storeSize = store.size();
            for (int i = 0; i < storeSize; i++) {
                Store nextStore = store.get(i);
                long storeD = Math.abs(nextStore.x - nowX) + Math.abs(nextStore.y - nowY);

                if (visited[i] == false && storeD <= 1000) {
                    q.offer(new int[]{nextStore.x, nextStore.y});
                    visited[i] = true;
                }
            }
        }
        return false;
    }

}