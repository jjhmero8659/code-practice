package Greedy;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_2828 {
    static Integer N, M;
    static Integer appleN;
    static int[] drop;
    static Bucket bucket;
    static class Bucket{
        int leftIdx;
        int rightIdx;
        long moveCnt;

        public Bucket(int leftIdx, int rightIdx, long moveCnt) {
            this.leftIdx = leftIdx;
            this.rightIdx = rightIdx;
            this.moveCnt = moveCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); //Screen
        M = Integer.parseInt(st.nextToken()); //Bucket

        appleN = Integer.parseInt(br.readLine()); //사과의 개수

        drop = new int[appleN];

        for (int i=0; i<appleN; i++){
            drop[i] = Integer.parseInt(br.readLine());
        }

        bucket = new Bucket(1,M,0);

        solution();

        bw.write(bucket.moveCnt + "\n");
        bw.flush();
        bw.close();
    }

    static void solution(){
        for (int i=0; i<appleN; i++){
            if (drop[i] < bucket.leftIdx){
                while (drop[i] != bucket.leftIdx){
                    bucket.leftIdx--;
                    bucket.rightIdx--;
                    bucket.moveCnt++;
                }
            }
            else if (drop[i] > bucket.rightIdx){
                while (drop[i] != bucket.rightIdx){
                    bucket.leftIdx++;
                    bucket.rightIdx++;
                    bucket.moveCnt++;
                }
            }
        }
    }
}