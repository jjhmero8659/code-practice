package Greedy;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_1515 {
    static char[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = br.readLine().toCharArray(); //주어진 문자 열
        int arrP = 0;

        int ans = 1;

        while (arrP < arr.length) {
            String s = Integer.toString(ans);

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == arr[arrP]){
                    arrP++;
                }
                if (arrP >= arr.length)break;
            }

            ans += 1;
        }

        bw.write((ans - 1) + "\n");
        bw.flush();
        bw.close();
    }


}