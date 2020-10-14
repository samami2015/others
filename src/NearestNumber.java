import java.util.Arrays;

public class NearestNumber {
    public static int[] findNearestNumber(int[] numbers) {
        int index = findTransferPoint(numbers);
        if (index == 0) {
            return null;
        }
        int[] numbersCopy = Arrays.copyOf(numbers, numbers.length);
        exchangeHead(numbersCopy, index);
        reverse(numbersCopy,index);
        return numbersCopy;
    }

    private static int[] reverse(int[] numbers, int index) {
        for(int i=index,j=numbers.length-1;i<j;i++,j--){
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
        return numbers;
    }

    private static int[] exchangeHead(int[] numbers, int index) {
        int head = numbers[index-1];
        for(int i=numbers.length-1;i>0;i--){
            if(head<numbers[i]){
                numbers[index-1]=numbers[i];
                numbers[i] = head;
                break;
            }
        }
        return numbers;
    }

    private static int findTransferPoint(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] > numbers[i - 1]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        for (int i=0;i<10;i++){
            numbers = findNearestNumber(numbers);
            outputNumbers(numbers);
        }
    }

    private static void outputNumbers(int[] numbers) {
        for (int i:numbers){
            System.out.println(i);
        }
        System.out.println();
    }
}
