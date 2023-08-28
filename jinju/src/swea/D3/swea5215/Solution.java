package swea.D3.swea5215;

import java.io.*;

class Solution
{
    private static int[] weights;
    private static int[] cals;
    
    private static int[][] DP;
    
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
		for(int test_case = 1; test_case <= T; test_case++) {
			String[] temp = br.readLine().split(" ");
            int N = Integer.parseInt(temp[0]);
            int L = Integer.parseInt(temp[1]);

            weights = new int[N + 1]; //0�� ������� ����
            cals = new int[N + 1]; //0�� ������� ����
            DP = new int[N + 1][L + 1]; //�ִ� Į�θ��� �־������Ƿ� �ε����� ����� �� �ִ�.
            
            for(int i = 1; i <= N; i++) {
                String[] temp2 = br.readLine().split(" ");
                int weight = Integer.parseInt(temp2[0]);
                int cal = Integer.parseInt(temp2[1]);
                
                weights[i] = weight;
                cals[i] = cal;
            }
            
            for(int i = 1; i <= N; i++) { //�������� ���� ��ŭ ��ȸ
            	int currWeight = weights[i];
                int currCal = cals[i];
                
                for(int cal = 1; cal <= L; cal++) { //Į�θ��� �÷����� ��ȸ
                	if(currCal <= cal) { //���� �ִ� Į�θ��� �������� ���ߴٸ� ���ذ���. (ON)
                        DP[i][cal] = Math.max(DP[i - 1][cal - currCal] + currWeight, DP[i - 1][cal]);
                        //���� �迭���� ����, ���� �迭 ���� ������ ��Ḧ ������ �����Ѵ�.
                    }
                    else { //���� Į�θ��� �� ũ�� ���� �迭 ���� �̾ ����. (OFF)
                        DP[i][cal] = DP[i - 1][cal];
                    }
                }
            }
            
            int answer = DP[N][L];
            
            sb.append("#" + test_case + " ").append(answer).append("\n");
		}
        
        System.out.print(sb);
	}
}
