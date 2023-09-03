CREATE TABLE IF NOT EXISTS doctor(
    id serial PRIMARY KEY,
    name text NOT NULL UNIQUE,
    email text NOT NULL UNIQUE,
    crm text NOT NULL UNIQUE,
    specialty text NOT NULL,
    address_type text,
    neighborhood text,
    postal_code text,
    city text,
    state text,
    number text,
    notes text
)