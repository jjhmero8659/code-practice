import java.io.*;
import java.util.StringTokenizer;


public class Solution_17203 {

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N + 1];
        int[] changeA = new int[N + 1];
        int[] SA = new int[N + 1];

        StringTokenizer stD = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(stD.nextToken());
        }

        changeA[1] = 0;

        for (int i = 2; i <= N; i++) {
            changeA[i] = Math.abs(A[i] - A[i-1]);
        }

        for (int i = 1; i <= N; i++) {
            SA[i] = SA[i-1] + changeA[i];
        }

        for (int i = 1; i <= M; i++) {
            StringTokenizer stQ = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(stQ.nextToken());
            int end = Integer.parseInt(stQ.nextToken());
            int result = SA[end] - SA[start];

            bw.write(result + "\n");
        }
        bw.flush();
        bw.close();
    }

}