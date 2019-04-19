with open('movie_quotes.txt','r') as file:
    lines = file.readlines()

 #'''   while line != '':
  #      print(line,end='')
   #     line=file.readline() '''
    for line in lines:
        print(line,end='')