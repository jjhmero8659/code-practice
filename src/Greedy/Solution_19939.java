package Greedy;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_19939 {
    static int N, K;
    static int[] bucket;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); //공 개수
        K = Integer.parseInt(st.nextToken()); //바구니 개수

        bucket = new int[K];

        defaultSet();
        int solution = solution();
        bw.write( solution + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static void defaultSet() {
        for (int i = 0; i < K; i++) {
            bucket[i] += (i + 1);
            N -= (i + 1);
        }
    }

    static int solution() {
        int ball = N / K;

        for (int i = 0; i < K; i++) {
            bucket[i] += ball;
            N -= ball;
        }

        if (N > 0){
            return (bucket[K - 1] + 1) - bucket[0];
        }
        else if (N == 0){
            return bucket[K - 1] - bucket[0];
        }
        else{
            return -1;
        }

    }
}