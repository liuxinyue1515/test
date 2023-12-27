
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextInt()) {
            int n = scanner.nextInt();
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int[] nums = new int[n];
            int minNum = Integer.MAX_VALUE, maxNum = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                nums[i] = num;
                minNum = Math.min(minNum, num);
                maxNum = Math.max(maxNum, num);
                if (!hashMap.containsKey(num)) {
                    hashMap.put(num, 1);
                } else {
                    hashMap.put(num, hashMap.get(num) + 1);
                }
            }
            Arrays.sort(nums);
            int min = 0, max;
            if (minNum == maxNum) {
                Integer integer = hashMap.get(minNum);
                max = (integer * (integer - 1)) / 2;
            } else {
                Integer minCounts = hashMap.get(minNum);
                Integer maxCounts = hashMap.get(maxNum);
                max = maxCounts * minCounts;
            }

            int minValue = Integer.MAX_VALUE;
            for (int i = 0; i < n - 1; i++) {
                minValue = Math.min(nums[i+1] - nums[i], minValue);
            }

            if (minValue != 0) {
                min = 1;
            } else {
                for (Integer integer : hashMap.keySet()) {
                    Integer counts = hashMap.get(integer);
                    if (counts > 1) {
                        min += (counts * (counts - 1)) / 2;
                    }
                }
            }

            System.out.println(min + " " + max);
        }
    }
}