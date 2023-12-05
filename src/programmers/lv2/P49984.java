package programmers.lv2;

public class P49984 {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    // U 2, D 3 , L 1 R 0
    public int solution(String dirs) {
        int ans = 0;
        boolean[][][] visited = new boolean[11][11][11];
        int[][][][] edge = new int[11][11][11][11];
        int x = 5;
        int y = 5;
        for (int i=0; i<dirs.length(); i++) {
            final String targetString = dirs.substring(i, i + 1);
            int moveX = 0;
            int moveY = 0;
            int curX = x;
            int curY = y;
            int dir = 0;
            // dir 1
            if (targetString.equals("U")) {
                moveX = dx[2];
                moveY = dy[2];
                dir = 3;
                // dir 2
            } else if (targetString.equals("D")) {
                moveX = dx[3];
                moveY = dy[3];
                dir = 0;
                // dir 3
            } else if (targetString.equals("L")) {
                moveX = dx[1];
                moveY = dy[1];
                dir = 1;
                // dir 4
            } else if (targetString.equals("R")) {
                moveX = dx[0];
                moveY = dy[0];
                dir = 2;
            } else {
                System.out.println("Invalid Character");
            }


            if (x+ moveX >=0 && x + moveX <= 10 && y + moveY <= 10 && y + moveY >=0) {
                if (!visited[x][y][dir] && !visited[x+moveX][y+moveY][3-dir]) {
                    visited[x][y][dir] = true;
                    ans++;
                }
                x += moveX;
                y += moveY;
            }
        }


        return ans;
    }
}
