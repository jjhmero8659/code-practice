import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_3273 {
    public static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // data 크기

        int[] A = new int[n+1]; //data 배열
        StringTokenizer stA = new StringTokenizer(br.readLine()," ");

        for (int i=1; i<=n; i++){
            A[i] = Integer.parseInt(stA.nextToken());
        }

        Arrays.sort(A); //배열 정렬
        
        int target = Integer.parseInt(br.readLine()); // 찾아야 하는 target 숫자

        int begin = 1;
        int end = n;
        
        while (begin < end){ //시작 포인터가 end 포인터 보다 작을 때
            if (A[begin] + A[end] < target){ //양쪽 포인터가 가리키는 숫자의 합이 target 보다 작을 때
                begin++; //시작 포인터 값 증가 , 배열이 정렬 되어 있기에 포인터 값이 증가하면 전체 합 이 증가 할 것
            }
            else if(A[begin] + A[end] > target){ //양쪽 포인터가 가리키는 숫자의 합이 target 보다 클 때
                end--; //끝 포인터 값 감소 , 배열이 정렬 되어 있기에 포인터 값이 감소하면 전체 합 이 감소 할 것
            }
            else if (A[begin] + A[end] == target){ //양쪽 포인터가 가리키는 숫자의 합이 target 과 같다면
                end--; // 마지막 포인터 값 감소
                begin++; //시작 포인터 값 증가
                cnt++; //찾은 개수 를 뜻하는 count 증가
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(cnt+"\n");
        bw.flush();
        bw.close();
    }


}