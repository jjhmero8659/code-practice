package BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_12761 {
    static int A, B, S, T;
    static int[] rock = new int[100001];
    static boolean[] visited = new boolean[100001];
    static int[] move; //이동
    static int[] jump;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        move = new int[] {1, -1, -A, +A, -B, +B};
        jump = new int [] {A, B};

        bw.write(bfs() + "\n");
        bw.flush();
        bw.close();
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {S,0}); //depth 초기 = 0
        visited[S] = true;

        while (!q.isEmpty()){
            int[] pd = q.poll();
            int idx = pd[0]; //현재 인덱스
            int d = pd[1]; //현재 depth

            if (idx == T){
                return d;
            }

            for (int i=0; i<6; i++){ //일반 이동 + 연산
                int nIdx = idx + move[i];

                if (0<=nIdx && nIdx<100001){
                    if (visited[nIdx] == false){
                        visited[nIdx] = true;
                        q.offer(new int[] {nIdx,d+1});
                    }
                }
            }

            for (int i=0; i<2; i++){ //점프 이동 * 연산
                int nIdx = idx * jump[i];

                if (0<=nIdx && nIdx<100001){
                    if (visited[nIdx] == false){
                        visited[nIdx] = true;
                        q.offer(new int[] {nIdx,d+1});
                    }
                }
            }
        }

        return -1;
    }

}