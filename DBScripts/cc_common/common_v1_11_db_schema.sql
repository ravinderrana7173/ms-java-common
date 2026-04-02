
CREATE PROCEDURE public.common_v1_11_db_schema()
    LANGUAGE plpgsql
    AS $$
DECLARE
    VersionNumber TEXT := 'common_v1_11';
    system_code_exists BOOLEAN;
BEGIN
    -- Check if the version exists
    IF NOT EXISTS(SELECT 1 FROM com_version WHERE version_number = VersionNumber) THEN
        -- Add column system_code if it doesn't exist
        IF NOT EXISTS (
            SELECT 1 
            FROM information_schema.columns 
            WHERE table_schema = current_schema() AND table_name = 'com_system'
            AND column_name = 'system_code'
        ) THEN
            ALTER TABLE com_system ADD COLUMN system_code VARCHAR(30);
        END IF;

        -- Update system_code values for specific system_uuid values
        UPDATE com_system SET system_code = 'AWSW' WHERE system_uuid = '5e659757-ddd9-423d-a9b4-a73c12444bec';
        UPDATE com_system SET system_code = 'AZRW' WHERE system_uuid = '2f835b92-0fd2-43d5-baac-665d41a37499';
        UPDATE com_system SET system_code = 'CPED' WHERE system_uuid = 'ca133051-3d40-4e51-844b-5c0e0448a8b0';
        UPDATE com_system SET system_code = 'WSW' WHERE system_uuid = '1d17e299-641c-4ce3-aeeb-5939bd04eb08';

        -- Add unique constraint if it doesn't exist
        IF NOT EXISTS (
            SELECT 1 
            FROM information_schema.table_constraints 
            WHERE table_schema = current_schema() AND table_name = 'com_system'
            AND constraint_name = 'uq_com_system_a'
        ) THEN
            ALTER TABLE com_system ADD CONSTRAINT uq_com_system_a UNIQUE (system_code);
        END IF;

        -- Add column is_simulation if it doesn't exist
        IF NOT EXISTS (
            SELECT 1 
            FROM information_schema.columns 
            WHERE table_schema = current_schema() AND table_name = 'com_system'
            AND column_name = 'is_simulation'
        ) THEN
            ALTER TABLE com_system ADD COLUMN is_simulation SMALLINT NOT NULL DEFAULT 0;
        END IF;

        -- Insert version information
        INSERT INTO com_version(version_number, version_deployment_date)
        VALUES (VersionNumber, CURRENT_TIMESTAMP);
    ELSE
        RAISE NOTICE 'Version % ,common_v1_11,Already Deployed...', VersionNumber;
    END IF;
END;
$$;