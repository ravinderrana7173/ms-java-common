
CREATE PROCEDURE public.common_v1_08_db_schema()
    LANGUAGE plpgsql
    AS $$
DECLARE
    VersionNumber TEXT := 'common_v1_08';
    version_exists BOOLEAN;
BEGIN
    -- Check if the version exists
    SELECT EXISTS(SELECT 1 FROM com_version WHERE version_number = VersionNumber) INTO version_exists;

    IF NOT version_exists THEN
        -- Create table com_system_capability_details if it doesn't exist
        CREATE TABLE IF NOT EXISTS com_system_capability_details (
            system_capability_detail_id SERIAL PRIMARY KEY,
            system_id INT NOT NULL,
            capability_id INT NOT NULL,
            key VARCHAR(50) NOT NULL,
            value VARCHAR(500) NOT NULL,
            created_by VARCHAR(50) NOT NULL,
            created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
            modified_by VARCHAR(50) NOT NULL,
            modified_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
            UNIQUE (system_id, capability_id),
            FOREIGN KEY (system_id) REFERENCES com_system (system_id),
            FOREIGN KEY (capability_id) REFERENCES com_capability (capability_id)
        );

        -- Insert version information
        INSERT INTO com_version(version_number, version_deployment_date)
        VALUES(VersionNumber, CURRENT_TIMESTAMP);
    ELSE
        RAISE NOTICE 'Version % common_v1_08,Already Deployed...', VersionNumber;
    END IF;
END;
$$;
