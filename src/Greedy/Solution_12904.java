package Greedy;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_12904 {
    static StringBuffer S,T;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        S = new StringBuffer(br.readLine());
        T = new StringBuffer(br.readLine());

        while (S.length() < T.length()){
            if (T.charAt(T.length() - 1) == 'A'){
                T.deleteCharAt(T.length() - 1);
            }
            else if (T.charAt(T.length() - 1) == 'B'){
                T.deleteCharAt(T.length() - 1);
                T.reverse();
            }
        }

        bw.write(S.toString().equals(T.toString()) ? "1\n" : "0\n");

        bw.flush();
        bw.close();
    }

}