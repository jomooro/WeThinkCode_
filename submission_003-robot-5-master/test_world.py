import unittest
from io import StringIO
import sys
from test_base import run_unittests
from test_base import captured_io
import maze.obstacles as obstacles
import robot 
import world.text.world as world
    
obstacles.random.randint = lambda a, b: 0

class MyTestCase(unittest.TestCase):
    def test_do_forward(self):
        myresult = world.do_forward('hal',50)
        self.assertEqual(myresult,(True, ' > hal moved forward by 50 steps.'))


    def test_do_back(self):
        myresult = world.do_back('hal',50)
        self.assertEqual(myresult,(True, ' > hal moved back by 50 steps.'))


    def test_do_left(self):
        myresult = world.do_left_turn('hal')
        self.assertEqual(myresult,(True, ' > hal turned left.'))


    def test_do_right(self):
        myresult = world.do_right_turn('hal')
        self.assertEqual(myresult,(True, ' > hal turned right.'))


if __name__ == '__main__':
    unittest.main()

