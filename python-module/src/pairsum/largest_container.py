from typing import List

from utils import util_functions as uf

# Read water pool heights from console
heights = uf.read_int_array()

# Print original array
uf.print_array(heights)


def largest_container_brute_force(heights_array: List[int]) -> int:
    n = len(heights_array)
    max_water = 0
    # Find the maximum amount of water stored between all pairs of lines.
    for i in range(n):
        for j in range(i + 1, n):
            water = min(heights_array[i], heights_array[j]) * (j - i)
            max_water = max(max_water, water)
            print("Brute force water amount: ", water)

    return max_water

print("\n")
def largest_container(heights_array: List[int]) -> int:
    left, right = 0, len(heights_array) - 1
    max_water = 0
    while left < right:
        water = min(heights_array[left], heights_array[right]) * (right - left)
        print("Water amount: ", water)
        max_water = max(max_water, water)
        if heights_array[left] < heights_array[right]:
            left += 1
        elif heights_array[left] > heights_array[right]:
            right -= 1
        else:
            left += 1
            right -= 1
    return max_water


print("Max water brute force: ", largest_container_brute_force(heights))
print("Max water force: ", largest_container(heights))
