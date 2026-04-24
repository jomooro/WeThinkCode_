

# TODO: Step 1 - get shape (it can't be blank and must be a valid shape!)
def get_shape():
    
    shape = input('Shape?: ').lower()
    
    while shape not in ['pyramid', 'square', 'triangle', 'right_triangle', 'rhombus']:
        shape = input('Shape?: ')
    return shape


# TODO: Step 1 - get height (it must be int!)
def get_height():

    while True:
        height = input('Height?: ')

        if height.isdigit():
            return int(height)



# TODO: Step 2
def draw_pyramid(height, outline):
    if not outline:
        for i in range(height):
            for j in range(height-i-1):
                print(" ", end="")
            for j in range(2*i+1):
                print("*", end="")
            print()
    else:
        for i in range(1,height+1):
            if i == 1 or i == height:
                print((height - i)*(" ") + ((2*i -1)*("*")))
            else: 
                print(((height - i)*(" ")) + "*" + ((2*i -3) * (" "))+"*")

# TODO: Step 3
def draw_square(height, outline):
    if not outline:
        for i in range(height):
            for j in range(height):
                print("*",end="")
            print()
    else:
        for i in range(1,height+1,1):
            for j in range(1,height+1,1):
                if i==1 or i==height or j==1 or j==height:
                    print("*",end="")
            
                else: 
                    print(" ",end="")
            print() 

# TODO: Step 4
def draw_triangle(height, outline):
    if not outline:
        for i in range(height):
            for j in range(-i-1):
                print(" ",end="")
            for j in range(i+1):
                print("*",end="")
            print()
    else:
        for i in range(1,height+1):
            for j in range(i):
                if j==0 or i==(height) or i==j+1:
                    print("*",end="")
                else:
                    print(" ",end="")
            print()

def draw_right_triangle(height, outline):
    if not outline:
        for i in range(height):
            for j in range(height-i-1):
                    print(" ",end="")
            for j in range(i+1):
                print("*",end="")
            print()

    else: 
        for i in range(height):
            for j in range(height):
                if i==(height-1) or j==(height-1) or i+j==(height-1):
                    print("*",end="")
                else:
                    print(" ",end="")
            print()

def draw_rhombus(height, outline):
    if not outline:
        for i in range(height):
            for j in range(height-i-1):
                print(" ",end="")
            for j in range(height):
                print("*",end="")
            print()
        
    else:
        for i in range(height):
            for j in range(height-i-1):
                    print(" ",end="")
            for k in range(height):
                if k==0 or i==0 or k==(height-1) or i==(height-1):
                    print("*",end="")
                else:
                    print(" ",end="")
            print()
           

# TODO: Steps 2 to 4, 6 - add support for other shapes
def draw(shape, height, outline):

    if shape == 'pyramid':
        draw_pyramid(height, outline)
    elif shape == 'square':
         draw_square(height, outline)
    elif shape == 'triangle':
        draw_triangle(height, outline)
    elif shape == 'right_triangle':
        draw_right_triangle(height, outline)
    elif shape == 'rhombus':
        draw_rhombus(height, outline)


# TODO: Step 5 - get input from user to draw outline or solid
def get_outline():

    outline = input('Outline only? (y/N): ').lower()
    if outline == 'y':
        return True
    elif outline == 'n':
        return False



if __name__ == "__main__":
    shape_param = get_shape()
    height_param = get_height()
    outline_param = get_outline()
    draw(shape_param, height_param, outline_param)

