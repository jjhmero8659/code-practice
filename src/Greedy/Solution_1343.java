package Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;


public class Solution_1343 {
    static String N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = br.readLine();

        String changeA = N.replaceAll("XXXX", "AAAA");
        String changeB = changeA.replaceAll("XX", "BB");

        boolean stat = true;
        for (int i=0; i<N.length(); i++){
            if (changeB.charAt(i) == 'X'){
                stat = false;
                break;
            }
        }

        bw.write(stat == true ? changeB + "\n" : "-1\n");
        bw.flush();
        bw.close();
    }

}