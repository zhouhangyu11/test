import java.io.File;
import java.io.IOException;
import java.util.Scanner;
//zhouhangyuniubi
public class TestSort {
    public static final int x = 100000;

    public static void main(String[] args) throws IOException {
        File file = new File("Test.txt");
        if (file.exists()) {
            BuddleSort(file);
            Scanner scanner = new Scanner(file);
            System.out.println("现在开始进行快速排序，排序100000个数据用时：");
            int[] a = new int[x];
            for (int i = 0; i < x; i++)
                a[i] = scanner.nextInt();
            long t1 = System.currentTimeMillis() ;
            QuickSOrt(a, 0, a.length - 1);
            long t2 = System.currentTimeMillis() ;
            System.out.println("排序用时：" + (t2 - t1) + "毫秒");

        }


    }

    public static void BuddleSort(File file) throws IOException {
        Scanner scanner = new Scanner(file);
        System.out.println("现在开始进行冒泡排序，排序100000个数据用时：");

        int[] a = new int[x];
        for (int i = 0; i < x; i++)
            a[i] = scanner.nextInt();
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < x - 1; i++) {
            int flag = 0;
            for (int j = 0; j < x - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp;
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = 1;
                }
            }
            if (flag == 0)
                break;
        }
        long time2 = System.currentTimeMillis();
        System.out.println("排序用时：" + (time2 - time1) + "毫秒");
    }

    public static int Partition(int[] a, int low, int high) {
        int pivotkey = a[low];
        while (low < high) {
            while (low < high && a[high] >= pivotkey)
                high--;
            a[low] = a[high];
            while (low < high && a[low] <= pivotkey)
                low++;
            a[high] =a[low];
        }
        a[low] =pivotkey;
        return low;
    }

    public static void QuickSOrt(int[] a, int low, int high) {
        if (low < high) {
            int pivot = Partition(a, low, high);
            QuickSOrt(a, low, pivot - 1);
            QuickSOrt(a, pivot + 1, high);
        }
    }
}



