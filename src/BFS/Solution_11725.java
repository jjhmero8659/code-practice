package BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_11725 {
    static long N;
    static ArrayList<Long>[] tree;
    static boolean[] visited;
    static long[] pNode;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Long.parseLong(br.readLine());
        tree = new ArrayList[(int)N+1];
        visited = new boolean[(int)N+1];
        pNode = new long[(int)N+1];
        
        for (int i=1; i<=N; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int i=0; i<N-1; i++){
            StringTokenizer stL = new StringTokenizer(br.readLine(), " ");

            long s = Integer.parseInt(stL.nextToken());
            long e = Integer.parseInt(stL.nextToken());

            tree[(int)s].add(e); //양방향 연결
            tree[(int)e].add(s);
        }

        bfs(1);

        for (int i=2; i<=N; i++){
            bw.write(pNode[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void bfs(long root) {
        Queue<Long> q = new LinkedList<>();
        q.add(root); //루트 노드 추가

        while (!q.isEmpty()){
            int size = q.size(); //q 사이즈
            
            for (int i=0; i<size; i++){ //사이즈 만큼 반복
                long pollData = q.poll();
                if (visited[(int)pollData] == false){ //방문 하지 않은 상태라면
                    visited[(int)pollData] = true; //방문 true
                    for (long cN : tree[(int)pollData]){
                        if (visited[(int)cN] == false){
                            q.offer(cN); //자식 노드 들 추가
                            pNode[(int)cN] = pollData;
                        }
                    }
                }
            }

        }
    }

}