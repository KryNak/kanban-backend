INSERT INTO users VALUES('4923f732-b5c6-47fe-90a1-6b1376f1a8c5', null, 'test@test.com', '$2b$10$l6WpubtEPHe5k8Dr6WY1g.yyJAVUOfjssfB1/N594YgIGusu2HUQC', false);

ALTER TABLE boards ADD COLUMN user_id uuid;
UPDATE boards SET user_id = '4923f732-b5c6-47fe-90a1-6b1376f1a8c5';
ALTER TABLE boards ALTER COLUMN user_id SET NOT NULL;
