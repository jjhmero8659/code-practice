import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_25916 {
    static int N,M;
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N+1];

        StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

        for (int i=1; i<=N; i++){
            A[i] = Integer.parseInt(stD.nextToken());
        }

        Arrays.sort(A);

        int begin = 1;
        int end = N;

        int cnt = 0;

        while (begin < end){
            long currentValue = A[begin] + A[end];
            if (currentValue >= M){ //최소 능력치
                begin++;
                end--;
                cnt++;
            }
            else if(currentValue < M){
                begin++;
            }
        }



        bw.write(cnt + "\n");
        bw.flush();
        bw.close();

    }

}