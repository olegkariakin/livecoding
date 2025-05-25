import random
from datetime import datetime

# Generate a random number between 1 and 100
random_number = random.randint(1, 100)

# Ask the user for their name
name = input("Enter your name: ")

# Get current date and time
now = datetime.now()
current_time = now.strftime("%Y-%m-%d %H:%M:%S")

# Display messages
print(f"\nHello, {name}!")
print(f"Today's date and time: {current_time}")
print(f"Here's a fun fact: Your random number is {random_number}")