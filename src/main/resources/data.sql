INSERT INTO customers (customer_identifier, last_name, first_name, email_address, street_address, postal_code, city, province,
                       username, password)
VALUES
    ('123e4567-e89b-12d3-a456-556642440000', 'Smith', 'John', 'john.smith@example.com', '123 Maple Street', 'M1M 1M1', 'Toronto', 'Ontario', 'sjhon', 'pwd1'),
    ('223e4567-e89b-12d3-a456-556642440001', 'Johnson', 'Emily', 'emily.johnson@example.com', '456 Oak Avenue', 'V6B 2W1', 'Vancouver', 'British Columbia' ,'jemily', 'pwd2'),
    ('323e4567-e89b-12d3-a456-556642440002', 'Wong', 'Michael', 'michael.wong@example.com', '789 Elm Street', 'H3H 2N2', 'Montreal', 'Quebec','wmichael', 'pwd3'),
    ('423e4567-e89b-12d3-a456-556642440003', 'Patel', 'Sara', 'sara.patel@example.com', '321 Pine Street', 'T2N 4T4', 'Calgary', 'Alberta','psara' , 'pwd4'),
    ('523e4567-e89b-12d3-a456-556642440004', 'Lee', 'David', 'david.lee@example.com', '987 Cedar Avenue', 'K1K 7L7', 'Ottawa', 'Ontario', 'ldavid', 'pwd5'),
    ('623e4567-e89b-12d3-a456-556642440005', 'Singh', 'Alisha', 'alisha.singh@example.com', '741 Birch Street', 'L5A 1X2', 'Mississauga', 'Ontario','salisha' , 'pwd6'),
    ('723e4567-e89b-12d3-a456-556642440006', 'Chen', 'Jason', 'jason.chen@example.com', '852 Elmwood Drive', 'B3A 2K6', 'Halifax', 'Nova Scotia','cjason', 'pwd7' ),
    ('823e4567-e89b-12d3-a456-556642440007', 'Garcia', 'Sophia', 'sophia.garcia@example.com', '963 Spruce Road', 'G1P 3T5', 'Quebec City', 'Quebec','gsophia' , 'pwd8'),
    ('923e4567-e89b-12d3-a456-556642440008', 'Martinez', 'Daniel', 'daniel.martinez@example.com', '654 Oak Lane', 'E1A 4R7', 'Fredericton', 'New Brunswick','mdaniel', 'pwd9' ),
    ('a23e4567-e89b-12d3-a456-556642440009', 'Kim', 'Jessica', 'jessica.kim@example.com', '852 Pinecrest Boulevard', 'A1A 5W3', 'St. Johns', 'Newfoundland and Labrador', 'kjessica', 'pwd10');


INSERT INTO products (product_identifier, name, description, size, price, quantity, product_status)
VALUES
    ('123e4567-a456-12d3-e89b-556642440000', 'T-Shirt', 'Plain white cotton T-shirt', 'Medium', 15.99, 50, 'IN_STOCK'),
    ('123e4567-a456-12d3-e89b-556642440001', 'Jeans', 'Blue denim jeans', '32W x 34L', 29.99, 30, 'IN_STOCK'),
    ('123e4567-a456-12d3-e89b-556642440002', 'Sneakers', 'Black and white sneakers', 'US 9', 49.99, 20, 'IN_STOCK'),
    ('123e4567-a456-12d3-e89b-556642440003', 'Hoodie', 'Gray pullover hoodie', 'Large', 39.99, 40, 'IN_STOCK'),
    ('123e4567-a456-12d3-e89b-556642440004', 'Dress Shirt', 'Formal white dress shirt', '15.5 neck', 49.99, 25, 'IN_STOCK'),
    ('123e4567-a456-12d3-e89b-556642440005', 'Skirt', 'Black mini skirt', 'Small', 24.99, 15, 'OUT_OF_STOCK'),
    ('123e4567-a456-12d3-e89b-556642440006', 'Jacket', 'Leather biker jacket', 'Medium', 89.99, 10, 'IN_STOCK'),
    ('123e4567-a456-12d3-e89b-556642440007', 'Sweatpants', 'Gray sweatpants', 'Large', 29.99, 35, 'IN_STOCK'),
    ('123e4567-a456-12d3-e89b-556642440008', 'Beanie', 'Black knitted beanie', 'One size', 9.99, 50, 'IN_STOCK'),
    ('123e4567-a456-12d3-e89b-556642440009', 'Leggings', 'Black stretch leggings', 'Medium', 19.99, 20, 'IN_STOCK');


INSERT INTO orders (order_identifier, product_identifier, name, price, customer_identifier,  delivery_status, shipping_price, total_price)
VALUES
    ('223e4567-oooo-12d3-a456-556642440001', '123e4567-a456-12d3-e89b-556642440001', 'Jeans', 29.99, '123e4567-e89b-12d3-a456-556642440000',  'PENDING', 10.00, 39.99),
    ('323e4567-oooo-12d3-a456-556642440002', '123e4567-a456-12d3-e89b-556642440002', 'Sneakers', 49.99, '223e4567-e89b-12d3-a456-556642440001',  'DELIVERED', 15.00, 64.99),
    ('423e4567-oooo-12d3-a456-556642440003', '123e4567-a456-12d3-e89b-556642440003', 'Hoodie', 39.99, '323e4567-e89b-12d3-a456-556642440002',  'PENDING', 10.00, 49.99),
    ('523e4567-oooo-12d3-a456-556642440004', '123e4567-a456-12d3-e89b-556642440004', 'Dress Shirt', 49.99, '423e4567-e89b-12d3-a456-556642440003',  'DELIVERED', 15.00, 64.99),
    ('623e4567-oooo-12d3-a456-556642440005', '123e4567-a456-12d3-e89b-556642440006', 'Jacket', 89.99, '523e4567-e89b-12d3-a456-556642440004',  'PENDING', 10.00, 99.99),
    ('723e4567-oooo-12d3-a456-556642440006', '123e4567-a456-12d3-e89b-556642440007', 'Sweatpants', 29.99, '623e4567-e89b-12d3-a456-556642440005',  'DELIVERED', 15.00, 44.99),
    ('823e4567-oooo-12d3-a456-556642440007', '123e4567-a456-12d3-e89b-556642440008', 'Beanie', 9.99, '723e4567-e89b-12d3-a456-556642440006',  'PENDING', 5.00, 14.99),
    ('923e4567-oooo-12d3-a456-556642440008', '123e4567-a456-12d3-e89b-556642440009', 'Leggings', 19.99, '823e4567-e89b-12d3-a456-556642440007',  'PENDING', 5.00, 24.99),
    ('a23e4567-oooo-12d3-a456-556642440009', '123e4567-a456-12d3-e89b-556642440000', 'T-Shirt', 15.99, '923e4567-e89b-12d3-a456-556642440008',  'PENDING', 5.00, 20.99);
