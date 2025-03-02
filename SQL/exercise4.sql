--For our first foray into aggregates, we're going to stick to something simple. We want to know how many facilities exist - 
--simply produce a total count.
SELECT COUNT(name) FROM cd.facilities;


--Produce a count of the number of facilities that have a cost to guests of 10 or more.
SELECT COUNT(name) from cd.facilities WHERE guestcost >= 10;


--Produce a count of the number of recommendations each member has made. Order by member ID
SELECT DISTINCT recommendedby ,COUNT(recommendedby)FROM cd.members 
WHERE recommendedby != 0 
GROUP BY recommendedby 
ORDER BY recommendedby;


--Produce a list of the total number of slots booked per facility. For now, just produce an 
--output table consisting of facility id and slots, sorted by facility id.
SELECT facid, SUM(slots) AS "Total Slots" FROM cd.bookings
GROUP BY facid
ORDER BY facid;


--Produce a list of the total number of slots booked per facility in the month of September 2012. 
--Produce an output table consisting of facility id and slots, sorted by the number of slots.
SELECT facid,SUM(slots) AS "Total Slots"
FROM cd.bookings
WHERE starttime >= '2012-09-01' AND starttime <= '2012-10-01'
GROUP BY facid
ORDER BY "Total Slots";


--Produce a list of the total number of slots booked per facility per month in the year of 2012. 
--Produce an output table consisting of facility id and slots, sorted by the id and month.
SELECT facid,EXTRACT(MONTH FROM starttime) AS month,SUM(slots) AS "Total Slots"
FROM cd.bookings
WHERE EXTRACT(YEAR FROM starttime) = 2012
GROUP BY month,facid
ORDER BY facid;


--Find the total number of members (including guests) who have made at least one booking.
SELECT COUNT(DISTINCT memid) FROM cd.bookings;


--Produce a list of facilities with more than 1000 slots booked. 
--Produce an output table consisting of facility id and slots, sorted by facility id.
SELECT facid, SUM(slots) AS "Total Slots"
FROM cd.bookings
GROUP BY facid
HAVING SUM(slots) > 1000
ORDER BY facid;


--Produce a list of facilities along with their total revenue. The output table should consist of facility
-- name and revenue, sorted by revenue. Remember that there's a different cost for guests and members!
SELECT fac.name,
    SUM(
  CASE
  		WHEN book.memid = 0 THEN book.slots * fac.guestcost
  		ELSE book.slots * fac.membercost
  END
  )
AS revenue
FROM cd.bookings book
    JOIN cd.facilities fac
    ON book.facid = fac.facid
GROUP BY fac.name
ORDER BY revenue ASC;


--Produce a list of facilities with a total revenue less than 1000. Produce an output table 
--consisting of facility name and revenue, sorted by revenue. Remember that there's a different cost for guests and members!
SELECT name,SUM(revenue) AS "revenue" 
FROM (
  SELECT fac.name AS name,
  CASE
  		WHEN book.memid = 0 THEN book.slots * fac.guestcost
  		ELSE book.slots * fac.membercost
  END AS revenue
  FROM cd.facilities fac
  JOIN cd.bookings book ON fac.facid = book.facid
  ) AS name_rev 
GROUP BY name
HAVING SUM(revenue) < 1000
ORDER BY "revenue";


--Output the facility id that has the highest number of slots booked. For bonus points, try a version without a LIMIT clause. 
--This version will probably look messy!
SELECT facid,SUM(slots) AS "Total Slots" FROM 
cd.bookings 
GROUP BY facid
ORDER BY "Total Slots" DESC
LIMIT 1;

--Produce a list of the total number of slots booked per facility per month in the year of 2012. In this version, include output 
--rows containing totals for all months per facility, and a total for all months for all facilities. The output table should consist
--of facility id, month and slots, sorted by the id and month. When calculating the aggregated values for all months and all facids,
--return null values in the month and facid columns.
SELECT facid, EXTRACT(MONTH FROM starttime) AS month, SUM(slots) AS slots
FROM cd.bookings
WHERE EXTRACT(YEAR FROM STARTTIME) = 2012
GROUP BY ROLLUP(facid,month)
ORDER BY facid,month;


--Produce a list of the total number of hours booked per facility, remembering that a slot lasts half an hour. The output table 
--should consist of the facility id, name, and hours booked, sorted by facility id. Try formatting the hours to two decimal places.
SELECT book.facid,fac.name, TO_CHAR(SUM((slots * 30)) / 60::DECIMAL,'FM999999.00') AS "Total Hours"
FROM cd.bookings book
JOIN cd.facilities fac
ON book.facid = fac.facid
GROUP BY book.facid,fac.name
ORDER BY facid;


--Produce a list of each member name, id, and their first booking after September 1st 2012. Order by member ID.
SELECT mem.surname,mem.firstname,mem.memid,MIN(book.starttime) AS "First Booking"
FROM cd.members mem
JOIN cd.bookings book
ON mem.memid = book.memid
WHERE book.starttime > '2012-09-01'
GROUP BY mem.surname,mem.firstname,mem.memid
ORDER BY mem.memid;


--  