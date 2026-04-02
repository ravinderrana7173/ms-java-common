CREATE PROCEDURE public.common_v1_10_db_schema()
    LANGUAGE plpgsql
    AS $$
DECLARE
    VersionNumber TEXT := 'common_v1_10';
    CLCON_capability_id INT;
    AWS_system_id INT;
BEGIN
    -- Check if the version exists
    IF NOT EXISTS(SELECT 1 FROM com_version WHERE version_number = VersionNumber) THEN
        -- Insert CLCON capability if it doesn't exist
        INSERT INTO com_capability (capability_code, capability_name, description, created_by, created_on, modified_by, modified_on)
        VALUES ('CLCON', 'Cloud Connect', 'Cloud Connect', 1, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP)
        ON CONFLICT DO NOTHING;

        -- Get CLCON capability ID
        SELECT capability_id INTO CLCON_capability_id FROM com_capability WHERE capability_code = 'CLCON';

        -- Get AWS system ID
        SELECT system_id INTO AWS_system_id FROM com_system WHERE system_uuid = '5e659757-ddd9-423d-a9b4-a73c12444bec';

        -- Insert into com_system_capability_details
        INSERT INTO com_system_capability_details (system_id, capability_id, key, value, created_by, created_on, modified_by, modified_on)
        VALUES (AWS_system_id, CLCON_capability_id, 'credential_uuid', '', 1, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP),
               (AWS_system_id, NULL, 'alias', 'aws', 1, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP)
        ON CONFLICT DO NOTHING;

        -- Insert version information
        INSERT INTO com_version(version_number, version_deployment_date)
        VALUES (VersionNumber, CURRENT_TIMESTAMP);
    ELSE
        RAISE NOTICE 'Version %,common_v1_10, Already Deployed...', VersionNumber;
    END IF;
END;
$$;
