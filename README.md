# Android-And-Adidas
Hello and welcome

## Things I would've done with more time

### Finished detail page
Currently, the onlick method takes you to the detail fragment, however I need to pass in the selected product page using the parcelable interface

### Solve the Glide bug
Somehow images weren't loaded correctly, this leads to a placeholder image being loaded. Must find out what's up with Glide and make it work better

### Add filters
Would be cool to add filters to filter products obviously

### Add review get request and post request
When a selected product is viewed, I should retrieve the reviews for that product and provide functionality to add a review

### Improve the UI
Would love to give the fonts a pretty font 

### Add translations
Would be amazing to add in Dutch translation

## What coul've been done better
I noticed as I ran the docker compose file that the db was corrupted. This made it impossible for the product and review containers to retrieve data from the mongo db container

Since the API couldn't retrieve products or reviews, I can't start working on the Android app, since I don't have a data source. Due to this issue, I lost a lot of time

Another problem with docker was one of the containers was attempting to run on a port which was already occupied on my latptop

Thankfully with the help of a friend, I managed to identify the issue. Each time ```docker-compose up``` is ran, the folder creates a "data" folder. 
And when restart the docker compose, the DB becomes corrupted because the data folder already exists. To solve this, I must delete this data folder every single time
I wanted to restart the docker compose file.

Another issue was the port. This was solved by somehow restarting my laptop then immediately running the docker compose file

## What I learned
For the past week, I have been going through the course on Udacity for Kotlin Android development, where core topics are covered. And thanks to the course,
I had the knowledge required to develop the application. To summarise what I learned:
1. App Architectures, what livedata is, what viewmodels are, what a viewmodelfactory is, and why all of this is used
2. Lifecycles. I learned what they are and why it's important to leverage them
3. Retrieving data from the internet. This was done using retrofit. I learned how to parse JSON objects into Kotlin data objects
4. Navigation. I learned how to use the navigation library provided by Android
5. RecyclerViews. I learned how to display a list of items on a screen and how to implement an onclick event for each of them

I can say the most challenging thing to learn the past week was architecture, because I was introduced to so many new concepts. It's Android development done in a 
completely different way. But as long as you know the core fundamentals, it'll all make sense

I also learned how to solve this pesky docker issue, so next time it happens, I'll know what to do

## What I would've done next time
If I had another chance, I'd have completed the courses far earlier. I only spent about a day on the app (7 or 6 hours) and I'm sure if I had more time, I'd be able to
implement more. Majority of my time was spent on learning the Android courses, and also on solving the docker issue.

## How did I find this experience?
I can say I haven't had so much fun in a while! I loved making the app. I was glued to my laptop and kept on working. I love being productive, and I'm proud of what I've made so far

## What's next?
I'm going to continue learning, the journey won't ever stop, and I'll continue working on this app
