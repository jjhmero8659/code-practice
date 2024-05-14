package TopologicalSorting;

import java.io.*;
import java.util.*;


public class Solution_1766 {
    static int N, M;
    static ArrayList<Integer>[] relation;
    static int[] parent;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); //문제의 수
        M = Integer.parseInt(st.nextToken()); //정보 의 수 , 관계 수

        relation = new ArrayList[N+1];
        parent = new int[N+1];

        for (int i=1; i<=N; i++){
            relation[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");
            int sp = Integer.parseInt(stD.nextToken());
            int ep = Integer.parseInt(stD.nextToken());

            relation[sp].add(ep);
            parent[ep]++;
        }

        topologicalSort();

        bw.write(sb.toString() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void topologicalSort() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=1; i<=N; i++){
            if (parent[i] == 0){
                pq.offer(i);
            }
        }

        while (!pq.isEmpty()){
            Integer now = pq.poll();
            sb.append(now + " ");
            for (int next : relation[now]){
                parent[next]--;

                if (parent[next] == 0){
                    pq.offer(next);
                }
            }
        }

    }
}