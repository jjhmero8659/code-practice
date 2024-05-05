package Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_1817 {
    static int N,M;
    static ArrayList<Integer> box = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (N == 0){
            bw.write("0\n");
        }
        else{
            box.add(M);
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");
            for (int i=0; i<N; i++){
                int lastIdx = box.size() - 1;

                Integer remain = box.get(lastIdx);
                int book = Integer.parseInt(stD.nextToken());
                if (remain < book){
                    box.add(M - book);
                }
                else{
                    box.set(lastIdx, remain - book);
                }
            }

            bw.write(box.size() + "\n");
        }

        bw.flush();
        bw.close();
    }

}