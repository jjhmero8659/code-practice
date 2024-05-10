package UnionFind;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_1976 {
    static int N, M;
    static int[] parent;
    static int[] compare;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        compare = new int[M + 1];

        for (int i=1; i<=N; i++){
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
            for (int p = 1; p <= N; p++) {
                int stat = Integer.parseInt(stD.nextToken());

                if (stat == 1) {
                    union(i,p);
                }
            }
        }

        StringTokenizer stT = new StringTokenizer(br.readLine()," ");
        for (int i=1; i<=M; i++){
            compare[i] = Integer.parseInt(stT.nextToken());
        }
        bw.write(checkSame() ? "YES\n" : "NO\n");

        bw.flush();
        bw.close();
    }

    static boolean checkSame(){
        int target = find(compare[1]);
        for (int i=2; i<compare.length; i++){
            if(target != find(compare[i])){
                return false;
            }
        }
        return true;
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if (a != b){
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