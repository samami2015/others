public class KDigits_001 {
    public static String removeKDigits(String num, int k) {
        for (int i = 0; i < k; i++) {
            boolean hasCut = false;
            for (int j = 0; j < num.length() - 1; j++) {
                if (num.charAt(j) > num.charAt(j + 1)) {
                    num = num.substring(0, j) + num.substring(j + 1, num.length());
                    hasCut = true;
                    break;
                }
            }
            if (!hasCut) {
                num = num.substring(0, num.length() - 1);
            }
        }
        int start = 0;
        for (int j = 0; j < num.length() - 1; j++) {
            if (num.charAt(j) != '0') {
                break;
            }
            start++;
        }
        num = num.substring(start, num.length());
        if (num.length() == 0) {
            return "0";
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(removeKDigits("1593212", 3)); //153212 -> 13212 -> 1212
        System.out.println(removeKDigits("30200", 1)); //200
        System.out.println(removeKDigits("10", 2)); // 0
        System.out.println(removeKDigits("541270936", 3)); //41270936 -> 1270936 -> 120936
    }
}
