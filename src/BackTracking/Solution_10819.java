package BackTracking;

import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Solution_10819 {
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] inputNum, arr;
    static boolean[] visited;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); //숫자 개수

        arr = new int[N];
        inputNum = new int[N];
        visited = new boolean[N];

        StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            inputNum[i] = Integer.parseInt(stD.nextToken());
        }

        backTracking(0);
        bw.write(max + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static void backTracking(int depth) {
        if (depth == N){
            int sum = getResult();
            max = Math.max(sum , max);
            return;
        }

        for (int i=0; i<N; i++){
            if (visited[i] == false){
                visited[i] = true;
                arr[depth] = inputNum[i];
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }

    static int getResult(){
        int sum = 0;
        for (int i=0; i<N-1; i++){
            sum += Math.abs(arr[i] - arr[i + 1]);
        }

        return sum;
    }
}

