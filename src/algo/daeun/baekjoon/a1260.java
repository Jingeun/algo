package algo.daeun.baekjoon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class vertex {
	int num;

	vertex(int v) {
		num = v;
	}
}

/**
 * https://www.acmicpc.net/problem/1260
 */
public class a1260 {
	static int[][] arr;
	static int[] visited;
	static int[] result;
	static int n, m, v;

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		// Scanner s = new Scanner(System.in);
		Scanner s = new Scanner(new File("resources/algo.daeun.baekjoon/1260.txt"));

		n = s.nextInt();
		m = s.nextInt();
		v = s.nextInt();
		arr = new int[n + 1][n + 1];
		visited = new int[n + 1];
		result = new int[n + 1];
		for (int i = 1; i <= m; i++) {
			int tmp, tmp2;
			tmp = s.nextInt();
			tmp2 = s.nextInt();
			arr[tmp][tmp2] = arr[tmp2][tmp] = 1;
		}
		dfs(v);
		System.out.println();
		bfs(v);

	}

	static void dfs(int v) {
		vertex w = new vertex(v);
		int count = 1;
		Stack<vertex> s = new Stack<vertex>();
		s.push(w);

		visited[v] = 1;
		vertex pop;

		while (!s.isEmpty()) {
			pop = (vertex) s.pop();
			visited[pop.num] = 1;
			if (count <= n)
				result[count++] = pop.num;
			for (int i = n; i >= 1; i--) {
				if (arr[pop.num][i] == 1 && visited[i] == 0) {
					vertex u = new vertex(i);
					s.push(u);
				}
			}
		}
		for (int i = 1; i <= n; i++)
			System.out.print(result[i] + " ");

	}

	static void bfs(int v) {
		visited = new int[n + 1];
		result = new int[n + 1];
		int w = v, count = 1, tmp;
		Queue q = new LinkedList();
		q.offer(w);
		visited[w] = 1;
		while (!q.isEmpty()) {
			tmp = (int) q.poll();
			for (int i = 1; i <= n; i++) {
				if (arr[tmp][i] == 1 && visited[i] == 0) {
					q.offer(i);
					visited[i] = 1;

				}
			}
			if (count <= n)
				result[count++] = tmp;

		}

		for (int i = 1; i <= n; i++)
			System.out.print(result[i] + " ");
	}

}