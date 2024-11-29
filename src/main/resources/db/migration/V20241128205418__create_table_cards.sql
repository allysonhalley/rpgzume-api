CREATE TABLE cards (
    id TEXT PRIMARY KEY UNIQUE NOT NULL,
    name VARCHAR(255) NOT NULL,
    resume VARCHAR(255) NOT NULL,
    description TEXT,
    book VARCHAR(255),
    page INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Data de criação
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP -- Data de atualização
);