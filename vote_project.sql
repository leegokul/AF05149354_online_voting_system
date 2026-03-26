CREATE DATABASE votingdb;
USE votingdb;

CREATE TABLE voters (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    voted BOOLEAN DEFAULT FALSE
);

CREATE TABLE candidates (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    votes INT DEFAULT 0
);

CREATE TABLE votes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    voter_id INT NOT NULL,
    candidate_id INT NOT NULL,
    FOREIGN KEY (voter_id) REFERENCES voters(id),
    FOREIGN KEY (candidate_id) REFERENCES candidates(id)
);