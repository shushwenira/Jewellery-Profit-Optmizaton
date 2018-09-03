package sxk173732;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sxk173732Project6363 {

	static int VERBOSE = 0;
	static int[][] jewellery_profit;

	static class Jewel {
		public int weight, profit, min, max, fine, cap;

		Jewel(int w, int p, int n, int x, int f, int c) {
			weight = w;
			profit = p;
			min = n;
			max = x;
			fine = f;
			cap = c;
		}

		@Override
		public String toString() {
			return weight + " " + profit + " " + min + " " + max + " " + fine + " " + cap;
		}
	}

	static class Pair {
		public int p, n;

		Pair(int p, int n) {
			this.p = p;
			this.n = n;
		}

		@Override
		public String toString() {
			return p + " " + n;
		}
	}

	public static Pair process(int G, Jewel[] items, int n) {

		jewellery_profit = new int[n + 1][G + 1];
		int[][] no_of_solutions = new int[n + 1][G + 1];

		for (int g = 0; g <= G; g++) {
			jewellery_profit[0][g] = 0;
			no_of_solutions[0][g] = 1;
		}

		for (int i = 1; i <= n; i++) {

			for (int g = 0; g <= G; g++) {

				int max_quantity = items[i].max;
				int item_weight = items[i].weight;
				int ratio = g / item_weight;
				int quantity_supplied = Integer.min(max_quantity, ratio);
				jewellery_profit[i][g] = Integer.MIN_VALUE;

				for (int k = 0; k <= quantity_supplied; k++) {
					int fine = 0;

					if (k < items[i].min) {
						fine = items[i].fine * (items[i].min - k);
						fine = Integer.min(fine, items[i].cap);
					}

					int value = k * items[i].profit + jewellery_profit[i - 1][g - items[i].weight * k] - fine;

					if (jewellery_profit[i][g] < value) {
						jewellery_profit[i][g] = value;
					}
				}
				for (int k = 0; k <= quantity_supplied; k++) {
					int fine = 0;

					if (k < items[i].min) {
						fine = items[i].fine * (items[i].min - k);
						fine = Integer.min(fine, items[i].cap);
					}

					int value = k * items[i].profit + jewellery_profit[i - 1][g - items[i].weight * k] - fine;

					if (jewellery_profit[i][g] == value) {
						no_of_solutions[i][g] = no_of_solutions[i][g] + no_of_solutions[i - 1][g - items[i].weight * k];
					}
				}
			}
		}

		return new Pair(jewellery_profit[n][G], no_of_solutions[n][G]);
	}

	public static void calculate_solution(Jewel[] items, int n, int G, int[] solutions) {
		if (n > 0) {
			int max_quantity = items[n].max;
			int item_weight = items[n].weight;
			int ratio = G / item_weight;
			int quantity_supplied = Integer.min(max_quantity, ratio);

			for (int k = 0; k <= quantity_supplied; k++) {
				int fine = 0;

				if (k < items[n].min) {
					fine = items[n].fine * (items[n].min - k);
					fine = Integer.min(fine, items[n].cap);
				}

				int value = k * items[n].profit + jewellery_profit[n - 1][G - items[n].weight * k] - fine;

				if (jewellery_profit[n][G] == value) {
					solutions[n - 1] = k;
					calculate_solution(items, n - 1, G - items[n].weight * k, solutions);
				}
			}
		} else {
			int solutions_size = solutions.length;
			for (int j = 0; j < solutions_size; j++) {
				System.out.print(solutions[j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in;
		if (args.length == 0 || args[0].equals("-")) {
			in = new Scanner(System.in);
		} else {
			File inputFile = new File(args[0]);
			in = new Scanner(inputFile);
		}
		if (args.length > 1) {
			VERBOSE = Integer.parseInt(args[1]);
		}

		int G = in.nextInt();
		int n = in.nextInt();
		Jewel[] items = new Jewel[n + 1];
		for (int i = 0; i < n; i++) {
			int index = in.nextInt();
			int weight = in.nextInt();
			int profit = in.nextInt();
			int min = in.nextInt();
			int max = in.nextInt();
			int fine = in.nextInt();
			int cap = in.nextInt();
			items[index] = new Jewel(weight, profit, min, max, fine, cap);
		}

		in.close();
		long start = System.getTime();
		Pair answer = process(G, items, n);
		System.out.println(answer);

		if (VERBOSE > 0) {
			calculate_solution(items, n, G, new int[n]);
		}
		long end = System.getTime();
		
		System.out.println("Time taken: "+ (end-start)/1000);
	}
}
