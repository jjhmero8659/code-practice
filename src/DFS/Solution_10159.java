package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution_10159 {
    static int N,M;
    static ArrayList<Integer>[] ascThings;
    static ArrayList<Integer>[] descThings;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); //물건의 개수
        M = Integer.parseInt(br.readLine()); //물건 쌍의 개수

        ascThings = new ArrayList[N+1];
        descThings = new ArrayList[N+1];

        for (int i=1; i<=N; i++){
            ascThings[i] = new ArrayList<>();
            descThings[i] = new ArrayList<>();
        }

        for (int i=1; i<=M; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");

            int sp = Integer.parseInt(stD.nextToken());
            int ep = Integer.parseInt(stD.nextToken());

            descThings[sp].add(ep);
            ascThings[ep].add(sp);
        }

        for (int i=1; i<=N; i++){
            ArrayList<Integer> contains = new ArrayList<>();

            visited = new boolean[N+1];

            //자신보다 큰 물건 들
            ascDfs(i);
            
            //자신보다 작은 물건 들
            descDfs(i);

            long falseCnt = 0;
            for (boolean nonV : visited){
                if (nonV == false){
                    falseCnt++;
                }
            }

            bw.write(falseCnt-1 + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void ascDfs(int index){
        visited[index] = true;

        for (int num : ascThings[index]){
            if (visited[num] == false){
                ascDfs(num);
            }
        }
    }

    static void descDfs(int index){
        visited[index] = true;

        for (int num : descThings[index]){
            if (visited[num] == false){
                descDfs(num);
            }
        }
    }
}