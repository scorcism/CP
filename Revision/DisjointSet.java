import java.util.ArrayList;
import java.util.List;

class Disjoint_Set {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public Disjoint_Set(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findUparent(int node) {
        if (node == parent.get(node)) {
            return node;
        }

        int ulp = findUparent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUparent(u);
        int ulp_v = findUparent(v);

        if (ulp_u == ulp_v)
            return;

        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);

        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);

        } else {
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }
}

public class DisjointSet {

    public static void main(String[] args) {
        Disjoint_Set ds = new Disjoint_Set(7);

        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // 3 and 7 are same or not
        if (ds.findUparent(3) == ds.findUparent(7)) {
            System.out.println("same");
        } else {
            System.out.println("Not same");
        }

        ds.unionByRank(3, 7);
        if (ds.findUparent(3) == ds.findUparent(7)) {
            System.out.println("same");
        } else {
            System.out.println("Not same");
        }

    }
}
