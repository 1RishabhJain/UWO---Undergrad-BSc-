"""
COMPSCI 1026A 003
Rishabh Jain
251103653
October 2nd, 2019

Assignment 1
A basic program that allows the user to place a breakfast order at a restaurant.
The program inputs the users meal choices and prints out their total cost.
"""
#Creates a dictionary called menu that stores the menu item and the price
menu = {"egg": 0.99, "bacon": 0.49, "sausage": 1.49, "hash brown": 1.19, "toast": 0.79, "coffee": 1.09, "tea": 0.89}
#Adds and computes the value for the small, regular and big breakfasts  total
menu["small breakfast"] = menu["egg"] + menu["hash brown"] + 2*menu["toast"] + 2*menu["bacon"] + menu["sausage"]
menu["regular breakfast"] = 2*menu["egg"] + menu["hash brown"] + 2*menu["toast"] + 2*menu["bacon"] + 2*menu["sausage"]
menu["big breakfast"] = 3*menu["egg"] + 2*menu["hash brown"] + 4*menu["toast"] + 6*menu["bacon"] + 3*menu["sausage"]
#Defines a function that removes leading and trailing spaces, and joins words with a single space
def formatInput(textLine):
    textLine = textLine.lower().strip()
    wordList = textLine.split()
    textLine = " ".join(wordList)
    return textLine
#Defines a function that gets the order quantity
def getQuantity():
    global getInput, itemChoice, orderCost
    #while loop that continues to prompt the user to input the quantity until a positive integer is entered
    while not getInput:
        itemQuantity = input("Enter Quantity: ")
        #Checks if input is numeric and greater than 0
        if itemQuantity.isnumeric() and int(itemQuantity) > 0:
            #Increases the orderCost with the product of the item's cost and quantity
            orderCost += int(itemQuantity)*(menu[itemChoice])
            #sets invalidQuantity to False to leave the while loop
            getInput = True
        #Prints the following statement when the input is invalid
        else:
            print("Your input is invalid, please enter a positive integer.")
#Defines a variable called orderCost that stores the total order cost
orderCost = 0
#Prints the order menu
print("\nWelcome to Good Morning America!\n")
print("******* Here is our menu *******")
print(" 1. Small Breakfast   - $6.23")
print(" 2. Regular Breakfast - $8.71")
print(" 3. Big Breakfast     - $15.92")
print(" 4. Egg               - $0.99 each")
print(" 5. Bacon             - $0.49 per strip")
print(" 6. Sausage           - $1.49 each")
print(" 7. Hash Brown        - $1.19 each")
print(" 8. Toast             - $0.79 per slice")
print(" 9. Coffee            - $1.09 per cup")
print("10. Tea               - $0.89 per tea bag\n")
#takeOrder is set to True to enter the while loop
takeOrder = True
#While loop that continues to prompt the user to order food
while takeOrder:
    #Sets getInput to True to enter the while loop that prompts for meal item input
    getInput = True
    while getInput:
        itemChoice = formatInput(input("Enter item (q to terminate): small breakfast, regular breakfast, big breakfast, egg, bacon, sausage, hash brown, toast, coffee, tea: "))
        #checks the user input and quits the program if "q" is entered
        if itemChoice == "q":
            getInput = False
            takeOrder = False
        #If the input is in the menu list it runs the following code
        elif itemChoice in menu:
            #Sets invalidItem to False to exit the current while loop
            getInput = False
            #Calls the function that prompts for the user to input the order quantity
            getQuantity()
        else:
            print("That is not a valid option from the menu, please try again")
#Once the order is complete the program prints out the cost, tax amount and total
print("\nCost:  $%.2f" % round(orderCost, 2))
print("Tax:   $%.2f" % round(orderCost*.13, 2))
print("Total: $%.2f" % round(orderCost*1.13, 2))
