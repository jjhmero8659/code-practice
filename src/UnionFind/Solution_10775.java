package UnionFind;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution_10775 {
    static int N, M;
    static int[] airport;
    static int dockingCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); //게이트 수
        M = Integer.parseInt(br.readLine()); //비행기 수

        airport = new int[N+1];

        for (int i=0; i<=N; i++){
            airport[i] = i;
        }


        for (int i=0; i<M; i++){
            int docking = Integer.parseInt(br.readLine());

            int possibleGate = find(docking);

            if (possibleGate == 0){
                break;
            }

            dockingCnt++;

            union(possibleGate - 1 , possibleGate);
        }

        bw.write(dockingCnt + "\n");
        bw.flush();
        bw.close();
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if (a != b){
            airport[b] = a;
        }
    }

    static int find(int a){
        if (a == airport[a]){
            return a;
        }
        else{
            return airport[a] = find(airport[a]);
        }
    }


}