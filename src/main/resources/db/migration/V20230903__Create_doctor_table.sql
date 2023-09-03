CREATE TABLE IF NOT EXISTS doctor(
    id serial PRIMARY KEY,
    name text NOT NULL UNIQUE,
    email text NOT NULL UNIQUE,
    crm text NOT NULL UNIQUE,
    specialty text NOT NULL,
    address text NOT NULL,
    neighborhood text NOT NULL,
    postal_code text NOT NULL,
    city text NOT NULL,
    state text NOT NULL,
    number text,
    notes text
);