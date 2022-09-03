CREATE TABLE users(
    id UUID DEFAULT uuid_generate_v4(),
    nickname VARCHAR(255),
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    email_Verified BOOLEAN DEFAULT FALSE
);
