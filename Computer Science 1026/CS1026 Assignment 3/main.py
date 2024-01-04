"""
COMPSCI 1026A 003
Rishabh Jain
November 12th, 2019

Assignment 3
A program that analyzes a text file containing tweets
The tweets are sorted by region and assigned a happiness score based on the value of the words
"""
# imports the sentiment analysis file
from sentiment_analysis import *

# assigns empty list to return to enter the while loop
result = []

while len(result) == 0:

    # imports both the tweet file and keyword file
    tweetFile = input("Please enter the name of the tweet file: ")
    keywordFile = input("Please enter the name of the keyword file: ")

    # tries to call the compute_tweets function (passes the file names) and assigns the value to the result variable
    try:
        result = compute_tweets(tweetFile, keywordFile)

        # if the result is no longer an empty list the following code is executed
        if len(result) != 0:
            print("\nSentiment Analysis of the tweets file, " + tweetFile + ", using keywords from, " + keywordFile)
            # prints the contents of the result line by line
            print("\nREGION    AVERAGE SCORE    KEYWORD TWEETS    TOTAL TWEETS")
            print("---------------------------------------------------------")
            for value in result:
                print("%-8s%10s%17s%18s" % (value[0], value[1], value[2], value[3]))

        # prints an error message, and informs the user to re-enter the values
        else:
            print("\nThere was an error in trying to open either of those files, please re-enter the file names\n")

    # if there is a value error, the exception is handled
    except ValueError:
        print("\nAn error has occurred, please check the files and try again\n")
