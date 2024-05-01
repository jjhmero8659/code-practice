package Greedy;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_19941 {
    static String str;
    static int N,K;
    static char[] arr;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        str = br.readLine();

        arr = str.toCharArray();
        solution();

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }

    static void solution(){
        for (int i=0; i<arr.length; i++){
            if (arr[i] == 'P'){ //사람 이라면
                boolean find = false;

                //왼쪽에서부터 가장 먼 햄버거
                for (int j=K; j>=1; j--){
                    if ((i-j) >= 0){
                        if(arr[i-j] == 'H'){
                            arr[i-j] = 'E';
                            cnt++;
                            find = true;
                            break;
                        }
                    }
                }

                //왼쪽에서 먹을 수 있는 햄버거가 없다면 오른쪽에서 가장 가까운 햄버거
                if (find == false){
                    for (int j=1; j<=K; j++){
                        if ((i+j) < arr.length){
                            if(arr[i+j] == 'H'){
                                arr[i+j] = 'E';
                                cnt++;
                                find = true;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }
}