--
-- PostgreSQL database dump
--

-- Dumped from database version 14.1
-- Dumped by pg_dump version 14.1

-- Started on 2021-12-15 22:05:34

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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 209 (class 1259 OID 32948)
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."user" (
    id_user bigint NOT NULL,
    first_name character varying,
    last_name character varying,
    email character varying,
    password character varying,
    phone bigint,
    gander character varying,
    status_compte boolean,
    id_role bigint,
    id_adress bigint,
    id_event bigint,
    id_fabrique bigint
);


ALTER TABLE public."user" OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 32975)
-- Name: admin; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.admin (
)
INHERITS (public."user");


ALTER TABLE public.admin OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 32997)
-- Name: adress; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.adress (
    id_adress bigint NOT NULL,
    country character varying,
    region character varying,
    city character varying,
    code_postal integer
);


ALTER TABLE public.adress OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 32965)
-- Name: chef_fabrique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.chef_fabrique (
    date_entry_fabrique date
)
INHERITS (public."user");


ALTER TABLE public.chef_fabrique OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 33083)
-- Name: class; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.class (
    id_class bigint NOT NULL,
    name_class character varying,
    star_day date,
    end_day date,
    id_promotion bigint
);


ALTER TABLE public.class OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 32992)
-- Name: event; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.event (
    id_event bigint NOT NULL,
    start_date date,
    end_date date
);


ALTER TABLE public.event OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 33054)
-- Name: fabrique; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.fabrique (
    id_fabrique bigint NOT NULL,
    name_fabrique character varying,
    id_pointeur bigint,
    id_adress bigint
);


ALTER TABLE public.fabrique OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 32970)
-- Name: formateur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.formateur (
    id_class bigint,
    id_specialiter bigint
)
INHERITS (public."user");


ALTER TABLE public.formateur OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 33014)
-- Name: permission; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.permission (
    id_permission bigint NOT NULL,
    name_permission character varying,
    description_permission character varying,
    status_permission boolean
);


ALTER TABLE public.permission OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 33039)
-- Name: pointer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pointer (
    id_user bigint,
    id_pointeur bigint,
    arrival_date date,
    go_date date,
    id_pointer bigint NOT NULL
);


ALTER TABLE public.pointer OWNER TO postgres;

--
-- TOC entry 220 (class 1259 OID 33034)
-- Name: pointeur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pointeur (
    id_pointeur bigint NOT NULL,
    brand character varying
);


ALTER TABLE public.pointeur OWNER TO postgres;

--
-- TOC entry 225 (class 1259 OID 33091)
-- Name: promotion; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.promotion (
    id_promotion bigint NOT NULL,
    name_promotion character varying,
    year date,
    star_date date,
    end_date date
);


ALTER TABLE public.promotion OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 32980)
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    id_role bigint NOT NULL,
    name_role character varying,
    description_role character varying,
    status_role boolean
);


ALTER TABLE public.role OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 33021)
-- Name: role_permision; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role_permision (
    id_role bigint,
    id_permission bigint,
    assigned_at date,
    update_at date,
    id_role_permision bigint NOT NULL
);


ALTER TABLE public.role_permision OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 32955)
-- Name: secretary; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.secretary (
    date_entry_fabrique date
)
INHERITS (public."user");


ALTER TABLE public.secretary OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 33076)
-- Name: specialiter; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.specialiter (
    id_specialiter bigint NOT NULL,
    name_specialiter character varying,
    description character varying
);


ALTER TABLE public.specialiter OWNER TO postgres;

--
-- TOC entry 211 (class 1259 OID 32960)
-- Name: student; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.student (
    id_class bigint,
    id_specialiter bigint
)
INHERITS (public."user");


ALTER TABLE public.student OWNER TO postgres;

--
-- TOC entry 3414 (class 0 OID 32975)
-- Dependencies: 214
-- Data for Name: admin; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.admin (id_user, first_name, last_name, email, password, phone, gander, status_compte, id_role, id_adress, id_event, id_fabrique) FROM stdin;
\.


--
-- TOC entry 3417 (class 0 OID 32997)
-- Dependencies: 217
-- Data for Name: adress; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.adress (id_adress, country, region, city, code_postal) FROM stdin;
\.


--
-- TOC entry 3412 (class 0 OID 32965)
-- Dependencies: 212
-- Data for Name: chef_fabrique; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.chef_fabrique (id_user, first_name, last_name, email, password, phone, gander, status_compte, date_entry_fabrique, id_role, id_adress, id_event, id_fabrique) FROM stdin;
\.


--
-- TOC entry 3424 (class 0 OID 33083)
-- Dependencies: 224
-- Data for Name: class; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.class (id_class, name_class, star_day, end_day, id_promotion) FROM stdin;
\.


--
-- TOC entry 3416 (class 0 OID 32992)
-- Dependencies: 216
-- Data for Name: event; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.event (id_event, start_date, end_date) FROM stdin;
\.


--
-- TOC entry 3422 (class 0 OID 33054)
-- Dependencies: 222
-- Data for Name: fabrique; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.fabrique (id_fabrique, name_fabrique, id_pointeur, id_adress) FROM stdin;
\.


--
-- TOC entry 3413 (class 0 OID 32970)
-- Dependencies: 213
-- Data for Name: formateur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.formateur (id_user, first_name, last_name, email, password, phone, gander, status_compte, id_role, id_adress, id_event, id_fabrique, id_class, id_specialiter) FROM stdin;
\.


--
-- TOC entry 3418 (class 0 OID 33014)
-- Dependencies: 218
-- Data for Name: permission; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.permission (id_permission, name_permission, description_permission, status_permission) FROM stdin;
\.


--
-- TOC entry 3421 (class 0 OID 33039)
-- Dependencies: 221
-- Data for Name: pointer; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pointer (id_user, id_pointeur, arrival_date, go_date, id_pointer) FROM stdin;
\.


--
-- TOC entry 3420 (class 0 OID 33034)
-- Dependencies: 220
-- Data for Name: pointeur; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.pointeur (id_pointeur, brand) FROM stdin;
\.


--
-- TOC entry 3425 (class 0 OID 33091)
-- Dependencies: 225
-- Data for Name: promotion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.promotion (id_promotion, name_promotion, year, star_date, end_date) FROM stdin;
\.


--
-- TOC entry 3415 (class 0 OID 32980)
-- Dependencies: 215
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.role (id_role, name_role, description_role, status_role) FROM stdin;
\.


--
-- TOC entry 3419 (class 0 OID 33021)
-- Dependencies: 219
-- Data for Name: role_permision; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.role_permision (id_role, id_permission, assigned_at, update_at, id_role_permision) FROM stdin;
\.


--
-- TOC entry 3410 (class 0 OID 32955)
-- Dependencies: 210
-- Data for Name: secretary; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.secretary (id_user, first_name, last_name, email, password, phone, gander, status_compte, date_entry_fabrique, id_role, id_adress, id_event, id_fabrique) FROM stdin;
\.


--
-- TOC entry 3423 (class 0 OID 33076)
-- Dependencies: 223
-- Data for Name: specialiter; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.specialiter (id_specialiter, name_specialiter, description) FROM stdin;
\.


--
-- TOC entry 3411 (class 0 OID 32960)
-- Dependencies: 211
-- Data for Name: student; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.student (id_user, first_name, last_name, email, password, phone, gander, status_compte, id_role, id_adress, id_event, id_fabrique, id_class, id_specialiter) FROM stdin;
\.


--
-- TOC entry 3409 (class 0 OID 32948)
-- Dependencies: 209
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."user" (id_user, first_name, last_name, email, password, phone, gander, status_compte, id_role, id_adress, id_event, id_fabrique) FROM stdin;
\.


--
-- TOC entry 3238 (class 2606 OID 33003)
-- Name: adress adress_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.adress
    ADD CONSTRAINT adress_pkey PRIMARY KEY (id_adress);


--
-- TOC entry 3252 (class 2606 OID 33089)
-- Name: class class_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.class
    ADD CONSTRAINT class_pkey PRIMARY KEY (id_class);


--
-- TOC entry 3236 (class 2606 OID 32996)
-- Name: event event_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.event
    ADD CONSTRAINT event_pkey PRIMARY KEY (id_event);


--
-- TOC entry 3248 (class 2606 OID 33060)
-- Name: fabrique fabrique_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fabrique
    ADD CONSTRAINT fabrique_pkey PRIMARY KEY (id_fabrique);


--
-- TOC entry 3232 (class 2606 OID 33104)
-- Name: formateur formateur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formateur
    ADD CONSTRAINT formateur_pkey PRIMARY KEY (id_user);


--
-- TOC entry 3240 (class 2606 OID 33020)
-- Name: permission permission_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.permission
    ADD CONSTRAINT permission_pkey PRIMARY KEY (id_permission);


--
-- TOC entry 3246 (class 2606 OID 33128)
-- Name: pointer pointer_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pointer
    ADD CONSTRAINT pointer_pkey PRIMARY KEY (id_pointer);


--
-- TOC entry 3244 (class 2606 OID 33043)
-- Name: pointeur pointeur_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pointeur
    ADD CONSTRAINT pointeur_pkey PRIMARY KEY (id_pointeur);


--
-- TOC entry 3254 (class 2606 OID 33097)
-- Name: promotion promotion_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.promotion
    ADD CONSTRAINT promotion_pkey PRIMARY KEY (id_promotion);


--
-- TOC entry 3242 (class 2606 OID 33130)
-- Name: role_permision role_permision_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role_permision
    ADD CONSTRAINT role_permision_pkey PRIMARY KEY (id_role_permision);


--
-- TOC entry 3234 (class 2606 OID 32986)
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (id_role);


--
-- TOC entry 3250 (class 2606 OID 33082)
-- Name: specialiter specialiter_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.specialiter
    ADD CONSTRAINT specialiter_pkey PRIMARY KEY (id_specialiter);


--
-- TOC entry 3230 (class 2606 OID 33111)
-- Name: student student_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT student_pkey PRIMARY KEY (id_user);


--
-- TOC entry 3228 (class 2606 OID 32954)
-- Name: user user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id_user);


--
-- TOC entry 3256 (class 2606 OID 33004)
-- Name: user id_adress; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT id_adress FOREIGN KEY (id_adress) REFERENCES public.adress(id_adress) NOT VALID;


--
-- TOC entry 3268 (class 2606 OID 33071)
-- Name: fabrique id_adress; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fabrique
    ADD CONSTRAINT id_adress FOREIGN KEY (id_adress) REFERENCES public.adress(id_adress) NOT VALID;


--
-- TOC entry 3261 (class 2606 OID 33105)
-- Name: formateur id_class; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formateur
    ADD CONSTRAINT id_class FOREIGN KEY (id_class) REFERENCES public.class(id_class) NOT VALID;


--
-- TOC entry 3259 (class 2606 OID 33112)
-- Name: student id_class; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT id_class FOREIGN KEY (id_class) REFERENCES public.class(id_class) NOT VALID;


--
-- TOC entry 3257 (class 2606 OID 33009)
-- Name: user id_event; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT id_event FOREIGN KEY (id_event) REFERENCES public.event(id_event) NOT VALID;


--
-- TOC entry 3258 (class 2606 OID 33061)
-- Name: user id_fabrique; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT id_fabrique FOREIGN KEY (id_fabrique) REFERENCES public.fabrique(id_fabrique) NOT VALID;


--
-- TOC entry 3264 (class 2606 OID 33029)
-- Name: role_permision id_permossion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role_permision
    ADD CONSTRAINT id_permossion FOREIGN KEY (id_permission) REFERENCES public.permission(id_permission) NOT VALID;


--
-- TOC entry 3266 (class 2606 OID 33049)
-- Name: pointer id_pointeur; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pointer
    ADD CONSTRAINT id_pointeur FOREIGN KEY (id_pointeur) REFERENCES public.pointeur(id_pointeur) NOT VALID;


--
-- TOC entry 3267 (class 2606 OID 33066)
-- Name: fabrique id_pointeur; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fabrique
    ADD CONSTRAINT id_pointeur FOREIGN KEY (id_pointeur) REFERENCES public.pointeur(id_pointeur) NOT VALID;


--
-- TOC entry 3269 (class 2606 OID 33098)
-- Name: class id_promotion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.class
    ADD CONSTRAINT id_promotion FOREIGN KEY (id_promotion) REFERENCES public.promotion(id_promotion) NOT VALID;


--
-- TOC entry 3255 (class 2606 OID 32987)
-- Name: user id_role; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT id_role FOREIGN KEY (id_role) REFERENCES public.role(id_role) NOT VALID;


--
-- TOC entry 3263 (class 2606 OID 33024)
-- Name: role_permision id_role; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role_permision
    ADD CONSTRAINT id_role FOREIGN KEY (id_role) REFERENCES public.role(id_role) NOT VALID;


--
-- TOC entry 3260 (class 2606 OID 33117)
-- Name: student id_specialiter; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.student
    ADD CONSTRAINT id_specialiter FOREIGN KEY (id_specialiter) REFERENCES public.specialiter(id_specialiter) NOT VALID;


--
-- TOC entry 3262 (class 2606 OID 33122)
-- Name: formateur id_specialiter; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.formateur
    ADD CONSTRAINT id_specialiter FOREIGN KEY (id_specialiter) REFERENCES public.specialiter(id_specialiter) NOT VALID;


--
-- TOC entry 3265 (class 2606 OID 33044)
-- Name: pointer id_user; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pointer
    ADD CONSTRAINT id_user FOREIGN KEY (id_user) REFERENCES public."user"(id_user) NOT VALID;


-- Completed on 2021-12-15 22:05:35

--
-- PostgreSQL database dump complete
--

