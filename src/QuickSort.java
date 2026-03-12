/**
 * 快速排序算法实现
 * 时间复杂度：平均O(n log n)，最坏O(n^2)
 * 空间复杂度：O(log n)
 * 稳定性：不稳定排序
 */
public class QuickSort {
    
    /**
     * 快速排序主方法
     * @param arr 待排序数组
     */
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }
    
    /**
     * 递归快速排序
     * @param arr 待排序数组
     * @param low 起始索引
     * @param high 结束索引
     */
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 获取分区点
            int pivotIndex = partition(arr, low, high);
            
            // 递归排序左半部分
            quickSort(arr, low, pivotIndex - 1);
            
            // 递归排序右半部分
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    /**
     * 分区函数 - 使用最后一个元素作为基准
     * @param arr 待分区数组
     * @param low 起始索引
     * @param high 结束索引
     * @return 基准元素的正确位置
     */
    private static int partition(int[] arr, int low, int high) {
        // 选择最后一个元素作为基准
        int pivot = arr[high];
        
        // 小于基准的元素的索引
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            // 如果当前元素小于或等于基准
            if (arr[j] <= pivot) {
                i++;
                // 交换arr[i]和arr[j]
                swap(arr, i, j);
            }
        }
        
        // 将基准元素放到正确的位置
        swap(arr, i + 1, high);
        
        return i + 1;
    }
    
    /**
     * 交换数组中的两个元素
     * @param arr 数组
     * @param i 第一个元素的索引
     * @param j 第二个元素的索引
     */
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    /**
     * 打印数组
     * @param arr 要打印的数组
     */
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    /**
     * 测试主方法
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 测试用例1：普通数组
        int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("原始数组1:");
        printArray(arr1);
        
        quickSort(arr1);
        System.out.println("排序后数组1:");
        printArray(arr1);
        System.out.println();
        
        // 测试用例2：已排序数组
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("原始数组2（已排序）:");
        printArray(arr2);
        
        quickSort(arr2);
        System.out.println("排序后数组2:");
        printArray(arr2);
        System.out.println();
        
        // 测试用例3：逆序数组
        int[] arr3 = {7, 6, 5, 4, 3, 2, 1};
        System.out.println("原始数组3（逆序）:");
        printArray(arr3);
        
        quickSort(arr3);
        System.out.println("排序后数组3:");
        printArray(arr3);
        System.out.println();
        
        // 测试用例4：包含重复元素的数组
        int[] arr4 = {3, 7, 3, 2, 7, 2, 1, 1};
        System.out.println("原始数组4（包含重复）:");
        printArray(arr4);
        
        quickSort(arr4);
        System.out.println("排序后数组4:");
        printArray(arr4);
        System.out.println();
        
        // 测试用例5：空数组
        int[] arr5 = {};
        System.out.println("测试空数组:");
        quickSort(arr5);
        System.out.println("空数组排序完成");
        System.out.println();
        
        // 测试用例6：单个元素数组
        int[] arr6 = {42};
        System.out.println("原始数组6（单个元素）:");
        printArray(arr6);
        
        quickSort(arr6);
        System.out.println("排序后数组6:");
        printArray(arr6);
        
        // 性能测试
        System.out.println("\n=== 性能测试 ===");
        int size = 10000;
        int[] performanceArr = new int[size];
        for (int i = 0; i < size; i++) {
            performanceArr[i] = (int)(Math.random() * 10000);
        }
        
        long startTime = System.currentTimeMillis();
        quickSort(performanceArr);
        long endTime = System.currentTimeMillis();
        
        // 验证排序结果
        boolean isSorted = true;
        for (int i = 1; i < performanceArr.length; i++) {
            if (performanceArr[i] < performanceArr[i - 1]) {
                isSorted = false;
                break;
            }
        }
        
        System.out.println("排序" + size + "个随机数用时: " + (endTime - startTime) + "毫秒");
        System.out.println("排序验证: " + (isSorted ? "成功" : "失败"));
    }
}