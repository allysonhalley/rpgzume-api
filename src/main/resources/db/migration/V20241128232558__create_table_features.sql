-- Criação da tabela feature com relacionamento 1x1 com card
CREATE TABLE features (
     id TEXT PRIMARY KEY UNIQUE NOT NULL, -- ID único para feature
     card_id TEXT UNIQUE NOT NULL, -- Relacionamento 1x1 com card
     prerequisites VARCHAR(255), -- Pré-requisitos
     benefit TEXT, -- Benefícios
     normal TEXT, -- Descrição normal
     special TEXT, -- Descrição especial,
     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Data de criação
     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, -- Data de atualização

    -- Constraint de chave estrangeira com exclusão em cascata
     CONSTRAINT fk_feature_card FOREIGN KEY (card_id) REFERENCES cards (id) ON DELETE CASCADE
);

-- Índice para performance (opcional)
CREATE INDEX idx_feature_card_id ON features (card_id);
