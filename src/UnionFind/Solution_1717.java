package UnionFind;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_1717 {
    static int N, M;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //정점 개수
        M = Integer.parseInt(st.nextToken()); //질의

        parent = new int[N + 1];

        for (int i=1; i<=N; i++){
            parent[i] = i;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");

            int question = Integer.parseInt(stD.nextToken());
            int a = Integer.parseInt(stD.nextToken());
            int b = Integer.parseInt(stD.nextToken());

            if (question == 0){
                //Union
                union(a,b);
            }
            else{
                bw.write(checkSame(a,b) ? "YES\n" : "NO\n");
            }

        }

        bw.flush();
        bw.close();
    }

    static void union(int a, int b){
        int repA = find(a);
        int repB = find(b);

        if (repA != repB){
            parent[repB] = repA;
        }
    }

    static int find(int num){
        if (num == parent[num]){
            //만약 현재 num 과 대표 num 이 동일하다면
            //자기 자신이 대표 num
            return num;
        }
        else{
            int representative  = find(parent[num]);
            parent[num] = representative;
            return representative;
        }
    }

    static boolean checkSame(int a,int b){
        if (find(a) == find(b)){
            return true;
        }
        return false;
    }

}