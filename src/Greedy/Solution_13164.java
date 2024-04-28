package Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_13164 {
    static int N, K;
    static int[] kinder;
    static int[] diff;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); //원생
        K = Integer.parseInt(st.nextToken()); //분할 해야하는 K조

        StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

        kinder = new int[N];
        diff = new int[N - 1];

        for (int i = 0; i < N; i++) {
            kinder[i] = Integer.parseInt(stD.nextToken());
        }

        for (int i = 1; i < N; i++) {
            diff[i - 1] = kinder[i] - kinder[i - 1];
        }

        Arrays.sort(diff); //오름 차순 정렬

        long sum = 0;
        long group = N; //조원이 하나인 조의 개수 == N

        for (int i = 0; i < diff.length; i++) {
            if (group == K){
                break;
            }

            group--;
            sum += diff[i];
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}