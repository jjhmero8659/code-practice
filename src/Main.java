import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N+1]; //일반 data 배열
        int[] S = new int[N+1]; //data 합 배열
        
        StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<=N; i++){
            A[i] = Integer.parseInt(stD.nextToken());
            S[i] = S[i-1] + A[i];
        }

        int max = 0;

        // 벌 벌 벌통
        for (int i=2; i<=N; i++){
            int bee1 = S[N] - A[1] - A[i];
            int bee2 = S[N] - S[i];
            max = Math.max(max, bee1 + bee2);
        }

        // 벌통 벌 벌
        for (int i=1; i<=N-1; i++){
            int bee1 = S[N] - A[N] - A[i];
            int bee2 = S[i-1];
            max = Math.max(max, bee1 + bee2);
        }

        //벌 벌통 벌
        for (int i=2; i<=N-1; i++){
            int bee1 = S[i] - A[1]; //왼쪽 벌
            int bee2 = S[N] - S[i-1] - A[N]; //오른쪽 벌
            max = Math.max(max, bee1 + bee2);
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
    }


}