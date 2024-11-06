DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS customers;
DROP TABLE IF EXISTS products;

CREATE TABLE IF NOT EXISTS customers
(
    id
    INTEGER
    NOT
    NULL
    AUTO_INCREMENT
    PRIMARY
    KEY,
    customer_identifier
    VARCHAR
(
    50
) UNIQUE,
    last_name VARCHAR
(
    50
),
    first_name VARCHAR
(
    50
),
    email_address VARCHAR
(
    50
),
    street_address VARCHAR
(
    50
),
    postal_code VARCHAR
(
    50
),
    city VARCHAR
(
    50
),
    province VARCHAR
(
    50
),
    username VARCHAR
(
    50
),
    password VARCHAR
(
    50
)
    );



CREATE TABLE IF NOT EXISTS products
(
    id
    INTEGER
    NOT
    NULL
    AUTO_INCREMENT
    PRIMARY
    KEY,
    product_identifier
    VARCHAR
(
    50
) UNIQUE,
    name VARCHAR
(
    50
),
    description VARCHAR
(
    300
),
    size VARCHAR
(
    50
),
    price DECIMAL
(
    10,
    2
),
    quantity INTEGER,
    product_status VARCHAR
(
    50
)
    );


CREATE TABLE IF NOT EXISTS orders
(
    id
    INTEGER
    NOT
    NULL
    AUTO_INCREMENT
    PRIMARY
    KEY,
    order_identifier
    VARCHAR
(
    50
) UNIQUE,
    product_identifier VARCHAR
(
    50
),
    name VARCHAR
(
    50
),
    price DECIMAL
(
    10,
    2
),
    customer_identifier VARCHAR
(
    50
),
    delivery_status VARCHAR
(
    50
),
    shipping_price DECIMAL
(
    10,
    2
),
    total_price DECIMAL
(
    10,
    2
),
    FOREIGN KEY
(
    product_identifier
) REFERENCES products
(
    product_identifier
),
    FOREIGN KEY
(
    customer_identifier
) REFERENCES customers
(
    customer_identifier
)

    );
