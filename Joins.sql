select CustomerName from Customers where Country in (Select Country from Customers); 

select c.CustomerName from Customers c , Orders r ,OrderDetails o where c.CustomerID=r.CustomerID  and  r.OrderID=o.OrderID and ProductID in(select ProductID from Products where ProductName like "%t%") ;

select p.ProductName,o.OrderID,o.Quantity from Products p join OrderDetails o  on p.ProductID=o.ProductID;

select c.CustomerName,p.ProfileDetails from Customers c join CustomerProfiles p on c.CustomerID=p.CustomerID;


select p.ProductName , o.OrderID ,p.Price from Products p join OrderDetails o on p.ProductID=o.ProductID;

select o.OrderDate ,c.CustomerName from Orders o join Customers c on o.CustomerID=c.CustomerID  group by o.CustomerID , c.CustomerName having count(o.OrderID)>2;
SET sql_mode = ''; 


select p.ProductName ,c.email from Products p join OrderDetails o join Orders o1 join Customers c on o1.OrderID=o.OrderID and o.ProductID=p.ProductID and c.CustomerID=o1.CustomerID ;

select p.ProductName ,c.CustomerName ,o1.OrderDate from Products p join OrderDetails o join Orders o1 join Customers c on o1.OrderID=o.OrderID and o.ProductID=p.ProductID and c.CustomerID=o1.CustomerID ;

select p.ProductName , o.OrderID from Products p join OrderDetails o on p.ProductID=o.ProductID; 


select  ContactNumber ,Email from Customers ;


select o.OrderID ,c.CustomerName from Orders o join Customers c on o.CustomerID=c.CustomerID  ;

select p.ProductName,o.OrderID,o.Quantity from Products p join OrderDetails o on p.ProductID=o.ProductID;

select c.CustomerNAme, o.OrderID from Customers c join Orders o  ;


select p.ProductName,p.Price,o.Quantity from Products p  Join OrderDetails o ;


select p.ProductName, o.OrderID from Products p  Join OrderDetails o ;

select c.Email ,o.OrderID from Customers c join Orders o ;

-- Find pairs of customers from the same country.
select c1.CustomerName,c2.CustomerName from Customers c1 cross join Customers c2 where   c1.Country=c2.Country and c1.CustomerID!=c2.CustomerID;
-- List customers who have the same contact name.
select c1.CustomerName,c2.CustomerName from Customers c1 cross join Customers c2 where   c1.ContactName=c2.ContactName and c1.CustomerID!=c2.CustomerID;
 
-- Display customers who share the same country with at least one other customer.
select  c1.CustomerID from Customers c1 join Customers c2 where c1.CustomerID>c2.CustomerID   group by c1.Country having count(c1.CustomerID)>0; 

-- Find customers who have the same contact number prefix (first 3 digits).
select c1.CustomerName,substring(c1.ContactName,1,3) from Customers c1,Customers c2 where c1.CustomerID!=c2.CustomerID and subString(c1.ContactName,1,3)=Substring(c2.ContactName,1,3);

-- Create a list of all possible customer and product combinations.

select c.CustomerName,p.ProductName from Customers c cross join Products p ;

Select * from Products;
 -- Generate a list of all customers and the order quantities they could potentially order. 

select c.CustomerName,o1.Quantity from Customers c join OrderDetails o1 join Orders o on c.CustomerID=o.CustomerID and o.OrderID=o1.OrderID;

-- Show all possible order dates and product names.

select o.OrderDate ,p.ProductName from Products p join Orders o join OrderDetails o1 on p.ProductID=o1.ProductID and o.OrderID=o1.OrderID ;  

-- Show all orders and include product names if they were ordered.
select p.ProductName , o.OrderID from Products p join OrderDetails o join Orders o1  on p.ProductID=o.ProductID and  o.OrderID=o1.OrderID;

select p.ProductName   from Products p    where p.ProductID not in (select OrderID from Orders);

-- Find orders with quantities greater than any previous order' 

select o1.OrderID from OrderDetails o1 ,OrderDetails o3,Orders o2,Orders o4 where o1.OrderID=o2.OrderID and  o3.OrderID=o4.OrderID and o2.OrderDate>o4.OrderDate and o3.Quantity>o1.Quantity;

 
