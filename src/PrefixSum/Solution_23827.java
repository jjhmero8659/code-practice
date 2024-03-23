package PrefixSum;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_23827 {
    public static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        int[] pair = new int[N + 1];
        int[] sumA = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=2; i<=N; i++){
            pair[i] = arr[i-1] * arr[i];
        }


        bw.write("");
        bw.flush();
        bw.close();
    }

}