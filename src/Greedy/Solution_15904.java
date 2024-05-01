package Greedy;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_15904 {
    static String str;
    static char[] arr;
    static Queue<Character> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = br.readLine();

        arr = str.toCharArray();

        bw.write(solution() ? "I love UCPC\n" : "I hate UCPC\n");
        bw.flush();
        bw.close();
    }

    static boolean solution(){
        char[] target = {'U','C','P','C'};

        for (int i=0; i<arr.length; i++){
            if (arr[i] == 'U' || arr[i] == 'C' || arr[i] == 'P'){
                q.offer(arr[i]);
            }
        }

        int index = 0;

        while (!q.isEmpty()){
            Character poll = q.poll();
            if (index >= 4){
                break;
            }

            if (target[index] == poll){
                index++;
            }
        }

        return index >= 4;

    }
}