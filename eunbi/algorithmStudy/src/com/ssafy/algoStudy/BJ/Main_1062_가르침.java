package com.ssafy.algoStudy.BJ;
/**
 * K개의 글자를 배워서 이것으로만 이루어진 단어만을 읽을 수 있을 때
 * 어떤 K개의 글자를 가르쳐야 학생들이 읽을 수 있는 단어의 개수가 최대가 되는지 구하지
 * 남극언어의 모든 단어는 "anta"로 시작되고, "tica"로 끝난다.
 * @author SSAFY
 *
 */
public class Main_1062_가르침 {

	public static void main(String[] args) {
		/**
		 * [입력]
		 * 1. 단어의 개수 N, K (1 <= N <= 50, 0 <= K <= 26)
		 * 2~N. 남극 언어의 단어 (8 <= 길이 <= 15)
		 */
		/**
		 * [출력]
		 * 단어 개수의 최댓값
		 */
	}
/**
 *a,n,t,i,c -> 최소 5개는 있어야 단어를 읽을 수 있음.
 *K가 5보다 작으면 읽을 수 있는 단어가 없음.
 *(K - 5)개의 글자 중 가장 많은  
 *
 *[ex1] 6 - 5. 1개의 
 * r - 1개
 * hello
 * r
 * 
 * [ex2] 8 - 5 .3개의
 * b - 1
 * x
 * d
 * e
 * f
 * g
 * h
 * j
 * k
 * 
 * [ex3] 9 - 5. 4개
 * d - 1
 * dfg - 3
 * dfffh - 3
 * dfhj - 4
 * ghj - 3
 * ghjk -4
 * 
 * d ->4개의 단어에 포함
 * f ->3개의 단어에 포함
 * g ->3개의 단어에 포함
 * h ->4개의 단어에 포함
 * j ->3개의 단어에 포함
 * k ->1개의 단어에 포함
 * 
 * 짧은 것부터 ?
 * d, f, g
 */
}