CREATE TABLE profiles
(
    id INT PRIMARY KEY,
    bio TEXT,
    phone_number VARCHAR(20) NOT NULL,
    date_of_birth DATE,
    loyalty_points INT CHECK (loyalty_points >= 0) DEFAULT 0,
    FOREIGN KEY (id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE tags
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE user_tags
(
    user_id INT NOT NULL,
    tag_id INT NOT NULL,
    PRIMARY KEY (user_id, tag_id),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
    FOREIGN KEY (tag_id) REFERENCES tags(id) ON DELETE CASCADE
);
