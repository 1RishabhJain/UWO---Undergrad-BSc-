"""
COMPSCI 1026A 003
Rishabh Jain
December 5th, 2019

Assignment 4 - country.py
A program that takes a text file with a list of countries and their information, and updates the existing
information with the new data according to country
"""


# Assignment 4 - country.py

# creates country class to create country objects
class Country:
    def __init__(self, name, pop, area, continent):
        self._name = name
        self._pop = pop
        self._area = area
        self._continent = continent

    # Getter methods
    def getName(self):
        return self._name

    def getPopulation(self):
        return self._pop

    def getArea(self):
        return self._area

    def getContinent(self):
        return self._continent

    # Setter methods
    def setPopulation(self, population):
        self._pop = population

    def setArea(self, area):
        self._area = area

    def setContinent(self, continent):
        self._continent = continent

    # object string representation
    def __repr__(self):
        return str(self._name) + " (pop: " + self._pop + ", size: " + self._area + ") in " + self._continent
