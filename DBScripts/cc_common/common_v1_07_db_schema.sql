
CREATE PROCEDURE public.common_v1_07_db_schema()
LANGUAGE plpgsql
AS $$
DECLARE
    VersionNumber TEXT := 'common_v1_07';
    version_exists BOOLEAN;
BEGIN
    -- Create the com_version table if it doesn't exist
    CREATE TABLE IF NOT EXISTS public.com_version (
        version_id BIGSERIAL NOT NULL,
        version_number VARCHAR(100) NOT NULL,
        version_deployment_date TIMESTAMP NOT NULL,
        CONSTRAINT pk_com_version PRIMARY KEY (version_id)
    );

    -- Check if the version already exists
    SELECT EXISTS(SELECT 1 FROM com_version WHERE version_number = VersionNumber) INTO version_exists;

    IF NOT version_exists THEN
        -- Insert data into com_system
        INSERT INTO com_system (system_uuid, system_name, description, logo, created_by, created_on, modified_by, modified_on)
        VALUES ('ca133051-3d40-4e51-844b-5c0e0448a8b0', 'CPE Device', 'CPE Device', NULL, 1, CURRENT_TIMESTAMP, 1, CURRENT_TIMESTAMP);
       

        -- Update logo for specific system_uuid values
        UPDATE com_system SET logo = 'img-aws.png' WHERE system_uuid = '5e659757-ddd9-423d-a9b4-a73c12444bec';
        UPDATE com_system SET logo = 'img-microsoft-azure.png' WHERE system_uuid = '2f835b92-0fd2-43d5-baac-665d41a37499';
        UPDATE com_system SET logo = 'img-central-repository.png' WHERE system_uuid = '1d17e299-641c-4ce3-aeeb-5939bd04eb08';

        -- Insert version information
        INSERT INTO com_version (version_number, version_deployment_date) 
        VALUES (VersionNumber, NOW());
    ELSE
        RAISE NOTICE 'Version %, common_v1_07,already deployed...', VersionNumber;
    END IF;
END;
$$;
