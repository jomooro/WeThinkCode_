import random
obstacles_list = []

def get_obstacles():
    '''
    The width for the maze in the textfile is 10 and the length is 20
    The function intialize the coordinates and of the maze
    '''

    global obstacles_list
    obstacles_list = []
    
    f = open('maze/tenbytwenty.txt', 'r')
    read_lines = f.readlines()
    f.close()

    robot_world_x_coord = -100
    robot_world_y_coord = 200
    for i in range(len(read_lines)):
        for j in range(10): 
            m = read_lines[i][j]
            if read_lines[i][j] == '$':
                obstacles_list.append((robot_world_x_coord,robot_world_y_coord-4))
                obstacles_list.append((robot_world_x_coord+4,robot_world_y_coord-4))
                obstacles_list.append((robot_world_x_coord+8,robot_world_y_coord-4))
                obstacles_list.append((robot_world_x_coord+12,robot_world_y_coord-4))
                obstacles_list.append((robot_world_x_coord+16,robot_world_y_coord-4))
                obstacles_list.append((robot_world_x_coord,robot_world_y_coord-8))
                obstacles_list.append((robot_world_x_coord+4,robot_world_y_coord-8))
                obstacles_list.append((robot_world_x_coord+8,robot_world_y_coord-8))
                obstacles_list.append((robot_world_x_coord+12,robot_world_y_coord-8))
                obstacles_list.append((robot_world_x_coord+16,robot_world_y_coord-8))
                obstacles_list.append((robot_world_x_coord,robot_world_y_coord-12))
                obstacles_list.append((robot_world_x_coord+4,robot_world_y_coord-12))
                obstacles_list.append((robot_world_x_coord+8,robot_world_y_coord-12))
                obstacles_list.append((robot_world_x_coord+12,robot_world_y_coord-12))
                obstacles_list.append((robot_world_x_coord+16,robot_world_y_coord-12))
                obstacles_list.append((robot_world_x_coord,robot_world_y_coord-16))
                obstacles_list.append((robot_world_x_coord+4,robot_world_y_coord-16))
                obstacles_list.append((robot_world_x_coord+8,robot_world_y_coord-16))
                obstacles_list.append((robot_world_x_coord+12,robot_world_y_coord-16))
                obstacles_list.append((robot_world_x_coord+16,robot_world_y_coord-16))
                obstacles_list.append((robot_world_x_coord,robot_world_y_coord-20))
                obstacles_list.append((robot_world_x_coord+4,robot_world_y_coord-20))
                obstacles_list.append((robot_world_x_coord+8,robot_world_y_coord-20))
                obstacles_list.append((robot_world_x_coord+12,robot_world_y_coord-20))
                obstacles_list.append((robot_world_x_coord+16,robot_world_y_coord-20))
            


            robot_world_x_coord = robot_world_x_coord + 20 #moves along each x cooridates for each line
        robot_world_y_coord = robot_world_y_coord - 20 #moves along each y cooridates for each line
        robot_world_x_coord = -100 #resets each coordinate for each line
    return obstacles_list


def is_position_blocked(x, y):
    
    global obstacles_list
    for position_x,position_y in obstacles_list:
        if x in range(position_x,position_x + 4) and y in range(position_y,position_y + 4):
            return True
    return False 


def is_path_blocked(x1, y1, x2, y2):

    for obst in obstacles_list:
        if x1 == x2:   
            if y1>y2: y1,y2 = y2,y1    
            if obst[0] <= x1 <= obst[0] + 4:  
                if y1 <= obst[1] <= y2:
                    return True
                   
        if y1 == y2:    
            if x1>x2: x1,x2 = x2,x1   
            if obst[1] <= y1 <= obst[1] +4:     
                if x1 <= obst[0] <= x2:
                    return True
        else:
            continue
    return False

