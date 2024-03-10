import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수
        
        for (int p=0; p<t; p++){
            StringTokenizer stN = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(stN.nextToken()); //A의 개수
            int m = Integer.parseInt(stN.nextToken()); //B의 개수
            
            int[] A = new int[n+1];
            int[] B = new int[m+1];

            StringTokenizer stA = new StringTokenizer(br.readLine(), " ");
            for (int a=1; a<=n; a++){
                A[a] = Integer.parseInt(stA.nextToken());
            }

            StringTokenizer stB = new StringTokenizer(br.readLine(), " ");
            for (int b=1; b<=m; b++){
                B[b] = Integer.parseInt(stB.nextToken());
            }

            Arrays.sort(A); //배열 정렬
            Arrays.sort(B); //배열 정렬
            int cnt = 0;
            for (int i=n; i>=1; i--){
                for (int j=m; j>=1; j--){
                    if (A[i] > B[j]){
                        cnt += j;
                        break;
                    }
                }
            }
            bw.write(cnt+"");
            bw.newLine();
            bw.flush();
        }
        bw.close();
        
    }

}