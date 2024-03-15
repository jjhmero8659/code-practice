import java.io.*;
import java.util.*;


public class Solution_11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();

        StringTokenizer stA = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            arr.add(Integer.parseInt(stA.nextToken()));
        }

        StringTokenizer stB = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= M; i++) {
            arr.add(Integer.parseInt(stB.nextToken()));
        }

        Collections.sort(arr); //정렬


        for (int i=0; i<M+N; i++){
            bw.write(arr.get(i) + " ");
        }

        bw.flush();
        bw.close();
    }

}