-- Create your SELECT statement here
-- https://www.codewars.com/kata/5809508cc47d327c12000084/train/sql
SELECT * FROM people WHERE age > 50 ORDER BY age DESC;

-- https://www.codewars.com/kata/5809b9ef88b750ab180001ec/train/sql
-- Type your query here
SELECT * FROM students WHERE IsActive == 1;

-- https://www.codewars.com/kata/594a9592704e4d21bc000131/sql
SELECT MOD(number1, number2) FROM decimals

-- https://www.codewars.com/kata/594a691720ac16a544000075
SELECT SQRT(number1) AS root, LOG(number2) AS "log" FROM decimals;

-- https://www.codewars.com/kata/5910b0d378cc2ba91400000b/train/sql
SELECT * FROM students WHERE tuition_received IS NOT true;

-- https://www.codewars.com/kata/590cc86f7557c0494000007e/train/sql

INSERT INTO participants(name, age, attending) VALUES('Patrick', 25, true);

SELECT * FROM participants;

-- https://www.codewars.com/kata/590ba881fe13cfdcc20001b4/train/sql
SELECT * FROM travelers WHERE country != 'Canada' AND country != 'Mexico' AND country != 'USA';


-- https://www.codewars.com/kata/590a95eede09f87472000213/train/sql

SELECT * FROM users WHERE age >= 18;


-- https://www.codewars.com/kata/58111f4ee10b5301a7000175/train/sql


SELECT age, COUNT(*) As people_count FROM people GROUP BY age;

-- https://www.codewars.com/kata/5809575e166583acfa000083

SELECT RANK() over (ORDER BY SUM(points) DESC),COALESCE(NULLIF(clan,''), '[no clan specified]') AS clan, SUM(points) AS total_points , COUNT(*) AS total_people FROM people GROUP BY clan;

