package Impl;

import java.io.*;
import java.util.*;


public class Solution_1620 {
    static int N,M;
    static Map<Integer, String> pocket = new HashMap();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st  = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++){
            pocket.put(1,br.readLine());
        }
        
        for (int i=0; i<M; i++){
            String question = br.readLine();

            if (pocket.containsValue(question)){
                Set<Map.Entry<Integer, String>> data = pocket.entrySet();
                bw.write(da + "\n");
            }
            else{
                bw.write(pocket.get(Integer.parseInt(question)) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

}