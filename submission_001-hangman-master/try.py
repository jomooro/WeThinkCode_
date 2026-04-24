import random
words = ["apple", "banana", "cherry"]

pos = random.randint(0, (len(words) - 1))

word = words[pos]
pos_letter = random.randint(1, len(word)+1) 

#print(pos_letter)

#print(words[pos_letter])


letter = word[pos_letter]
replacing = word.replace(letter, '_')
print(word)
print(replacing)
