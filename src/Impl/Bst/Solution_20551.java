package Impl.Bst;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_20551 {
    static int N, M;
    static long[] nums;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); //원소 개수
        M = Integer.parseInt(st.nextToken()); //질문 개수

        nums = new long[N];

        for (int i=0; i<N; i++){
            nums[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(nums);
        //power 값에 따른 정렬

        for (int i = 0; i < M; i++) {
            long findData = Long.parseLong(br.readLine());

            bw.write(bst(findData) + "\n");
        }

        bw.flush();
        bw.close();
    }

    static int bst(long target){
        int start = 0;
        int end = N-1;
        int answerIdx = Integer.MAX_VALUE;

        while (start <= end){
            int mid = (start + end) / 2;

            if (target <= nums[mid]){
                if (target == nums[mid]){
                    answerIdx = Math.min(answerIdx,mid);
                }
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return answerIdx == Integer.MAX_VALUE ? -1 : answerIdx;
    }
}