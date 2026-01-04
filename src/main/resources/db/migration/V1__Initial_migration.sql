CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       password_hash VARCHAR(255) NOT NULL,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE addresses(
                          id SERIAL PRIMARY KEY,
                          user_id INT NOT NULL,
                          street VARCHAR(255) NOT NULL,
                          village VARCHAR(255) NOT NULL,
                          state VARCHAR(255) NOT NULL,
                          pincode VARCHAR(255) NOT NULL,
                          FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);



