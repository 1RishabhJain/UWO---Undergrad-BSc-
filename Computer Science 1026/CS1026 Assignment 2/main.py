"""
COMPSCI 1026A 003
Rishabh Jain
October 16th, 2019

Assignment 2
A program that calculates the volume of the shape entered by the user.
At the end, the program prints the volumes for all the shapes entered.
"""
#Imports the volume.py file and all the objects and methods from the file
from volumes import*
from summarize import*

#Boolean value True set to testNum to enter the while loop
invalidInput = True
while invalidInput:
    testNumber = input("Enter a Test Case Number: ")
    #checks if test case input is numeric
    if testNumber.isnumeric():
        print("This is Test Case {}".format(testNumber))
        invalidInput = False
    else:
        print("Your input is invalid, please enter a positive integer.")

#Boolean value True set to getVolume to enter the while loop
getVolume = True
#While loop that takes user input for shape choice
while getVolume:
    shapeChoice = input("\nChoose an option - (q)uit, (c)ube, (p)yramid, (e)llipsoid: ").lower()
    #checks input against the program options (quit, cube, pyramid, ellipsoid)
    if shapeChoice in ["quit", "q"]:
        getVolume = False
    elif shapeChoice in ["cube", "c"]:
        #Prompts for user to input the length
        cubeLength = float(input("Enter Cube Side Length: "))
        #calls the function to compute the volume
        cubeVolume = cube(cubeLength)
        #adds the volume to the cubeVolume list
        clist.append(cubeVolume)
        #prints the line with the shape length and calculated volume
        print("The volume of a cube with a side length of {} is {}".format(cubeLength, cubeVolume))
    elif shapeChoice in ["pyramid", "p"]:
        #Prompts for user to input dimensions
        pyramidBase = float(input("Enter Pyramid Side Length: "))
        pyramidHeight = float(input("Enter Pyramid Height: "))
        #calls the function to compute the volume
        pyramidVolume = pyramid(pyramidBase, pyramidHeight)
        #adds the volume to the pyramidVolume list
        plist.append(pyramidVolume)
        #prints the line with the shape dimensions and calculated volume
        print("The volume of a pyramid with a base of {} and height of {} is {}".format(pyramidBase, pyramidHeight, pyramidVolume))
    elif shapeChoice in ["ellipsoid", "e"]:
        #Prompts for user to input dimensions
        radius1 = float(input("Enter Radius 1: "))
        radius2 = float(input("Enter Radius 2: "))
        radius3 = float(input("Enter Radius 3: "))
        #calls the function to compute the volume
        ellipsoidVolume = ellipsoid(radius1, radius2, radius3)
        #adds the volume to the ellipsoidVolume list
        elist.append(ellipsoidVolume)
        #prints the line with the shape dimensions and calculated volume
        print("The volume of a ellipsoid with a radius 1 of {}, radius 2 of {} and radius 3 of {} is {}".format(radius1, radius3, radius3, ellipsoidVolume))
    else:
        print("That is not a valid shape option")

#Sorts the three shape lists
clist.sort()
plist.sort()
elist.sort()

print("\nYou have reached the end of your session.\n")

#Checks the contents of the shape lists and outputs the appropriate message
if clist == [] and plist == [] and elist == []:
    print("You did not perform any volume calculations")
else:
    print("The volumes calculated for each shape are:")
    if clist == []:
        print("Cube: No shapes entered")
    else:
        print("Cube:", str(clist).strip("[]"))
    if plist == []:
        print("Pyramid: No shapes entered")
    else:
        print("Pyramid:", str(plist).strip("[]"))
    if elist == []:
        print("Ellipsoid: No shapes entered")
    else:
        print("Ellipsoid:", str(elist).strip("[]"))

#calls the summarize function
summarize(clist,plist,elist,testNumber)
