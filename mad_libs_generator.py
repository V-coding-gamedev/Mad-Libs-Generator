# Mad Libs Generator - Cao Hoang Viet 13/05/2021

# Questions that the program ask the user
name = input("Enter your name: ").title()
job = input("Enter your job: ").lower()
reason = input("The reason why you want to get into game industry: ").lower()
game_studio = input("Enter your favourite game studio: ").title()
city = input("Enter the city where this game studio is located: ").title()
company_size = input("Enter the total number of employees working in this game studio: ")
Your_Favourite_Game_Of_This_Studio = input("Enter a video game you love most from this game studio: ").title()

# print the story based on the user input
print("My name is " + name + " and I'm a " + job + ".") 
print("The reason why I choose to become a " + job + " is because " + reason + ".") 
print("At the moment, I am working in an AAA studio called " + game_studio + " located in " + city + ".")
print("The total number of employees in our studio is about " + company_size + ".")  
print("For me, I think that the most outstanding game that we have made so far is " + Your_Favourite_Game_Of_This_Studio + ".") 
print("Hopefully, in the future, we will deliver more fantastic games to all of our fans.") 
print("Bye for now and have a great day!" )