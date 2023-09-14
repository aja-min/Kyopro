import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

public class Main {
    // Ctrl + R で実行
    public static String Y = "Yes";
    public static String N = "No";
    // public static long MOD = (long) (Math.pow(10, 9) + 7);
    public static long MOD = 998244353l;
    public static Scanner sc = new Scanner(System.in);
    static String W_QUAT = "\"";

    Set<Integer> sssssssssss = new HashSet<>();
    List<Integer> sssssssssssl = new ArrayList<>();
    Map<Integer, Integer> sssssssssssm = new HashMap<>();

    @SuppressWarnings("boxing")
    public static void main(String[] args) {
        int n = ni();
        long d = nl();
        long p = nl();
        Long[] f = new Long[n];
        long wa = 0l;
        for (int i = 0; i < n; i++) {
            f[i] = nl();
            wa += f[i];
        }
        Arrays.sort(f, Collections.reverseOrder());

        for (int i = 0; i < n; i += d) {
            long dwa = 0l;
            if (i + d > n - 1) {

                for (int k = i; k < n; k++) {
                    dwa += f[k];

                }
                if (dwa >= p) {
                    wa -= (dwa - p);
                }
                break;
            }
            for (int j = 0; j < d; j++) {
                dwa += f[i + j];
            }
            if (dwa >= p) {
                wa -= (dwa - p);
            }
        }
        out(wa);
    }

    static long[] inLongArray(int n) {
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] = nl();
        }
        return res;
    }

    static String[] inStringArray(int n) {
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = n();
        }
        return res;
    }

    static void dispYNByFlg(boolean f) {
        if (f)
            out(Y);
        else
            out(N);
    }

    static int countOccurrences(String str, char ch) {
        int counter = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                counter++;
            }
        }

        return counter;
    }

    public static long ncr(long n, long r) {
        long ue = 1l;
        long sita = 1l;

        for (long i = 0; i < r; i++) {
            ue *= (n - i);
        }
        sita = kaijo(r);

        return ue / sita;
    }

    public static long modPow(long a, long n, long mod) {
        // a^nを計算
        long ans = 1l;
        long tmp = a % mod;

        // わかりやすくfor文の中ですべて処理
        for (;;) {
            // すべての桁を見終わったら終了
            if (n < 1l) {
                break;
            }

            // 最下位bitが1かどうかの判定
            if (n % 2l == 1l) {
                ans *= tmp;
                ans %= mod;
            }

            // tmpの更新
            tmp *= tmp;
            tmp %= mod;

            // nのbitを一つずらす
            n = n >> 1;
        }
        return ans;
    }

    static boolean isRegaxSame(String target, String regax) {
        // Pattern p = Pattern.compile("a*b");
        // Matcher m = p.matcher("aaaaab");
        // boolean b = m.matches();

        return Pattern.compile(regax).matcher(target).matches();
    }

    static char[][] migi90(char[][] a) {
        int n = a.length;
        char[][] s = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s[i][j] = a[n - 1 - j][i];
            }
        }

        return s;
    }

    static boolean arrayEqual(char[][] a, char[][] b) {
        int n = a.length;
        boolean f = true;
        loop: for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[i][j] != b[i][j]) {
                    f = false;
                    break loop;
                }
            }
        }

        return f;
    }

    public static void reverseSort2DArrayBasedOnColumnNumber(double[][] array, final int columnNumber) {
        // https://www.delftstack.com/ja/howto/java/sort-2d-array-java/
        Arrays.sort(array, new Comparator<double[]>() {
            @Override
            public int compare(double[] first, double[] second) {
                // 1-indexed
                if (first[columnNumber - 1] == second[columnNumber - 1])
                    return 0;
                if (first[columnNumber - 1] < second[columnNumber - 1])
                    return 1;
                else
                    return -1;
            }
        });
    }

    public static int[] kousokusoinnsuubunkaihairetsu(int n2) {

        int[] d = new int[n2];
        for (int i = 0; i < n2; i++) {
            d[i] = i;
        }
        for (int i = 2; i * i < n2; i++) {
            for (int j = i * i; j < n2; j += i) {
                if (d[j] == j)
                    d[j] = i;
            }
        }
        return d;
    }

    static int kakuinowa(String a) {
        char[] cl = a.toCharArray();
        int wa = 0;
        for (int i = 0; i < cl.length; i++) {
            wa += Integer.parseInt("" + cl[i]);
        }

        return wa;
    }

    static int[] zahyoasshuku(long[] a) {
        int size = a.length;
        int ret[] = new int[size];

        long[] acopy = a.clone();
        Arrays.sort(acopy);
        Map<Long, Integer> map = new HashMap<>();
        int ind = 0;
        long tmp = acopy[0];
        map.put(tmp, ind);
        for (int i = 1; i < size; i++) {
            if (acopy[i] != tmp) {
                map.put(acopy[i], ++ind);
            }

            tmp = acopy[i];
        }

        for (int i = 0; i < size; i++) {
            ret[i] = map.get(a[i]);
        }

        return ret;
    }

    // n桁で0埋め
    private static String zeroPaddingnketa(String s, int n) {
        String str = s;
        String paddingStr = str.format("%" + n + "s", str).replace(" ", "0");

        return paddingStr;
    }

    public static void outTable(double[][] table) {
        for (int i = 0; i < table.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < table[0].length; j++) {
                sb.append(table[i][j] + " ");
            }
            out(sb.toString().substring(0, sb.length() - 1));
        }
    }

    public static void outTable(long[] table) {

        //for (int i = 0; i < table.length; i++) {
        //		for (int i = 0; i < table.length; i++) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < table.length; j++) {
            sb.append(table[j] + " ");
        }
        out(sb.toString().substring(0, sb.length() - 1));
        //}
    }

    public static void outTable(int[] table) {

        //for (int i = 0; i < table.length; i++) {
        //		for (int i = 0; i < table.length; i++) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < table.length; j++) {
            sb.append(table[j] + " ");
        }
        out(sb.toString().substring(0, sb.length() - 1));
        //}
    }

    public static void outTable(char[] table) {

        //for (int i = 0; i < table.length; i++) {
        //		for (int i = 0; i < table.length; i++) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < table.length; j++) {
            sb.append(table[j] + " ");
        }
        out(sb.toString().substring(0, sb.length() - 1));
        //}
    }

    public static void outTable(int[][] table) {

        for (int i = 0; i < table.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < table[0].length; j++) {
                sb.append(table[i][j] + " ");
            }
            out(sb.toString().substring(0, sb.length() - 1));
        }
    }

    public static void outTable(char[][] table) {

        for (int i = 0; i < table.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < table[0].length; j++) {
                sb.append(table[i][j] + " ");
            }
            out(sb.toString().substring(0, sb.length() - 1));
        }
    }

    public static void permutation(String q, String ans) {

        // Base Case
        if (q.length() <= 1) {
            System.out.println(ans + q);
            //list.add(ans + q);
            //solve(ans + q);

        }
        // General Case
        else {
            for (int i = 0; i < q.length(); i++) {
                permutation(q.substring(0, i) + q.substring(i + 1), ans + q.charAt(i));
            }
        }
    }

    static void debug() {

        out("---");
    }

    static void debug(Object a) {

        out("-------");
        out(a);
        out("-------");
    }

    static int ketasuu(int n) {

        String str = "" + n;
        return str.length();
    }

    static long ketasuu(long n) {

        String str = "" + n;
        return str.length();
    }

    static int stringCount(String str, String target) {
        // strにtargetがいくつ含まれているかを数える

        int count = 0;
        int len = str.length();
        for (int i = 0; i < len - target.length() + 1; i++) {
            if (target.equals(str.substring(i, i + target.length()))) {
                count++;
            }
        }
        return count;
    }

    static int ni() {

        return sc.nextInt();
    }

    static long nl() {

        return sc.nextLong();
    }

    static double nd() {

        return sc.nextDouble();
    }

    static String n() {

        return sc.next();
    }

    static char[] nc() {

        return n().toCharArray();
    }

    static int kaijo(int n) {

        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * kaijo(n - 1);
        }
    }

    static long kaijo(long n) {

        if (n == 0l || n == 1l) {
            return 1l;
        } else {
            return n * kaijo(n - 1l);
        }
    }

    static int fib(int n) {

        return (n == 1 || n == 0) ? n : fib(n - 2) + fib(n - 1);
    }

    static long lcm(long m, long n) {
        long w = gcd(m, n);
        if (m % w == 0l) {
            return (m / w) * n;
        } else {
            return (n / w) * m;
        }

        //		return m * n / gcd(m, n);
    }

    static int lcm(int m, int n) {

        return m * n / gcd(m, n);
    }

    static long gcd(long a, long b) {

        return (b == 0) ? a : gcd(b, a % b);
    }

    static int gcd(int a, int b) {

        return (b == 0) ? a : gcd(b, a % b);
    }

    static void out(Object obj) {

        System.out.println(obj);
    }

    static void outn(Object obj) {

        System.out.print(obj);
    }

    static double max(double d, double e) {

        return Math.max(d, e);
    }

    static int max(int d, int e) {

        return Math.max(d, e);
    }

    static long max(long a, long b) {

        return Math.max(a, b);
    }

    static long min(long d, long e) {

        return Math.min(d, e);
    }

    static double min(double d, double e) {

        return Math.min(d, e);
    }

    static int min(int a, int b) {

        return Math.min(a, b);
    }
}

class XY {

    int h;
    int w;
    int count;
    //	long[] l;
    Set<Long> set;

    XY(int h, int w, int count, Set<Long> set) {
        this.h = h;
        this.w = w;
        this.count = count;
        this.set = new HashSet<>(set);
        //this.d = d;
    }
}

class UnionFind {

    int[] parent;
    int[] rank;

    public UnionFind(int n) {
        // 初期化コンストラクタ
        this.parent = new int[n];
        this.rank = new int[n];

        // 最初はすべてが根
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    /**
     * 要素の根を返す。
     * 経路圧縮付き。（1→3→2となっていて2をfindした際、1→3,2と木の深さを浅くする。）
     *
     * @param x
     * @return 要素xの根
     */
    public int find(int x) {

        if (x == parent[x]) {
            return x;
        } else {
            // 経路圧縮時はrank変更しない
            parent[x] = find(parent[x]);
            return parent[x];
        }
    }

    /**
     * ２つの要素が同じ集合に属するかどうかを返す。
     *
     * @param x
     * @param y
     * @return 同じ集合であればtrue
     */
    public boolean same(int x, int y) {

        return find(x) == find(y);
    }

    /**
     * 要素xが属する集合と要素yが属する集合を連結する。
     * 木の高さ（ランク）を気にして、低い方に高い方をつなげる。（高い方の根を全体の根とする。）
     *
     * @param x
     * @param y
     */
    public void unite(int x, int y) {

        int xRoot = find(x);
        int yRoot = find(y);

        if (xRoot == yRoot) {
            // 属する集合が同じな場合、何もしない
            return;
        }

        // rankを比較して共通の根を決定する。
        // ※find時の経路圧縮はrank考慮しない
        if (rank[xRoot] > rank[yRoot]) {
            // xRootのrankのほうが大きければ、共通の根をxRootにする
            parent[yRoot] = xRoot;
        } else if (rank[xRoot] < rank[yRoot]) {
            // yRootのrankのほうが大きければ、共通の根をyRootにする
            parent[xRoot] = yRoot;
        } else {
            // rankが同じであれば、どちらかを根として、rankを一つ上げる。
            parent[xRoot] = yRoot;
            rank[xRoot]++;
        }
    }
}

class Sh {
    int id;
    int sh;

    Sh(int id, int sh) {

        this.id = id;

        this.sh = sh;
    }

    public int getId() {
        return id;
    }

    public int getSh() {
        return sh;
    }

}

class In {
    long max;
    long min;

    In(long z, long m) {
        max = z;
        min = m;
    }
}

class Pone {
    int h;
    int w;
    int n;

    Pone(int ll, int rr, int n) {
        h = ll;
        w = rr;
        this.n = n;
    }
}

class Node implements Comparable<Node> {

    int tyoten;
    long minDistance;

    public Node(int t, long m) {
        tyoten = t;
        minDistance = m;
    }

    @Override
    public int compareTo(Node o) {
        int res = -1;
        if (this.minDistance - o.minDistance >= 0) {
            res = 1;
        }
        return res;
    }

}
