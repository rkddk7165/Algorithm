import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] board;
    static boolean[][] visited;
    static int R, C, K;
    static int count = 0;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++){
            String line = br.readLine();
            for (int j = 0; j < C; j++){
                if(line.charAt(j) == 'T'){
                    board[i][j] = 1;
                }
            }
        }

        dfs(R - 1, 0, 1);

        bw.write(count + "\n");
        bw.flush();
        br.close();

    }

    private static void dfs(int x, int y, int moved) {


        if (moved == K && x == 0 && y == C - 1){
            count++;
            return;
        }


        visited[x][y] = true;
        for(int i = 0; i < 4; i++){
            int curX = x + dx[i];
            int curY = y + dy[i];

            // 보드 바깥일 경우
            if (curX < 0 || curY < 0 || curX >= R || curY >= C) continue;

            // 장애물일 경우
            if (board[curX][curY] == 1) continue;
            // 이미 방문한 경우
            if (visited[curX][curY]) continue;

            visited[curX][curY] = true;
            dfs(curX, curY, moved + 1);

            //더 이상 갈 곳 없을 경우 혹은 경우의수 찾은 경우 다시 되돌아옴 (백트래킹)
            visited[curX][curY] = false;
        }
    }
}