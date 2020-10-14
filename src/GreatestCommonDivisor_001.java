public class GreatestCommonDivisor_001 {
    public static int getGreatestCommonDivisor(int a, int b) {
        int big = a > b ? a : b;
        int small = a < b ? a : b;
        if (big % small == 0) {
            return small;
        }
        for (int i = small / 2; i > 2; i--) {
            if (small % i == 0 && big % i == 0) {
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(25,5));
        System.out.println(getGreatestCommonDivisor(100,80));
        System.out.println(getGreatestCommonDivisor(27,14));
    }
}
