package UnionFind;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution_1043 {
    static int N, M;
    static int T;
    static int[] truth;
    static int[] parent;
    static ArrayList<Integer>[] party;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //사람 수
        M = Integer.parseInt(st.nextToken()); //파티 수

        StringTokenizer stT = new StringTokenizer(br.readLine(), " ");
        T = Integer.parseInt(stT.nextToken()); //진실을 아는 사람

        truth = new int[T];
        
        for (int i=0; i<T; i++){
            truth[i] = Integer.parseInt(stT.nextToken());
        }

        party = new ArrayList[M];
        for (int i=0; i<M; i++){
            StringTokenizer stP = new StringTokenizer(br.readLine(), " ");

            party[i] = new ArrayList<>();
            int partySize = Integer.parseInt(stP.nextToken());
            for (int j=0; j<partySize; j++){
                party[i].add(Integer.parseInt(stP.nextToken()));
            }
        }

        parent = new int[N+1];

        for (int i=1; i<=N; i++) {
            parent[i] = i;
        }


        for (int i=0; i<M; i++){
            int partyFirst = party[i].get(0);
            for (int j=1; j<party[i].size(); j++){
                union(partyFirst , party[i].get(j));
            }
        }

        int result = 0;

        for (int i=0; i<M; i++){
            int partyFirst = party[i].get(0);
            boolean isPossible = true;
            for (int j=0; j<truth.length; j++){
                if (find(partyFirst) == find(truth[j])){
                    isPossible = false;
                    break;
                }
            }

            if (isPossible){
                result++;
            }
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if (a!=b){
            parent[b] = a;
        }
    }

    static int find(int a){
        if (a == parent[a]){
            return a;
        }
        else{
            return parent[a] = find(parent[a]);
        }
    }


}