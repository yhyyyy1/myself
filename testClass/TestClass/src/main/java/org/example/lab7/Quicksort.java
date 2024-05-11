package org.example.lab7;

class Quicksort {
    // 递归快速排序函数
    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            // 分区操作，将数组分为两部分
            int pivotIndex = partition(array, low, high);

            // 递归排序左子数组
            quickSort(array, low, pivotIndex - 1);

            // 递归排序右子数组
            quickSort(array, pivotIndex + 1, high);
        }
    }

    // 分区函数，返回中枢的正确位置
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];  // 选择最后一个元素作为中枢
        int i = (low - 1); // 小于中枢的元素的索引

        for (int j = low; j < high; j++) {
            // 如果当前元素小于或等于中枢
            if (array[j] <= pivot) {
                i++;

                // 交换 array[i] 和 array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // 将中枢元素放到正确的位置
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    // 辅助函数，用于启动快速排序过程
    public static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    // 主函数，用于测试快速排序
    public static void main(String[] args) {
        int[] array = {10, 7, 8, 9, 1, 5};
        sort(array);
        System.out.println("Sorted array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }
}
