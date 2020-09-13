class Solution {
    // 4个方向前进
    int wl, bi, bj;
    int[] ri = {-1, 0, 0, 1};
    int[] cj = {0, -1, 1, 0};
    String waitSearch = null;

    public boolean findCharacter(char[][] board, int di, int dj, boolean[][] visited, int i) {
        boolean judge = false;
        if (i == wl) {
            return true;
        }
        for (int j = 0; j < 4; j++) {
            if ((di+ri[j])<bi && (dj+cj[j])<bj && (di+ri[j])>=0 && (dj+cj[j])>=0 && board[di+ri[j]][dj+cj[j]]==waitSearch.charAt(i) && !visited[di+ri[j]][dj+cj[j]]) {
                visited[di+ri[j]][dj+cj[j]] = true;
                judge = findCharacter(board, di+ri[j], dj+cj[j], visited, i+1);
                visited[di+ri[j]][dj+cj[j]] = false;
                if (judge) {
                    return judge;
                }
            }
        }
        return judge;
    }

    public boolean exist(char[][] board, String word) {
        wl = word.length();
        if (wl == 0) {
            return true;
        }
        waitSearch = word;
        int i, j;
        bi = board.length;
        bj = board[0].length;
        boolean[][] visited = new boolean[bi][bj];
        boolean judge = false;
        for (i = 0; i < bi; i++) {
            for (j = 0; j < bj; j++) {
                visited[i][j] = false;
            }
        }
        for (i = 0; i < bi; i++) {
            for (j = 0; j < bj; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    judge = findCharacter(board, i, j, visited, 1);
                    visited[i][j] = false;
                }
                if (judge) {
                    return judge;
                }
            }
        }
        return judge;
    }
}