package TopologicalSorting;

import java.io.*;
import java.util.*;


public class Solution_2252 {
    static int N, M;
    static ArrayList<Integer>[] graph;
    static int[] inDegree;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken()); //학생 수
        M = Integer.parseInt(st.nextToken()); //비교 횟수

        graph = new ArrayList[N+1];
        inDegree = new int[N+1];

        for (int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");

            int sp = Integer.parseInt(stD.nextToken());
            int ep = Integer.parseInt(stD.nextToken());

            graph[sp].add(ep);
            inDegree[ep]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=N; i++){
            if (inDegree[i] == 0){
                q.offer(i);
            }
        }

        while (!q.isEmpty()){
            Integer now = q.poll();
            bw.write(now + " ");
            for (int next : graph[now]){
                inDegree[next]--;
                if (inDegree[next] == 0){
                    q.offer(next);
                }
            }
        }

        bw.flush();
        bw.close();
    }

}