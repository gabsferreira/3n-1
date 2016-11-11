import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			System.out.print(i + " " + j);
			processa(i, j);
		}

	}
	
	static long cache[] = new long[1000001]; 

	private static void processa(int i, int j) {
		if(i > j) {
			processa(j,i);
			return;
		}
		long maior = 1;

		for (int x = i; x <= j; x++) {
			long quantidade;
			if(cache[x] != 0) {
				quantidade = cache[x];
			} else {
				quantidade = contaParaGenial(x);
				cache[x] = quantidade;
			}
			if (quantidade > maior)
				maior = quantidade;
		}
		System.out.println(" " + maior);
	}
	
	private static long contaParaGenial(long x) {
		if(x == 1) return 1;
		
		if(x <= 1000000 &&  cache[(int) x] != 0) {
			return cache[(int) x];
		}
		
		long quantidade = processaParImpar(x);
		if(x <= 1000000) cache[(int) x ] = quantidade;
		return quantidade;	
	}

	private static long processaParImpar(long x) {
		if(x % 2 == 0) {
			long quantidade = contaParaGenial(x / 2) + 1;
			return quantidade;
		} else {
			long quantidade = contaParaGenial(x * 3 + 1) + 1;
			return quantidade;
		}
	}

	private static long contaPara(long x) {
		long quantidade = 0;

		// System.out.println(x);
		quantidade++;
		while (x != 1) {
			if (x % 2 == 0) {
				x = x / 2;
			} else {
				x = x * 3 + 1;
			}
			quantidade++;
			// System.out.println(x);
		}

		return quantidade;
	}

}
