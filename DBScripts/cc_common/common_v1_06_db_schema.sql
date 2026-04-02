

CREATE OR REPLACE PROCEDURE public.common_v1_06_db_schema()
LANGUAGE plpgsql
AS $$
DECLARE
    VersionNumber TEXT := 'common_v1_06';
    version_exists BOOLEAN;
    column_exists BOOLEAN;
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
        -- Check if the column exists
        SELECT EXISTS(
            SELECT 1 
            FROM information_schema.columns 
            WHERE table_schema = current_schema() AND table_name = 'com_system' AND column_name = 'logo'
        ) INTO column_exists;

        IF NOT column_exists THEN
            -- Alter the table to add the logo column
            ALTER TABLE com_system ADD COLUMN logo VARCHAR(50) DEFAULT NULL;
        END IF;

        -- Insert version information
        INSERT INTO com_version (version_number, version_deployment_date) 
        VALUES (VersionNumber, NOW()) 
        ON CONFLICT (version_id) DO NOTHING;
    ELSE
        RAISE NOTICE 'Version %,common_v1_06 Al,ready Deployed...', VersionNumber;
    END IF;
END;
$$;
