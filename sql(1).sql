/*1 .Write a query to find all countries 
with population greater than 100,000,000 and a surface area less than 1,000,000 sq km. */
SELECT Population,SurfaceArea FROM country WHERE Population>100000000 AND SurfaceArea<1000000;

/*4 .Find the countries in each continent in which 
country name starts with 'A','U' without using the LIKE operator.*/
-- Retriving all the country names which starts with A and U from Specific continent.
SELECT Continent,Name FROM country  WHERE (left(Name,1)='A' or left(Name,1)='U') GROUP BY Continent,Code ORDER BY Continent;

/*5.Find the top 10 cities with the largest population without using any function.*/
SELECT Name,Population FROM city ORDER BY Population DESC LIMIT 10;

/*6.Given the string value 'This dataset contains World report information', write a SQL 
query to display the substring values 'World Information'*/ 
-- The index value of the given substrings "World" and "information" is retrived by using locate method.
-- locate method is used to find the first index value of given substring 
SELECT CONCAT(locate("World","This dataset contains World report information") ,' ',(locate("information","This dataset contains World report information"))) AS Substring_Value;

/*15.Write a stored procedure that takes a continent name as 
an input and returns the total population of that continent.*/ 
-- The result shows the total population of given continent name as Asia.
DELIMITER //
CREATE PROCEDURE CONTINENT_NAME ( -- creqating the procedure
IN Name VARCHAR(100) -- initilizing the variable 
)
BEGIN 
DECLARE result VARCHAR(100); -- declaring the varaible result to store the result
SELECT sum(Population) AS Total_Population FROM country WHERE Continent=Name; -- printing the output 
END ;

drop procedure CONTINENT_NAME;
call CONTINENT_NAME("Asia"); -- calling the procedure 

/*17.Write a user-defined function that takes a country code as 
input and returns the number of official languages spoken in that country.*/ 
-- 
DELIMITER //
CREATE FUNCTION IsOfficialLang(  country_code CHAR(3) )
RETURNS INT
DETERMINISTIC
BEGIN
DECLARE Result INT;
SET Result =(
SELECT count(CountryCode)  FROM countrylanguage WHERE IsOfficial="T" AND CountryCode= country_code);
RETURN Result;
END ;

DROP FUNCTION IsOfficialLang;
SELECT IsOfficialLang("AFG");
 
--  20.Write a stored procedure that uses a cursor to 
-- iterate over all countries and prints their names and populations.

DELIMITER // 
CREATE PROCEDURE pr ()
BEGIN
DECLARE done INT  DEFAULT 0;  --   we have initialised a default value done=0 and it determines whether the loop should execute or not 
DECLARE country_name CHAR(52) ;  --  declared country_name to fetch the value from cursor
DECLARE  populations INT ;        -- declared populations to fetch the value from cursor
DECLARE eam_cursor CURSOR FOR (SELECT Name, Population FROM country); -- initialising the cursor
DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;   -- if condition fails then done is 1 
  
DROP TEMPORARY TABLE IF EXISTS pop;

CREATE  TEMPORARY TABLE pop (countryname CHAR(52), population INT); -- creating a temporary table 
OPEN eam_cursor;   -- opening a cursor
read_loop: LOOP  
FETCH eam_cursor INTO country_name, populations;  -- feting the values from cursor
if done THEN 
LEAVE read_loop;
END IF;
INSERT into pop VALUES(country_name, populations); -- inserting the values to temporary table
END LOOP;
CLOSE eam_cursor ; -- closing the cursor
SELECT * FROM pop;  -- printing the temporary table
END ;
 // delimiter ;
 DROP PROCEDURE pr;  
 CALL pr(); -- calling the procedure