package TopologicalSorting;

import java.io.*;
import java.util.*;


public class Solution_1005 {
    static int N, M, T , target;
    static ArrayList<Integer>[] relation;
    static int[] parent;
    static int[] workTime;
    static int[] totalTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken()); //건물 수
            M = Integer.parseInt(st.nextToken()); //정보 의 수 , 관계 수

            relation = new ArrayList[N+1];

            for (int i=1; i<=N; i++){
                relation[i] = new ArrayList<>();
            }

            parent = new int[N+1];
            workTime = new int[N+1];
            totalTime = new int[N+1];

            StringTokenizer stT = new StringTokenizer(br.readLine()," ");
            for (int i=1; i<=N; i++){
                workTime[i] = Integer.parseInt(stT.nextToken());
            }

            for (int i=0; i<M; i++){
                StringTokenizer stD = new StringTokenizer(br.readLine()," ");
                int sp = Integer.parseInt(stD.nextToken());
                int ep = Integer.parseInt(stD.nextToken());

                relation[sp].add(ep);
                parent[ep]++;
            }

            target = Integer.parseInt(br.readLine());

            topologicalSort();

            bw.write(totalTime[target] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void topologicalSort() {
        Queue<Integer> q= new LinkedList<>();
        for (int i=1; i<=N; i++){
            if (parent[i] == 0){
                q.offer(i);
                totalTime[i] = workTime[i];
            }
        }

        while (!q.isEmpty()){
            Integer now = q.poll();

            for (int next : relation[now]){
                parent[next]--;
                totalTime[next] = Math.max(totalTime[next], totalTime[now] + workTime[next]);

                if (parent[next] == 0){
                    q.offer(next);
                }
            }
        }
    }
}