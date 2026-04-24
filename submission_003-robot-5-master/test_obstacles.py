import unittest
from io import StringIO
import sys
import maze.obstacles as obstacles
import robot
    
    
class MyTestCase(unittest.TestCase):

    def test_get_obstacles(self):
        obstacles.obstacles_list = [(0,10)] 


    def test_is_position_blocked_true(self):
        obstacles.obstacles_list = [(1,1)]
        myresult = obstacles.is_position_blocked(1,1)
        self.assertEqual(myresult,True)


    def test_is_position_blocked_false(self):
        obstacles.obstacles_list = [(1,1)]
        myresult = obstacles.is_position_blocked(6,6)
        self.assertEqual(myresult,False)
        

if __name__ == '__main__':
    unittest.main()

