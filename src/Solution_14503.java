import java.io.*;
import java.util.StringTokenizer;


public class Solution_14503 {
    static int[] dx = {-1 , 0 , 1, 0}; //북 동 남 서
    static int[] dy = {0 , 1 , 0, -1}; //북 동 남 서

    static int[][] map;
    static int n,m,r,c,d;
    static int count = 1;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stF = new StringTokenizer(br.readLine()," ");
        
        n = Integer.parseInt(stF.nextToken()); 
        m = Integer.parseInt(stF.nextToken());
        map = new int[n][m]; // 지도

        StringTokenizer stS = new StringTokenizer(br.readLine()," ");

        r = Integer.parseInt(stS.nextToken()); //청소기 초기 x 좌표
        c = Integer.parseInt(stS.nextToken()); //청소기 초기 y 좌표
        d = Integer.parseInt(stS.nextToken()); //현재 바라보는 방향
        

        for (int i=0; i<n; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");
            
            for (int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(stD.nextToken()); // 지도 채우기
            }
        }

        clean(r,c,d);
        
        bw.write(count +"\n");
        bw.flush();
        bw.close();
    }
    
    static void clean(int x, int y, int dir){ //청소
        map[x][y] = -1; //현재 자리 청소
        
        for (int i=0; i<4; i++){ //4방향 순회 , 현재 위치 , 현재 바라보는 방향 부터 반시계
            dir = (dir + 3) % 4;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >=0 && ny >=0 && nx < n && ny < m){
                if (map[nx][ny] == 0){
                    count++;
                    clean(nx,ny,dir);

                    return;
                }
            }
        }

        //네 방향 모두 청소가 이미 되어있거나 벽인 경우
        //뒤쪽 칸이 벽이 아니라는 전제 하에, 바라보는 방향을 유지한 채로 한 칸 후진.
        int d = (dir + 2) % 4; //반대 방향으로 후진
        int bx = x + dx[d];
        int by = y + dy[d];
        if(bx >= 0 && by >= 0 && bx < n && by < m && map[bx][by] != 1) {
            clean(bx, by, dir); //후진이니까 바라보는 방향은 유지
        }
    }
    
}