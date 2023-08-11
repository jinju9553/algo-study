package boj.gold.boj2042;

import java.io.*;

public class Main {

	private static long[] tree;
	private static long[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] temp = br.readLine().split(" ");
		
		int N = Integer.parseInt(temp[0]);
		int M = Integer.parseInt(temp[1]);
		int K = Integer.parseInt(temp[2]);
		
		arr = new long[N + 1]; //0�� ������� ����
		
		for(int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		tree = new long[4 * N];
		
		init(1, N, 1); //1���� N���� �κ����� �ʱ�ȭ�Ѵ�.
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M + K; i++) {
			temp = br.readLine().split(" ");
			
			int a = Integer.parseInt(temp[0]);
			int b = Integer.parseInt(temp[1]);
			long c = Long.parseLong(temp[2]);
			long diff = 0;
			
			if(a == 1) {
				diff = c - arr[b];
				arr[b] = c;
				update(1, N, 1, b, diff);
			} else if(a == 2) {
				long result = sum(1, N, 1, b, (int)c); //1���� N�� ������ Ž��, b~c ������ ���
				sb.append(result).append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	/**
	 * @param start ���� �ε���
	 * @param end �� �ε���
	 * @param node ��� ��ȣ
	 * @return �� �κ����� ���� ���� �ڱ� �ڽ��� ��尪���� ��´�.
	 */
	private static long init(int start, int end, int node) {
		if(start == end) {
			return tree[node] = arr[start]; //��尪���� �������� �޾��ش�.
		}
		int mid = (start + end) / 2; //�̺� Ž��
		
		return tree[node] 
				= init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
	}
	
	/**
	 * @param start ���� �ε���
	 * @param end �� �ε���
	 * @param node ��� ��ȣ
	 * @param left �������� ã���� �ϴ� ������
	 * @param right �������� ã���� �ϴ� ����
	 * @return
	 */
	private static long sum(int start, int end, int node, int left, int right) {
		if(left > end || right < start) //Ž�� ���� �ۿ� �ִٸ�
			return 0;
		
		if(left <= start && end <= right) //Ž�� ���� �ȿ� �ִٸ�
			return tree[node]; //��尪�� ��ȯ
		
		//�׷��� ������ �� �κ����� ������ �ٽ� Ž��
		int mid = (start + end) / 2;
		
		return sum(start, mid, node * 2, left, right) 
				+ sum(mid + 1, end, node * 2 + 1, left, right);
	}

	/**
	 * @param start ���� �ε���
	 * @param end �� �ε���
	 * @param node ��� ��ȣ
	 * @param index �����ϰ��� �ϴ� ���
	 * @param diff ������ ��
	 * @return
	 */
	private static void update(int start, int end, int node, int index, long diff) {
		if(index < start || index > end) //���� �ۿ� �ִٸ� ����
			return;
		
		//���� �ȿ� ������ �������� �ٸ� ���ҵ� ����
		tree[node] += diff;
		
		if(start == end) 
			return;
		
		int mid = (start + end) / 2;
		
		update(start, mid, node * 2, index, diff);
		update(mid + 1, end, node * 2 + 1, index, diff);
	}
}
