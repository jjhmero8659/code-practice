package Greedy;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_13417 {
    static int N,T;
    static char[] inputChar;
    static Deque<Character> dq = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());

            inputChar = new char[N];

            StringTokenizer stC = new StringTokenizer(br.readLine(), " ");

            for (int i=0; i<N; i++){
                inputChar[i] = stC.nextToken().charAt(0);
            }

            dq.addLast(inputChar[0]);

            for (int i=1; i<N; i++){
                Character peekFirst = dq.peekFirst();

                if (peekFirst >= inputChar[i]){
                    dq.addFirst(inputChar[i]);
                }
                else{
                    dq.addLast(inputChar[i]);
                }
            }

            while (!dq.isEmpty()){
                bw.write(dq.pollFirst()+"");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

}