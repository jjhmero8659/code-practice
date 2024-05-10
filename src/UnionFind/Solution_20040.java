package UnionFind;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution_20040 {
    static int N, M;
    static int[] parent;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //정점 수
        M = Integer.parseInt(st.nextToken()); //연결 선

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        boolean cycle = false;
        int cnt = 1;

        for (int i = 0; i < M; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(stD.nextToken());
            int b = Integer.parseInt(stD.nextToken());
            if (find(a) == find(b)) {
                cycle = true;
                break;
            }
            else{
                cnt++;
                union(a,b);
            }
        }

        bw.write(cycle ? cnt + "\n" : "0\n");
        bw.flush();
        bw.close();
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    static int find(int a) {
        if (a == parent[a]) {
            return a;
        } else {
            return parent[a] = find(parent[a]);
        }
    }


}