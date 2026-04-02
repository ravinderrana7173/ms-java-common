CREATE PROCEDURE public.common_v1_09_db_schema()
    LANGUAGE plpgsql
    AS $$
DECLARE
    VersionNumber TEXT := 'common_v1_09';
    column_exists BOOLEAN;
    foreign_key_exists BOOLEAN;
    index_exists BOOLEAN;
BEGIN
    -- Check if the version exists
    IF NOT EXISTS(SELECT 1 FROM com_version WHERE version_number = VersionNumber) THEN
        -- Check if the column exists and is nullable
        SELECT EXISTS (
            SELECT 1 
            FROM information_schema.columns 
            WHERE table_schema = current_schema() AND table_name = 'com_system_capability_details'
            AND column_name = 'capability_id' AND is_nullable = 'NO'
        ) INTO column_exists;

        -- Alter column capability_id if it exists and is not nullable
        IF column_exists THEN
            ALTER TABLE com_system_capability_details ALTER COLUMN capability_id DROP NOT NULL;
        END IF;

        -- Check if the foreign key exists and drop it
        SELECT EXISTS (
            SELECT 1 
            FROM information_schema.table_constraints 
            WHERE table_schema = current_schema() AND table_name = 'com_system_capability_details'
            AND constraint_name = 'fk_com_system_capability_details_a'
        ) INTO foreign_key_exists;

        IF foreign_key_exists THEN
            ALTER TABLE com_system_capability_details DROP CONSTRAINT fk_com_system_capability_details_a;
        END IF;

        -- Check if the unique index exists and drop it
        SELECT EXISTS (
            SELECT 1 
            FROM pg_catalog.pg_indexes 
            WHERE schemaname = current_schema() AND tablename = 'com_system_capability_details'
            AND indexname = 'uq_com_system_capability_details_a'
        ) INTO index_exists;

        IF index_exists THEN
            DROP INDEX uq_com_system_capability_details_a;
        END IF;

        -- Add the foreign key constraint if it doesn't exist
        IF NOT foreign_key_exists THEN
            ALTER TABLE com_system_capability_details ADD CONSTRAINT fk_com_system_capability_details_a
            FOREIGN KEY (system_id) REFERENCES com_system(system_id);
        END IF;

        -- Insert version information
        INSERT INTO com_version(version_number, version_deployment_date)
        VALUES (VersionNumber, CURRENT_TIMESTAMP);
    ELSE
        RAISE NOTICE 'Version % common_v1_09, Already Deployed...', VersionNumber;
    END IF;
END;
$$;
