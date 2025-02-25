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
