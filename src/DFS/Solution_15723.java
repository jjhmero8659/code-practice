package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution_15723 {
    static int N,M;
    static ArrayList<Integer>[] nArr;
    static boolean visited[];

    static boolean possible = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine()); //전제 개수
        nArr = new ArrayList[26+1];
        visited = new boolean[26+1];
        
        for (int i=0; i<27; i++){
            nArr[i] = new ArrayList<>();
        }

        for (int i=0; i<N; i++){
            String line = br.readLine();
            
            int start = line.charAt(0) - 96; //전제 1
            int end = line.charAt(5) - 96; //전제 2

            nArr[start].add(end); //단방향 연결
        }

        M = Integer.parseInt(br.readLine()); //전제 개수

        for (int i=0; i<M; i++){
            String line = br.readLine();

            int start = line.charAt(0) - 96; //전제 1
            int target = line.charAt(5) - 96; //전제 2 , target

            possible = false;

            for (int j=0; j<27; j++){
                visited[j] = false;
            }

            dfs(start,target);

            if (possible){
                bw.write("T\n");
            }
            else{
                bw.write("F\n");
            }


        }

        bw.flush();
        bw.close();
    }

    static void dfs(int alpha , int target){
        visited[alpha] = true;

        if (alpha == target){
            possible = true;
            return;
        }

        for (int alphabet : nArr[alpha]){
            if (visited[alphabet] == false){
                dfs(alphabet , target);
            }
        }
    }


}