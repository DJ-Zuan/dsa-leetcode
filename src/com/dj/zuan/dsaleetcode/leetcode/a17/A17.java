package com.dj.zuan.dsaleetcode.leetcode.a17;

import java.util.ArrayList;
import java.util.List;

// StringBuilder有合适的操作，可以让性能继续提升

public class A17 {
    private static final char[] a2 = {'a', 'b', 'c'};
    private static final char[] a3 = {'d', 'e', 'f'};
    private static final char[] a4 = {'g', 'h', 'i'};
    private static final char[] a5 = {'j', 'k', 'l'};
    private static final char[] a6 = {'m', 'n', 'o'};
    private static final char[] a7 = {'p', 'q', 'r', 's'};
    private static final char[] a8 = {'t', 'u', 'v'};
    private static final char[] a9 = {'w', 'x', 'y', 'z'};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() < 1) return result;

        char[] da = digits.toCharArray();
        lc(da, 0, "", result);
        return result;
    }

    private void lc(char[] da, int cur, String prefix, List<String> result) {
        if (cur >= da.length) {
            result.add(prefix);
            return;
        }

        char[] ax = get(da[cur]);
        for (int i = 0; i < ax.length; i++)
            lc(da, cur + 1, prefix + ax[i], result);
    }

    private char[] get(char digit) {
        switch (digit) {
            case '2': return a2;
            case '3': return a3;
            case '4': return a4;
            case '5': return a5;
            case '6': return a6;
            case '7': return a7;
            case '8': return a8;
            case '9': return a9;
        }
        return null;
    }
}
