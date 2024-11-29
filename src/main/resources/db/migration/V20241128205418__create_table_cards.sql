CREATE TABLE cards (
      id TEXT PRIMARY KEY UNIQUE NOT NULL,
      name VARCHAR(255) NOT NULL,
      resume VARCHAR(255) NOT NULL,
      description TEXT,
      book VARCHAR(255),
      page INT
);