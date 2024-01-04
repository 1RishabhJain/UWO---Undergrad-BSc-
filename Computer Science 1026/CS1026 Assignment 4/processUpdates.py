"""
COMPSCI 1026A 003
Rishabh Jain
December 5th, 2019

Assignment 4 - processUpdates.py
A program that takes a text file with a list of countries and their information, and updates the existing
information with the new data according to country
"""


# Assignment 4 - processUpdates.py

from catalogue import CountryCatalogue


# processUpdates uses the two file names (country and update), to update the country values required
def processUpdates(countryFileName, updateFileName):
    continueUpdate = True
    countryFile = countryFileName
    updateFile = updateFileName

    # will update the file depending on user input
    while continueUpdate:
        fileExist = False

        # attempts to open the country file and handles the error if the file does not exist
        try:
            countryData = open(countryFile, "r")
            fileExist = True

        # handles the error and prints out the statement
        except FileNotFoundError:
            print("\nThe country file was not found in the directory.\nWould you like to try again? Yes(Y) or No(N)")

        # if the file does not exist, will continue to ask until valid input entered or the user chooses to quit
        if not fileExist:
            choiceInput = input()
            if choiceInput == "Y":
                countryFile = input("Enter name of file with country data: ")
            if choiceInput != "Y":
                outputUnsuccessful()
                return False

        # if the file exists it will pass it will call the CountryCatalogue
        if fileExist:
            catalogue = CountryCatalogue(countryData)
            fileUpdate = False

            # attempts to open the update file and handles the error if the file does not exist
            try:
                updates = open(updateFile, "r")
                fileUpdate = True

            # handles the error and prints out the statement
            except FileNotFoundError:
                print("\nThe update file was not found in the directory.\nWould you like to try again? Yes(Y) or No(N)")

            # if the file does not exist, will continue to ask until valid input entered or the user chooses to quit
            if not fileUpdate:
                choiceInput = input()
                if choiceInput != "Y":
                    outputUnsuccessful()
                    countryData.close()
                    return False
                if choiceInput == "Y":
                    updateFile = input("Enter name of file with country updates: ")

            # once both files are inputted correctly, program will get the updates needed
            if fileUpdate:
                updateList = getUpdates(updates)
                for item in updateList:
                    countryName = item[0]
                    if countryName in catalogue.getDictionary():
                        if item[1] != "":
                            catalogue.getDictionary()[countryName].setPopulation(item[1])
                        if item[2] != "":
                            catalogue.getDictionary()[countryName].setArea(item[2])
                        if item[3] != "":
                            catalogue.getDictionary()[countryName].setContinent(item[3])
                    else:
                        catalogue.addCountry(countryName, item[1], item[2], item[3])
                catalogue.saveCountryCatalogue("output.txt")
                countryData.close()
                updates.close()
                return True


# Called when there is an unsuccessful output
def outputUnsuccessful():
    # writes to the output file that it was unsuccessful and closes the file
    file = open("output.txt", "w")
    file.write("Update Unsuccessful\n")
    file.close()


# interprets the update file and stores the required updates in a list
def getUpdates(updates):
    updateList = []

    # goes through each line and checks what needs to be updated
    for line in updates:
        countryName = ""
        updatedPopulation = ""
        updatedArea = ""
        updatedContinent = ""
        contentList = line.split(";")
        contentList_noSpaces = []
        for content in contentList:
            contentList_noSpaces.append(content.strip(" \n"))
        countryName = contentList[0]

        # updates according to label (P, A or C)
        for content in contentList_noSpaces:
            if content[0] == "P" and content[1] == "=":
                updatedPopulation = content[2:]
            if content[0] == "A" and content[1] == "=":
                updatedArea = content[2:]
            if content[0] == "C" and content[1] == "=":
                updatedContinent = content[2:]

        # updates the updateList with the new values
        updateList.append((countryName, updatedPopulation, updatedArea, updatedContinent))
    return updateList
