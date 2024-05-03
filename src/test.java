import java.io.*;
import java.util.*;
import java.util.function.Function;


public class test {
    static int n;
    static int[] dx = {0, 0, 1, -1}; //동 서 남 북 순서
    static int[] dy = {1, -1, 0, 0};
    static double[] percent = new double[4];
    static boolean[][] visited = new boolean[30][30];
    static double resultPercent = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();

        for (int i = 0; i < 4; i++) {
            percent[i] = scan.nextInt() * 0.01;
        }

        dfs(15, 15, 0, 1);
        System.out.println(resultPercent);
    }

    public static void dfs(int x, int y, int idx, double total) {
        if (idx == n) {
            resultPercent += total;
            return;
        }

        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < 30 && ny < 30) {
                if (visited[nx][ny] == false) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, idx + 1,total * percent[i]);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}