import unittest
import super_algos


class Test_Recursion(unittest.TestCase):
    def test_find_min(self):
        '''Tests the minimum element in a list of integers, when the list is empty and invalid elements'''
        self.assertEqual(super_algos.find_min([2, 13, 17, 21, 24]), 2)
        self.assertEqual(super_algos.find_min([]),-1)
        self.assertEqual(super_algos.find_min(['h', 13, 17, 'j', 21]), -1)


    def test_sum_all(self):
        '''Tests the sum of all element in a list of integers, an empty list and invalid elements'''
        self.assertEqual(super_algos.sum_all([2, 13, 17, 21, 24]), 77)
        self.assertEqual(super_algos.sum_all([]), -1)
        self.assertEqual(super_algos.sum_all(['s', 13, 'i', 21, 24]), -1)


    def test_find_possible_strings(self):
        '''Tests a list of all possible strings, an empty list and invalid elements'''
        self.assertEqual(super_algos.find_possible_strings(['m','t','j'], 3),['mmm', 'mmt', 'mmj', 'mtm', 'mtt', 'mtj', 'mjm', 'mjt', 'mjj', 'tmm', 'tmt', 'tmj', 'ttm', 'ttt', 'ttj', 'tjm', 'tjt', 'tjj', 'jmm', 'jmt', 'jmj', 'jtm', 'jtt', 'jtj', 'jjm', 'jjt', 'jjj'])
        self.assertEqual(super_algos.find_possible_strings([], 3),[])
        self.assertEqual(super_algos.find_possible_strings([1,2,4,5], 3),[])


if __name__ == "__main__":
    unittest.main()