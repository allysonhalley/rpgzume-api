-- Semilla de Dados para Tormenta RPG (Expandida)

-- ==========================================
-- TALENTOS (FEATURES)
-- ==========================================

-- 1. Ataque Poderoso
INSERT INTO card (id, type, name, resume, description, book, page) VALUES 
('d5e6f7a8-1b2c-3d4e-5f6g-7h8i9j0k1l2m', 'feature', 'Ataque Poderoso', 'Troque precisão por dano bruto.', 'Você sabe desferir golpes pesados e imprudentes.', 'Tormenta RPG', 115);

INSERT INTO feature (id, card_id, feature_type, prerequisites, benefit, normal, special) VALUES 
('a1b2c3d4-e5f6-7890-1234-567890abcdef', 'd5e6f7a8-1b2c-3d4e-5f6g-7h8i9j0k1l2m', 'Combate', 'For 13', 'Ao realizar um ataque corpo-a-corpo, você pode escolher sofrer uma penalidade de –2 no teste de ataque para receber um bônus de +4 na jogada de dano. A penalidade e o bônus duram até o início do seu próximo turno.', 'O bônus de dano não se plica a ataques com armas leves (exceto desarmados).', NULL);

-- 2. Esquiva
INSERT INTO card (id, type, name, resume, description, book, page) VALUES 
('f0e1d2c3-b4a5-9687-5432-10fedcba0987', 'feature', 'Esquiva', 'Recebe bônus na CA.', 'Você é perito em evitar golpes.', 'Tormenta RPG', 121);

INSERT INTO feature (id, card_id, feature_type, prerequisites, benefit, normal, special) VALUES 
('98765432-10fe-dcba-0987-654321fedcba', 'f0e1d2c3-b4a5-9687-5432-10fedcba0987', 'Combate', 'Des 13', 'Você recebe +1 na classe de armadura.', 'Uma condição que faça você perder seu bônus de Destreza na CA também faz você perder este bônus.', NULL);

-- 3. Foco em Arma
INSERT INTO card (id, type, name, resume, description, book, page) VALUES 
('c3b2a109-8765-4321-fedc-ba0987654321', 'feature', 'Foco em Arma', 'Bônus em ataques com uma arma.', 'Você é mestre em uma arma específica.', 'Tormenta RPG', 123);

INSERT INTO feature (id, card_id, feature_type, prerequisites, benefit, normal, special) VALUES 
('b1a20394-8574-6352-d1c2-b3a405968741', 'c3b2a109-8765-4321-fedc-ba0987654321', 'Combate', 'Usar Arma (escolhida), BBA +1', 'Escolha uma arma (como espada longa ou arco longo). Você recebe +1 nas jogadas de ataque com a arma escolhida.', NULL, 'Você pode adquirir este talento várias vezes. Cada vez que adquire este talento, ele se aplica a uma arma diferente.');

-- 4. Iniciativa Aprimorada
INSERT INTO card (id, type, name, resume, description, book, page) VALUES 
('e1d2c3b4-a506-9788-7654-3210fedcba99', 'feature', 'Iniciativa Aprimorada', 'Reage mais rápido ao perigo.', 'Você reage rapidamente ao perigo.', 'Tormenta RPG', 124);

INSERT INTO feature (id, card_id, feature_type, prerequisites, benefit, normal, special) VALUES 
('a5b4c3d2-e1f0-9876-5432-10ab9c8d7e6f', 'e1d2c3b4-a506-9788-7654-3210fedcba99', 'Combate', 'Nenhum', 'Você recebe +4 em testes de Iniciativa.', NULL, NULL);

-- 5. Tiro Certeiro
INSERT INTO card (id, type, name, resume, description, book, page) VALUES 
('00112233-4455-6677-8899-aabbccddeeff', 'feature', 'Tiro Certeiro', 'Bônus em ataque e dano à curta distância.', 'Você é perito em disparos precisos à curta distância.', 'Tormenta RPG', 127);

INSERT INTO feature (id, card_id, feature_type, prerequisites, benefit, normal, special) VALUES 
('ffeeddcc-bbaa-9988-7766-554433221100', '00112233-4455-6677-8899-aabbccddeeff', 'Combate', 'BBA +1', 'Você recebe +1 nas jogadas de ataque e dano com armas de ataque à distância contra inimigos a até 9m.', NULL, NULL);

-- 6. Vitalidade
INSERT INTO card (id, type, name, resume, description, book, page) VALUES 
('1a2b3c4d-5e6f-7a8b-9c0d-1e2f3a4b5c6d', 'feature', 'Vitalidade', 'Ganha PV extras.', 'Você é mais resistente que o normal.', 'Tormenta RPG', 129);

INSERT INTO feature (id, card_id, feature_type, prerequisites, benefit, normal, special) VALUES 
('9z8y7x6w-5v4u-3t2s-1r0q-9p8o7n6m5l4k', '1a2b3c4d-5e6f-7a8b-9c0d-1e2f3a4b5c6d', 'Geral', 'Con 13', 'Você recebe +3 pontos de vida. Para cada nível de personagem além do 1º, você recebe +1 PV.', NULL, NULL);

-- 7. Vontade de Ferro
INSERT INTO card (id, type, name, resume, description, book, page) VALUES 
('12345678-1234-1234-1234-123456789012', 'feature', 'Vontade de Ferro', 'Bônus em testes de Vontade.', 'Você tem uma força de vontade inabalável.', 'Tormenta RPG', 129);

INSERT INTO feature (id, card_id, feature_type, prerequisites, benefit, normal, special) VALUES 
('87654321-4321-4321-4321-210987654321', '12345678-1234-1234-1234-123456789012', 'Geral', 'Nenhum', 'Você recebe +2 em testes de Vontade.', NULL, NULL);

-- ==========================================
-- MAGIAS (MAGICS)
-- ==========================================

-- 8. Mísseis Mágicos
INSERT INTO card (id, type, name, resume, description, book, page) VALUES
('11aa22bb-33cc-44dd-55ee-66ff77889900', 'magic', 'Mísseis Mágicos', 'Dispara dardos de energia infalíveis.', 'Dardos de pura energia saem da ponta de seus dedos e atingem os alvos infalivelmente.', 'Tormenta RPG', 185);

INSERT INTO magic (id, card_id, type, school, level, components, cast_time, range, target_area, duration, saving_throw, spell_resistance, effect) VALUES
('aa11bb22-cc33-dd44-ee55-ff6677889900', '11aa22bb-33cc-44dd-55ee-66ff77889900', 'Arcana', 'Evocação', '1', 'V, G', '1 ação padrão', 'Médio (30m + 3m/nível)', 'Até 5 criaturas', 'Instantânea', 'Nenhum', 'Sim', 'Você cria até 5 setas de energia que causam 1d4+1 pontos de dano de essência cada.');

-- 9. Curar Ferimentos Leves
INSERT INTO card (id, type, name, resume, description, book, page) VALUES
('22bb33cc-44dd-55ee-66ff-7788990011aa', 'magic', 'Curar Ferimentos Leves', 'Cura 1d8+1/+nível pvs (máx +5).', 'Você canaliza energia positiva para curar um aliado.', 'Tormenta RPG', 167);

INSERT INTO magic (id, card_id, type, school, level, components, cast_time, range, target_area, duration, saving_throw, spell_resistance, effect) VALUES
('bb22cc33-dd44-ee55-ff66-7788990011aa', '22bb33cc-44dd-55ee-66ff-7788990011aa', 'Divina', 'Invocação', '1', 'V, G', '1 ação padrão', 'Toque', 'Criatura tocada', 'Instantânea', 'Vontade metade (inofensiva)', 'Sim (inofensiva)', 'A magia canaliza energia positiva que cura 1d8+1 pontos de dano +1 por nível de conjurador (máximo +5).');

-- 10. Bola de Fogo
INSERT INTO card (id, type, name, resume, description, book, page) VALUES
('33cc44dd-55ee-66ff-7788-990011aa22bb', 'magic', 'Bola de Fogo', 'Causa 1d6/nível de dano de fogo.', 'Você aponta o dedo e uma pequena esfera de fogo voa até o ponto escolhido, onde explode em chamas.', 'Tormenta RPG', 160);

INSERT INTO magic (id, card_id, type, school, level, components, cast_time, range, target_area, duration, saving_throw, spell_resistance, effect) VALUES
('cc33dd44-ee55-ff66-7788-990011aa22bb', '33cc44dd-55ee-66ff-7788-990011aa22bb', 'Arcana', 'Evocação', '3', 'V, G, M', '1 ação padrão', 'Longo (120m + 12m/nível)', 'Esfera de 6m de raio', 'Instantânea', 'Reflexos metade', 'Sim', 'Causa 1d6 pontos de dano de fogo por nível de conjurador (máximo 10d6) a todas as criaturas na área.');

-- 11. Armadura Arcana
INSERT INTO card (id, type, name, resume, description, book, page) VALUES
('44dd55ee-66ff-7788-9900-11aa22bb33cc', 'magic', 'Armadura Arcana', 'Concede bônus de +4 na CA.', 'Uma armadura invisível mas tangível envolve o alvo.', 'Tormenta RPG', 157);

INSERT INTO magic (id, card_id, type, school, level, components, cast_time, range, target_area, duration, saving_throw, spell_resistance, effect) VALUES
('dd44ee55-ff66-7788-9900-11aa22bb33cc', '44dd55ee-66ff-7788-9900-11aa22bb33cc', 'Arcana', 'Invocação', '1', 'V, G, F', '1 ação padrão', 'Toque', 'Criatura tocada', '1 hora/nível', 'Vontade anula (inofensiva)', 'Sim (inofensiva)', 'O alvo recebe um bônus de +4 na classe de armadura.');

-- 12. Benção
INSERT INTO card (id, type, name, resume, description, book, page) VALUES
('55ee66ff-7788-9900-11aa-22bb33cc44dd', 'magic', 'Benção', 'Aliados ganham +1 em ataque e medo.', 'Preenche os aliados com coragem.', 'Tormenta RPG', 159);

INSERT INTO magic (id, card_id, type, school, level, components, cast_time, range, target_area, duration, saving_throw, spell_resistance, effect) VALUES
('ee55ff66-7788-9900-11aa-22bb33cc44dd', '55ee66ff-7788-9900-11aa-22bb33cc44dd', 'Divina', 'Encantamento', '1', 'V, G, DF', '1 ação padrão', '15m', 'Todos os aliados a até 15m', '1 minuto/nível', 'Nenhum', 'Sim', 'Concede +1 nas jogadas de ataque e testes de resistência contra medo.');
