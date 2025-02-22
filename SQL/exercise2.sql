--How can you produce a list of the start times for bookings by members named 'David Farrell'?
SELECT book.starttime FROM cd.members mem
JOIN cd.bookings book ON mem.memid = book.memid
WHERE CONCAT(mem.firstname + mem.surname) = 'David Farrell';


--How can you produce a list of the start times for bookings for tennis courts, for the date '2012-09-21'? Return a list of start time and facility name pairings, ordered by the time.
SELECT book.starttime, fac.name FROM cd.bookings book
INNER JOIN cd.facilities fac
ON book.facid = fac.facid
WHERE fac.name LIKE '%Tennis Court%'
AND book.starttime >= '2012-09-21' AND book.starttime < '2012-09-22'
ORDER BY book.starttime;


--How can you output a list of all members who have recommended another member?
--Ensure that there are no duplicates in the list, and that results are ordered by (surname, firstname).
SELECT DISTINCT firstname,surname FROM cd.members mem
JOIN (SELECT recommendedby FROM cd.members) as rec
ON mem.memid = rec.recommendedby
ORDER BY mem.surname,mem.firstname;


--How can you output a list of all members, including the individual who recommended them (if any)? 
--Ensure that results are ordered by (surname, firstname).
SELECT
	--mem.recommendedby, id of who recommends
	--rec.memid, id of member
    mem.firstname,
    mem.surname,
    rec.firstname AS recfname,
    rec.surname AS recsname
FROM cd.members mem
LEFT JOIN cd.members rec
    ON rec.memid = mem.recommendedby  --match the id of a member to be the same of whoever recommends
ORDER BY mem.surname, mem.firstname;


--How can you produce a list of all members who have used a tennis court? 
--Include in your output the name of the court, and the name of the member formatted as a single column.
--Ensure no duplicate data, and order by the member name followed by the facility name.
SELECT DISTINCT CONCAT(mem.firstname,' ',mem.surname) as member,fac.name as facility 
FROM cd.members mem
INNER JOIN cd.bookings book 
ON mem.memid  = book.memid
INNER JOIN cd.facilities fac
ON book.facid = fac.facid
WHERE fac.name in('Tennis Court 1', 'Tennis Court 2')
ORDER BY member,facility;
--OR
/*SELECT DISTINCT mem.firstname||' '|| mem.surname as member,fac.name as facility 
FROM cd.members mem
INNER JOIN cd.bookings book 
ON mem.memid  = book.memid
INNER JOIN cd.facilities fac
ON book.facid = fac.facid
WHERE fac.name in('Tennis Court 1', 'Tennis Court 2')
ORDER BY member,facility*/ --IN POSTGRESQL


--How can you produce a list of bookings on the day of 2012-09-14 which will cost the member (or guest) more than $30? 
--Remember that guests have different costs to members (the listed costs are per half-hour 'slot'), and the guest 
--user is always ID 0. Include in your output the name of the facility, the name of the member formatted as a single column, 
--and the cost.Order by descending cost, and do not use any subqueries.
SELECT CONCAT(mem.firstname,' ',mem.surname),fac.name,
CASE
	WHEN mem.memid = 0 THEN book.slots*fac.guestcost
	ELSE book.slots*fac.membercost
END as cost
FROM cd.members mem
INNER JOIN cd.bookings book
ON mem.memid = book.memid
INNER JOIN cd.facilities fac
ON book.facid = fac.facid
WHERE book.starttime >= '2012-09-14' AND book.starttime < '2012-09-15' AND CASE
	WHEN mem.memid = 0 THEN book.slots*fac.guestcost
	ELSE book.slots*fac.membercost
END > 30
ORDER BY cost;


--How can you output a list of all members, including the individual who recommended them (if any),
--without using any joins? Ensure that there are no duplicates in the list, and that each 
--firstname + surname pairing is formatted as a column and ordered.
SELECT DISTINCT CONCAT(firstname,' ',surname) AS member,
(SELECT CONCAT(firstname,' ',surname) 
 FROM cd.members rec 
 WHERE mem.recommendedby = rec.memid)AS recommender 
 FROM cd.members mem
 ORDER BY member;


--The Produce a list of costly bookings exercise contained some messy logic: we had to calculate the 
--booking cost in both the WHERE clause and the CASE statement. 
--Try to simplify this calculation using subqueries. For reference, the question was:
--How can you produce a list of bookings on the day of 2012-09-14 which will cost the member (or guest) more than $30? 
--Remember that guests have different costs to members (the listed costs are per half-hour 'slot'), and the guest user is always ID 0. 
--Include in your output the name of the facility, 
--the name of the member formatted as a single column, and the cost. Order by descending cost.


