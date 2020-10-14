public class PowerOf2_001 {
    public static boolean isPowerOf2(int num) {
        int temp = 1;
        while (temp <= num) {
            if (temp == num) {
                return true;
            }
            temp = temp * 2;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOf2(32));
        System.out.println(isPowerOf2(19));
    }
}
