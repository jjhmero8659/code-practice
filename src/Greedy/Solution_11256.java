package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_11256 {
    static int T, J, N;
    static Integer[] box;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            J = Integer.parseInt(st.nextToken()); //사탕 개수
            N = Integer.parseInt(st.nextToken()); //상자 개수

            box = new Integer[N];


            for (int i = 0; i < N; i++) {
                StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

                int r = Integer.parseInt(stD.nextToken());
                int c = Integer.parseInt(stD.nextToken());

                box[i] = r * c;
            }
            int cnt = 0;
            Arrays.sort(box, Collections.reverseOrder());
            for(int k = 0; k < N; k++) {
                J -= box[k];
                cnt ++;

                if(J <= 0) {
                    break;
                }
            }

            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
    }
}