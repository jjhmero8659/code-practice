package TopologicalSorting;

import java.io.*;
import java.util.*;


public class Solution_2611 {
    static int N, M;
    static ArrayList<Node>[] graph;
    static int[] inDegree, score, prev;
    static Deque<Integer> dq = new ArrayDeque<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Node {
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); //정점 수
        M = Integer.parseInt(br.readLine()); //간선 수

        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        inDegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

            int s = Integer.parseInt(stD.nextToken());
            int e = Integer.parseInt(stD.nextToken());
            int v = Integer.parseInt(stD.nextToken());

            graph[s].add(new Node(e, v));
            inDegree[e]++;
        }

        solved();

        bw.write(print() + "\n");

        bw.flush();
        bw.close();
    }

    static void solved(){
        score = new int[N + 1];
        prev = new int[N + 1];

        dq.offerLast(1); // 시작 정점 = 1

        while (!dq.isEmpty()){
            Integer now = dq.pollFirst();

            for (Node next : graph[now]){
                int nextCost = score[now] + next.cost;

                if (score[next.num] < nextCost){
                    score[next.num] = nextCost;
                    prev[next.num] = now;
                }

                inDegree[next.num]--;

                if (inDegree[next.num] == 0 && (next.num != 1)){
                    dq.offerLast(next.num);
                }
            }
        }
    }

    static String print() throws IOException{
        bw.write(score[1] + "\n");

        StringBuilder sb = new StringBuilder();

        int num = 1;
        while (true){
            if (prev[num] == 1){
                dq.offerLast(1);
                break;
            }

            dq.offerLast(prev[num]);
            num = prev[num];
        }

        while (!dq.isEmpty()){
            sb.append(dq.pollLast()).append(' ');
        }

        sb.append("1 ");

        return sb.toString();
    }

}