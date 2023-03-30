#https://docs.python.org/3/library/string.html#format-specification-mini-language
#https://mkaz.blog/working-with-python/string-formatting/
#https://pyformat.info/
#https://peps.python.org/pep-0498/
if __name__ == '__main__':
    n = int(input())
    student_marks = {}
    for _ in range(n):
        name, *line = input().split()
        scores = list(map(float, line))
        student_marks[name] = scores
    query_name = input()
    average = sum(student_marks[query_name])/len(student_marks[query_name])
    print('{0:.2f}'.format(average))