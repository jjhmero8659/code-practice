package Impl.Bst;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Solution_2121 {
    static int P,W,H;
    static ArrayList<Point> points = new ArrayList<>();
    static int resultCnt = 0;
    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        P = Integer.parseInt(br.readLine());

        StringTokenizer stP = new StringTokenizer(br.readLine()," ");
        W = Integer.parseInt(stP.nextToken()); //가로 길이
        H = Integer.parseInt(stP.nextToken()); //높이

        for (int i=0; i<P; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine() , " ");

            int x = Integer.parseInt(stD.nextToken());
            int y = Integer.parseInt(stD.nextToken());

            points.add(new Point(x,y));
        }

        Collections.sort(points, (a,b) -> (a.y == b.y ? Integer.compare(a.x,b.x) : Integer.compare(a.y,b.y)));
        //Y좌표 값이 같다면 X좌표 기준으로 정렬
        //다르다면 Y좌표 기준으로 정렬
        
        for (Point now : points){
            Point p2 = new Point(now.x + W , now.y); //x좌표 증가
            Point p3 = new Point(now.x , now.y + H); //y좌표 증가
            Point p4 = new Point(now.x + W, now.y + H); //x좌표 증가 , y좌표 증가

            if (bst(p2) && bst(p3) && bst(p4)){
                //모든 나머지 좌표가 있다면
                resultCnt++;
            }
        }

        bw.write(resultCnt + "\n");
        bw.flush();
        bw.close();
    }

    static boolean bst(Point target){
        int start = 0;
        int end = points.size() - 1;

        while (start <= end){
            int mid = (start + end) / 2;
            Point midPoint = points.get(mid);

            if (midPoint.y > target.y){
                //찾는 값이 중간 값보다 작다면
                end = mid - 1;
            }
            else if (midPoint.y < target.y){
                start = mid + 1;
            }
            else{
                // y 좌표 값이 동일 하다면
                if (midPoint.x > target.x){
                    //중간 값 x좌표 값이 더 크다면
                    end = mid - 1;
                }
                else if(midPoint.x < target.x){
                    start = mid + 1;
                }
                else{
                    return true; //값을 찾음 , x 좌표 y좌표 모두 동일
                }
            }
        }

        return false;
    }
}