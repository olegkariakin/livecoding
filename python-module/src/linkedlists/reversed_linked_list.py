from utils import util_functions as uf

# Read values for a linked list from console
values = uf.read_int_array()

# Convert List to LinkedList
linkedList = uf.list_to_linked_list(values)

# Print LinkedList to console
uf.print_linked_list_to_console(linkedList)
