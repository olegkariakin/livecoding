def print_array(arr):
    """Print array to console."""
    print("Array: ", arr)

def sort_array_ascending(arr):
    """Return a sorted copy of array in ascending order."""
    return sorted(arr)

def sort_array_descending(arr):
    """Return a sorted copy of array in descending order."""
    return sorted(arr, reverse=True)

def read_int():
    """Read a single integer from console."""
    while True:
        try:
            return int(input("Enter an integer: "))
        except ValueError:
            print("Invalid input. Please enter an integer")

def read_int_array(stop_value=-100500):
    """Read integers from console until stop_value is encountered, return as list."""
    arr = []
    print(f"Enter integers (stop with {stop_value}):")
    while True:
        try:
            num = int(input())
            if num == stop_value:
                break
            arr.append(num)
        except ValueError:
            print("Invalid input. Please enter an integer.")
    return arr