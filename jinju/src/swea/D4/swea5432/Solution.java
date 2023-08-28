package swea.D4.swea5432;

import java.io.*;

class Solution
{
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			String input = br.readLine();
			
			input = input.replace("()", "*");
			
			int stick = 0;
			int result = 0;
			for(int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				
				if (c == '(') {
					stick += 1;
				} else if (c == ')') {
					result += 1; //������ ������ �� ����
					stick -= 1; //���� �ϳ��� ��� �߷� ������
				} else if (c == '*') {
					result += stick; //���� ������ ������ ������ŭ �丷 ����
				}
			}
			
			sb.append("#").append(test_case).append(" ")
				.append(result).append("\n");
		}
		
		System.out.println(sb);
	}
}