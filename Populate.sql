INSERT INTO users (username, password, email, role) VALUES
('buyer1', 'password12345', 'buyer1@example.com', 'buyer'),  -- Password: buyer1
('buyer2', 'password23456', 'buyer2@example.com', 'buyer');  -- Password: buyer2

INSERT INTO users (username, password, email, role) VALUES
('seller1', 'password34567', 'seller1@example.com', 'seller'),  -- Password: seller1
('seller2', 'password45678', 'seller2@example.com', 'seller');  -- Password: seller2

INSERT INTO users (username, password, email, role) VALUES
('admin', '', 'admin@example.com', 'admin');  -- Password: admin1

INSERT INTO products (name, price, quantity, seller_id) VALUES
('Laptop', 999.99, 10, (SELECT id FROM users WHERE username='seller1')),
('Smartphone', 699.99, 25, (SELECT id FROM users WHERE username='seller1')),
('Headphones', 199.99, 50, (SELECT id FROM users WHERE username='seller2')),
('Tablet', 299.99, 30, (SELECT id FROM users WHERE username='seller2'));