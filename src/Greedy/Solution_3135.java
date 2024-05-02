package Greedy;

import java.io.*;
import java.util.*;


public class Solution_3135 {
    static int A,B,N;
    static int[] frequency;
    static ArrayList<Integer> btnCnt = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken()); //A 주파수
        B = Integer.parseInt(st.nextToken()); //B 주파수
        
        N = Integer.parseInt(br.readLine()); //지정 주파수 개수

        frequency = new int[N];

        for (int i=0; i<N; i++){
            frequency[i] = Integer.parseInt(br.readLine()); //default value
        }

        solution();

        bw.write(btnCnt.get(0) + "\n");
        bw.flush();
        br.close();
        bw.close();
    }


    static void solution() {
        btnCnt.add(Math.abs(A-B)); // 지정 주파수 없이 btn 이동

        for (int i=0; i<N; i++){
            btnCnt.add(Math.abs(frequency[i] - B) + 1);
        }

        Collections.sort(btnCnt);
    }
}