
CREATE PROCEDURE public.common_v1_12_db_schema()
    LANGUAGE plpgsql
    AS $$
DECLARE
    VersionNumber TEXT := 'common_v1_12';
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

         update com_city set city_name = LTRIM(city_name); 
         update com_city set city_name = RTRIM(city_name); 

        -- Insert version information
        INSERT INTO com_version(version_number, version_deployment_date)
        VALUES (VersionNumber, CURRENT_TIMESTAMP);
    ELSE
        RAISE NOTICE 'Version % ,common_v1_12,Already Deployed...', VersionNumber;
    END IF;
END;
$$;