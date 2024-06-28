 -- Create a stored procedure to add a new customer to the Customers table.
Delimiter //
 create procedure InsertItem(in Cname varchar(100), in area varchar(100),in ContactNumer varchar(20),in email varchar(100))
 begin
 
 insert into Customers(CustomerName,Country,ContactNumber,Email) values(Cname,area,ContactNumber,email) ;
 
 end ; //
 
 

call  InsertItem("Jhon Doe","USA","1144443122","Jane@gmail.com")

 
-- Create a stored procedure to add a new product to the Products table.

 


-- Create a stored procedure to add a new order to the Orders table.
-- Create a stored procedure to add details for an order to the OrderDetails table.
-- Create a stored procedure to retrieve all orders for a specific customer.
-- Create a stored procedure to retrieve all details for a specific order.
-- Create a stored procedure to update customer information in the Customers table.
-- Create a stored procedure to delete a customer from the Customers table.\



-- 1. Create a stored procedure that uses a cursor to iterate over all customers and print their
-- details

Delimiter \\

create Procedure Iter ()
begin  

DECLARE done int DEFAULT 0;
declare  C_iD int;
declare CName varchar(100);
declare Country , Cnum , Email varchar(100);
declare   d cursor  for (select * from Customers);
 
DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
drop table  if exists TempCustomer;

create Temporary table TempCustomer(CId int,CName varchar(100),Country varchar(50),Cno varchar(20),Email varchar(100));
 
open d;
read_loop :Loop

fetch d into C_id ,CName,Country,Cnum,Email;
IF done THEN 
			leave read_loop;
		END IF;
Insert into TempCustomer values(C_id,CName,Country,Cnum,Email);

end loop;   
-- select concat(C_id) as CustomerID , concat(Cname) as CustomerName, concat(Country) as Country, concat(Cnum) as ContactNumber, concat(Email) as Email ;
-- end Loop; 
close d ;

Select * from TempCustomer;

 
end ;  \\
 

drop Procedure Iter;

call Iter();
 
 
 
 delimiter \\
 create trigger AutoAdd  After Insert  on Customers   
 for each row 
 begin
 Insert into CustomerProfiles values(new.CustomerID ,new.CustomerName);
  end; \\
 
 Insert into Customers(CustomerName,Country,ContactNumber,Email) values("Jack","Canada","7854265432","jack12@gmail.com"); 
 
 select * from CustomerProfiles;
 
 
 
--  1. Create a user-defined function to calculate the age of a person given their birthdate.
delimiter \\
create function Age(birth Date) returns int deterministic
   begin
   declare
   a int ;  
   set a=year(now())-year(birth);
 
   return a;
   
   end ;\\


select Age('2002-11-02')
--  Create a stored procedure that divides two numbers and handles the division by zero
-- exception.  
delimiter \\
Create Procedure Divison(in a int, in b int)
begin 
declare  c int ;
DECLARE exit HANDLER FOR SQLEXCEPTION 
begin
Select concat("divide by zero exception") as errormsg;
end;
 
 
set c=a/b;
Select concat("Division of a and b ",c);
  

end \\
Drop Procedure Divison
call Divison(12,0) Products;
 

delimiter \\ 
create trigger ct after insert on Customers 
for each row
begin
Select concat("hello") from Orders;
end \\
 