"""
File used in main.py
sentiment_analysis.py performs the multiple calculations needed to print out the happiness score,
number of keyword tweets and number of tweets per region in the main program
"""
from string import punctuation

# the compute tweets function uses both files to find keywords in the tweets and assign a score to the region
def compute_tweets(tweetFile, keywordFile):
    # Variables for the happiness score for each region
    easternScore = 0
    centralScore = 0
    mountainScore = 0
    pacificScore = 0

    # Variables for the number of keyword tweets
    easternKeywordTweet = 0
    centralKeywordTweet = 0
    mountainKeywordTweet = 0
    pacificKeywordTweet = 0

    # Variables for the number of total tweets
    easternTweetCount = 0
    centralTweetCount = 0
    mountainTweetCount = 0
    pacificTweetCount = 0

    # checks the validity of both file names provided
    tweetValid = checkFile(tweetFile)
    keywordValid = checkFile(keywordFile)

    # if both files are valid the following code is executed
    if tweetValid and keywordValid:
        # opens both files
        tweetFile = open(tweetFile, "r", encoding="utf‐8")
        keywordFile = open(keywordFile, "r", encoding="utf‐8")

        # calls the function to create the dictionary from the keyword file
        keywordDictionary = dictionary(keywordFile)

        # iterates through the tweet file
        for line in tweetFile:
            # calls the function that interprets the line of the tweet file
            latitude, longitude, tweetData = tweetInterpreter(line)

            # calls the function that analyses the score of the tweet line
            tweetScore, keywordTweet = tweetAnalysis(tweetData, keywordDictionary)

            # The score, keyword tweet count, and tweet count is added to the respective region
            # for each if/elif statement, the latitude and longitude is compared to the boundaries of the regions
            if 24.660845 <= latitude <= 49.189787 and -125.242264 <= longitude <= -67.444574:
                # Eastern
                if -87.518395 <= longitude <= -67.444574:
                    easternScore = easternScore + tweetScore
                    easternTweetCount = easternTweetCount + 1
                    easternKeywordTweet = easternKeywordTweet + keywordTweet
                # Central
                elif -101.998892 <= longitude <= -87.518395:
                    centralScore = centralScore + tweetScore
                    centralTweetCount = centralTweetCount + 1
                    centralKeywordTweet = centralKeywordTweet + keywordTweet
                # Mountain
                elif -115.236428 <= longitude <= -101.998892:
                    mountainScore = mountainScore + tweetScore
                    mountainTweetCount = mountainTweetCount + 1
                    mountainKeywordTweet = mountainKeywordTweet + keywordTweet
                # Pacific
                elif -125.242264 <= longitude <= -115.236428:
                    pacificScore = pacificScore + tweetScore
                    pacificTweetCount = pacificTweetCount + 1
                    pacificKeywordTweet = pacificKeywordTweet + keywordTweet

        # creates a tuple for each region. Contains the average score, keyword tweet count, and total tweet count
        eastern = ("EASTERN", "%.2f" % divide(easternScore, easternKeywordTweet), easternKeywordTweet, easternTweetCount)
        central = ("CENTRAL", "%.2f" % divide(centralScore, centralKeywordTweet), centralKeywordTweet, centralTweetCount)
        mountain = ("MOUNTAIN", "%.2f" % divide(mountainScore, mountainKeywordTweet), mountainKeywordTweet, mountainTweetCount)
        pacific = ("PACIFIC", "%.2f" % divide(pacificScore, pacificKeywordTweet), pacificKeywordTweet, pacificTweetCount)

        # returns list of regions
        return [eastern, central, mountain, pacific]
    # returns an empty list when either of the files are invalid
    else:
        return []

# REMAINING FUNCTIONS
# Function that is called in compute tweets to check the validity of file names entered
def checkFile(fileName):
    # will try and open the file, if successful, returns True
    try:
        f = open(fileName)
        f.close()
        result = True
    # if the file is not found, returns false
    except FileNotFoundError:
        result = False
    return result

# function that creates the dictionary of keyword tweets and their scores
def dictionary(keywordFile):
    # creates dictionary with keyword file
    keywordDictionary = {}
    for line in keywordFile:
        word, score = line.split(",")
        score = int(score.strip())
        keywordDictionary[word] = score
    keywordFile.close()
    return keywordDictionary

# function that correctly interprets the tweet file provided
def tweetInterpreter(line):
    # assigns a value to latitude, longitude and the words in the tweet (tweetData)
    data = line.split("]")
    location = data[0]
    tweetData = "]".join(data[1:])
    latitude, longitude = location.split(",")
    latitude = float(latitude.strip("["))
    longitude = float(longitude)
    tweetData = str(tweetData[23:].lower())
    return latitude, longitude, tweetData

# function that compares each word in the tweetData to the keyword dictionary
def tweetAnalysis(tweetData, keywordDictionary):
    tweetCleaned = ""
    tweetScore = 0
    keywordTweet = 0
    counter = 0
    # iterates through the tweet text
    for word in tweetData.split():
        word = word.strip(punctuation)
        tweetCleaned = tweetCleaned + " " + word
        # for each word of the tweet, checks each word in the keyword dictionary
        for i in keywordDictionary:
            # increases the score, counter and keyword tweet value
            if i == word:
                tweetScore = tweetScore + keywordDictionary[i]
                counter = counter + 1
                keywordTweet = 1
    # uses the function divide that will only divide if the denominator is not 0
    tweetScore = divide(tweetScore, counter)
    return tweetScore, keywordTweet

# divide function that performs the division only if the denominator is not 0
# this prevents a divide by zero error
def divide(numerator, denominator):
    if denominator == 0:
        return 0
    else:
        return numerator/denominator
