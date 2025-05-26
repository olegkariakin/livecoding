from utils import util_functions as uf
from typing import List

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

#Read a single integer
target = uf.read_int()
print("Target is: ", target)

def pair_sum_sorted_brute_force(nums: List[int],
                                tar: int) -> List[int]:
    """Pair sum brute force with O(n^2) time complexity"""
    n = len(nums)
    for i in range(n):
        for j in range(i + 1, n):
            if nums[i] + nums[j] == target:
                return [i, j]
    return []

print("Result is with brute force approach: ", pair_sum_sorted_brute_force(asc_array, target))
