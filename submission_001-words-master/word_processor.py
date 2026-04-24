
def split(delimiters, text):
    """
    Splits a string using all the delimiters supplied as input string
    :param delimiters:
    :param text: string containing delimiters to use to split the string, e.g. `,;? `
    :return: a list of words from splitting text using the delimiters
    """

    import re
    regex_pattern = '|'.join(map(re.escape, delimiters))
    return re.split(regex_pattern, text, 0)


def convert_to_word_list(text):
    '''The function transforms to lowercase list'''
    
    text = text.lower()
    words = split(" .,?!/",text)
    word_list = []
    for word in words:
        if word != "":
            word_list.append(word)
    return word_list 


def words_longer_than(length, text):
    '''The function filters words on length'''
    
    text = convert_to_word_list(text) 
    words_longer = [word for word in text if len(word) > length]
    return words_longer 
    

def words_lengths_map(text):
    '''The function spreads of word lengths'''
    
    text = convert_to_word_list(text)
    words_length = [len(word) for word in text] 
    return {word:words_length.count(word) for word in words_length}


def letters_count_map(text):
    '''The function counts the letters'''

    text = convert_to_word_list(text)
    letter_count = "".join(text)
    word_list = ["a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
    return {word:letter_count.count(word) for word in word_list} 


def most_used_character(text):
    '''The function reduces to highest occurrence'''

    if text != '':
        text = letters_count_map(text)
        most_used = max([text[characters] for characters in text])
        popular_char = [word for word,words in text.items() if most_used == words][-1]  
        return popular_char 


if __name__ == "__main__":
    print(convert_to_word_list("These are indeed interesting, an obvious understatement, times. What say you?"))
    print(words_longer_than(10,"These are indeed interesting, an obvious understatement, times. What say you?"))
    print(words_lengths_map("These are indeed interesting, an obvious understatement, times. What say you?"))
    print(letters_count_map("These are indeed interesting, an obvious understatement, times. What say you?"))
    print(most_used_character("These are indeed interesting, an obvious understatement, times. What say you?"))