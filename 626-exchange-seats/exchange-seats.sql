SELECT id,
    CASE
        WHEN id % 2 = 1 THEN
            COALESCE(
                (SELECT s.student
                 FROM Seat s
                 WHERE s.id = s1.id + 1),
                s1.student
            )
        WHEN id % 2 = 0 THEN
            (SELECT s.student
             FROM Seat s
             WHERE s.id = s1.id - 1)
    END AS student
FROM Seat s1;