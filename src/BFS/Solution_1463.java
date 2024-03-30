
package BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;


public class Solution_1463 {
    static int S;
    static long minD = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        S = Integer.parseInt(br.readLine());

        bfs(S);
        bw.write(minD+"\n");
        bw.flush();
        bw.close();
    }

    static void bfs(int start){
        Queue<int[]> q = new LinkedList<>();
        int depth = 0;

        q.offer(new int[] {start,depth});

        while (!q.isEmpty()){
            int[] pd = q.poll();
            int idx = pd[0]; //현재 숫자
            int d = pd[1]; //depth

            if (idx == 1){
                minD = Math.min(minD , d);
                return;
            }
            else if (idx < 1){
                continue; //목표하는 1값보다 작다면
            }

            if (idx % 3 == 0){
                q.offer(new int[] {idx / 3,d+1});
            }

            if (idx % 2 == 0){
                q.offer(new int[] {idx / 2,d+1});
            }

            q.offer(new int[] {idx - 1,d+1});
        }
    }

}