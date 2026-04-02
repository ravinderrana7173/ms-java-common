CREATE OR REPLACE PROCEDURE public.common_v1_05_system_capability_data()
 LANGUAGE plpgsql
AS $procedure$

DECLARE
Versions varchar(50) := 'common_db_1_05';

BEGIN

	CREATE Table IF NOT EXISTS public.com_version (
		version_id bigserial NOT NULL,
		version_number varchar(100) NOT NULL,
		version_deployment_date timestamp NOT NULL,
		CONSTRAINT pk_com_version PRIMARY KEY (version_id)
	);
	
	IF NOT EXISTS (select version_number  FROM com_version 
	WHERE version_number = Versions) THEN

			INSERT INTO public.com_capability OVERRIDING SYSTEM VALUE VALUES (1, 'STRG', 'Storage', 'Storage', '1', '2024-06-03 13:07:35.338288', '1', '2024-06-03 13:07:35.338288');
			INSERT INTO public.com_capability OVERRIDING SYSTEM VALUE VALUES (2, 'STRG', 'Storage', 'Storage', '1', '2024-06-03 13:08:40.847462', '1', '2024-06-03 13:08:40.847462');
			INSERT INTO public.com_capability OVERRIDING SYSTEM VALUE VALUES (4, 'STRG', 'Storage', 'Storage', '1', '2024-06-03 13:11:52.709542', '1', '2024-06-03 13:11:52.709542');
			INSERT INTO public.com_capability OVERRIDING SYSTEM VALUE VALUES (5, 'CLCON', 'Cloud Connect', 'Cloud Connect', '1', '2024-06-03 13:26:53.680228', '1', '2024-06-03 13:26:53.680228');

			INSERT INTO public.com_system OVERRIDING SYSTEM VALUE VALUES (1, '5e659757-ddd9-423d-a9b4-a73c12444bec', 'Aws Worker', 'Aws Worker', '1', '2024-06-03 13:11:52.709542', '1', '2024-06-03 13:11:52.709542', 'AWSW', 0);
			INSERT INTO public.com_system OVERRIDING SYSTEM VALUE VALUES (2, '2f835b92-0fd2-43d5-baac-665d41a37499', 'Azure Worker', 'Azure Worker', '1', '2024-06-03 13:11:52.709542', '1', '2024-06-03 13:11:52.709542', 'AZRW', 0);
			INSERT INTO public.com_system OVERRIDING SYSTEM VALUE VALUES (3, '1d17e299-641c-4ce3-aeeb-5939bd04eb08', 'Web Storage Worker', 'Web Storage Worker', '1', '2024-06-03 13:11:52.709542', '1', '2024-06-03 13:11:52.709542', 'WSW', 0);


			INSERT INTO public.com_system_capability OVERRIDING SYSTEM VALUE VALUES (1, 1, 1, '1', '2024-06-03 13:11:52.709542', '1', '2024-06-03 13:11:52.709542');
			INSERT INTO public.com_system_capability OVERRIDING SYSTEM VALUE VALUES (2, 2, 1, '1', '2024-06-03 13:11:52.709542', '1', '2024-06-03 13:11:52.709542');
			INSERT INTO public.com_system_capability OVERRIDING SYSTEM VALUE VALUES (3, 3, 1, '1', '2024-06-03 13:11:52.709542', '1', '2024-06-03 13:11:52.709542');


			INSERT INTO public.com_system_capability_details VALUES (1, 1, 5, 'credential_uuid', '', '1', '2024-06-03 13:26:53.680228', '1', '2024-06-03 13:26:53.680228');
			INSERT INTO public.com_system_capability_details VALUES (2, 1, NULL, 'alias', 'aws', '1', '2024-06-03 13:26:53.680228', '1', '2024-06-03 13:26:53.680228');



	   INSERT INTO com_version (version_number,version_deployment_date) 
		VALUES(Versions
		,now()) ON CONFLICT (version_id) DO NOTHING;
  ELSE
      RAISE NOTICE 'Version,common_db_1_05,Already Deployed...';
   END IF;
END $procedure$
;
