"""
COMPSCI 1026A 003
Rishabh Jain
December 5th, 2019

Assignment 4 - catalogue.py
A program that takes a text file with a list of countries and their information, and updates the existing
information with the new data according to country
"""

# Assignment 4 - catalogue.py

from country import Country


# Creates country catalogue class
class CountryCatalogue:
    def __init__(self, countryFile):
        self._countryCat = CountryCatalogue.createCountryDictionary(countryFile)

    # creates dictionary and adds values from each line
    def createCountryDictionary(countryFile):
        countryDataFile = countryFile
        # skips over first line with headers
        countryDataFile.readline()

        # defines a country dictionary
        _dictionaryOfCountries = {}

        # goes through each line and adds the values to the dictionary
        for line in countryDataFile:
            formattedLine = line.strip(" \n")
            values = formattedLine.split("|")
            countryName = values[0]
            _dictionaryOfCountries[countryName] = Country(values[0], values[2], values[3], values[1])
        return _dictionaryOfCountries

    # setter methods
    def setPopulationOfCountry(self, pop):
        self._country.setPopulation(pop)

    def setAreaOfCountry(self, area):
        self._country.setArea(area)

    def setContinentOfCountry(self, cont):
        self._country.setContinent(cont)

    # finds the country within dictionary based on country name
    def findCountry(self, country):
        if country.getName() in self._countryCat:
            return country
        else:
            return None

    def getDictionary(self):
        return self._countryCat

    # constructs the country object and adds it to the dictionary if it doesnt already exist
    def addCountry(self, country, pop, area, cont):

        if country not in self._countryCat.keys():

            self._countryCat[country] = Country(country, pop, area, cont)
            return True
        else:
            return False

    # prints the country
    def printCountryCatalogue(self):
        for country in self._countryCat.keys():
            print(self._countryCat[country])

    # outputs data to file
    def saveCountryCatalogue(self, filename):
        # Write the catalogue to a file alphabetically by country
        # Open a file to save catalogue to. Check that it exists.
        file_object = open(filename, 'w')

        # Make a list of the countries sorted alphabetically.
        countryList = []
        for country in self._countryCat.keys():
            countryList.append(country)
        countryList = sorted(countryList)

        # Make item counter to count items written.
        count = 0

        # Write the catalogue to the file.
        file_object.write("Country|Continent|Population|Area\n")
        for country in countryList:
            countryName = self._countryCat[country].getName()
            population = self._countryCat[country].getPopulation()
            area = self._countryCat[country].getArea()
            continent = self._countryCat[country].getContinent()
            file_object.write(countryName + '|' + continent + '|' + str(population) + '|' + str(area) + "\n")
            count += 1

        # Close the file and return count.
        file_object.close()
        if count == 0:
            return -1
        return count
