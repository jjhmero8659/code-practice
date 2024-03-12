import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_1966 {
    public static int questionN;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        for (int qn=1; qn<=questionN; qn++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken()); //문서 개수
            int m = Integer.parseInt(st.nextToken()); //찾아야 할 문서

            Queue<int[]> queue = new LinkedList<int[]>();


            for (int i=1; i<=n; i++){
                StringTokenizer stD = new StringTokenizer(br.readLine() , " ");

            }
        }

    }

}