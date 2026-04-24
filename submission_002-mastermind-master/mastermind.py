import random


def run_game():
    """
    TODO: implement Mastermind code here
    """
    
    code_master = []
    while len(code_master) < 4:
            random_number = str(random.randint(1,8))
            if random_number not in code_master:
                code_master.append(random_number)
    code = "".join(code_master)
    
    print("4-digit Code has been set. Digits in range 1 to 8. You have 12 turns to break it.")


    turns = 12

    while turns > 0:
        user = input('Input 4 digit code: ')
        code_cracker = list(user)

        flag = False
        correct_place = 0
        incorrect_place = 0

        if user.isdigit() and ("0" not in user and "9" not in user) and len(code_cracker) == 4:
            for i in range(len(code_cracker)):
                if i == 3:
                    turns = turns - 1
                if code_master[i] == code_cracker[i]:
                    correct_place += 1
                elif code_master[i] in code_cracker:
                    incorrect_place += 1
        else: 
            flag = True
            print("Please enter exactly 4 digits.")

        if flag == False:
            if turns ==0:
                print("The code was:" + code)
                break
            print(f"Number of correct digits in correct place:     {str(correct_place)}")
            print(f"Number of correct digits not in correct place: {str(incorrect_place)}")
            if correct_place ==4:
                print("Congratulations! You are a codebreaker!")
                print("The code was: " + code)
                break
            print("Turns left: " + str(turns))


if __name__ == "__main__":
    run_game()
