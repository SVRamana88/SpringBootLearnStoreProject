CREATE OR REPLACE FUNCTION find_products_by_price(
    min_price NUMERIC(10, 2),
    max_price NUMERIC(10, 2)
)
    RETURNS TABLE
            (
                id          BIGINT,
                name        VARCHAR(250),
                price       NUMERIC(10, 2),
                category_id SMALLINT
            )
AS
$$
BEGIN
    RETURN QUERY
        SELECT id, name, price, category_id
        FROM products
        WHERE price BETWEEN min_price AND max_price
        ORDER BY name;
END;
$$ LANGUAGE plpgsql;
