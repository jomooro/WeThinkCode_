from io import StringIO
import mastermind
import unittest
from unittest.mock import patch


class MyTestCase(unittest.TestCase):


    def test_create_code(self):
        '''Tests the 4 digit code, using random digits from 1 to 8'''

        for i in range (100):
            code = mastermind.create_code()
            self.assertEqual(len(code), 4)
            for value in code:
                my_list = [1,2,3,4,5,6,7,8]
                self.assertIn(value,(my_list))


    def test_check_correctness(self):
        '''The test checks correctness of answer and show output to user'''

        self.assertTrue(mastermind.check_correctness(10, 4))
        self.assertFalse(mastermind.check_correctness(2, 2))


    @patch("sys.stdin", StringIO("12345\n12\n1234\n"))
    def test_get_answer_input(self):
        '''Test the answer from user repeatedly'''

        self.assertEqual(mastermind.get_answer_input(),"1234")


    @patch("sys.stdin", StringIO("1234\n1256\n4321\n"))
    def test_take_turn(self):
        '''The test tracks the taking of turns, namely:
       * tests if answer is valid
       * tests correctness of answer'''

        code = [1,2,3,4]
        self.assertEqual(mastermind.take_turn(code),(4,0))
        self.assertEqual(mastermind.take_turn(code),(2,0))
        self.assertEqual(mastermind.take_turn(code),(0,4))


if __name__ == "__main__":
    unittest.main()



    



