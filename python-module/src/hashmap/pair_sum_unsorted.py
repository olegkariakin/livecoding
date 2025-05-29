from typing import List

from utils import util_functions as uf

# Read array from console
array = uf.read_int_array()

# Print original array to console
uf.print_array(array)

target = uf.read_int()


def pair_sum_unsorted_two_pass(nums: List[int],
                               tar: int) -> List[int]:
    num_map = {}
    # First pass: Populate the hash map with each number and its index.
    for i, num in enumerate(nums):
        num_map[num] = i
    # Second pass: Check for each number's complement in the hash map.
    for i, num in enumerate(nums):
        complement = tar - num
        if complement in num_map and num_map[complement] != i:
            return [i, num_map[complement]]
    return []


print("Two pass approach: ", pair_sum_unsorted_two_pass(array, target))
