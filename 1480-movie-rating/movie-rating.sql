
(
SELECT name AS results
FROM MovieRating r
JOIN Users u
ON r.user_id = u.user_id
GROUP BY u.user_id
ORDER BY COUNT(*) DESC, name
LIMIT 1
)

UNION ALL

(
SELECT title AS results
FROM MovieRating r
JOIN Movies m
ON r.movie_id = m.movie_id
WHERE DATE_FORMAT(created_at,'%Y-%m') = '2020-02'
GROUP BY m.movie_id
ORDER BY AVG(rating) DESC, title
LIMIT 1
);