Insert into Item(id, Cost, Type) values(1,10, 'Ping-pong ball');
Insert into Location(id, Street, Town, zip) values(1,'1000 Sherman Ave', 'Evanston', 60201);
Insert into Sponsor(id, name, size, type) values(1,'Dominos','m','Restaurant');
Insert into Project values (1, CURRENT_DATE(), 15, 500, 1, 1, 1);

Insert into Item(Cost, Type) values(5, 'Towels');
Insert into Location(Street, Town, zip) values('200 Chicago', 'Evanston', 60201);
Insert into Sponsor(name, size, type) values('Saville','s','Flower Shop');
Insert into Project values (2, CURRENT_DATE(), 15, 500, 2, 2, 2);


-- Select * from Item;
-- Select * from Location;
-- Select * from Project;
-- Select * from Sponsor;