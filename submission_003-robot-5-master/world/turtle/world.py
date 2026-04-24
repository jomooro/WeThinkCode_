# -------------------------------------------------------------------------------------------------
#
# TODO: Please replace this placeholder code with your solution for Toy Robot 4, and work from there.
#
# -------------------------------------------------------------------------------------------------
import turtle
import maze.obstacles as obstacles
import import_helper
import maze.simple_maze as puzzle
    
# screen display
screen = turtle.Screen()
screen.bgcolor("blue")
turtle.tracer(0)

# border display
border = turtle.Turtle()
border.penup()
border.setposition(-100, -200)
border.pendown()
border.pensize(5)
border.speed(10)


def draw_obstacles(obstacles_list):
    
    for i,j in obstacles_list:
        obstacle_robot = turtle.Turtle()
        obstacle_robot.color("black")
        obstacle_robot.shape("square")
        obstacle_robot.shapesize(0.2,0.2)
        obstacle_robot.penup()
        obstacle_robot.goto((i+4+i)/2, (j+4+j)/2)
        obstacle_robot.pendown()
        obstacle_robot.speed(0)
    turtle.update()

border.lt(90)
border.fd(400)
border.rt(90)
border.fd(200)
border.rt(90)
border.fd(400)
border.rt(90)
border.fd(200)
border.hideturtle()

    # obstacles.get_obstacles

# move the robot
move_robot = turtle.Turtle()
move_robot.shapesize(0.2,0.2)
move_robot.setheading(90)
move_robot.shape("triangle")
move_robot.color("red")

draw_obstacles(obstacles.obstacles_list)


# list of valid command names
valid_commands = ['off', 'help', 'replay', 'forward', 'back', 'right', 'left', 'sprint']
move_commands = valid_commands[3:]


# variables tracking position and direction
position_x = 0
position_y = 0
directions = ['forward', 'right', 'back', 'left']
current_direction_index = 0



# area limit vars
min_y, max_y = -200, 200
min_x, max_x = -100, 100


def show_position(robot_name):
    print(' > '+robot_name+' now at position ('+str(position_x)+','+str(position_y)+').')


def is_position_allowed(new_x, new_y):
    """
    Checks if the new position will still fall within the max area limit
    :param new_x: the new/proposed x position
    :param new_y: the new/proposed y position
    :return: True if allowed, i.e. it falls in the allowed area, else False
    """

    return min_x <= new_x <= max_x and min_y <= new_y <= max_y


def update_position(robot_name,steps):
    """
    Update the current x and y positions given the current direction, and specific nr of steps
    :param steps:
    :return: True if the position was updated, else False
    """

    global position_x, position_y
    new_x = position_x
    new_y = position_y

    if directions[current_direction_index] == 'forward':
        new_y = new_y + steps
    elif directions[current_direction_index] == 'right':
        new_x = new_x + steps
    elif directions[current_direction_index] == 'back':
        new_y = new_y - steps
    elif directions[current_direction_index] == 'left':
        new_x = new_x - steps
    


    #if is_position_allowed(new_x, new_y)  and obstacles.is_position_blocked(position_x,position_y) == False and obstacles.is_path_blocked(position_x,position_y,new_x,new_y) == False:
    if is_position_allowed(new_x, new_y) and not obstacles.is_path_blocked(position_x, position_y, new_x, new_y):
        
        position_x = new_x
        position_y = new_y
        return True
    elif is_position_allowed(new_x,new_y) and (obstacles.is_position_blocked(position_x,position_y) or obstacles.is_path_blocked(position_x,position_y,new_x,new_y)):
        return None
    else:
        # print(f"{robot_name}: Sorry, there is an obstacle in the way.")
        return False


def do_forward(robot_name, steps):
    """
    Moves the robot forward the number of steps
    :param robot_name:
    :param steps:
    :return: (True, forward output text)
    """
    if update_position(robot_name,steps):
        move_robot.forward(steps)
        turtle.update()
        return True, ' > '+robot_name+' moved forward by '+str(steps)+' steps.'
    elif update_position(robot_name,steps) == None:
        return True,''+robot_name+': Sorry, there is an obstacle in the way.'
    else:
        return True, ''+robot_name+': Sorry, I cannot go outside my safe zone.'


def do_back(robot_name, steps):
    """
    Moves the robot forward the number of steps
    :param robot_name:
    :param steps:
    :return: (True, forward output text)
    """

    if update_position(robot_name,-steps):
        move_robot.forward(-steps)
        turtle.update()
        return True, ' > '+robot_name+' moved back by '+str(steps)+' steps.'
    elif update_position(robot_name,steps) == None:
        return True,''+robot_name+': Sorry, there is an obstacle in the way.'
    else:
        return True, ''+robot_name+': Sorry, I cannot go outside my safe zone.'


def do_right_turn(robot_name):
    """
    Do a 90 degree turn to the right
    :param robot_name:
    :return: (True, right turn output text)
    """
    global current_direction_index
 
    current_direction_index += 1
    if current_direction_index > 3:
        current_direction_index = 0
    move_robot.right(90)
    turtle.update()
    return True, ' > '+robot_name+' turned right.'

def reset_turtle():
    '''
    Resets the turtle back to position 0
    '''
    move_robot.penup()
    move_robot.setposition(0,0)
    move_robot.pendown()
    move_robot.setheading(90)


def do_left_turn(robot_name):
    """
    Do a 90 degree turn to the left
    :param robot_name:
    :return: (True, left turn output text)
    """
    global current_direction_index

    current_direction_index -= 1
    if current_direction_index < 0:
        current_direction_index = 3
    move_robot.left(90)
    turtle.update()
    return True, ' > '+robot_name+' turned left.'


def do_sprint(robot_name, steps):
    """
    Sprints the robot, i.e. let it go forward steps + (steps-1) + (steps-2) + .. + 1 number of steps, in iterations
    :param robot_name:
    :param steps:
    :return: (True, forward output)
    """

    if steps == 1:
        return do_forward(robot_name, 1)
    else:
        (do_next, command_output) = do_forward(robot_name, steps)
        print(command_output)
        return do_sprint(robot_name, steps - 1)






    
