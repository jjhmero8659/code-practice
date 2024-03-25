package BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_11060 {
    static int N;
    static int[] maze;
    static boolean[] visited;
    static int depth = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        maze = new int[N + 1];
        visited = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            maze[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(bfs() + "\n");

        bw.flush();
        bw.close();
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 0}); //1번 index , depth = 0

        while (!q.isEmpty()) {
            int[] pD = q.poll(); //poll data, 큐 에서 뽑은 data
            int index = pD[0]; //현재 index
            int depth = pD[1]; //현재 depth

            if (visited[index] == true){
                continue;
            }

            visited[index] = true; // 뽑은 data는 visit true

            if (index == N) { //도착점에 도달 했다면
                return depth;
            }

            int jR = maze[index]; //최대 점프 거리
            for (int i = 1; i <= jR; i++) {
                q.offer(new int[]{index + i, depth + 1});
            }

        }

        return -1;
    }

}