from __future__ import annotations
from typing import Optional

class ListNode:
    def __init__(self, val: int, nex: Optional[ListNode] = None):
        self.val = val
        self.next = nex
