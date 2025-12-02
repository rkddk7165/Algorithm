import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] city;
    static ArrayList<Node> chicken = new ArrayList<Node>();
    static ArrayList<Node> house = new ArrayList<>();
    static int answer;
    static boolean[] selected;
    static int N, M;

    public static class Node{
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        city = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1){
                    house.add(new Node(i, j));
                }
                else if (tmp == 2){
                    chicken.add(new Node(i, j));
                }
                city[i][j] = tmp;
            }
        }

        answer = Integer.MAX_VALUE;
        selected = new boolean[chicken.size()];

        dfs(0, 0);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();


    }

    private static void dfs(int idx, int cnt) {
        //idx = 지금 보고 있는 치킨집 인덱스
        //cnt = 지금까지 선택한 치킨집 개수

        // 1. M개의 치킨집을 모두 고른 경우 -> 도시 치킨 거리 계산
        if (cnt == M) {
            calculateDistance();
            return;
        }

        if (idx == chicken.size()) {
            return;
        }

        //가능한 모든 조합의 경우 (선택되거나 안되거나)
        selected[idx] = true;
        dfs(idx+1, cnt+1);

        selected[idx] = false;
        dfs(idx+1, cnt);
    }

    private static void calculateDistance() {
        int sum = 0;

        // 각 집에 대한 최소거리 찾기
        for (Node h : house) {
            int minDist = Integer.MAX_VALUE;

            for (int i = 0; i < chicken.size(); i++) {
                if(!selected[i]) continue;

                Node c = chicken.get(i);
                int dist = Math.abs(h.x - c.x) + Math.abs(h.y - c.y);

                if (dist < minDist) {
                    minDist = dist;
                }
            }
            sum += minDist;
        }
        answer = Math.min(answer, sum);
    }


}