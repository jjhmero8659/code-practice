package Dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_10282 {
    static int T,N,D,S;
    static ArrayList<Node>[] nodes;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] distance;
    static final int INF = 987654321;
    static class Node {
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        
        for (int t=0; t<T; t++){
            StringTokenizer stI = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(stI.nextToken()); //정점의 개수
            D = Integer.parseInt(stI.nextToken()); //의존성 개수
            S = Integer.parseInt(stI.nextToken()); //처음 해킹 당하는 컴퓨터의 번호

            nodes = new ArrayList[N+1];
            distance = new int[N+1];

            Arrays.fill(distance,INF);

            for (int i=1; i<=N; i++){
                nodes[i] = new ArrayList<>();
            }

            for (int d = 0; d<D; d++){
                StringTokenizer stD = new StringTokenizer(br.readLine()," ");

                int e = Integer.parseInt(stD.nextToken());
                int s = Integer.parseInt(stD.nextToken());
                int time = Integer.parseInt(stD.nextToken());

                nodes[s].add(new Node(e,time));
            }
            dijkstra();

            print();
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a,b) -> Integer.compare(a.cost,b.cost)
        );

        distance[S] = 0; //처음 해킹 컴퓨터는 시작하자마자 감염

        pq.offer(new Node(S,0));
        
        while (!pq.isEmpty()){
            Node now = pq.poll();
            int nowN = now.num;

            //poll 한 컴퓨터가 해킹 되므로 연관있는 컴퓨터들 전부 감염
            for (Node next : nodes[nowN]){
                if (distance[next.num] > distance[nowN] + next.cost){
                    pq.offer(next);
                    distance[next.num] = distance[nowN] + next.cost;
                }

            }
        }

    }

    static void print() throws IOException {
        int cnt = 0;
        int maxT = 0;

        for (int i=1; i<=N; i++){
            if (distance[i] != INF){
                cnt++;
                maxT = Math.max(distance[i], maxT);
            }
        }

        bw.write(cnt + " " + maxT + "\n");
    }


}