
CREATE SEQUENCE IF NOT EXISTS public."PERSON_SEQUENCE"
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public."PERSON_SEQUENCE"
    OWNER TO postgres;

CREATE TABLE IF NOT EXISTS persona
(
    id integer NOT NULL DEFAULT nextval('public."PERSON_SEQUENCE"') NOT NULL,
    tipo_documento varchar,
    num_documento integer,
    primer_nombre varchar,
    segundo_nombre varchar,
    primer_apellido varchar,
    segundo_apellido varchar,
    telefono integer,
    direccion varchar,
    ciudad_residencia varchar,
    CONSTRAINT persona_pkey PRIMARY KEY (id)
    )

    GRANT ALL ON TABLE public.persona TO postgres;