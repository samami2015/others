public class BestGoldMining_003 {
    public static int getBestGoldMining(int w, int[] p, int[] g) {
        int[] results = new int[w + 1];
        for (int i = 1; i < g.length; i++) {
            for (int j = w; j >= 1; j--) {
                if (j >= p[i - 1]) {
                    results[j] = Math.max(results[j], results[j - p[i - 1]] + g[i - 1]);
                }
            }
        }
        return results[w];
    }

    public static void main(String[] args) {
        int w = 10;
        int[] p = {5, 5, 3, 4, 3};
        int[] g = {400, 500, 200, 300, 350};
        System.out.println("最优收益：" + getBestGoldMining(w, p, g));
    }
}
