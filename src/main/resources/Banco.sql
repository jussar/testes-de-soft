CREATE TABLE usuario
(
  id serial NOT NULL,
  nome character varying(10) NOT NULL,unique,
  senha character varying(10) NOT NULL,
  email character varying NOT NULL,unique;
  bio character varying(100),
  avatar character varying,
  CONSTRAINT usuario_pkey PRIMARY KEY (senha, email),
  CONSTRAINT usuario_email_key UNIQUE (email)
)