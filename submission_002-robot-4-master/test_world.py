import unittest
from io import StringIO
import sys
from test_base import run_unittests
from test_base import captured_io
import world.obstacles as obstacles
import robot
    
    
class MyTestCase(unittest.TestCase):
    def test_check_observations(self):

        with captured_io(StringIO('HAL\nleft\nforward 10\noff\n')) as (out, err):
            obstacles.random.randint = lambda a, b: 1
            robot.robot_start()

        output = out.getvalue().strip()

        self.assertEqual("""What do you want to name your robot? HAL: Hello kiddo!
There are some obstacles:
- At position 1,1 (to 5,5)""", output[:107])


if __name__ == '__main__':
    unittest.main()
