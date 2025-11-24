DROP TABLE IF EXISTS allergen CASCADE;

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

DROP TABLE IF EXISTS food CASCADE;
DROP TABLE IF EXISTS meal CASCADE;
DROP TABLE IF EXISTS symptom CASCADE;
DROP TABLE IF EXISTS app_user CASCADE;
DROP TABLE IF EXISTS food_allergen CASCADE;

CREATE TABLE allergen (
                          id          BIGSERIAL PRIMARY KEY,
                          description TEXT NOT NULL
);

CREATE TABLE app_user (
    id          UUID PRIMARY KEY,
    email       VARCHAR(255) NOT NULL UNIQUE,
    nome        VARCHAR(255) NOT NULL
);

CREATE TABLE meal (
    id          SERIAL PRIMARY KEY,
    user_id     UUID NOT NULL,
    date        TIMESTAMPTZ NOT NULL,

    CONSTRAINT fk_meal_user
        FOREIGN KEY (user_id)
        REFERENCES app_user (id)
        ON DELETE CASCADE
);

CREATE TABLE food (
    id          SERIAL PRIMARY KEY,
    meal_id     SERIAL NOT NULL,
    description TEXT NOT NULL,

    CONSTRAINT fk_food_meal
        FOREIGN KEY (meal_id)
        REFERENCES meal (id)
        ON DELETE CASCADE
);

CREATE TABLE symptom (
    id          SERIAL PRIMARY KEY,
    user_id     UUID NOT NULL,
    description TEXT NOT NULL,
    date        TIMESTAMPTZ NOT NULL,

    CONSTRAINT fk_symptom_user
        FOREIGN KEY (user_id)
            REFERENCES app_user (id)
            ON DELETE CASCADE
);

CREATE TABLE food_allergen (
                               food_id     INT NOT NULL REFERENCES food(id) ON DELETE CASCADE,
                               allergen_id INT NOT NULL REFERENCES allergen(id) ON DELETE CASCADE,
                               PRIMARY KEY (food_id, allergen_id)
);

CREATE INDEX idx_meal_user          ON meal(user_id);
CREATE INDEX idx_food_meal          ON food(meal_id);
CREATE INDEX idx_symptom_user_date  ON symptom(user_id, date);


INSERT INTO allergen (description) VALUES
                                       ('gluten'),
                                       ('milk'),
                                       ('egg'),
                                       ('peanut'),
                                       ('fish'),
                                       ('soy'),
                                       ('sesame'),
                                       ('lactose'),
                                       ('no-allergens');

INSERT INTO app_user (id, email, nome) VALUES
                                           ('11111111-1111-1111-1111-111111111111', 'erick@example.com', 'Erick'),
                                           ('22222222-2222-2222-2222-222222222222', 'ana@example.com', 'Ana'),
                                           ('33333333-3333-3333-3333-333333333333', 'joao@example.com', 'João');

INSERT INTO meal (id, user_id, date) VALUES
                                         (1, '11111111-1111-1111-1111-111111111111', '2025-01-01T12:00:00Z'),
                                         (2, '11111111-1111-1111-1111-111111111111', '2025-01-02T19:30:00Z'),

                                         (3, '22222222-2222-2222-2222-222222222222', '2025-01-01T08:00:00Z'),
                                         (4, '22222222-2222-2222-2222-222222222222', '2025-01-03T20:10:00Z'),

                                         (5, '33333333-3333-3333-3333-333333333333', '2025-01-01T13:15:00Z'),
                                         (6, '33333333-3333-3333-3333-333333333333', '2025-01-04T10:00:00Z');

INSERT INTO food (id, meal_id, description) VALUES
                                                -- Meal 1 (Erick)
                                                (1, 1, 'Pão integral'),
                                                (2, 1, 'Presunto'),
                                                (3, 1, 'Queijo'),

                                                -- Meal 2 (Erick)
                                                (4, 2, 'Arroz'),
                                                (5, 2, 'Feijão'),
                                                (6, 2, 'Frango grelhado'),

                                                -- Meal 3 (Ana)
                                                (7, 3, 'Ovos mexidos'),
                                                (8, 3, 'Iogurte natural'),
                                                (9, 3, 'Banana'),

                                                -- Meal 4 (Ana)
                                                (10, 4, 'Macarrão'),
                                                (11, 4, 'Molho branco'),
                                                (12, 4, 'Salada verde'),

                                                -- Meal 5 (João)
                                                (13, 5, 'Salmão'),
                                                (14, 5, 'Arroz'),
                                                (15, 5, 'Ervilhas'),

                                                -- Meal 6 (João)
                                                (16, 6, 'Panqueca'),
                                                (17, 6, 'Mel'),
                                                (18, 6, 'Manteiga');

INSERT INTO symptom (id, user_id, description, date) VALUES
                                                         (1, '11111111-1111-1111-1111-111111111111', 'Dor de estômago', '2025-01-01T12:30:00Z'),
                                                         (2, '11111111-1111-1111-1111-111111111111', 'Coceira leve', '2025-01-02T20:00:00Z'),

                                                         (3, '22222222-2222-2222-2222-222222222222', 'Enjoo', '2025-01-01T08:20:00Z'),
                                                         (4, '22222222-2222-2222-2222-222222222222', 'Fadiga', '2025-01-03T21:00:00Z'),

                                                         (5, '33333333-3333-3333-3333-333333333333', 'Vermelhidão na pele', '2025-01-01T13:40:00Z'),
                                                         (6, '33333333-3333-3333-3333-333333333333', 'Dor de cabeça', '2025-01-04T11:00:00Z');

INSERT INTO food_allergen (food_id, allergen_id) VALUES
                                                     -- Meal 1
                                                     (1, 1), -- pão integral → gluten
                                                     (3, 2), -- queijo → milk
                                                     (3, 8), -- queijo → lactose

                                                     -- Meal 2
                                                     (6, 9), -- frango → no-allergens

                                                     -- Meal 3
                                                     (7, 3), -- ovos mexidos → egg
                                                     (8, 2), -- iogurte → milk
                                                     (8, 8), -- iogurte → lactose

                                                     -- Meal 4
                                                     (10, 1), -- macarrão → gluten

                                                     -- Meal 5
                                                     (13, 5), -- salmão → fish

                                                     -- Meal 6
                                                     (16, 3), -- panqueca → egg
                                                     (18, 2), -- manteiga → milk
                                                     (18, 8); -- manteiga → lactose
