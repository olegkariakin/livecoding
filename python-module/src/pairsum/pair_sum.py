from typing import List

from utils import util_functions as uf

# Read array from console
array = uf.read_int_array()

# Print original array
uf.print_array(array)

# Sort ascending
asc_array = uf.sort_array_ascending(array)
print("Sorted ascending: ", asc_array)

# Sort descending
desc_array = uf.sort_array_descending(array)
print("Sorted descending: ", desc_array)

# Read a single integer
target = uf.read_int()
print("Target is: ", target)


def pair_sum_sorted_brute_force(nums: List[int],
                                tar: int) -> List[int]:
    """Pair sum brute force with O(n^2) time complexity"""
    n = len(nums)
    for i in range(n):
        for j in range(i + 1, n):
            if nums[i] + nums[j] == tar:
                return [i, j]
    return []


def pair_sum_sorted(nums: List[int],
                    tar: int) -> List[int]:
    """Pair sum with 2 pointers clever algo with O(n) time complexity"""
    left, right = 0, len(nums) - 1
    while left < right:
        clever_sum = nums[left] + nums[right]
        if clever_sum < tar:
            left += 1
        elif clever_sum > tar:
            right += 1
        else:
            return [left, right]
    return []


print("Result is with brute force approach: ", pair_sum_sorted_brute_force(asc_array, target))
print("Result is with clever 2 pointer approach: ", pair_sum_sorted(asc_array, target))
