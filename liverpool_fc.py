# Mad Libs Generator - Viet Hoang Cao 13/05/2021

def intro_to_lfc():
    print("Welcome to my mad libs game !")
    ans = input("Are you ready ?").strip().lower()
    score = 0
    total_question = 4 

    if ans == "yes":
        print("Then let's proceed to the next stage")
        print(f"You will have {total_question} to get over, each correct answer will earn you a point. In contrast: one question wrong will take away one point")
        football_club = input("What is Viet's favourite soccer club: ").title().strip()
        if football_club == "Liverpool":
            score = score + 1
            print(f"Correct ! Your score is now {score}")
        else:
            score = score - 1
            print(f"Wrong answer ! Your score is now {score}")
        stadium = input("Write down the name of Liverpool's stadium: ").title().strip()
        if stadium == "Anfield":
            score = score + 1
            if football_club == "Liverpool":
                print(f"Very good ! two questions down, two to go. Your score is now {score}")
            else:
                print(f"Your score is back to {score}. Remember to think wisely before answering the following  questions")
        else: 
            score = score - 1
            print("That's bad luck but there is still a lot of chances waiting for you")
        coach = input("Who is Liverpool's coach at the moment ? ").title().strip()
        if coach == "Jurgen Klopp":
            score += 1 
            if stadium == "Anfield":
                print(f"Great jobs ! Jurgen Klopp is such a successful manager. I really love hime. Anyway, your score is now {score}")
            else:
                print(f"Well done ! Your score is now {score}")
        else:
            score -= 1 
            print(f"Incorrect ! Your score is now {score}")
        captain = input("Enter Liverpool's current captain: ").title().strip()
        if captain == "Jordan Henderson":
            score += 1
            if coach == "Jurgen Klopp":
                print(f"Congratulations ! You have done an exceptional job. Your total score is {score}")
            else: 
                print(f"That's the end of this game. Your total score is {score}")
        else:
            print(f"That's a wrong answer. This is the end of this game. Your total score is {score}")

    print("Thank you very much for playing")

intro_to_lfc()   