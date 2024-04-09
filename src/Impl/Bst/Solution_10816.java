package Impl.Bst;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Solution_10816 {
    static int N, M;

    static int[] num;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int inputNum = Integer.parseInt(st.nextToken());

            num[i] = inputNum;
        }

        Arrays.sort(num);

        M = Integer.parseInt(br.readLine());
        StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= M; i++) {
            int targetNum = Integer.parseInt(stD.nextToken());
            int uC = upperBound(targetNum);
            int lC = lowerBound(targetNum);
            bw.write(uC - lC + " ");
        }

        bw.flush();
        bw.close();
    }

    static int lowerBound(int target) {
        int low = 0;
        int high = num.length;
        while (low < high) {
            int mid = (high + low) / 2;
            if (target <= num[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int upperBound(int target) {
        int low = 0;
        int high = num.length;
        while (low < high) {
            int mid = (high + low) / 2;
            if (target < num[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}