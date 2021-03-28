package org.mirai.sword;


/**
 * @author mirau on 2021/3/27.
 * @version 1.0
 */
public class Q04FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        return useBinarySearch(matrix, target);
    }

    private boolean useBinarySearch(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int xRight = 0;
        int yRight = matrix[0].length - 1;

        // 从右上角开始找，如果当前值比查找值小的往左移动一列，如果当前值比查找值大则往下移动一列，等于则返回
        while (xRight < matrix.length && yRight >= 0) {
            if (matrix[xRight][yRight] > target) {
                yRight -= 1;
            } else if (matrix[xRight][yRight] < target) {
                xRight += 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
