DROP FUNCTION find_products_by_price(numeric, numeric);

CREATE OR REPLACE FUNCTION find_products_by_price(
    min_price NUMERIC(10, 2),
    max_price NUMERIC(10, 2)
)
    RETURNS TABLE
            (
                id          BIGINT,
                name        VARCHAR(250),
                price       NUMERIC(10, 2),
                category_id SMALLINT,
                description TEXT
            )
AS
$$
BEGIN
    RETURN QUERY
        SELECT products.id          AS id,
               products.name        AS name,
               products.price       AS price,
               products.category_id AS category_id,
               products.description AS description
        FROM products
        WHERE products.price BETWEEN min_price AND max_price
        ORDER BY products.name;
END;
$$ LANGUAGE plpgsql;
