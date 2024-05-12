package TopologicalSorting;

import java.io.*;
import java.util.*;


public class Solution_2056 {
    static int N;
    static ArrayList<Integer>[] workRelation;
    static int[] workTime;
    static int[] parent;
    static int[] totalTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); //작업 개수

        workRelation = new ArrayList[N+1];
        workTime = new int[N+1];
        totalTime = new int[N+1];
        parent = new int[N+1];

        for (int i=1; i<=N; i++){
            workRelation[i] = new ArrayList<>();
        }

        for (int i=1; i<=N; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");

            int wT = Integer.parseInt(stD.nextToken()); //작업 시간
            workTime[i] = wT;
            
            int prevN = Integer.parseInt(stD.nextToken()); //선행 관계 작업 개수

            for (int p=0; p<prevN; p++){
                int prevW = Integer.parseInt(stD.nextToken());
                workRelation[prevW].add(i);
                parent[i]++;
            }
        }

        topologicalSort();

        int maxWork = 0;

        for (int i=1; i<=N; i++){
            maxWork = Math.max(maxWork, totalTime[i]);
        }

        bw.write(maxWork + "\n");
        bw.flush();
        bw.close();
    }

    static void topologicalSort(){

        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<parent.length; i++){
            if (parent[i] == 0){
                q.offer(i);
                totalTime[i] = workTime[i];
            }
        }

        while (!q.isEmpty()){
            Integer now = q.poll();

            for (int nextWork : workRelation[now]){
                parent[nextWork]--;
                totalTime[nextWork] = Math.max(totalTime[now] , totalTime[nextWork]);

                if (parent[nextWork] == 0){
                    q.offer(nextWork);
                    totalTime[nextWork] += workTime[nextWork];
                }
            }
        }
    }
}