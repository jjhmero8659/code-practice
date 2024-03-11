import java.io.*;
import java.util.StringTokenizer;


public class Solution_10773 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        n = Integer.parseInt(br.readLine()); // 숫자 개수
        
        int[] A = new int[n+1]; //데이터 배열

        for (int i=1; i<=n; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        bw.write(solution(A) + "");
        bw.newLine();
        bw.flush();
        bw.close();
    }

    private static int solution(int[] A){
        int sum = 0;
        for (int i=1; i<=n; i++){
            if (A[i] == 0){
                for (int j=i-1; j>=1; j--){
                    if(A[j] != 0){
                        sum -= A[j];
                        A[j] = 0;
                        break;
                    };
                }
            }
            else{
                sum += A[i];
            }
        }

        return sum;
    }

}