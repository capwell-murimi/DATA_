--The club is adding a new facility - a spa. We need to add it into the facilities table. Use the following values:
--facid: 9, Name: 'Spa', membercost: 20, guestcost: 30, initialoutlay: 100000, monthlymaintenance: 800.
INSERT INTO cd.facilities 
(facid,name,membercost,guestcost,initialoutlay,monthlymaintenance) 
VALUES(9,'Spa',20,30,100000,800);


--In the previous exercise, you learned how to add a facility. Now you're going to add multiple facilities in one command. Use the following values:
--facid: 9, Name: 'Spa', membercost: 20, guestcost: 30, initialoutlay: 100000, monthlymaintenance: 800.
--facid: 10, Name: 'Squash Court 2', membercost: 3.5, guestcost: 17.5, initialoutlay: 5000, monthlymaintenance: 80.
INSERT INTO cd.facilities 
(facid,name,membercost,guestcost,initialoutlay,monthlymaintenance) 
VALUES(9,'Spa',20,30,100000,800),(10,'Squash Court 2',3.5,17.5,5000,80);


--Let's try adding the spa to the facilities table again. This time, though, we want to automatically generate the value for the next facid, rather than specifying it as a constant. Use the following values for everything else:
--Name: 'Spa', membercost: 20, guestcost: 30, initialoutlay: 100000, monthlymaintenance: 800.
INSERT INTO cd.facilities 
(facid,name,membercost,guestcost,initialoutlay,monthlymaintenance) 
VALUES
(
    (
        SELECT MAX(facid)+1 FROM cd.facilities
    ),
            'Spa', 20, 30, 100000, 800
);


--We made a mistake when entering the data for the second tennis court. 
--The initial outlay was 10000 rather than 8000: you need to alter the data to fix the error.
UPDATE cd.facilities
SET initialoutlay = 10000
WHERE name = 'Tennis Court 2';


--We want to increase the price of the tennis courts for both members and guests.
--update the costs to be 6 for members, and 30 for guests.
UPDATE cd.facilities
SET membercost = 6, guestcost = 30
WHERE name IN('Tennis Court 1','Tennis Court 2');


--We want to alter the price of the second tennis court so that it costs 10% more than the first one. Try to do this without using constant values for the prices, 
--so that we can reuse the statement if we want to.
UPDATE cd.facilities
SET membercost = (SELECT membercost * 1.1 FROM cd.facilities WHERE facid = 0),
	guestcost = (SELECT guestcost * 1.1 FROM cd.facilities WHERE facid = 0)
WHERE name = 'Tennis Court 2';


--As part of a clearout of our database, 
--we want to delete all bookings from the cd.bookings table. How can we accomplish this?
DELETE FROM cd.bookings;


--We want to remove member 37, 
--who has never made a booking, from our database. How can we achieve that?
DELETE FROM cd.members WHERE memid = 37;


--In our previous exercises, we deleted a specific member who had never made a booking. How can we make that more general,
--to delete all members who have never made a booking?
DELETE FROM cd.members
WHERE memid NOT IN(SELECT memid FROM cd.bookings);
--OR
DELETE FROM cd.members
WHERE NOT EXISTS(SELECT 1 FROM cd.bookings WHERE cd.members.memid = cd.bookings.memid);
--Using 1 in the query doest display anything which is efficient in this case since we are checking if the members who have booked exist