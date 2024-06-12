package BackTracking;

import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Solution_10819 {
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static Deque<Integer> dq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); //숫자 개수

        arr = new int[2];

        StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            dq.add(Integer.parseInt(stD.nextToken()));
        }

        dq.stream().sorted();



        bw.flush();
        br.close();
        bw.close();
    }

    static void backTracking(int startIdx, int depth) {
        
    }
}

