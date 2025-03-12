"""Implement the flatten_dicts function.

Given a nested list of dictionaries, return a flattened dictionary
in which the values for common keys are summed up.

---
Example

Input:
[{"a": 1}, [{"a": 2, "b": 1}]]

Return:
{"a": 3, "b": 1}
"""


##  My implementation
# def union_dict(dict1 : dict, dict2 : dict) -> dict:
#     for key, val in dict2.items():
#         if key in dict1:
#             dict1[key] += val
#         else:
#             dict1[key] = val
#     return dict1
    
    
# def flatten_dicts(example) -> dict:
#     """iterate list
#     for item in list:
#         ...
#     """
#     """iterate dict
#     for key, value in dictionary.items():
#         ...
#     """
#     if len(example) == 0:
#         return dict()

#     res_dict = dict()
#     for my_dict in example:
#         if isinstance(my_dict, dict):
#             res_dict = union_dict(res_dict, my_dict)
#         elif isinstance(my_dict, list):
#             res_dict = union_dict(res_dict, flatten_dicts(my_dict))
#     return res_dict


from collections import Counter
from typing import Union, List, Dict

def merge_dicts(dict1: Dict, dict2: Dict) -> Dict:
    """Merge two dictionaries, summing values of common keys."""
    return dict(Counter(dict1) + Counter(dict2))

def flatten_dicts(nested_data: Union[List, Dict]) -> Dict:
    """
    Flattens a nested list of dictionaries into a single dictionary,
    summing values for common keys.
    
    Example:
        Input: [{"a": 1}, [{"a": 2, "b": 1}]]
        Output: {"a": 3, "b": 1}
    """
    if isinstance(nested_data, dict):
        return nested_data  # Base case: a single dictionary

    if isinstance(nested_data, list):
        result = Counter()
        for item in nested_data:
            result += Counter(flatten_dicts(item))
        return dict(result)
    
    return {}  # If invalid type, return an empty dictionary

# Testing
if __name__ == "__main__":
    example1 = [{"a": 1, "b": 2}, [{"a": 2, "c": 1}, {"b": 8, "d": 3}], [{"a": 3, "d": 2, "e": 1}, [{"q": 4, "e": 1}]]]
    expected1 = {"a": 6, "b": 10, "c": 1, "d": 5, "e": 2, "q": 4}

    example2 = [{"x": 10, "y": 20}, [{"z": 5, "x": 1}, [{"y": 2, "z": 8}, {"x": 7, "w": 4}, [{"v": 3, "w": 6}, {"u": 9, "v": 2}, [{"t": 5, "s": 7}, {"r": 8, "q": 1}]]], {"w": 3, "v": 8}], [{"u": 2, "t": 6}, [{"s": 4, "r": 3}, [{"q": 7, "p": 5}, {"o": 2, "n": 3}, [{"m": 1, "l": 4}, {"k": 5, "j": 6}, [{"i": 7, "h": 8}, {"g": 9, "f": 1}, [{"e": 2, "d": 3}, {"c": 4, "b": 5}, {"a": 6, "z": 7}]]]]], {"y": 1, "x": 2}]]
    expected2 = {"x": 20, "y": 23, "z": 20, "w": 13, "v": 13, "u": 11, "t": 11, "s": 11, "r": 11, "q": 8, "p": 5, "o": 2, "n": 3, "m": 1, "l": 4, "k": 5, "j": 6, "i": 7, "h": 8, "g": 9, "f": 1, "e": 2, "d": 3, "c": 4, "b": 5, "a": 6}

    assert flatten_dicts(example1) == expected1, "Example 1 failed!"
    assert flatten_dicts(example2) == expected2, "Example 2 failed!"

    print("All tests passed!")


if __name__ == "__main__":
    example1 = [{"a": 1, "b": 2}, [{"a": 2, "c": 1}, {"b": 8, "d": 3}], [{"a": 3, "d": 2, "e": 1}, [{"q": 4, "e": 1}]]]
    expected1 = {"a": 6, "b": 10, "c": 1, "d": 5, "e": 2, "q": 4}
    
    example2 = [{"x": 10, "y": 20}, [{"z": 5, "x": 1}, [{"y": 2, "z": 8}, {"x": 7, "w": 4}, [{"v": 3, "w": 6}, {"u": 9, "v": 2}, [{"t": 5, "s": 7}, {"r": 8, "q": 1}]]], {"w": 3, "v": 8}], [{"u": 2, "t": 6}, [{"s": 4, "r": 3}, [{"q": 7, "p": 5}, {"o": 2, "n": 3}, [{"m": 1, "l": 4}, {"k": 5, "j": 6}, [{"i": 7, "h": 8}, {"g": 9, "f": 1}, [{"e": 2, "d": 3}, {"c": 4, "b": 5}, {"a": 6, "z": 7}]]]]], {"y": 1, "x": 2}]]
    expected2 = {"x": 20, "y": 23, "z": 20, "w": 13, "v": 13, "u": 11, "t": 11, "s": 11, "r": 11, "q": 8, "p": 5, "o": 2, "n": 3, "m": 1, "l": 4, "k": 5, "j": 6, "i": 7, "h": 8, "g": 9, "f": 1, "e": 2, "d": 3, "c": 4, "b": 5, "a": 6}

    # Before running the test, make sure the function signature matches your implementation!
    res_dict1 = flatten_dicts(example1)
    if res_dict1 == expected1:
        print("Example 1 passed!")
    else:
        print("Example 1 failed!")

    if flatten_dicts(example2) == expected2:
        print("Example 2 passed!")
    else:
        print("Example 2 failed")
