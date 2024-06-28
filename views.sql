 
-- Create a simple view that selects specific columns from a single table.
create view OrderView as select OrderID,OrderDate from Orders;

 
select * from CustomerView;
-- Create a view that includes a WHERE clause to filter data in the view.
create view CustomerView as select * from Customers where CustomerID<10;

 -- Create a view that joins two or more tables.
 
 create view SampleJoins as select p.ProductName,o.OrderID,o.Quantity from Products p join OrderDetails o on p.ProductID=o.ProductID;

-- Update a view to reflect changes in underlying tables.

update  OrderView set OrderDate=now() where OrderID=1;
select * from OrderView;
-- Drop a view from the database.

drop view OrderView;
-- Create a view with aggregate functions like COUNT, SUM, and AVG.
Create view ProductAggregate as select Sum(Price) from Products;

-- Create a view that uses CASE statements for conditional logic.

create view ConditionalView as select case when Price<500 then "Fair Price" 
                                            when Price>500 then "High cost" 
                                            end from Products;
-- Create a view that includes a subquery.
create view SubView as select p.ProductName   from Products p    where p.ProductID not in (select OrderID from Orders);


-- Create a view with UNION or UNION ALL to combine data from multiple queries

create View Combine as (Select CustomerID from Customers ) union (Select CustomerID from Orders); 
 
-- Verify Primary Key Indexes (already created in table definitions) as primary key or not


-- Create a Primary key index on the Customers table on CustomerID
create   Unique Index CustomerIndex on Customers(CustomerID);
drop Index   CustomerIndex on Customers;

-- Create a Unique Index on the ContactName column in the Customers table
Create Unique Index ContactIndex on Customers(ContactName);
-- Create a Unique Index on the ProductName column in the Products table
Create Unique Index ProductIndex on Products(ProductName);
drop Index   ProductIndex on Products;
-- Create a Normal Index on the Country column in the Customers table
Create Index CountryIndex on Customers(Country);
-- Create a Normal Index on the Price column in the Products table
create Index PriceIndex on Products(Price);
-- Create a Composite Index on the ContactName and Country columns in the Customers
-- table

create Index Composite on Customers(ContactName,Country);
-- 8. Create a Composite Index on the OrderDate and CustomerID columns in the Orders table

create Index CompositeOrder on Orders(OrderDate,CustomerID);  



-- Subquery in the FROM Clause
-- Find the total quantity ordered for each product.

select ProductID,sum(Quantity) from OrderDetails group by ProductID;

select ProductID ,(select sum(Quantity) from OrderDetails o where  o.ProductID=o1.OrderID) from OrderDetails o1;

-- List customers along with the number of orders they have placed.
select c.CustomerName , count(o.OrderID) from Customers c,Orders o  where c.CustomerID =o.CustomerID group by o.CustomerID  ;


select c.CustomerName , (select count(OrderID) from Orders o where o.CustomerID=c.CustomerID)  from Customers c  ;

-- Find the average order quantity for each product.

select ProductID,avg(Quantity) from OrderDetails Group by ProductID;

select ProductID ,(select avg(Quantity) from OrderDetails o where  o.ProductID=o1.OrderID) from OrderDetails o1;

-- Subquery in the SELECT Statement 
-- List customers with their total number of orders.
select c.CustomerName ,count(o.OrderID) as TotalOrders from Customers c join  Orders o where c.CustomerID=o.CustomerID group by c.CustomerID;


select c.CustomerName ,(select count(o.OrderID) from Orders o  where c.CustomerID=o.CustomerID)as TotalOrders from Customers c     group by c.CustomerID;

-- List products with their total quantity ordered.
Select ProductName,sum(Quantity) as TotalQuantity from Products p ,OrderDetails o where p.ProductID=o.ProductID group by p.ProductID;


-- List customers with their latest order date. 

select c.CustomerName ,o.OrderDate from Customers c join Orders o   where c.CustomerID=o.OrderID  order by o.OrderDate desc;

-- Subquery in the WHERE Clause
-- List orders that include the product 'Smartphone' 

Select o.OrderID from Orders o1 join OrderDetails o join Products p on o.ProductID=p.ProductID and o.OrderID=o1.OrderID and  p.ProductName="Smartphone";
 
Select o.OrderID from Orders o1 join OrderDetails o join Products p on o.ProductID=p.ProductID and o.OrderID=o1.OrderID and  p.ProductID in (select ProductID from Products where ProductName="Smartphone");

-- 8. Find customers who have ordered products that cost more than $500.

select CustomerName,p.ProductName,p.Price from Customers c join Orders o join OrderDetails o1 join Products p on c.CustomerID=o.CustomerID and o.OrderID=o1.OrderID and o1.ProductID=p.ProductID where p.Price>500;

select CustomerName from Customers where CustomerID in (select c.CustomerID from Customers c join OrderDetails o  join Orders o1 join Products p on c.CustomerID=o1.CustomerID and p.ProductID=o.ProductID and o.OrderId=o1.OrderID where p.Price>500);


 -- 9. List products that have been ordered by 'John Doe'.

select CustomerName,p.ProductName,p.Price from Customers c join Orders o join OrderDetails o1 join Products p on c.CustomerID=o.CustomerID and o.OrderID=o1.OrderID and o1.ProductID=p.ProductID where c.CustomerName='John Doe';
select ProductName from Products p join OrderDetails o join Orders o1 on o.OrderID=o1.OrderID and p.ProductID=o.ProductId where o1.CustomerID in (select CustomerID from Customers where CustomerName='John Doe');

-- Nested


-- 10. Find the names of customers who have placed an order.

select CustomerName from Customers where CustomerID not in ( select CustomerID from Orders);

-- 11. List the products that have never been ordered.
select ProductName from Products where ProductID not in ( select ProductID from OrderDetails);

-- 12. Find the names of customers who have ordered the product 'Laptop'.

select CustomerName , p.ProductName from Customers c join Orders o join OrderDetails o1 join Products p on c.CustomerID=o.CustomerID and o.OrderID=o1.OrderID and o1.ProductID=p.ProductID  where p.ProductName='Laptop';
-- Correlated
-- 13. Find customers who have placed orders with an order date in January 2023.

select CustomerName , p.ProductName ,o.OrderDate from Customers c join Orders o join OrderDetails o1 join Products p on c.CustomerID=o.CustomerID and o.OrderID=o1.OrderID and o1.ProductID=p.ProductID  where o.OrderDate in (select OrderDate from Orders where OrderDate like '2023-01%');


select CustomerName  from Customers c join (select CustomerID from Orders where OrderDate like '2023-01%') o  on c.CustomerID=o.CustomerID;

-- 14. List products ordered more than 3 times in any single order.

select ProductName from Products p join OrderDetails o on p.ProductID=o.ProductID  group by OrderID , p.ProductName having count(p.ProductID)>3; 



SELECT p.ProductName 
FROM Products p 
JOIN OrderDetails o ON p.ProductID = o.ProductID 
JOIN (
    SELECT OrderID
    FROM OrderDetails
    GROUP BY OrderID
    HAVING COUNT(ProductID) > 3
) AS sub ON o.OrderID = sub.OrderID;

-- 15. Find customers who have ordered more than 10 different products.

 
select ProductName from Products p join OrderDetails o   join Orders  o1 join Customers c on p.ProductID=o.ProductID and  c.CustomerID=o1.CustomerID and o.OrderID=o1.OrderID group by o1.CustomerID , p.ProductName having count(p.ProductID)>10; 

select CustomerName from Customers c join (select CustomerID from Orders group by CustomerID having count(OrderID)>10) o where c.CustomerID=o.CustomerID;


Drop table Students;
-- 1. Create a table named Students with a StudentID column set to AUTO_INCREMENT as the
-- primary key.

 create table Students(StudentID int Primary Key auto_increment,StudentName varchar(50));

-- 2. Insert a new student into the Students table without specifying a value for the
-- AUTO_INCREMENT column.

insert into Students(StudentName) values("indu");
-- 3. Retrieve the value generated for the last inserted row in the Students table. 
select StudentID from Students where StudentName="indu";

-- 4. Reset the AUTO_INCREMENT value for the Students table to start from 100.

alter table Students  auto_increment=100;
-- 5. Insert multiple students into the Students table without specifying values for the
-- AUTO_INCREMENT column.
Insert into Students(StudentName) values ("joshi"),("deepthi"),("Sharmila");

-- 6. Retrieve the current AUTO_INCREMENT value for the Students table. 
select StudentID from Students order by StudentId desc limit 1;

select last StudentID from Students
-- 7. Create a table with an AUTO_INCREMENT primary key and other constraints such as NOT
-- NULL and UNIQUE.

create table Library(BookID  int Primary key auto_increment,BookName varchar(100) unique , Author varchar(100) not null);