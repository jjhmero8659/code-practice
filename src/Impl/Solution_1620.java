package Impl;

import java.io.*;
import java.util.*;


public class Solution_1620 {
    static int N,M;
    static Map<Integer, String> pocketMap_VS = new HashMap();
    static Map<String, Integer> pocketMap_VI = new HashMap();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st  = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++){
            String s = br.readLine();
            pocketMap_VS.put(i,s);
            pocketMap_VI.put(s,i);
        }
        
        for (int i=0; i<M; i++){
            String question = br.readLine();

            if (isNum(question)){
                bw.write(pocketMap_VS.get(Integer.parseInt(question)) + "\n");
            }
            else{
                bw.write(pocketMap_VI.get(question) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    static boolean isNum(String str){
        for (int i=0; i<str.length(); i++){
            if (Character.isDigit(str.charAt(i)) == false){
                return false;
            }
        }
        return true;
    }

}