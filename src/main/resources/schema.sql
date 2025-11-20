-- ============================================
-- LIMPAR APENAS O QUE VAI USAR AGORA
-- ============================================
DROP TABLE IF EXISTS allergen CASCADE;

-- ============================================
-- EXTENSÕES (desnecessário agora)
-- ============================================
-- CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- ============================================
-- TABELAS NÃO USADAS AGORA
-- ============================================
-- DROP TABLE IF EXISTS food CASCADE;
-- DROP TABLE IF EXISTS meal CASCADE;
-- DROP TABLE IF EXISTS symptom CASCADE;
-- DROP TABLE IF EXISTS app_user CASCADE;


-- ============================================
-- TABELA ALLERGEN (única usada agora)
-- ============================================
CREATE TABLE allergen (
                          id          BIGSERIAL PRIMARY KEY,
                          description TEXT NOT NULL
);


-- ============================================
-- TABELAS FUTURAS (completamente ocultadas)
-- ============================================
-- CREATE TABLE app_user (
--     id          UUID PRIMARY KEY,
--     email       VARCHAR(255) NOT NULL UNIQUE,
--     nome        VARCHAR(255) NOT NULL
-- );
--
-- CREATE TABLE meal (
--     id          UUID PRIMARY KEY,
--     user_id     UUID NOT NULL,
--     date        TIMESTAMPTZ NOT NULL,
--
--     CONSTRAINT fk_meal_user
--         FOREIGN KEY (user_id)
--         REFERENCES app_user (id)
--         ON DELETE CASCADE
-- );
--
-- CREATE TABLE food (
--     id          SERIAL PRIMARY KEY,
--     meal_id     UUID NOT NULL,
--     description TEXT NOT NULL,
--
--     CONSTRAINT fk_food_meal
--         FOREIGN KEY (meal_id)
--         REFERENCES meal (id)
--         ON DELETE CASCADE
-- );
--
-- CREATE TABLE symptom (
--     id          SERIAL PRIMARY KEY,
--     user_id     UUID NOT NULL,
--     description TEXT NOT NULL,
--     date        TIMESTAMPTZ NOT NULL,
--
--     CONSTRAINT fk_symptom_user
--         FOREIGN KEY (user_id)
--             REFERENCES app_user (id)
--             ON DELETE CASCADE
-- );
--
-- CREATE INDEX idx_meal_user          ON meal(user_id);
-- CREATE INDEX idx_food_meal          ON food(meal_id);
-- -- CREATE INDEX idx_allergen_food   ON allergen(food_id);  -- não existe food_id
-- CREATE INDEX idx_symptom_user_date  ON symptom(user_id, date);


-- ============================================
-- INSERTS DE TESTE (AQUI SUA API JÁ VAI LER)
-- ============================================
INSERT INTO allergen (description) VALUES
                                       ('gluten'),
                                       ('milk'),
                                       ('egg'),
                                       ('peanut'),
                                       ('fish'),
                                       ('soy'),
                                       ('sesame'),
                                       ('lactose'),
                                       ('no-allergens');  -- pra testar caso sem alérgeno
