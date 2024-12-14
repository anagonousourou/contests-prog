-- https://leetcode.com/problems/employees-earning-more-than-their-managers/submissions/1457244909/

SELECT t1.name AS 'Employee' FROM Employee AS t1 JOIN Employee AS t2 ON t1.managerId = t2.id WHERE t1.salary > t2.salary;