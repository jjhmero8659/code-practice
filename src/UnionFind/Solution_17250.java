package UnionFind;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_17250 {
    static int N, M;
    static int[] parent;
    static int[] planet;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //은하 수
        M = Integer.parseInt(st.nextToken()); //철도

        planet = new int[N+1]; //연결 은하 숫자
        parent = new int[N+1]; //대표

        for (int i=1; i<=N; i++){
            parent[i] = i;
        }

        for (int i=1; i<=N; i++){
            planet[i] = Integer.parseInt(br.readLine());
        }

        for (int i=0; i<M; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(stD.nextToken());
            int b = Integer.parseInt(stD.nextToken());

            int rA = find(a); //a 대표
            int rB = find(b); //b 대표

            int aPlanet = planet[rA];
            int bPlanet = planet[rB];

            if (rA == rB){
                bw.write(aPlanet + "\n");
            }
            else{
                union(a,b); //a , b 연결
                int updateA = find(a); //업데이트
                planet[updateA] = aPlanet + bPlanet;
                bw.write(planet[updateA] + "\n");
            }
        }
        
        bw.flush();
        bw.close();
    }

    static int find(int a){
        if (a == parent[a]){
            return a;
        }
        else{
            return parent[a] = find(parent[a]);
        }
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if (a != b){
            parent[b] = a;
        }
    }


}