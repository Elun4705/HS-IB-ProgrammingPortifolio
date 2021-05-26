![alt text](http://www.stockmarketgame.org/img/horizontal_logo_lg.png "StockMarketGame")

###### Skyline's automated stock investor app to compete in the semi-annual student based stock market game. All logic and business rules must conform to the [StockMarketGame](http://www.stockmarketgame.org "Documentation").

---
## Project Description:
  * App is designed to run unattended on a Raspberry Pi through the real date of the Stock Market Game
  * App decides when to purchase and sell stocks throughout the ten week period based on live stock data, starting with $100,000 fake dollars.
  * App reports balances and runtime stats via email daily.
  * App will write to log files that track all automated buy/sell decisions made.
  * Stock Market Game runs from February 1 to April 9

---
## Yahoo Finance API

The official Yahoo Finance API was discontinued in 2017. However, we found an unofficial java API called yahoofinance-api that should suit our needs. This API can be found at https://github.com/sstrickx/yahoofinance-api. This API is a vital component of the project as it is responsible for getting any stock data. It took many hours of work to impliment and incorperate this API into the systems, and the final result is quick and efficient.

---
## JavaMail API and JAF

The combination of the JavaMail API and the Javabeans API is used to send emails. It sends the entire history of the project's runtime to us at the cosing of the stock market every day

---
## Other API information

Unfortunately, there is no API to work with the Stock Market Game. Building an API from scratch is beyond the scope of our project, so rather than interact with the Stock Market Game directly, we will store stock information and profits internally.

---
## Buying and Selling Systems and Algorithms

This program works of a very simple algorithm that runs on a timer or 10 minutes. At the end of the timer, and assuming the stock market is open, The algorithm will determin the 5 best stocks to purchased based off of their percentage delta at the time of query. It will then sell every one of its stocks not on that list, and purchase as many of those stocks as it can afford to.

---
## Class Diagram
![class_diagram](https://github.com/SkylineHigh/StockInvestor/blob/master/doc/classDiagram.png)

---
## Example Output
![example_output](https://github.com/SkylineHigh/StockInvestor/blob/master/doc/example_output.png)
