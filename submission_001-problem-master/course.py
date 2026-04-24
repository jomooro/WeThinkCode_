

def create_outline():
    """
    TODO: implement your code here
    """
    print("Course Topics:")
    
    Course_Topics = {"Introduction to Python", "Tools of the Trade", "How to make decisions", "How to repeat code", "How to structure data", "Functions", "Modules"}
    course_list = list(Course_Topics)
    course_list.sort()
    for i in course_list:
            print("*", i)

    print("Problems:")
    Topics = ['Introduction to Python', 'Tools of the Trade', 'How to make decisions', 'How to repeat code', 'How to structure data', 'Functions', 'Modules']
    problems = ('Problem 1, Problem 2, Problem 3')
    for i in Topics:
        print(f"* {i} : {problems}")

    print("Student Progress:")
    student_name = ('Nyari', 'Adam', 'James')
    problems2 = ('Problem 1', 'Problem 2', 'Problem 3')
    status = ('[STARTED]', '[GRADED]', '[COMPLETED]')
        
    for i in range(len(student_name)):
        print(f"{i+1}. {student_name[i]} - {course_list[i]} - {problems2[i]} - {status[i]}")
   



if __name__ == "__main__":
    create_outline()
