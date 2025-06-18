package week_11;

import java.util.*;

public class PGS_체육복 {

    public int solution(int totalStudents, int[] lostList, int[] extraList) {
        List<Integer> lostOnly = new ArrayList<>();
        List<Integer> spareOnly = new ArrayList<>();

        // 여벌도 있고 도난도 당한 학생 제거
        for (int lostNum : lostList) {
            if (!has(extraList, lostNum)) {
                lostOnly.add(lostNum);
            }
        }

        for (int extraNum : extraList) {
            if (!has(lostList, extraNum)) {
                spareOnly.add(extraNum);
            }
        }

        // 체육복 빌려주기
        for (int lender : spareOnly) {
            if (lostOnly.contains(lender - 1)) {
                lostOnly.remove(Integer.valueOf(lender - 1));
            } else if (lostOnly.contains(lender + 1)) {
                lostOnly.remove(Integer.valueOf(lender + 1));
            }
        }

        return totalStudents - lostOnly.size();
    }

    // 배열 안에 값 있는지 확인
    private boolean has(int[] array, int number) {
        for (int num : array) {
            if (num == number) return true;
        }
        return false;
    }

    // 테스트용 main 메서드
    public static void main(String[] args) {
        PGS_체육복 test = new PGS_체육복();
        System.out.println(test.solution(5, new int[]{2, 4}, new int[]{1, 3, 5})); // 5
        System.out.println(test.solution(5, new int[]{2, 4}, new int[]{3}));       // 4
        System.out.println(test.solution(3, new int[]{3}, new int[]{1}));          // 2
    }
}
