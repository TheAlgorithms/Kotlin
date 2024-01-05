package math
/**
 * Approach 1: Brute Force
 *
 * Complexity Analysis:
 *
 * Time complexity: O(n^2)
 * Space complexity: O(1)
 *
 * Try all the pairs in the array and see if any of them add up to the target number.
 * @param nums Array of integers.
 * @param target Integer target.
 * @return Indices of the two numbers such that they add up to target.
 */
fun twoSum(nums: IntArray, target: Int): IntArray{
    for (index1 in nums.indices) {
        val startIndex = index1 + 1
        for (index2 in startIndex..nums.lastIndex) {
            if (nums[index1] + nums[index2] == target) {
                return intArrayOf(index1, index2)
            }
        }
    }
    return intArrayOf(0,1)

}

/**
 * Approach 2: Using HashMap
 *
 * Complexity Analysis:
 *
 * Time complexity: O(n)
 * Space complexity: O(n)
 *
 * Create an empty mutableMap and for every num in nums
 * if map contains target-num, return num and target-num,
 * otherwise add num, this approach returns all distinct pairs
 * of such pairs.
 * @param nums Array of integers.
 * @param target Integer target.
 * @return the two numbers such that they add up to target.
 */
fun twoSumOptimised(nums: IntArray, target: Int): IntArray{

    val map: MutableMap<Int, Int> = HashMap()
    for(num  in nums) {
        val targetDiff = target - num;
        if(map[targetDiff] == null)
            map[num] = 1
        else return intArrayOf(num, targetDiff)
    }

    return intArrayOf()


}
