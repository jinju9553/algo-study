package swea.D3.swea1493;

import java.util.*;
import java.io.*;
import java.awt.Point;

class Solution
{
	private static final int MAX_SIZE = 300;
	
	private static Map<Integer, Point> map = new HashMap<>();
	private static int[][] matrix = new int[MAX_SIZE + 1][MAX_SIZE + 1]; //0�� ��� �� ��
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		//1.��Ģ�� �°� matrix�� ����
		initializeMatrix();
		
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			String[] temp = br.readLine().split(" ");
			
			int p = Integer.parseInt(temp[0]);
			int q = Integer.parseInt(temp[1]);
			
			//2.�־��� ���� ����
			Point p1 = map.get(p);
			Point p2 = map.get(q);
			
			int nx = p1.x + p2.x;
			int ny = p1.y + p2.y;
			
			int answer = matrix[ny][nx];
			
			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

	private static void initializeMatrix() {
		//������ �ʱ�ȭ
		int k = 1;
		matrix[1][1] = 1;
		map.put(matrix[1][1], new Point(1, 1));
		
		for(int i = 2; i <= MAX_SIZE; i++) {
			matrix[i][1] = matrix[i - 1][1] + (k++);
			map.put(matrix[i][1], new Point(1, i)); //row & col ���� ����
		}
		
		//������ �ʱ�ȭ
		k = 2;
		for(int i = 1; i <= MAX_SIZE; i++) {
			for(int j = 2; j <= MAX_SIZE; j++) {
				matrix[i][j] = matrix[i][j - 1] + (k + j - 2);
				map.put(matrix[i][j], new Point(j, i)); //row & col ���� ����
			}
			k++;
		}
	}
    
}