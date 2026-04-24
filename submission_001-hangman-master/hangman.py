#TIP: use random.randint to get a random word from the list
import random

def read_file(file_name):
    myfile =open(file_name, "r")
    words = myfile.readlines()
    myfile.close() 

    return words

def select_random_word(words):

#access position of the word in a list 
    position = random.randint(0, (len(words) - 1))
    word = words[position]

#access a letter in a word
    position_letter = random.randint(0, len(word) -1) 
    alphabet = word[position_letter]

#replacing a letter with dash
    replacing = word.replace(alphabet, '_')
    print("Guess the word:", replacing)

    return word
    
def get_user_input():

    input_from_user = input("Guess the missing letter: ") 
    return input_from_user


def run_game(file_name):
    """
    This is the main game code. You can leave it as is and only implement steps 1 to 3 as indicated above.
    """
    words = read_file(file_name)
    word = select_random_word(words)
    answer = get_user_input()
    print('The word was: '+word)




if __name__ == "__main__":
    run_game('short_words.txt')

