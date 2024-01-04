'''
Volume.py stores the functions that calculate and store the volume of the shapes
'''
#imports the math library
from math import*

#creates the 3 lists to store the volumes for each shape type
clist = []
plist = []
elist = []

#cube function responsible for calculating cube volume
def cube(cubeLength):
    cubeVolume = round(cubeLength**3, 2)
    return cubeVolume

#pyramid function responsible for calculating pyramid volume
def pyramid(pyramidBase, pyramidHeight):
    pyramidVolume = round((1/3)*(pyramidBase**2)*(pyramidHeight), 2)
    return pyramidVolume

#ellipsoid function responsible for calculating ellipsoid volume
def ellipsoid(radius1, radius2, radius3):
    ellipsoidVolume = round((4/3)*(pi)*(radius1)*(radius2)*(radius3), 2)
    return ellipsoidVolume
