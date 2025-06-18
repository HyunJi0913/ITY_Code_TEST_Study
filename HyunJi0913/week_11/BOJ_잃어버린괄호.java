package week_11;

public class BOJ_잃어버린괄호 {
    public static void main(String[] args) throws Exception {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String input = sc.nextLine();

        // '-' 기준으로 자름
        String[] parts = input.split("-");

        // 첫 덩어리는 더함
        int result = sumOf(parts[0]);

        // 이후 덩어리는 모두 빼줌
        for (int i = 1; i < parts.length; i++) {
            result -= sumOf(parts[i]);
        }

        System.out.println(result);
    }

    // 덧셈 문자열의 합을 계산 ("50+40" -> 90)
    private static int sumOf(String str) {
        String[] nums = str.split("\\+");
        int total = 0;
        for (String num : nums) {
            total += Integer.parseInt(num);
        }
        return total;
    }
}
