import random 
import turtle

obstacles_list = []

def get_obstacles():
    '''
    Returns the list of obstacles
    '''
    global obstacles_list
    number_obstacles = random.randint(0, 10)
    for i in range (number_obstacles):
        position_x = random.randint(-100, 100)
        position_y = random.randint(-200, 200)
        obstacles_list.append((position_x,position_y))
    return obstacles_list




def is_position_blocked(new_x,new_y):
    '''
    Checks if the position x,y falls inside an obstacle
    '''
    global obstacles_list
    for position_x,position_y in obstacles_list:
        if new_x in range(position_x,position_x + 4) and new_y in range(position_y,position_y + 4):
            return True
    return False 


def is_path_blocked(x1,y1, x2, y2):
    '''
    Checks if there is an obstacle in the line between the coordinates (x1, y1) and (x2, y2)
    '''
    for obst in obstacles_list:
        if x1 == x2:    #checks if we are moving along the y axis
            if y1>y2: y1,y2 = y2,y1     #flipping the current coordinate with the future coordinate, since our functions only works when we moving to the down
            if obst[0] <= x1 <= obst[0] + 4:    #checks if y coordinate is in range of the height of the obstacle
                if y1 <= obst[1] <= y2:
                    return True
                   
        if y1 == y2:    #checks if we are moving along the x axis
            if x1>x2: x1,x2 = x2,x1     #flipping the current coordinate with the future coordinate, since our functions only works when we moving to the right
            if obst[1] <= y1 <= obst[1] +4:     #checks if y coordinate is in range of the height of the obstacle
                if x1 <= obst[0] <= x2:
                    return True
        else:
            continue
    return False

