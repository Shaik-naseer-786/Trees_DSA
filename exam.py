# def max_subarray_sum(arr):
#     n = len(arr)
#     if n == 0:
#         return 0
#     if n == 1:
#         return arr[0]

#     dp = [0] * n
#     dp[0] = arr[0]
#     dp[1] = max(arr[0], arr[1])

#     for i in range(2, n):
#         dp[i] = max(dp[i - 1], dp[i - 2] + arr[i])

#     return dp[n - 1]

# arr = list(map(int, input().split(",")))
# result = max_subarray_sum(arr)
# print(result)

# Python3 program to demonstrate the use of 
# circular array without using extra memory space

# function to print circular list starting
# from given index ind.
# def prints(a, n, ind):
# 	i = ind
	
# 	# print from ind-th index to (n+i)th index.
# 	while i < n + ind :
# 		print(a[(i % n)], end = " ")
# 		i = i + 1

# # Driver Code
# a = [2,5,10,5]
# n = len(a)
# prints(a, n, 3)

# # This code is contributed by rishabh_jain

def find_max_subarray(nums):
    """
    Finds the maximum subarray sum in a given array.

    Args:
        nums: A list of integers representing the array.

    Returns:
        The maximum sum of a contiguous subarray in the array.
    """

    n = len(nums)
    if n == 1:
        return nums[0]

    # Initialize variables for tracking maximum sum and current sum.
    max_sum = float('-inf')
    current_sum = 0

    for num in nums:
        # Update current sum by considering the current number or starting a new subarray.
        current_sum = max(num, 0, current_sum + num)

        # Update maximum sum if necessary.
        max_sum = max(max_sum, current_sum)

    return max_sum

# Example usage
nums = [2, 7, 1, 9, 3]
result = find_max_subarray(nums)
print(result)  # Output: 16