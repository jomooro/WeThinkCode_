# TODO: Decompose into functions

def move_square(size, degrees):

    print("Moving in a square of size "+str(size))
    for i in range(4):
       
        print("* Move Forward "+str(size))
        print("* Turn Right "+str(degrees)+" degrees")      

def move_rectangle():

    length = 20
    width = 10
    degrees = 90

    print("Moving in a rectangle of "+str(length)+" by "+str(width))
    for i in range(2):
        
        print("* Move Forward "+str(length))
        print("* Turn Right "+str(degrees)+" degrees")
        print("* Move Forward "+str(width))
        print("* Turn Right "+str(degrees)+" degrees")

def move_circle():

    length = 1
    degrees = 1

    print("Moving in a circle")
    
    for i in range(360):

        print("* Move Forward "+str(length))
        print("* Turn Right "+str(degrees)+" degrees")

def move_square_dancing():

    length = 20

    print("Square dancing - 3 squares of size 20")
    for i in range(3):

        print("* Move Forward "+str(length))
        move_square(20, 90)

        '''print("Moving in a square of size 10")
        for j in range(4):
            print("* Move Forward " + str(size))
            print("* Turn Right " + str(degrees) + " degrees")'''

def move_crop_circles():

    length = 20

    print("Crop circles - 4 circles")
    for i in range(4):
        print("* Move Forward "+str(length))
        move_circle()

        '''print("Moving in a circle")
        for k in range(360):
            print("* Move Forward " + str(length))
            print("* Turn Right " + str(degrees) + " degrees")'''

def move():
    move_square(10, 90)
    move_rectangle()
    move_circle()
    move_square_dancing()
    move_crop_circles()

def robot_start():
    move()

if __name__ == "__main__":
    robot_start()
