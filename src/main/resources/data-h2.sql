Insert into Item(id, Cost, Type) values(1,10, 'Ping-pong ball');
Insert into Location(id, Street, Town, zip, state) values(1,'1000 Sherman Ave', 'Evanston', 60201, 'IL');
Insert into Sponsor(id, name, size, type) values(1,'Dominos','m','Restaurant');
Insert into Project values (1, CURRENT_DATE(), 15, 500, 1, 1, 1);

Insert into Item(Cost, Type) values(5, 'Towels');
Insert into Location(Street, Town, zip, state) values('200 Chicago', 'Evanston', 60201,'IL');
Insert into Sponsor(name, size, type) values('Saville','s','Flower Shop');
Insert into Project values (2, CURRENT_DATE(), 15, 500, 2, 2, 2);

Insert into Location(Street, Town, zip, state) values('1 Chicago', 'Evanston', 60201,'IL');
Insert into Location(Street, Town, zip, state) values('2 Chicago', 'Evanston', 60201,'IL');
Insert into Location(Street, Town, zip, state) values('3 Chicago', 'Evanston', 60201,'IL');

INSERT INTO Item (Cost, Type) VALUES (1, 'cups');
INSERT INTO Item (Cost, Type) VALUES (1, 'towels');
INSERT INTO Item (Cost, Type) VALUES (1, 'frisbees');

INSERT INTO Sponsor(NAME, SIZE, type) VALUES('Arbys', 's', 'Restaurant') ;
INSERT INTO Sponsor(NAME, SIZE, type) VALUES('McDonalds', 's', 'Restaurant') ;
INSERT INTO Sponsor(NAME, SIZE, type) VALUES('Burger King', 's', 'Restaurant') ;
Insert into Project values (3, CURRENT_DATE(), 15, 500, 3, 4, 5);
Insert into Project values (4, CURRENT_DATE(), 15, 500, 3, 4, 5);
Insert into Project values (5, CURRENT_DATE(), 15, 500, 3, 4, 5);






-- Select * from Item;
-- Select * from Location;
-- Select * from Project;
-- Select * from Sponsor;