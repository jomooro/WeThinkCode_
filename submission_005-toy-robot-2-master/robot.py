
def robot_start():
    """This is the entry function, do not change"""

    robot_name = name_the_robot()
    commands(robot_name)


def name_the_robot():
    '''The function provides a name for the robot and stores the name.'''

    robot_name = input('What do you want to name your robot? ').upper()
    print(robot_name + ': Hello kiddo!')
    return robot_name


def command_help():
    '''The function handles the help command'''

    print('I can understand these commands:')
    print('OFF  - Shut down robot')
    print('HELP - provide information about commands\n')


def commands(robot_name):
    '''The function gets a command as input from the user'''

    command_list = ['off', 'help', 'forward', 'back', 'right', 'left', 'sprint']
    robot_position = [0, 0]
    direction = '90_degrees'

    while True:
        command_ask = input(robot_name + ': What must I do next? ').lower().split() #The split() method splits a string into a list.
        if command_ask[0] == command_list[0]:
            print(robot_name + ': Shutting down..')
            break
        if command_ask[0] == command_list[1]:
            command_help()
            continue
    
        if command_ask[0] == command_list[2]:   #forward
            steps = int(command_ask[1])
            forward_command(robot_name, steps, direction, robot_position)
            track_position(robot_name, robot_position)
            continue

        if command_ask[0] == command_list[3]:   #back
            steps = int(command_ask[1])
            back_command(robot_name, robot_position, steps, direction)
            track_position(robot_name, robot_position)
            continue

        if command_ask[0] == command_list[4]:   #right 
            direction = turn_right_command(robot_name, direction)
            track_position(robot_name, robot_position)
            continue

        if command_ask[0] == command_list[5]:   #left
            direction = turn_left_command(robot_name, direction)
            track_position(robot_name, robot_position)
            continue

        if command_ask[0] == command_list[6]:   #sprint
            steps = int(command_ask[1])
            sprint_command(robot_name, steps, direction, robot_position)
            track_position(robot_name, robot_position)
            continue
        else:
            print(robot_name + ': Sorry, I did not understand ' + "'"+ command_ask[0].capitalize()+' ' +command_ask[1] + "'" + '.')
    

def forward_command(robot_name, steps, direction, robot_position):
    '''The function handles forward movements'''

    forward_message = (f' > {robot_name} moved forward by {steps} steps.')
    boundary_message = (f'{robot_name}: Sorry, I cannot go outside my safe zone.')

    if direction =='90_degrees':
        if robot_position[1] + steps < 200:
            robot_position[1] += steps
            print(forward_message)
        else:
            print(boundary_message)
    
    if direction == '270_degrees':
        if robot_position[1] + steps > -200:
            robot_position[1] -= steps
            print(forward_message)
        else:
            print(boundary_message)
    
    if direction == '360_degrees':
        if robot_position[0] - steps < 100:
            robot_position[0] += steps
            print(forward_message)
        else:
            print(boundary_message)
    
    if direction == '180_degrees':
        if robot_position[0] - steps > -100:
            robot_position[0] -= steps
            print(forward_message)
        else:
            print(boundary_message)
    

def track_position(robot_name, robot_position):
    '''The function keeps track of position''' 

    print(f' > {robot_name} now at position ({robot_position[0]},{robot_position[1]}).')


def back_command(robot_name, robot_position, steps, direction):
    '''The function allows the back movement'''

    back_message = (f' > {robot_name} moved back by {steps} steps.')
    boundary_message = (f'{robot_name}: Sorry, I cannot go outside my safe zone.')

    if direction =='90_degrees':
        if robot_position[1] - steps < 200:
            robot_position[1] -= steps
            print(back_message)
        else:
            print(boundary_message)

    if direction == '270_degrees':
        if robot_position[1] - steps > -200:
            robot_position[1] += steps
            print(back_message)
        else:
            print(boundary_message)

    if direction == '360_degrees':
        if robot_position[0] + steps < 100:
            robot_position[0] -= steps
            print(back_message)
        else:
            print(boundary_message)

    if direction == '180_degrees':
        if robot_position[0] + steps > -100:
            robot_position[0] += steps
            print(back_message)
        else:
            print(boundary_message)


def turn_right_command(robot_name, direction):
    '''The function handles the right movement'''

    print(f" > {robot_name} turned right.")

    if direction == "90_degrees": direction = "360_degrees"
    elif direction == "270_degrees": direction = "180_degrees"
    elif direction == "360_degrees": direction = "270_degrees"
    elif direction == "180_degrees": direction = "90_degrees"
    return direction
    

def turn_left_command(robot_name, direction):
    '''The function handles the left command'''
    
    print(f' > {robot_name} turned left.')

    if direction == "90_degrees": direction = "180_degrees"
    elif direction == "180_degrees": direction = "270_degrees"
    elif direction == "270_degrees": direction = "360_degrees"
    elif direction == "360_degrees": direction = "90_degrees"
    return direction


def sprint_command(robot_name, steps, direction, robot_position):
    '''The function handles the sprint movement'''

    if steps == 0:
        return
    else:
        forward_command(robot_name, steps, direction, robot_position)
        sprint_command(robot_name, steps-1, direction, robot_position)


if __name__ == "__main__":
    robot_start()
