package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_16435 {
    static Integer N, L;
    static int[] fruits;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); //fruit Num
        L = Integer.parseInt(st.nextToken()); //Snake Length

        fruits = new int[N];

        StringTokenizer stD = new StringTokenizer(br.readLine()," ");

        for (int i=0; i<N; i++){
            fruits[i] = Integer.parseInt(stD.nextToken());
        }

        Arrays.sort(fruits);

        for (int i=0; i<N; i++){
            if (fruits[i] <= L){
                L++;
            }
        }

        bw.write(L + "\n");
        bw.flush();
        bw.close();
    }
}