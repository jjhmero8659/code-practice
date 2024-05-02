package Greedy;

import java.io.*;
import java.util.*;


public class Solution_9237 {
    static int N;
    static Integer[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        tree = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i=0; i<N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree, Collections.reverseOrder());

        for (int i=0; i<N; i++){
            tree[i] += (i+1);
        }

        int max = 0;
        for (int t : tree){
            max = Math.max(max, t);
        }

        bw.write((max + 1) + "\n");
        bw.flush();
        bw.close();
    }

}