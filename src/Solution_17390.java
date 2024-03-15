import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_17390 {
    static int N,M;
    static int B[] ,SB[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        B = new int[N+1];
        SB = new int[N+1];
        StringTokenizer stD = new StringTokenizer(br.readLine()," ");

        for (int i=1; i<=N; i++){
            B[i] = Integer.parseInt(stD.nextToken());
        }

        Arrays.sort(B);

        for (int i=1; i<=N; i++){
            SB[i] = SB[i-1] + B[i];
        }

        for (int i=1; i<=M; i++){
            StringTokenizer stQ = new StringTokenizer(br.readLine()," ");
            int begin = Integer.parseInt(stQ.nextToken());
            int end = Integer.parseInt(stQ.nextToken());

            int result = SB[end] - SB[begin-1];
            bw.write(result+"\n");
        }

        bw.flush();
        bw.close();
    }

}