import java.util.*;

class Solution {
	public String[] solution(String[] files) {
		PriorityQueue<String[]> pq = new PriorityQueue<>((a, b) -> {
			String aHead = a[0].toUpperCase();
			String bHead = b[0].toUpperCase();

			if (aHead.equals(bHead)) {
				int numCompare = Integer.compare(Integer.parseInt(a[1]), Integer.parseInt(b[1]));

				if (numCompare == 0) {
					return Integer.compare(Integer.parseInt(a[3]), Integer.parseInt(b[3]));
				}

				return numCompare;
			} else {
				return aHead.compareTo(bHead);
			}
		});

		int curIdx = 0;
		int headIdx, numberIdx;
		for (String file : files) {
			headIdx = 0;
			char[] fileBits = file.toCharArray();
			while (!Character.isDigit(fileBits[headIdx])) {
				headIdx++;
			}

			numberIdx = headIdx;
			while (numberIdx < file.length() && Character.isDigit(fileBits[numberIdx])) {
				numberIdx++;
			}

			pq.offer(new String[] {
				file.substring(0, headIdx), file.substring(headIdx, numberIdx),
				file.substring(numberIdx), String.valueOf(curIdx)
			});

			curIdx++;
		}

		String[] results = new String[files.length];
		StringBuilder sb;
		int resultIdx = 0;
		while (!pq.isEmpty()) {
			String[] cur = pq.poll();
			sb = new StringBuilder();
			sb.append(cur[0]).append(cur[1]).append(cur[2]);

			results[resultIdx++] = sb.toString();
		}

		return results;
	}
}