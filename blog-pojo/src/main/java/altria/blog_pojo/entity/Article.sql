CREATE TABLE article (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    img VARCHAR(512),
    description TEXT,
    content LONGTEXT NOT NULL,
    category_id INT NOT NULL,
    status VARCHAR(20),
    views BIGINT DEFAULT 0,
    create_time DATETIME DEFAULT NULL,
    update_time DATETIME DEFAULT NULL
);