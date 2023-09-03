CREATE TABLE IF NOT EXISTS patient(
    id serial PRIMARY KEY,
    name text NOT NULL UNIQUE,
    email text NOT NULL UNIQUE,
    cpf text NOT NULL UNIQUE,
    phone text NOT NULL,
    address text NOT NULL,
    neighborhood text NOT NULL,
    postal_code text NOT NULL,
    city text NOT NULL,
    state text NOT NULL,
    number text,
    notes text
);