package boj.silver.boj1992;

import java.io.*;

public class Main {

	private static int[][] matrix;
	
	private static StringBuilder sb;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		matrix = new int[N][N];
		
		sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			String line = br.readLine();
			for(int j = 0; j < N; j++) {
				matrix[i][j] = line.charAt(j) - '0';
			}
		}
		
		quadTree(N, 0, 0);
		
		System.out.println(sb);
	}
	
	/**
	 * @param size : �� ���� ũ��
	 * @param r : �������� row
	 * @param c : �������� col
	 */
	private static void quadTree(int size, int r, int c) {
		//��� ���� ��Ʈ��� ����
		if(isAllSameBit(size, r, c)) {
			sb.append(matrix[r][c]);
			return;
		}
		
		if(size == 2) { // 2 * 2 matrix���� �ɰ����� ��
			sb.append("(");
			for(int i = r; i < r + size; i++) {
				for(int j = c; j < c + size; j++) {
					sb.append(matrix[i][j]);
				}
			}
			sb.append(")");
			
			return;
		}
		
		sb.append("("); //��͸� �����ϸ� ��ȣ ����
		int newSize = size / 2;
		quadTree(newSize, r, c);
		quadTree(newSize, r, c + newSize);
		quadTree(newSize, r + newSize, c);
		quadTree(newSize, r + newSize, c + newSize);
		sb.append(")"); //4��� ��Ͱ� ������ ��ȣ �ݱ�
	}

	private static boolean isAllSameBit(int size, int r, int c) {
		int initialBit = matrix[r][c];
		
		for(int i = r; i < r + size; i++) {
			for(int j = c; j < c + size; j++) {
				if(matrix[i][j] != initialBit) return false;
			}
		}
		
		return true;
	}
	
}
