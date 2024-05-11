package TopologicalSorting;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_2637 {
    static int N, M;
    static ArrayList<Part>[] part;
    static int[] need;
    static int parentPart[];

    static class Part{
        int num;
        int partNeed;
        public Part(int num, int partNeed) {
            this.num = num;
            this.partNeed = partNeed;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); //완제품 번호
        M = Integer.parseInt(br.readLine()); //부품 관계

        part = new ArrayList[N+1];
        need = new int[N+1];
        parentPart = new int[N+1];

        for (int i=1; i<=N; i++){
            part[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");

            int start = Integer.parseInt(stD.nextToken());
            int partN = Integer.parseInt(stD.nextToken());
            int need = Integer.parseInt(stD.nextToken());

            part[start].add(new Part(partN,need));
            parentPart[partN]++;
        }

        topologicalSort();

        for (int i=1; i<N; i++){
            if (part[i].size() == 0){
                bw.write(i + " " + need[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
    }

    static void topologicalSort(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        need[N] = 1;

        while (!q.isEmpty()){
            Integer now = q.poll();

            for (Part next : part[now]){
                int nextPN = next.num; //부품 번호
                int partNeed = next.partNeed; //부품 필요 개수

                need[nextPN] += need[now] * partNeed;
                parentPart[nextPN]--;

                if (parentPart[nextPN] == 0){
                    q.offer(nextPN);
                }
            }
        }
    }
}