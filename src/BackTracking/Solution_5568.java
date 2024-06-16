package BackTracking;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;


public class Solution_5568 {
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr, inputArr;
    static boolean[] visited;
    static LinkedHashSet<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine()); //숫자 N
        M = Integer.parseInt(br.readLine()); //사용할 수 있는 카드 쌍

        inputArr = new int[N]; //주어진 카드를 전부 저장
        arr = new int[M]; //사용할 수 있는 카드 제한 배열
        visited = new boolean[N];

        for (int i=0; i< N; i++){
            inputArr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(inputArr);

        backTracking(0);

        bw.write(set.size() + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    static void backTracking(int depth) {
        if (depth == M){
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<M; i++){
                sb.append(arr[i]);
            }
            set.add(sb.toString());
            return;
        }

        for (int i=0; i<N; i++){
            if (visited[i] == false){
                visited[i] = true;
                arr[depth] = inputArr[i];
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}

