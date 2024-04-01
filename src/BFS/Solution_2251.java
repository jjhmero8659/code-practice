package BFS;

import java.io.*;
import java.util.*;


public class Solution_2251 {
    static int A, B, C;
    static boolean[][][] visited;
    static ArrayList<Integer> cBottle = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        A = Integer.parseInt(st.nextToken()); //A 물병 용량
        B = Integer.parseInt(st.nextToken()); //B 물병 용량
        C = Integer.parseInt(st.nextToken()); //C 물병 용량

        visited = new boolean[A + 1][B + 1][C + 1]; // 0 ~ Limit 까지

        bfs(0, 0, C);

        Collections.sort(cBottle);

        for (int cBottle : cBottle){
            bw.write(cBottle + " ");
        }

        bw.flush();
        bw.close();
    }

    static class Bottle {
        int a, b, c;

        Bottle(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static void bfs(int a, int b, int c) {
        Queue<Bottle> q = new LinkedList<>();
        q.offer(new Bottle(a, b, c)); //초기 시작 물병
        //C만 가득 차 있음

        while (!q.isEmpty()) {
            Bottle nowB = q.poll(); //현재 물통 값 배열

            if (visited[nowB.a][nowB.b][nowB.c] == true) { //거쳐갔던 Bottle , Skip
                continue;
            }

            visited[nowB.a][nowB.b][nowB.c] = true; //방문 true

            if (nowB.a == 0) {
                //A 물통이 비어있을때
                //C 물통의 값은 무조건 저장
                if (!cBottle.contains(nowB.c)) { //여태까지 값중 중복되지 않은 값이라면
                    cBottle.add(nowB.c); //C값 저장
                }
            }

            // C -> A
            if (nowB.a + nowB.c <= A) { //현재 Bottle A 와 C의 물통의 합이 A전체 용량보다 작다면
                //몰아주기
                q.offer(new Bottle(nowB.a + nowB.c, nowB.b, 0));
            } else {
                //A물통 전부 채우기
                //A를 가득 채우기 위하여 사용된 용량만큼 C 차감
                q.offer(new Bottle(A, nowB.b, nowB.a + nowB.c - A));
            }
            // C -> B
            if (nowB.b + nowB.c <= B) {
                q.offer(new Bottle(nowB.a, nowB.b + nowB.c, 0));
            } else {
                q.offer(new Bottle(nowB.a, B, nowB.b + nowB.c - B));
            }
            //B -> A
            if (nowB.a + nowB.b <= A) {
                q.offer(new Bottle(nowB.a + nowB.b, 0, nowB.c));
            } else {
                q.offer(new Bottle(A, nowB.a + nowB.b - A, nowB.c));
            }
            //B -> C
            if (nowB.b + nowB.c <= C) {
                q.offer(new Bottle(nowB.a, 0, nowB.b + nowB.c));
            } else {
                q.offer(new Bottle(nowB.a, nowB.b + nowB.c - C, C));
            }
            //A -> B
            if (nowB.a + nowB.b <= B) {
                q.offer(new Bottle(0, nowB.a + nowB.b, nowB.c));
            } else {
                q.offer(new Bottle(nowB.a + nowB.b - B, B, nowB.c));
            }
            //A -> C
            if (nowB.a + nowB.c <= C) {
                q.offer(new Bottle(0, nowB.b, nowB.a + nowB.c));
            } else {
                q.offer(new Bottle(nowB.a + nowB.c - C, nowB.b, C));
            }
        }
    }

}