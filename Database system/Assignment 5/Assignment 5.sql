USE Adventureworks;

-- Exercise 1: Subquery 
-- Question 1
SELECT 
    `Name`
FROM
    Product
WHERE
    ProductSubcategoryID IN (
		SELECT 
            ProductSubcategoryID
        FROM
            Productsubcategory
        WHERE
            name = 'Saddles'
	);


-- Question 2
SELECT 
    `Name`
FROM
    Product
WHERE
    ProductSubcategoryID IN (
		SELECT 
            ProductSubcategoryID
        FROM
            Productsubcategory
        WHERE
            name LIKE 'BO%'
	);


-- Question 3
SELECT 
    `Name`
FROM
    Product
WHERE
    `Name` LIKE 'Touring%'
        AND Productnumber LIKE 'BK%'
        AND ListPrice = (SELECT 
            MIN(`ListPrice`)
        FROM
            Product
        WHERE
            `name` LIKE 'Touring%'
                AND productnumber LIKE 'BK%');



-- Exercise 2
-- Question 1
SELECT 
    c.`Name` AS 'Country', 
    s.`Name` AS 'Province'
FROM
    Countryregion c
        JOIN
    Stateprovince s ON c.CountryRegionCode = s.CountryRegionCode;


-- Question 2:
SELECT 
    c.`Name` AS 'Country', 
    s.`Name` AS 'Province'
FROM
    Countryregion c
        JOIN
    Stateprovince s ON c.CountryRegionCode = s.CountryRegionCode
WHERE
    c.`Name` LIKE ('Canada%')
        OR c.`Name` LIKE ('Germany%')
ORDER BY Country;


-- Question 3:
SELECT 
    so.SalesOrderID 	AS 'SalesOrderID',
    so.OrderDate 		AS 'Orderdate',
    so.SalesPersonID 	AS 'SalesPersonID',
    sp.SalesPersonID 	AS 'BusinessEntityID',
    sp.SalesYTD			AS 'Bonus and the SalesYTD'
FROM
    Salesorderheader so
        JOIN
    SalesPerson sp ON so.SalesPersonID = sp.SalesPersonID;


-- Question 4:
SELECT 
    so.SalesOrderID 	AS 'SalesOrderID',
    so.OrderDate 		AS 'Orderdate',
    e.Title 			AS 'Job Title',
    sp.SalesYTD 		AS 'Bonus and the SalesYTD'
FROM
    Salesorderheader so
        JOIN
    SalesPerson sp ON so.SalesPersonID = sp.SalesPersonID
        JOIN
    Employee e ON so.SalesPersonID = e.Employeeid;