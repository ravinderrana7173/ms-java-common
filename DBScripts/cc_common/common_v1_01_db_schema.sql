CREATE OR REPLACE PROCEDURE public.common_v1_01_db_schema()
 LANGUAGE plpgsql
AS $procedure$

DECLARE
Versions varchar(50) := 'common_db_1_01';

BEGIN

	CREATE Table IF NOT EXISTS public.com_version (
		version_id bigserial NOT NULL,
		version_number varchar(100) NOT NULL,
		version_deployment_date timestamp NOT NULL,
		CONSTRAINT pk_com_version PRIMARY KEY (version_id)
	);
	
	IF NOT EXISTS (select version_number  FROM com_version 
	WHERE version_number = Versions) THEN

--
-- TOC entry 214 (class 1259 OID 103016)
-- Name: com_capability; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.com_capability (
    capability_id bigint NOT NULL,
    capability_code character varying(10),
    capability_name character varying(100) NOT NULL,
    description character varying(500) DEFAULT NULL::character varying,
    created_by character varying(36),
    created_on timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    modified_by character varying(36),
    modified_on timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);


--
-- TOC entry 215 (class 1259 OID 103024)
-- Name: com_capability_capability_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.com_capability ALTER COLUMN capability_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.com_capability_capability_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 216 (class 1259 OID 103025)
-- Name: com_city; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.com_city (
    city_id bigint NOT NULL,
    city_name character varying(100) NOT NULL,
    state_id bigint NOT NULL,
    is_active boolean,
    created_by character varying(36),
    created_on timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    modified_by character varying(36),
    modified_on timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);


--
-- TOC entry 217 (class 1259 OID 103030)
-- Name: com_city_city_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.com_city ALTER COLUMN city_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.com_city_city_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 218 (class 1259 OID 103031)
-- Name: com_country; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.com_country (
    country_id bigint NOT NULL,
    country_name character varying(100) NOT NULL,
    country_code1 character varying(20) NOT NULL,
    country_code2 character varying(20) NOT NULL,
    country_number character varying(100) DEFAULT NULL::character varying,
    country_idd character varying(100) DEFAULT NULL::character varying,
    zip_required boolean,
    is_active boolean,
    created_by character varying(36),
    created_on timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    modified_by character varying(36),
    modified_on timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);


--
-- TOC entry 219 (class 1259 OID 103038)
-- Name: com_country_country_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.com_country ALTER COLUMN country_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.com_country_country_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 220 (class 1259 OID 103039)
-- Name: com_state; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.com_state (
    state_id bigint NOT NULL,
    state_code character varying(20) NOT NULL,
    state_name character varying(100) NOT NULL,
    country_id bigint NOT NULL,
    is_active boolean,
    created_by character varying(36),
    created_on timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    modified_by character varying(36),
    modified_on timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);


--
-- TOC entry 221 (class 1259 OID 103044)
-- Name: com_state_state_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.com_state ALTER COLUMN state_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.com_state_state_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 222 (class 1259 OID 103045)
-- Name: com_system; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.com_system (
    system_id bigint NOT NULL,
    system_uuid character varying(36) NOT NULL,
    system_name character varying(100) NOT NULL,
    description character varying(500) DEFAULT NULL::character varying,
    created_by character varying(36),
    created_on timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    modified_by character varying(36),
    modified_on timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    system_code character varying(30),
    is_simulation smallint DEFAULT 0 NOT NULL
);


--
-- TOC entry 223 (class 1259 OID 103054)
-- Name: com_system_capability; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.com_system_capability (
    system_capability_id bigint NOT NULL,
    system_id bigint NOT NULL,
    capability_id bigint NOT NULL,
    created_by character varying(36),
    created_on timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    modified_by character varying(36),
    modified_on timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);


--
-- TOC entry 224 (class 1259 OID 103059)
-- Name: com_system_capability_details; Type: TABLE; Schema: public; Owner: -
--

CREATE TABLE public.com_system_capability_details (
    system_capability_detail_id integer NOT NULL,
    system_id integer NOT NULL,
    capability_id integer,
    key character varying(50) NOT NULL,
    value character varying(500) NOT NULL,
    created_by character varying(50) NOT NULL,
    created_on timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL,
    modified_by character varying(50) NOT NULL,
    modified_on timestamp without time zone DEFAULT CURRENT_TIMESTAMP NOT NULL
);


--
-- TOC entry 225 (class 1259 OID 103066)
-- Name: com_system_capability_details_system_capability_detail_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

CREATE SEQUENCE public.com_system_capability_details_system_capability_detail_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


--
-- TOC entry 4035 (class 0 OID 0)
-- Dependencies: 225
-- Name: com_system_capability_details_system_capability_detail_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: -
--

ALTER SEQUENCE public.com_system_capability_details_system_capability_detail_id_seq OWNED BY public.com_system_capability_details.system_capability_detail_id;


--
-- TOC entry 226 (class 1259 OID 103067)
-- Name: com_system_capability_system_capability_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.com_system_capability ALTER COLUMN system_capability_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.com_system_capability_system_capability_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 227 (class 1259 OID 103068)
-- Name: com_system_system_id_seq; Type: SEQUENCE; Schema: public; Owner: -
--

ALTER TABLE public.com_system ALTER COLUMN system_id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.com_system_system_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);


--
-- TOC entry 3858 (class 2606 OID 103076)
-- Name: com_system_capability_details com_system_capability_details_pkey; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.com_system_capability_details
    ADD CONSTRAINT com_system_capability_details_pkey PRIMARY KEY (system_capability_detail_id);


--
-- TOC entry 3860 (class 2606 OID 103078)
-- Name: com_system_capability_details com_system_capability_details_system_id_capability_id_key; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.com_system_capability_details
    ADD CONSTRAINT com_system_capability_details_system_id_capability_id_key UNIQUE (system_id, capability_id);


--
-- TOC entry 3842 (class 2606 OID 103080)
-- Name: com_city ix_com_state_v; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.com_city
    ADD CONSTRAINT ix_com_state_v UNIQUE (city_name, state_id);


--
-- TOC entry 3854 (class 2606 OID 103082)
-- Name: com_system_capability ix_com_system_capability_v; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.com_system_capability
    ADD CONSTRAINT ix_com_system_capability_v UNIQUE (system_id, capability_id);


--
-- TOC entry 3840 (class 2606 OID 103084)
-- Name: com_capability pk_com_capability; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.com_capability
    ADD CONSTRAINT pk_com_capability PRIMARY KEY (capability_id);


--
-- TOC entry 3844 (class 2606 OID 103086)
-- Name: com_city pk_com_city; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.com_city
    ADD CONSTRAINT pk_com_city PRIMARY KEY (city_id);


--
-- TOC entry 3846 (class 2606 OID 103088)
-- Name: com_country pk_com_country; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.com_country
    ADD CONSTRAINT pk_com_country PRIMARY KEY (country_id);


--
-- TOC entry 3856 (class 2606 OID 103090)
-- Name: com_system_capability pk_com_system_capability; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.com_system_capability
    ADD CONSTRAINT pk_com_system_capability PRIMARY KEY (system_capability_id);





--
-- TOC entry 3848 (class 2606 OID 103094)
-- Name: com_state pk_connection; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.com_state
    ADD CONSTRAINT pk_connection PRIMARY KEY (state_id);


--
-- TOC entry 3850 (class 2606 OID 103096)
-- Name: com_system pk_system; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.com_system
    ADD CONSTRAINT pk_system PRIMARY KEY (system_id);


--
-- TOC entry 3852 (class 2606 OID 103098)
-- Name: com_system uq_com_system_a; Type: CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.com_system
    ADD CONSTRAINT uq_com_system_a UNIQUE (system_code);


--
-- TOC entry 3867 (class 2606 OID 103099)
-- Name: com_system_capability_details com_system_capability_details_capability_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.com_system_capability_details
    ADD CONSTRAINT com_system_capability_details_capability_id_fkey FOREIGN KEY (capability_id) REFERENCES public.com_capability(capability_id);


--
-- TOC entry 3868 (class 2606 OID 103104)
-- Name: com_system_capability_details com_system_capability_details_system_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.com_system_capability_details
    ADD CONSTRAINT com_system_capability_details_system_id_fkey FOREIGN KEY (system_id) REFERENCES public.com_system(system_id);


--
-- TOC entry 3863 (class 2606 OID 103109)
-- Name: com_city fk_com_city_v; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.com_city
    ADD CONSTRAINT fk_com_city_v FOREIGN KEY (state_id) REFERENCES public.com_state(state_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3864 (class 2606 OID 103114)
-- Name: com_state fk_com_state_v; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.com_state
    ADD CONSTRAINT fk_com_state_v FOREIGN KEY (country_id) REFERENCES public.com_country(country_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3865 (class 2606 OID 103119)
-- Name: com_system_capability fk_com_system_capability_b; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.com_system_capability
    ADD CONSTRAINT fk_com_system_capability_b FOREIGN KEY (capability_id) REFERENCES public.com_capability(capability_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 3869 (class 2606 OID 103124)
-- Name: com_system_capability_details fk_com_system_capability_details_a; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.com_system_capability_details
    ADD CONSTRAINT fk_com_system_capability_details_a FOREIGN KEY (system_id) REFERENCES public.com_system(system_id);


--
-- TOC entry 3866 (class 2606 OID 103129)
-- Name: com_system_capability fk_com_system_capability_v; Type: FK CONSTRAINT; Schema: public; Owner: -
--

ALTER TABLE ONLY public.com_system_capability
    ADD CONSTRAINT fk_com_system_capability_v FOREIGN KEY (system_id) REFERENCES public.com_system(system_id) ON UPDATE RESTRICT ON DELETE RESTRICT;


-- Completed on 2024-06-04 13:04:04

--
-- PostgreSQL database dump complete
--


ALTER TABLE ONLY public.com_system_capability_details ALTER COLUMN system_capability_detail_id SET DEFAULT nextval('public.com_system_capability_details_system_capability_detail_id_seq'::regclass);


	   INSERT INTO com_version (version_number,version_deployment_date) 
		VALUES(Versions
		,now()) ON CONFLICT (version_id) DO NOTHING;
  ELSE
      RAISE NOTICE 'Version,common_db_1_01,Already Deployed...';
   END IF;
END $procedure$
;
