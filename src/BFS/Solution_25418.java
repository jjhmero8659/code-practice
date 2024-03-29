package BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_25418 {
    static int A, B;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stL = new StringTokenizer(br.readLine(), " ");

        A = Integer.parseInt(stL.nextToken()); // 시작
        B = Integer.parseInt(stL.nextToken()); // 타겟

        visited = new boolean[B + 1];

        bw.write(bfs() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }


    static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(A);
        int depth = 0;
        visited[A] = true;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Integer num = q.poll();

                if (num == B) {
                    return depth;
                }

                int addNum = num + 1;
                int mulNum = num * 2;
                if (addNum <= B) {
                    if (visited[addNum] == false) {
                        q.offer(addNum);
                        visited[addNum] = true;
                    }
                }
                if (mulNum <= B) {
                    if (visited[mulNum] == false) {
                        q.offer(mulNum);
                        visited[mulNum] = true;
                    }
                }

            }
            depth++;
        }

        return -1;
    }

}