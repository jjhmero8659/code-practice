package BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_14562 {
    static int C;

    static class Info {
        int mP;
        int eP;
        int d;

        Info(int mP, int eP, int d) {
            this.mP = mP;
            this.eP = eP;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        C = Integer.parseInt(br.readLine());

        for (int c = 0; c < C; c++) {
            StringTokenizer stL = new StringTokenizer(br.readLine(), " ");

            int S = Integer.parseInt(stL.nextToken()); // 시작
            int T = Integer.parseInt(stL.nextToken()); // 타겟

            bw.write(bfs(S, T) + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }


    static int bfs(int start, int target) {
        int depth = 0;
        ArrayList<Boolean> visited = new ArrayList<>(); // 1 ~ 100
        for (int i = 0; i <= target; i++) {
            visited.add(false);
        }

        Queue<Info> q = new LinkedList<>();
        q.offer(new Info(start, target, depth));
        visited.set(start, true);

        while (!q.isEmpty()) {
            Info p = q.poll();
            int nowP = p.mP; //현재 점수
            int nowEP = p.eP; //현재 상대 점수
            int nowD = p.d; //깊이

            if (nowEP == nowP) { //현재 점수와 상대 점수가 같다면
                return nowD;
            }

            if (nowP > nowEP) {
                //현재 점수가 상대 점수보다 크다면
                continue; // 넘어 가기
            }

            q.offer(new Info(nowP * 2, nowEP + 3, nowD + 1));
            q.offer(new Info(nowP + 1, nowEP, nowD + 1));
        }

        return -1;
    }

}