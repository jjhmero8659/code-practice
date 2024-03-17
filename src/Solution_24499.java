import java.io.*;
import java.util.StringTokenizer;


public class Solution_24499 {
    static int[] a;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        a = new int[N + 1]; //들어오는 정수

        StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(stD.nextToken());
        }

        long maxSum = 0;
        for (int i=1; i<=K; i++){
            maxSum += a[i];
        }

        long currentSum = maxSum;

        for (int i=2; i<=N; i++){
            currentSum -= a[i - 1];

            if ((i+K-1) > N){
                currentSum += a[(i+K-1) % N];
            }
            else {
                currentSum += a[i+K-1];
            }

            maxSum = Math.max(maxSum,currentSum);
        }


        bw.write(maxSum + "\n");
        bw.flush();
        bw.close();
    }
}
