
package BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_12852 {
    static int S;
    static long minD = Long.MAX_VALUE;

    static class Info{
        int idx;
        int d;
        String str;
        Info(int idx, int d, String str){
            this.idx = idx;
            this.d = d;
            this.str = str;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        S = Integer.parseInt(br.readLine());

        String result = bfs(S);
        bw.write(minD+"\n");
        bw.write(result+"\n");
        bw.flush();
        bw.close();
    }

    static String bfs(int start){
        Queue<Info> q = new LinkedList<>();
        int depth = 0;

        q.offer(new Info(start,depth,start+" "));

        while (!q.isEmpty()){
            Info pd = q.poll();
            int idx = pd.idx; //현재 숫자
            int d = pd.d; //depth
            String str = pd.str;

            if (idx == 1){
                minD = Math.min(minD , d);
                return str;
            }
            else if (idx < 1){
                continue; //목표하는 1값보다 작다면
            }

            if (idx % 3 == 0){
                q.offer(new Info(idx / 3,d+1,str + (idx / 3) + " "));
            }

            if (idx % 2 == 0){
                q.offer(new Info(idx / 2,d+1,str + (idx / 2) + " "));
            }

            q.offer(new Info(idx - 1,d+1,str + (idx - 1) + " "));
        }

        return "-1";
    }

}