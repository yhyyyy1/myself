package org.example.writtenexamination.xiaohongshu;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class T1 {
    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        n = in.nextInt();
        m = in.nextInt();
        in.nextLine();

        int count = n * m;

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = in.nextLine().toCharArray();
        }

        Set<int[]> set = new HashSet<int[]>();

        int[] coordinate = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                coordinate = new int[]{i, j};
                set.clear();
                set.add(coordinate);
                while (true) {
                    if (map[coordinate[0]][coordinate[1]] == 'F') {
                        reFIxMap(map, set, 'F');
                        count--;
                        break;
                    } else if (map[coordinate[0]][coordinate[1]] == 'T' || map[coordinate[0]][coordinate[1]] == 'M') {
                        reFIxMap(map, set, 'T');
                        break;
                    }

                    int a = coordinate[0];
                    int b = coordinate[1];
                    coordinate = move(a, b, map[a][b]);
                    map[a][b] = 'M';

                    if (coordinate == null) {
                        reFIxMap(map, set, 'F');
                        count--;
                        break;
                    } else {
                        set.add(coordinate);
                    }

                }
            }
        }

        System.out.println(count);
    }

    private static int[] move(int i, int j, char op) {
        switch (op) {
            case 'L':
                if (j - 1 < 0) return null;
                else {
                    return new int[]{i, j - 1};
                }
            case 'R':
                if (j + 1 >= m) return null;
                else {
                    return new int[]{i, j + 1};
                }
            case 'U':
                if (i - 1 < 0) return null;
                else {
                    return new int[]{i - 1, j};
                }
            case 'D':
                if (i + 1 >= n) return null;
                else {
                    return new int[]{i + 1, j};
                }
        }
        return null;
    }

    private static void reFIxMap(char[][] map, Set<int[]> set, char op) {
        Iterator<int[]> i = set.iterator();
        while (i.hasNext()) {
            int[] temp = i.next();
            map[temp[0]][temp[1]] = op;
        }
    }
}
