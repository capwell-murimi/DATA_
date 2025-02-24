# SQL Exercises

## Basics of SQL

### Exercise 1

This category deals with the basics of SQL. It covers `SELECT` and `WHERE` clauses, `CASE` expressions, `UNION`s, and a few other odds and ends. If you're already educated in SQL, you will probably find these exercises fairly easy. If not, you should find them a good point to start learning for the more difficult categories ahead!

If you struggle with these questions, I strongly recommend *Learning SQL* by Alan Beaulieu, as a concise and well-written book on the subject. If you're interested in the fundamentals of database systems (as opposed to just how to use them), you should also investigate *An Introduction to Database Systems* by C.J. Date.

#### Topics Covered

- 📋 Retrieve everything from a table
- 📋 Retrieve specific columns from a table
- 📋 Control which rows are retrieved
- 📋 Control which rows are retrieved - part 2
- 🔍 Basic string searches
- 🔍 Matching against multiple possible values
- 🗂️ Classify results into buckets
- 📅 Working with dates
- 🗑️ Removing duplicates, and ordering results
- 🔗 Combining results from multiple queries
- 📊 Simple aggregation
- 📊 More aggregation

## Joins and Subqueries

### Exercise 2

This category deals primarily with a foundational concept in relational database systems: **joining**. Joining allows you to combine related information from multiple tables to answer a question. This isn't just beneficial for ease of querying: a lack of join capability encourages denormalization of data, which increases the complexity of keeping your data internally consistent.

This topic covers **inner**, **outer**, and **self joins**, as well as spending a little time on **subqueries** (queries within queries). If you struggle with these questions, I strongly recommend *Learning SQL* by Alan Beaulieu, as a concise and well-written book on the subject.

#### Topics Covered

- ⏰ Retrieve the start times of members' bookings
- ⏰ Work out the start times of bookings for tennis courts
- 👥 Produce a list of all members who have recommended another member
- 👥 Produce a list of all members, along with their recommender
- 🎾 Produce a list of all members who have used a tennis court
- 💰 Produce a list of costly bookings
- 👥 Produce a list of all members, along with their recommender, using no joins
- 💰 Produce a list of costly bookings, using a subquery

## Modifying Data

### Exercise 3

Querying data is all well and good, but at some point you're probably going to want to put data into your database! This section deals with inserting, updating, and deleting information. Operations that alter your data like this are collectively known as Data Manipulation Language, or DML.

In previous sections, we returned to you the results of the query you've performed. Since modifications like the ones we're making in this section don't return any query results, we instead show you the updated content of the table you're supposed to be working on. You can compare this with the table shown in 'Expected Results' to see how you've done.

If you struggle with these questions, I strongly recommend *Learning SQL* by Alan Beaulieu.

#### Topics Covered

- ➕ Insert some data into a table
- ➕ Insert multiple rows of data into a table
- ➕ Insert calculated data into a table
- ✏️ Update some existing data
- ✏️ Update multiple rows and columns at the same time
- ✏️ Update a row based on the contents of another row
- 🗑️ Delete all bookings
- 🗑️ Delete a member from the `cd.members` table
- 🗑️ Delete based on a subquery

## Aggregation

### Exercise 4

Aggregation is one of those capabilities that really make you appreciate the power of relational database systems. It allows you to move beyond merely persisting your data, into the realm of asking truly interesting questions that can be used to inform decision making. This category covers aggregation at length, making use of standard grouping as well as more recent window functions.

If you struggle with these questions, I strongly recommend *Learning SQL* by Alan Beaulieu and *SQL Cookbook* by Anthony Molinaro. In fact, get the latter anyway - it'll take you beyond anything you find on this site, and on multiple different database systems to boot.

#### Topics Covered

- 📊 Count the number of facilities
- 📊 Count the number of expensive facilities
- 📊 Count the number of recommendations each member makes
- 📊 List the total slots booked per facility
- 📊 List the total slots booked per facility in a given month
- 📊 List the total slots booked per facility per month
- 📊 Find the count of members who have made at least one booking
- 📊 List facilities with more than 1000 slots booked
- 📊 Find the total revenue of each facility
- 📊 Find facilities with a total revenue less than 1000
- 📊 Output the facility id that has the highest number of slots booked
- 📊 List the total slots booked per facility per month, part 2
- 📊 List the total hours booked per named facility
- 📊 List each member's first booking after September 1st 2012
- 📊 Produce a list of member names, with each row containing the total member count
- 📊 Produce a numbered list of members
- 📊 Output the facility id that has the highest number of slots booked, again
- 📊 Rank members by (rounded) hours used
- 📊 Find the top three revenue generating facilities
- 📊 Classify facilities by value
- 📊 Calculate the payback time for each facility
- 📊 Calculate a rolling average of total revenue