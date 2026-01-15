-- Fix null types in card table
UPDATE card SET type = 'feature' WHERE id IN (SELECT card_id FROM feature);
UPDATE card SET type = 'magic' WHERE id IN (SELECT card_id FROM magic);
UPDATE card SET type = 'generic' WHERE type IS NULL;
