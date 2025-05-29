from typing import List

from linkedlists.ListNode import ListNode


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


def read_string_from_console():
    while True:
        s = input("Enter a string: ")
        if s.strip():
            return s
        else:
            print("Input cannot be empty. Please try again")


def list_to_linked_list(items: List[int]) -> ListNode | None:
    head = None
    current = None
    for num in items:
        node = ListNode(num)
        if not head:
            head = node
            current = head
        else:
            current.next = node
            current = current.next
    return head


def print_linked_list_to_console(head: ListNode | None) -> None:
    current = head
    nodes = []
    while current:
        nodes.append(str(current.val))
        current = current.next
    print(" -> ".join(nodes))
