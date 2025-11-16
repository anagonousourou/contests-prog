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
