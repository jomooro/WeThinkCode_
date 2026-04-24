
def find_min(element):
    """TODO: complete for Step 1"""
    '''The function recursion, finds and returns the minimum element in a list of integers'''
    
    for x in element:
        if type(x) == str:
            return -1
    if element == []:
        return -1
    if len(element) == 1:
        return element[0]
    elif element[0] < element[1]:
        element.append(element[0])
        return(find_min(element[1:]))
    else:
        return(find_min(element[1:]))

print(find_min([2, 13, 17, 21, 24])) 


def sum_all(element):
    """TODO: complete for Step 2"""
    '''The function calculates and returns the sum of all element in a list of integers'''
    
    for x in element:
        if type(x) == str:
            return -1
    if element == []:
        return -1
    if len(element) == 1:
        return element[0]
    else:
        return element[0]+sum_all(element[1:])

print(sum_all([2, 13, 17, 21, 24]))


def find_possible_strings(char_set, n):
    """TODO: complete for Step 3"""
    '''The function returns a list of all possible strings of length n from the provided character_set.'''

    k = len(char_set)
    return possible_stringsRec(char_set, "", k, n)


def possible_stringsRec(char_set, prefix, k, n):
    """TODO: complete for Step 4"""
    '''Prints all possible strings'''

    for x in char_set:
        if type(x) is not str:
            return []

    outcome = []
    if n == 0:
        outcome.append(prefix)
        return outcome
    
    for i in range(k):
        newPrefix = prefix + char_set[i]
        outcome.extend(possible_stringsRec(char_set, newPrefix, k, n - 1))
    return outcome 

char_set = ['m','t','j']
possible_strings = find_possible_strings(char_set, 1)
print(find_possible_strings(char_set, 3))

