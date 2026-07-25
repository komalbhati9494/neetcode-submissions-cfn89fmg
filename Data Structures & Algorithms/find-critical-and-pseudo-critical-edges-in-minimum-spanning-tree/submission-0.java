class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
      
        int m = edges.length;

        // add index to each edge
        int[][] newEdges = new int[m][4];
        for (int i = 0; i < m; i++) {
            newEdges[i] = new int[]{edges[i][0], edges[i][1], edges[i][2], i};
        }

        // sort by weight
        Arrays.sort(newEdges, (a, b) -> a[2] - b[2]);

        int originalCost = kruskal(n, newEdges, -1, -1);

        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudo = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            // 1️⃣ Exclude edge i
            int costWithout = kruskal(n, newEdges, i, -1);
            if (costWithout > originalCost) {
                critical.add(newEdges[i][3]);
                continue;
            }

            // 2️⃣ Force include edge i
            int costWith = kruskal(n, newEdges, -1, i);
            if (costWith == originalCost) {
                pseudo.add(newEdges[i][3]);
            }
        }

        return Arrays.asList(critical, pseudo);
    }

    private int kruskal(int n, int[][] edges, int skip, int force) {
        UnionFind uf = new UnionFind(n);
        int cost = 0;

        // force include edge
        if (force != -1) {
            int[] e = edges[force];
            if (uf.union(e[0], e[1])) {
                cost += e[2];
            }
        }

        for (int i = 0; i < edges.length; i++) {
            if (i == skip) continue;

            int[] e = edges[i];
            if (uf.union(e[0], e[1])) {
                cost += e[2];
            }
        }

        return uf.count == 1 ? cost : Integer.MAX_VALUE;
    }

    class UnionFind {
        int[] parent;
        int count;

        UnionFind(int n) {
            parent = new int[n];
            count = n;
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa == pb) return false;
            parent[pa] = pb;
            count--;
            return true;
        }
    }
}