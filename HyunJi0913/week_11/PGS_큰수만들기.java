package week_11;

import java.util.*;

public class PGS_큰수만들기 {

    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();

        for (char digit : number.toCharArray()) {
            // 현재 숫자보다 stack의 top이 작으면 pop하면서 k를 줄여나감
            while (!stack.isEmpty() && k > 0 && stack.peek() < digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // 아직 제거할 수가 남았다면 뒤에서 제거
        while (k > 0) {
            stack.pop();
            k--;
        }

        // stack에 남은 숫자를 문자열로 변환
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }

    // 테스트용 main 메서드
    public static void main(String[] args) {
        PGS_큰수만들기 solver = new PGS_큰수만들기();
        System.out.println(solver.solution("1924", 2));        // "94"
        System.out.println(solver.solution("1231234", 3));     // "3234"
        System.out.println(solver.solution("4177252841", 4));  // "775841"
    }
}
