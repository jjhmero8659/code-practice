package Greedy;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_1783 {
    static Long N, M;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Long.parseLong(st.nextToken());
        M = Long.parseLong(st.nextToken());

        bw.write(solution() + "\n");


        bw.flush();
        bw.close();
    }

    static long solution() {
        if (N == 1 || M == 1) {
            return 1;
        } else if (N == 2) {
            return Math.min(4, (M + 1) / 2);
        } else if (M < 7) {
            return Math.min(M, 4);
        }

        return M - 2;
    }

}