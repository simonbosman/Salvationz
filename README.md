
Salvationz 2010 - A big dance event in the Netherlands
===

Context
---
A big dance event in the Netherlands required a website for promoting the event.  The most wanted requirement was to be able to handle a lot of web traffic at peak intervals.  

Other requirements where:
bye tickets online
subscribe to newsletter
play for prices
book a hotel room
general information about the event
visual effects
integration with social media
snappy look & feel 

Solution
---
After careful reconsideration, I chose Google Cloud Platform as the backend infrastructure. Java on Google App Engine has the following required features.
* Optimized to scale nearly instantaneously to handle huge traffic spikes.
* Most cost-effective for applications that have significant periods where they are not serving traffic.
* OpenJDK based Java runtime supports the standard public Java library.
* Doesn't impose a security manager--your code won't be restricted by Java permissions issues.

For the front-end, I choose Google Web Toolkit.

The following best practices and design patterns were implemented.
* Getting browser history right, and get it right early.
* Use an Eventbus to fight spaghetti
* Embrace asynchrony
* Always be decoupling
* Strive to achieve statelesness
* Command Pattern RPC
* MVP pattern for custom widgets
* Dependency injection of app-wide services
* Unit testing with mock services

See this video for some background
https://www.youtube.com/watch?v=PDuhR18-EdM

Demo
---
As of now, the website is archived for demoing purpose on IBM bluemix.
http://salvationz.mybluemix.net/




