-- https://leetcode.com/problems/employees-earning-more-than-their-managers/submissions/1457244909/

SELECT t1.name AS 'Employee' FROM Employee AS t1 JOIN Employee AS t2 ON t1.managerId = t2.id WHERE t1.salary > t2.salary;

-- https://leetcode.com/problems/employee-bonus/submissions/1827068392/

SELECT Employee.name, Bonus.bonus FROM Employee LEFT JOIN Bonus ON Employee.empId = Bonus.empId WHERE  (Bonus.bonus < 1000 OR Bonus.bonus IS NULL);


-- https://leetcode.com/problems/triangle-judgement/submissions/1827078045/

SELECT
    x,
    y,
    z,
    CASE
        -- All three pairwise sums must be greater than the remaining side
        WHEN x + y > z
         AND x + z > y
         AND y + z > x
        THEN 'Yes'
        ELSE 'No'
    END AS triangle
FROM Triangle;


-- https://leetcode.com/problems/biggest-single-number/submissions/1827094656/

SELECT (SELECT num FROM (SELECT MyNumbers.num AS 'num', COUNT(*) AS 'occurrence' FROM MyNumbers GROUP BY MyNumbers.num)
AS OccurrenceCount  WHERE occurrence = 1 ORDER BY num DESC LIMIT 1)  AS num;

-- https://leetcode.com/problems/department-highest-salary/submissions/1831562924/

SELECT Department.name AS 'Department', Employee.name AS 'Employee', Employee.salary AS 'Salary'
 FROM Employee JOIN (SELECT MAX(Employee.salary) AS 'salary', Employee.departmentId FROM Employee GROUP BY Employee.departmentId) AS highestSalaryPerDepartment ON
   highestSalaryPerDepartment.salary = Employee.salary AND highestSalaryPerDepartment.departmentId = Employee.departmentId
   JOIN Department ON Department.id = Employee.departmentId;

 -- https://leetcode.com/problems/nth-highest-salary/submissions/1831591711/

CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    RETURN (
        SELECT salaryRanking.salary FROM
        (SELECT salary, RANK() over(ORDER BY salary DESC) AS 'ranking'
        FROM (SELECT salary AS 'salary' FROM Employee GROUP BY salary) AS distinctSalary ) AS salaryRanking
        WHERE salaryRanking.ranking = N
        LIMIT 1
    );
END

-- https://leetcode.com/problems/combine-two-tables/submissions/1831603507/?envType=problem-list-v2&envId=db-db1-sql-i
SELECT Person.firstName, Person.lastName, Address.city, Address.state FROM
Person INNER JOIN Address ON Person.personId = Address.personId;

-- https://leetcode.com/problems/not-boring-movies/submissions/1831609523/?envType=problem-list-v2&envId=db-db1-sql-i
SELECT * FROM Cinema WHERE description != 'boring' AND MOD(id, 2) ORDER BY rating DESC;

-- https://leetcode.com/problems/find-customer-referee/submissions/1831613044/?envType=problem-list-v2&envId=db-db1-sql-i
SELECT name FROM Customer WHERE ((Customer.referee_id != 2 AND Customer.referee_id IS NOT NULL) OR Customer.referee_id IS NULL);


-- https://leetcode.com/problems/customer-placing-the-largest-number-of-orders/submissions/1831637980/?envType=problem-list-v2&envId=db-db2-filtering-aggregation
SELECT ordersByCustomer.customer_number FROM  (SELECT customer_number, COUNT(order_number) AS 'order_count'
FROM Orders GROUP BY customer_number ORDER BY order_count DESC LIMIT 1) AS ordersByCustomer;

-- https://leetcode.com/problems/classes-with-at-least-5-students/submissions/1831647048/?envType=problem-list-v2&envId=db-db2-filtering-aggregation
SELECT class FROM (SELECT class, COUNT(student) AS 'studentCount' FROM Courses GROUP BY class) AS studentCountByClass
WHERE studentCountByClass.studentCount >= 5;
-- OR:
SELECT class
FROM Courses
GROUP BY class
HAVING COUNT(student) >= 5;
