import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.function.Function;


public class test {
    private static final int SIZE = 500;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> stoi = Integer::parseInt;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = stoi.apply(st.nextToken()) + SIZE;
        int y = stoi.apply(st.nextToken()) + SIZE;
        int n = stoi.apply(st.nextToken());
        boolean[][] isBlock = new boolean[2 * SIZE + 1][2 * SIZE + 1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi.apply(st.nextToken()) + SIZE;
            int b = stoi.apply(st.nextToken()) + SIZE;
            isBlock[b][a] = true;
        }
        int result = cal(y, x, isBlock);
        System.out.println(result);
    }

    private static final int[] DY = {-1, 0, 1, 0};
    private static final int[] DX = {0, 1, 0, -1};

    private static int cal(int y, int x, boolean[][] isBlock) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{SIZE, SIZE});
        int time = 0;
        boolean[][] visited = new boolean[2*SIZE+1][2*SIZE+1];
        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int[] now = q.poll();
                if (now[0] == y && now[1] == x) {
                    return time;
                }
                for (int i = 0; i < 4; i++) {
                    int ny = now[0] + DY[i];
                    int nx = now[1] + DX[i];
                    if(ny >= 0 && ny <= 2*SIZE && nx >= 0 && nx <= 2*SIZE && !isBlock[ny][nx] && !visited[ny][nx]){
                        visited[ny][nx] = true;
                        q.offer(new int[]{ny,nx});
                    }
                }
            }
            time++;
        }
        return -1;
    }
}