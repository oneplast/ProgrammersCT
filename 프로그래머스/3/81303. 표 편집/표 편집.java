import java.util.*;
import java.util.stream.*;

class Solution {
	public String solution(int n, int k, String[] cmd) {
		int[] prev = new int[n];
		int[] next = new int[n];
		char[] chars = new char[n];
		Stack<int[]> removed = new Stack<>();

		for (int i = 0; i < n; i++) {
			prev[i] = i - 1;
			next[i] = i == n - 1 ? -1 : i + 1;
			chars[i] = 'O';
		}

		int cur = k;
		for (String s : cmd) {
			String[] bits = s.split(" ");
			String alp = bits[0];
			int x = -1;

			if (bits.length == 2) {
				x = Integer.parseInt(bits[1]);
			}

			if (alp.equals("U")) {
				while (x-- > 0) {
					cur = prev[cur];
				}
			} else if (alp.equals("D")) {
				while (x-- > 0) {
					cur = next[cur];
				}
			} else if (alp.equals("C")) {
				removed.add(new int[] {cur, prev[cur], next[cur]});
				chars[cur] = 'X';

				int cp = prev[cur];
				int cn = next[cur];

				if (cp != -1) {
					next[cp] = cn;
				}

				if (cn != -1) {
					prev[cn] = cp;
				}

				cur = cn != -1 ? cn : cp;
			} else {
				int[] pop = removed.pop();
				int idx = pop[0];
				int pPrev = pop[1];
				int pNext = pop[2];

				chars[idx] = 'O';
				prev[idx] = pPrev;
				next[idx] = pNext;

				if (pPrev != -1) {
					next[pPrev] = idx;
				}

				if (pNext != -1) {
					prev[pNext] = idx;
				}
			}
		}

		return new String(chars);
	}
}