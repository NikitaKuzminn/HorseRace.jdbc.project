-- DDL

-- Table: public.Bets

-- DROP TABLE public."Bets";

CREATE TABLE IF NOT EXISTS public."Bets"
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    user_id integer NOT NULL,
    horse integer NOT NULL,
    rate_value integer NOT NULL,
    CONSTRAINT "Bets_pkey" PRIMARY KEY (id)
);

-- Table: public.GameFund

-- DROP TABLE public."GameFund";

CREATE TABLE IF NOT EXISTS public."GameFund"
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    user_id integer NOT NULL,
    plus_minus integer NOT NULL,
    CONSTRAINT "GameFund _pkey" PRIMARY KEY (id)
);

-- Table: public.HorseRace

-- DROP TABLE public."HorseRace";

CREATE TABLE IF NOT EXISTS public."HorseRace"
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    winner character varying COLLATE pg_catalog."default",
    CONSTRAINT "HorseRace_pkey" PRIMARY KEY (id)
);

-- Table: public.Horses

-- DROP TABLE public."Horses";

CREATE TABLE IF NOT EXISTS public."Horses"
(
    horse_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    horse_name character varying COLLATE pg_catalog."default" NOT NULL,
    coefficient double precision NOT NULL,
    CONSTRAINT "Horses_pkey" PRIMARY KEY (horse_id)
);

CREATE TABLE IF NOT EXISTS public."Users"
(
    user_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    first_name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(20) COLLATE pg_catalog."default" NOT NULL,
    user_dob date NOT NULL,
    user_cash integer,
    CONSTRAINT "Users_pkey" PRIMARY KEY (user_id)
);

COMMIT;
