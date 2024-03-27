package BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_6118 {
    static int N, M;
    static ArrayList<Integer>[] barns;
    static boolean[] visited;
    static long[] lenArray;
    static long maxLen = Integer.MIN_VALUE;

    static class Node {
        int n;
        long d;

        Node(int n, long d) {
            this.n = n;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        barns = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        lenArray = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            barns[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

            int sp = Integer.parseInt(stD.nextToken());
            int ep = Integer.parseInt(stD.nextToken());

            barns[sp].add(ep); // 양방향 연결
            barns[ep].add(sp);
        }


        bfs();

        int maxIdx = 0;
        int maxCnt = 0;
        
        for (int i = 1; i <= N; i++) {
            if (lenArray[i] == maxLen) { //최대 길이 와 같다면
                if (maxIdx == 0) //처음 한번만 대입
                    maxIdx = i;
                maxCnt++; //중복 수 추가
            }
        }

        bw.write(maxIdx + " " + maxLen + " " + maxCnt + "\n");
        bw.flush();
        bw.close();
    }

    static void bfs() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(1, 0)); //현재 vertex 번호 , depth = 0
        visited[1] = true;

        while (!q.isEmpty()) {
            Node cNode = q.poll();
            int cn = cNode.n; //현재 vertex번호
            long cd = cNode.d; //현재 노드 깊이

            maxLen = Math.max(maxLen, cd);
            lenArray[cn] = cd;

            for (int nextV : barns[cn]) {
                if (visited[nextV] == false) {
                    visited[nextV] = true;
                    q.offer(new Node(nextV, cd + 1));
                }
            }
        }


    }

}