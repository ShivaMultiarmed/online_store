--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.17
-- Dumped by pg_dump version 9.6.17

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: DATABASE store_db; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON DATABASE store_db IS 'default administrative connection database';


--
-- Name: store_db; Type: SCHEMA; Schema: -; Owner: store_admin
--

CREATE SCHEMA store_db;


ALTER SCHEMA store_db OWNER TO store_admin;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


--
-- Name: device_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.device_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.device_id_seq OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: products; Type: TABLE; Schema: store_db; Owner: postgres
--

CREATE TABLE store_db.products (
    id bigint DEFAULT nextval('public.device_id_seq'::regclass) NOT NULL,
    name text,
    series bigint,
    price double precision,
    is_present boolean,
    width double precision,
    height double precision,
    length double precision,
    color text,
    product_type bigint
);


ALTER TABLE store_db.products OWNER TO postgres;

--
-- Name: computers; Type: TABLE; Schema: store_db; Owner: postgres
--

CREATE TABLE store_db.computers (
    processor text,
    category text
)
INHERITS (store_db.products);


ALTER TABLE store_db.computers OWNER TO postgres;

--
-- Name: fridges; Type: TABLE; Schema: store_db; Owner: postgres
--

CREATE TABLE store_db.fridges (
    doors integer,
    compressor text
)
INHERITS (store_db.products);


ALTER TABLE store_db.fridges OWNER TO postgres;

--
-- Name: product_types; Type: TABLE; Schema: store_db; Owner: postgres
--

CREATE TABLE store_db.product_types (
    id bigint NOT NULL,
    name text,
    country text,
    manufacturer text,
    is_online boolean,
    has_installment boolean
);


ALTER TABLE store_db.product_types OWNER TO postgres;

--
-- Name: product_types_id_seq; Type: SEQUENCE; Schema: store_db; Owner: postgres
--

CREATE SEQUENCE store_db.product_types_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE store_db.product_types_id_seq OWNER TO postgres;

--
-- Name: product_types_id_seq; Type: SEQUENCE OWNED BY; Schema: store_db; Owner: postgres
--

ALTER SEQUENCE store_db.product_types_id_seq OWNED BY store_db.product_types.id;


--
-- Name: smartphones; Type: TABLE; Schema: store_db; Owner: postgres
--

CREATE TABLE store_db.smartphones (
    memory double precision,
    cameras integer
)
INHERITS (store_db.products);


ALTER TABLE store_db.smartphones OWNER TO postgres;

--
-- Name: tvs; Type: TABLE; Schema: store_db; Owner: postgres
--

CREATE TABLE store_db.tvs (
    series bigint,
    price double precision,
    is_present boolean,
    technology text,
    category text
)
INHERITS (store_db.products);


ALTER TABLE store_db.tvs OWNER TO postgres;

--
-- Name: vacuum_cleaners; Type: TABLE; Schema: store_db; Owner: postgres
--

CREATE TABLE store_db.vacuum_cleaners (
    volume double precision,
    modes integer
)
INHERITS (store_db.products);


ALTER TABLE store_db.vacuum_cleaners OWNER TO postgres;

--
-- Name: computers id; Type: DEFAULT; Schema: store_db; Owner: postgres
--

ALTER TABLE ONLY store_db.computers ALTER COLUMN id SET DEFAULT nextval('public.device_id_seq'::regclass);


--
-- Name: fridges id; Type: DEFAULT; Schema: store_db; Owner: postgres
--

ALTER TABLE ONLY store_db.fridges ALTER COLUMN id SET DEFAULT nextval('public.device_id_seq'::regclass);


--
-- Name: product_types id; Type: DEFAULT; Schema: store_db; Owner: postgres
--

ALTER TABLE ONLY store_db.product_types ALTER COLUMN id SET DEFAULT nextval('store_db.product_types_id_seq'::regclass);


--
-- Name: smartphones id; Type: DEFAULT; Schema: store_db; Owner: postgres
--

ALTER TABLE ONLY store_db.smartphones ALTER COLUMN id SET DEFAULT nextval('public.device_id_seq'::regclass);


--
-- Name: tvs id; Type: DEFAULT; Schema: store_db; Owner: postgres
--

ALTER TABLE ONLY store_db.tvs ALTER COLUMN id SET DEFAULT nextval('public.device_id_seq'::regclass);


--
-- Name: vacuum_cleaners id; Type: DEFAULT; Schema: store_db; Owner: postgres
--

ALTER TABLE ONLY store_db.vacuum_cleaners ALTER COLUMN id SET DEFAULT nextval('public.device_id_seq'::regclass);


--
-- Name: device_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.device_id_seq', 36, true);


--
-- Data for Name: computers; Type: TABLE DATA; Schema: store_db; Owner: postgres
--

COPY store_db.computers (id, name, series, price, is_present, width, height, length, color, processor, category, product_type) FROM stdin;
30	laptop zenbook ultra	202402	78900	t	32.5	22.699999999999999	1.8999999999999999	silver	Intel i7	ultrabook	13
32	laptop powerbook 16	202426	84900	t	35	23.5	1.8999999999999999	blue	AMD Ryzen 7	high-performance	13
31	laptop zenbook pro	202404	92900	t	33	23	2	black	Intel i9	professional	13
\.


--
-- Data for Name: fridges; Type: TABLE DATA; Schema: store_db; Owner: postgres
--

COPY store_db.fridges (id, name, series, price, is_present, width, height, length, doors, compressor, color, product_type) FROM stdin;
15	Atlant XM-4424	12312312	60000	\N	59.5	196.80000000000001	62.899999999999999	2		white	2
16	Atlant XM-100500	404040	90000	\N	59.5	196.80000000000001	62.899999999999999	2		white	2
\.


--
-- Data for Name: product_types; Type: TABLE DATA; Schema: store_db; Owner: postgres
--

COPY store_db.product_types (id, name, country, manufacturer, is_online, has_installment) FROM stdin;
2	fridges	Belarus	Atlant	f	t
3	fridges	Italy	Indesit	f	t
4	smartphones	Korea	Samsung	t	t
1	smartphones	China	Xiaomi	t	t
5	smartphones	Russia	SmartTech	t	t
6	smartphones	China	TechWorld	f	t
8	tvs	Japan	Sony	t	f
9	vacuum_cleaners	Germany	Bosch	t	t
10	vacuum_cleaners	USA	Dyson	f	t
11	fridges	Italy	Whirlpool	t	t
12	fridges	Sweden	Electrolux	t	f
14	computers	USA	iMac	t	f
13	computers	China	Honor	t	f
7	tvs	South Korea	Superview	t	t
\.


--
-- Name: product_types_id_seq; Type: SEQUENCE SET; Schema: store_db; Owner: postgres
--

SELECT pg_catalog.setval('store_db.product_types_id_seq', 14, true);


--
-- Data for Name: products; Type: TABLE DATA; Schema: store_db; Owner: postgres
--

COPY store_db.products (id, name, series, price, is_present, width, height, length, color, product_type) FROM stdin;
5	LG 100500	\N	\N	\N	\N	\N	\N	\N	\N
6	LG 100500	\N	\N	\N	\N	\N	\N	\N	\N
7	LG 100500	\N	\N	\N	\N	\N	\N	\N	\N
8	LG 100500	\N	\N	\N	\N	\N	\N	\N	\N
9	LG 100500	\N	\N	\N	\N	\N	\N	\N	2
10	LG 100500	\N	\N	\N	\N	\N	\N	\N	2
11	LG 100500	\N	\N	\N	\N	\N	\N	\N	2
12	Xiaomi 5000	\N	599	\N	\N	\N	\N	\N	\N
13	Xiaomi 5000	\N	599	\N	\N	\N	\N	\N	\N
\.


--
-- Data for Name: smartphones; Type: TABLE DATA; Schema: store_db; Owner: postgres
--

COPY store_db.smartphones (id, name, series, price, is_present, width, height, length, color, memory, cameras, product_type) FROM stdin;
19	Samsung Galaxy S24	0	62999	t	7	0.80000000000000004	10	black	512	4	1
20	Samsung galaxy S23	0	72999	t	70.900000000000006	0.69999999999999996	146	black	512	4	1
27	smartphone novatek x1	202401	49900	t	7.2000000000000002	15.5	0.80000000000000004	black	128	3	5
28	smartphone novatek x2	202403	57900	t	7.2999999999999998	15.699999999999999	0.80000000000000004	blue	256	4	5
29	smartphone innova pro	202312	43900	t	7.0999999999999996	15.4	0.69999999999999996	gray	128	2	6
\.


--
-- Data for Name: tvs; Type: TABLE DATA; Schema: store_db; Owner: postgres
--

COPY store_db.tvs (id, name, series, price, is_present, technology, category, width, height, length, color, product_type) FROM stdin;
33	television superview 50	202401	99900	t	LED	4K Ultra HD	112	65	7.5	black	7
34	television ultraclear 48	202312	93900	t	OLED	Full HD	108	61	7	black	7
\.


--
-- Data for Name: vacuum_cleaners; Type: TABLE DATA; Schema: store_db; Owner: postgres
--

COPY store_db.vacuum_cleaners (id, name, series, price, is_present, width, height, length, volume, modes, color, product_type) FROM stdin;
35	bosch cleanforce 3000	202402	23900	t	30	45	20	2.5	3	red	9
36	dyson 5000	202404	27900	t	32	50	22	3	4	blue	10
\.


--
-- Name: computers computers_pkey; Type: CONSTRAINT; Schema: store_db; Owner: postgres
--

ALTER TABLE ONLY store_db.computers
    ADD CONSTRAINT computers_pkey PRIMARY KEY (id);


--
-- Name: fridges fridges_pkey; Type: CONSTRAINT; Schema: store_db; Owner: postgres
--

ALTER TABLE ONLY store_db.fridges
    ADD CONSTRAINT fridges_pkey PRIMARY KEY (id);


--
-- Name: product_types product_types_pkey; Type: CONSTRAINT; Schema: store_db; Owner: postgres
--

ALTER TABLE ONLY store_db.product_types
    ADD CONSTRAINT product_types_pkey PRIMARY KEY (id);


--
-- Name: products products_pkey; Type: CONSTRAINT; Schema: store_db; Owner: postgres
--

ALTER TABLE ONLY store_db.products
    ADD CONSTRAINT products_pkey PRIMARY KEY (id);


--
-- Name: smartphones smartphones_pkey; Type: CONSTRAINT; Schema: store_db; Owner: postgres
--

ALTER TABLE ONLY store_db.smartphones
    ADD CONSTRAINT smartphones_pkey PRIMARY KEY (id);


--
-- Name: tvs tvs_pkey; Type: CONSTRAINT; Schema: store_db; Owner: postgres
--

ALTER TABLE ONLY store_db.tvs
    ADD CONSTRAINT tvs_pkey PRIMARY KEY (id);


--
-- Name: vacuum_cleaners vacuum_cleaners_pkey; Type: CONSTRAINT; Schema: store_db; Owner: postgres
--

ALTER TABLE ONLY store_db.vacuum_cleaners
    ADD CONSTRAINT vacuum_cleaners_pkey PRIMARY KEY (id);


--
-- Name: products fk_product_type; Type: FK CONSTRAINT; Schema: store_db; Owner: postgres
--

ALTER TABLE ONLY store_db.products
    ADD CONSTRAINT fk_product_type FOREIGN KEY (product_type) REFERENCES store_db.product_types(id) ON UPDATE CASCADE ON DELETE CASCADE;


--
-- PostgreSQL database dump complete
--
