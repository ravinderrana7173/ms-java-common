
CREATE OR REPLACE PROCEDURE public.common_v1_02_country_data()
 LANGUAGE plpgsql
AS $procedure$

DECLARE
Versions varchar(50) := 'common_db_1_02';

BEGIN

	CREATE Table IF NOT EXISTS public.com_version (
		version_id bigserial NOT NULL,
		version_number varchar(100) NOT NULL,
		version_deployment_date timestamp NOT NULL,
		CONSTRAINT pk_com_version PRIMARY KEY (version_id)
	);
	
	IF NOT EXISTS (select version_number  FROM com_version 
	WHERE version_number = Versions) THEN

INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (1, 'Canada', 'CA', 'CAN', '124', '001', true, true, '1', '2024-06-03 11:25:24.408929', '1', '2024-06-03 11:25:24.408929');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (2, 'China', 'CN', 'CHN', '156', '086', true, true, '1', '2024-06-03 11:29:04.348904', '1', '2024-06-03 11:29:04.348904');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (3, 'France', 'FR', 'FRA', '250', '033', true, true, '1', '2024-06-03 11:29:04.348904', '1', '2024-06-03 11:29:04.348904');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (4, 'Germany', 'DE', 'DEU', '276', '049', true, true, '1', '2024-06-03 11:29:18.984418', '1', '2024-06-03 11:29:18.984418');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (5, 'Hong Kong', 'HK', 'HKG', '344', '852', true, true, '1', '2024-06-03 11:29:18.984418', '1', '2024-06-03 11:29:18.984418');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (6, 'Hungary', 'HU', 'HUN', '348', '036', true, true, '1', '2024-06-03 11:29:18.984418', '1', '2024-06-03 11:29:18.984418');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (7, 'Israel', 'IL', 'ISR', '376', '972', true, true, '1', '2024-06-03 11:29:18.984418', '1', '2024-06-03 11:29:18.984418');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (8, 'Italy', 'IT', 'ITA', '380', '039', true, true, '1', '2024-06-03 11:29:18.984418', '1', '2024-06-03 11:29:18.984418');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (9, 'Japan', 'JP', 'JPN', '392', '081', false, true, '1', '2024-06-03 11:29:18.984418', '1', '2024-06-03 11:29:18.984418');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (10, 'Korea (the Republic of)', 'KR', 'KOR', '410', '082', true, true, '1', '2024-06-03 11:29:18.984418', '1', '2024-06-03 11:29:18.984418');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (11, 'Netherlands (the)', 'NL', 'NLD', '528', '031', true, true, '1', '2024-06-03 11:29:18.984418', '1', '2024-06-03 11:29:18.984418');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (12, 'Portugal', 'PT', 'PRT', '620', '351', true, true, '1', '2024-06-03 11:29:18.984418', '1', '2024-06-03 11:29:18.984418');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (13, 'Russian Federation (the)', 'RU', 'RUS', '643', '007', true, true, '1', '2024-06-03 11:29:18.984418', '1', '2024-06-03 11:29:18.984418');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (14, 'Singapore', 'SG', 'SGP', '702', '065', true, true, '1', '2024-06-03 11:29:18.984418', '1', '2024-06-03 11:29:18.984418');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (15, 'Spain', 'ES', 'ESP', '724', '034', true, true, '1', '2024-06-03 11:29:18.984418', '1', '2024-06-03 11:29:18.984418');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (16, 'Turkey', 'TR', 'TUR', '792', '090', true, true, '1', '2024-06-03 11:29:18.984418', '1', '2024-06-03 11:29:18.984418');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (17, 'Viet Nam', 'VN', 'VNM', '704', '084', true, true, '1', '2024-06-03 11:29:18.984418', '1', '2024-06-03 11:29:18.984418');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (18, 'United Kingdom of Great Britain and Northern Ireland (the)', 'GB', 'GBR', '826', '044', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (19, 'United States of America (the)', 'US', 'USA', '840', '001', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (20, 'Afghanistan', 'AF', 'AFG', '4', '093', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (21, 'Albania', 'AL', 'ALB', '8', '355', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (22, 'Algeria', 'DZ', 'DZA', '12', '213', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (23, 'American Samoa', 'AS', 'ASM', '16', '684', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (24, 'Andorra', 'AD', 'AND', '20', '376', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (25, 'Angola', 'AO', 'AGO', '24', '244', false, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (27, 'Antarctica', 'AQ', 'ATA', '10', '672', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (28, 'Antigua and Barbuda', 'AG', 'ATG', '28', '268', false, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (29, 'Argentina', 'AR', 'ARG', '32', '054', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (30, 'Armenia', 'AM', 'ARM', '51', '374', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (31, 'Aruba', 'AW', 'ABW', '533', '297', false, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (32, 'Australia', 'AU', 'AUS', '36', '061', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (33, 'Austria', 'AT', 'AUT', '40', '043', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (34, 'Azerbaijan', 'AZ', 'AZE', '31', '994', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (35, 'Bahamas (the)', 'BS', 'BHS', '44', '242', false, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (36, 'Bahrain', 'BH', 'BHR', '48', '973', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (37, 'Bangladesh', 'BD', 'BGD', '50', '880', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (38, 'Barbados', 'BB', 'BRB', '52', '246', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (39, 'Belarus', 'BY', 'BLR', '112', '375', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (40, 'Belgium', 'BE', 'BEL', '56', '032', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (41, 'Belize', 'BZ', 'BLZ', '84', '501', false, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (42, 'Benin', 'BJ', 'BEN', '204', '229', false, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (43, 'Bermuda', 'BM', 'BMU', '60', '441', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (45, 'Bolivia (Plurinational State of)', 'BO', 'BOL', '68', '591', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (46, 'Bosnia and Herzegovina', 'BA', 'BIH', '70', '387', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (47, 'Botswana', 'BW', 'BWA', '72', '267', false, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (48, 'Brazil', 'BR', 'BRA', '76', '055', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (49, 'Virgin Islands (British)', 'VG', 'VGB', '92', '284', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (50, 'Brunei Darussalam', 'BN', 'BRN', '96', '673', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (51, 'Bulgaria', 'BG', 'BGR', '100', '359', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (52, 'Burkina Faso', 'BF', 'BFA', '854', '226', false, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (53, 'Myanmar', 'MM', 'MMR', '104', '095', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (54, 'Burundi', 'BI', 'BDI', '108', '257', false, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (55, 'Cambodia', 'KH', 'KHM', '116', '855', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (56, 'Cameroon', 'CM', 'CMR', '120', '237', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (57, 'Cabo Verde', 'CV', 'CPV', '132', '238', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (58, 'Cayman Islands (the)', 'KY', 'CYM', '136', '345', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (59, 'Central African Republic (the)', 'CF', 'CAF', '140', '236', false, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (61, 'Chile', 'CL', 'CHL', '152', '056', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (62, 'Christmas Island', 'CX', 'CXR', '162', '061', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (64, 'Colombia', 'CO', 'COL', '170', '057', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (66, 'Congo (the)', 'CD', 'COD', '180', '242', false, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (67, 'Congo (the Democratic Republic of the)', 'CG', 'COG', '178', '243', false, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (68, 'Cook Islands (the)', 'CK', 'COK', '184', '682', false, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (69, 'Costa Rica', 'CR', 'CRI', '188', '506', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (70, 'Croatia', 'HR', 'HRV', '191', '385', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (71, 'Cuba', 'CU', 'CUB', '192', '053', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (72, 'Cyprus', 'CY', 'CYP', '196', '357', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (73, 'Czech Republic (the)', 'CZ', 'CZE', '203', '420', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (74, 'Denmark', 'DK', 'DNK', '208', '045', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (76, 'Dominica', 'DM', 'DMA', '212', '767', false, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (77, 'Dominican Republic (the)', 'DO', 'DOM', '214', '809', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (78, 'Ecuador', 'EC', 'ECU', '218', '593', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (79, 'Egypt', 'EG', 'EGY', '818', '020', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (80, 'El Salvador', 'SV', 'SLV', '222', '503', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (82, 'Eritrea', 'ER', 'ERI', '232', '291', false, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (83, 'Estonia', 'EE', 'EST', '233', '372', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (84, 'Ethiopia', 'ET', 'ETH', '231', '251', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (85, 'Faroe Islands (the)', 'FO', 'FRO', '234', '298', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (87, 'Fiji', 'FJ', 'FJI', '242', '679', false, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (88, 'Finland', 'FI', 'FIN', '246', '358', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (89, 'French Guiana', 'GF', 'GUF', '254', '594', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (90, 'French Polynesia', 'PF', 'PYF', '258', '689', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (91, 'Gabon', 'GA', 'GAB', '266', '241', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (92, 'Gambia (the)', 'GM', 'GMB', '270', '220', false, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (93, 'Georgia', 'GE', 'GEO', '268', '995', true, true, '1', '2024-06-03 11:30:00.333344', '1', '2024-06-03 11:30:00.333344');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (94, 'Ghana', 'GH', 'GHA', '288', '233', false, true, '1', '2024-06-03 11:42:26.346334', '1', '2024-06-03 11:42:26.346334');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (95, 'Gibraltar', 'GI', 'GIB', '292', '350', true, true, '1', '2024-06-03 11:42:26.346334', '1', '2024-06-03 11:42:26.346334');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (96, 'Greece', 'GR', 'GRC', '300', '030', true, true, '1', '2024-06-03 11:42:26.346334', '1', '2024-06-03 11:42:26.346334');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (97, 'Greenland', 'GL', 'GRL', '304', '299', true, true, '1', '2024-06-03 11:42:26.346334', '1', '2024-06-03 11:42:26.346334');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (98, 'Grenada', 'GD', 'GRD', '308', '473', false, true, '1', '2024-06-03 11:42:26.346334', '1', '2024-06-03 11:42:26.346334');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (99, 'Guadeloupe', 'GP', 'GLP', '312', '590', true, true, '1', '2024-06-03 11:42:26.346334', '1', '2024-06-03 11:42:26.346334');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (100, 'Guam', 'GU', 'GUM', '316', '671', true, true, '1', '2024-06-03 11:42:26.346334', '1', '2024-06-03 11:42:26.346334');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (101, 'Guatemala', 'GT', 'GTM', '320', '502', true, true, '1', '2024-06-03 11:42:26.346334', '1', '2024-06-03 11:42:26.346334');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (102, 'Guinea', 'GN', 'GIN', '324', '224', false, true, '1', '2024-06-03 11:42:26.346334', '1', '2024-06-03 11:42:26.346334');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (104, 'Guyana', 'GY', 'GUY', '328', '592', false, true, '1', '2024-06-03 11:42:26.346334', '1', '2024-06-03 11:42:26.346334');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (105, 'Haiti', 'HT', 'HTI', '332', '509', true, true, '1', '2024-06-03 11:42:26.346334', '1', '2024-06-03 11:42:26.346334');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (106, 'Honduras', 'HN', 'HND', '340', '504', true, true, '1', '2024-06-03 11:42:26.346334', '1', '2024-06-03 11:42:26.346334');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (107, 'Iceland', 'IS', 'ISL', '352', '354', true, true, '1', '2024-06-03 11:42:26.346334', '1', '2024-06-03 11:42:26.346334');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (108, 'India', 'IN', 'IND', '356', '091', true, true, '1', '2024-06-03 11:42:26.346334', '1', '2024-06-03 11:42:26.346334');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (109, 'Indonesia', 'ID', 'IDN', '360', '062', true, true, '1', '2024-06-03 11:42:26.346334', '1', '2024-06-03 11:42:26.346334');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (110, 'Iran (Islamic Republic of)', 'IR', 'IRN', '364', '098', true, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (111, 'Iraq', 'IQ', 'IRQ', '368', '964', true, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (112, 'Ireland', 'IE', 'IRL', '372', '353', false, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (113, 'Cote d''Ivoire', 'CI', 'CIV', '384', '225', true, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (114, 'Jamaica', 'JM', 'JAM', '388', '876', true, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (115, 'Jordan', 'JO', 'JOR', '400', '962', true, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (116, 'Kazakhstan', 'KZ', 'KAZ', '398', '007', true, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (117, 'Kenya', 'KE', 'KEN', '404', '254', true, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (119, 'Kuwait', 'KW', 'KWT', '414', '965', true, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (120, 'Korea (the Democratic People''s Republic of)', 'KP', 'PRK', '408', '850', false, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (121, 'Kyrgyzstan', 'KG', 'KGZ', '471', '996', true, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (122, 'Lao People''s Democratic Republic (the)', 'LA', 'LAO', '418', '856', true, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (123, 'Latvia', 'LV', 'LVA', '428', '371', true, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (124, 'Lebanon', 'LB', 'LBN', '422', '961', true, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (125, 'Lesotho', 'LS', 'LSO', '426', '266', true, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (126, 'Liberia', 'LR', 'LBR', '430', '231', true, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (127, 'Libya', 'LY', 'LBY', '434', '218', true, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (128, 'Liechtenstein', 'LI', 'LIE', '438', '423', true, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (129, 'Lithuania', 'LT', 'LTU', '440', '370', true, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (130, 'Luxembourg', 'LU', 'LUX', '442', '352', true, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (131, 'Macao', 'MO', 'MAC', '446', '853', false, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (132, 'Macedonia (the former Yugoslav Republic of)', 'MK', 'MKD', '807', '389', true, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (133, 'Madagascar', 'MG', 'MDG', '450', '261', true, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (134, 'Malawi', 'MW', 'MWI', '454', '265', false, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (135, 'Malaysia', 'MY', 'MYS', '458', '060', true, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (136, 'Maldives', 'MV', 'MDV', '462', '960', true, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (137, 'Mali', 'ML', 'MLI', '466', '223', false, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (138, 'Malta', 'MT', 'MLT', '470', '356', true, true, '1', '2024-06-03 11:42:43.731649', '1', '2024-06-03 11:42:43.731649');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (139, 'Marshall Islands (the)', 'MH', 'MHL', '584', '692', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (140, 'Martinique', 'MQ', 'MTQ', '474', '596', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (141, 'Mauritania', 'MR', 'MRT', '478', '222', false, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (142, 'Mauritius', 'MU', 'MUS', '480', '230', false, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (144, 'Mexico', 'MX', 'MEX', '484', '052', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (145, 'Micronesia (Federated States of)', 'FM', 'FSM', '583', '691', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (146, 'Moldova (the Republic of)', 'MD', 'MDA', '498', '373', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (147, 'Monaco', 'MC', 'MCO', '492', '377', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (148, 'Mongolia', 'MN', 'MNG', '496', '976', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (151, 'Morocco', 'MA', 'MAR', '504', '212', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (152, 'Mozambique', 'MZ', 'MOZ', '508', '258', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (153, 'Namibia', 'NA', 'NAM', '516', '264', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (155, 'Nepal', 'NP', 'NPL', '524', '977', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (157, 'New Caledonia', 'NC', 'NCL', '540', '687', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (158, 'New Zealand', 'NZ', 'NZL', '554', '064', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (159, 'Nicaragua', 'NI', 'NIC', '558', '505', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (160, 'Niger (the)', 'NE', 'NER', '562', '227', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (161, 'Nigeria', 'NG', 'NGA', '566', '234', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (163, 'Norfolk Island', 'NF', 'NFK', '574', '672', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (164, 'Norway', 'NO', 'NOR', '578', '047', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (165, 'Oman', 'OM', 'OMN', '512', '968', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (166, 'Pakistan', 'PK', 'PAK', '586', '092', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (167, 'Palau', 'PW', 'PLW', '585', '680', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (168, 'Palestine, State of', 'PS', 'PSE', '275', '970', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (169, 'Panama', 'PA', 'PAN', '591', '507', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (170, 'Papua New Guinea', 'PG', 'PNG', '598', '675', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (171, 'Paraguay', 'PY', 'PRY', '600', '595', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (172, 'Peru', 'PE', 'PER', '604', '051', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (173, 'Philippines (the)', 'PH', 'PHL', '608', '063', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (174, 'Poland', 'PL', 'POL', '616', '048', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (175, 'Puerto Rico', 'PR', 'PRI', '630', '787', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (176, 'Qatar', 'QA', 'QAT', '634', '974', false, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (177, 'Reunion', 'RE', 'REU', '638', '262', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (178, 'Romania', 'RO', 'ROU', '642', '040', true, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (179, 'Rwanda', 'RW', 'RWA', '646', '250', false, true, '1', '2024-06-03 12:09:23.203607', '1', '2024-06-03 12:09:23.203607');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (181, 'Saint Kitts and Nevis', 'KN', 'KNA', '659', '869', false, true, '1', '2024-06-03 12:09:38.942199', '1', '2024-06-03 12:09:38.942199');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (182, 'Saint Lucia', 'LC', 'LCA', '662', '758', false, true, '1', '2024-06-03 12:09:38.942199', '1', '2024-06-03 12:09:38.942199');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (184, 'Saint Vincent and the Grenadines', 'VC', 'VCT', '670', '784', true, true, '1', '2024-06-03 12:09:38.942199', '1', '2024-06-03 12:09:38.942199');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (185, 'San Marino', 'SM', 'SMR', '674', '378', true, true, '1', '2024-06-03 12:09:38.942199', '1', '2024-06-03 12:09:38.942199');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (186, 'Sao Tome and Principe', 'ST', 'STP', '678', '239', false, true, '1', '2024-06-03 12:09:38.942199', '1', '2024-06-03 12:09:38.942199');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (187, 'Saudi Arabia', 'SA', 'SAU', '682', '966', true, true, '1', '2024-06-03 12:09:38.942199', '1', '2024-06-03 12:09:38.942199');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (188, 'Senegal', 'SN', 'SEN', '686', '221', true, true, '1', '2024-06-03 12:09:38.942199', '1', '2024-06-03 12:09:38.942199');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (190, 'Seychelles', 'SC', 'SYC', '690', '248', false, true, '1', '2024-06-03 12:09:38.942199', '1', '2024-06-03 12:09:38.942199');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (191, 'Sierra Leone', 'SL', 'SLE', '694', '249', false, true, '1', '2024-06-03 12:09:38.942199', '1', '2024-06-03 12:09:38.942199');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (192, 'Slovakia', 'SK', 'SVK', '703', '421', true, true, '1', '2024-06-03 12:09:38.942199', '1', '2024-06-03 12:09:38.942199');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (193, 'Slovenia', 'SI', 'SVN', '705', '386', true, true, '1', '2024-06-03 12:09:38.942199', '1', '2024-06-03 12:09:38.942199');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (194, 'Solomon Islands', 'SB', 'SLB', '90', '677', false, true, '1', '2024-06-03 12:09:38.942199', '1', '2024-06-03 12:09:38.942199');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (195, 'Somalia', 'SO', 'SOM', '706', '252', false, true, '1', '2024-06-03 12:09:38.942199', '1', '2024-06-03 12:09:38.942199');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (196, 'South Africa', 'ZA', 'ZAF', '710', '027', true, true, '1', '2024-06-03 12:09:38.942199', '1', '2024-06-03 12:09:38.942199');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (197, 'Sri Lanka', 'LK', 'LKA', '144', '094', true, true, '1', '2024-06-03 12:09:38.942199', '1', '2024-06-03 12:09:38.942199');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (198, 'Sudan (the)', 'SD', 'SDN', '729', '095', true, true, '1', '2024-06-03 12:09:38.942199', '1', '2024-06-03 12:09:38.942199');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (199, 'Suriname', 'SR', 'SUR', '740', '597', false, true, '1', '2024-06-03 12:09:38.942199', '1', '2024-06-03 12:09:38.942199');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (200, 'Swaziland', 'SZ', 'SWZ', '748', '268', true, true, '1', '2024-06-03 12:09:38.942199', '1', '2024-06-03 12:09:38.942199');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (201, 'Sweden', 'SE', 'SWE', '752', '046', true, true, '1', '2024-06-03 12:09:38.942199', '1', '2024-06-03 12:09:38.942199');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (202, 'Switzerland', 'CH', 'CHE', '756', '041', true, true, '1', '2024-06-03 12:09:38.942199', '1', '2024-06-03 12:09:38.942199');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (203, 'Syrian Arab Republic', 'SY', 'SYR', '760', '963', false, true, '1', '2024-06-03 12:09:38.942199', '1', '2024-06-03 12:09:38.942199');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (204, 'Taiwan (Province of China)', 'TW', 'TWN', '158', '886', true, true, '1', '2024-06-03 12:09:38.942199', '1', '2024-06-03 12:09:38.942199');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (205, 'Tajikistan', 'TJ', 'TJK', '762', '992', true, true, '1', '2024-06-03 12:09:38.942199', '1', '2024-06-03 12:09:38.942199');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (206, 'Tanzania, United Republic of', 'TZ', 'TZA', '834', '255', false, true, '1', '2024-06-03 12:09:38.942199', '1', '2024-06-03 12:09:38.942199');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (207, 'Thailand', 'TH', 'THA', '764', '066', true, true, '1', '2024-06-03 12:09:38.942199', '1', '2024-06-03 12:09:38.942199');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (208, 'Togo', 'TG', 'TGO', '768', '228', true, true, '1', '2024-06-03 12:09:38.942199', '1', '2024-06-03 12:09:38.942199');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (209, 'Tonga', 'TO', 'TON', '776', '676', false, true, '1', '2024-06-03 12:09:51.550463', '1', '2024-06-03 12:09:51.550463');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (210, 'Trinidad and Tobago', 'TT', 'TTO', '780', '868', false, true, '1', '2024-06-03 12:09:51.550463', '1', '2024-06-03 12:09:51.550463');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (211, 'Tunisia', 'TN', 'TUN', '788', '216', true, true, '1', '2024-06-03 12:09:51.550463', '1', '2024-06-03 12:09:51.550463');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (212, 'Turkmenistan', 'TM', 'TKM', '795', '993', true, true, '1', '2024-06-03 12:09:51.550463', '1', '2024-06-03 12:09:51.550463');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (213, 'Turks and Caicos Islands (the)', 'TC', 'TCA', '796', '649', true, true, '1', '2024-06-03 12:09:51.550463', '1', '2024-06-03 12:09:51.550463');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (215, 'Uganda', 'UG', 'UGA', '800', '256', false, true, '1', '2024-06-03 12:09:51.550463', '1', '2024-06-03 12:09:51.550463');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (216, 'Ukraine', 'UA', 'UKR', '804', '380', true, true, '1', '2024-06-03 12:09:51.550463', '1', '2024-06-03 12:09:51.550463');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (217, 'United Arab Emirates (the)', 'AE', 'ARE', '784', '971', false, true, '1', '2024-06-03 12:09:51.550463', '1', '2024-06-03 12:09:51.550463');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (218, 'Uruguay', 'UY', 'URY', '858', '598', true, true, '1', '2024-06-03 12:09:51.550463', '1', '2024-06-03 12:09:51.550463');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (219, 'Uzbekistan', 'UZ', 'UZB', '860', '998', true, true, '1', '2024-06-03 12:09:51.550463', '1', '2024-06-03 12:09:51.550463');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (220, 'Vanuatu', 'VU', 'VUT', '548', '678', false, true, '1', '2024-06-03 12:09:51.550463', '1', '2024-06-03 12:09:51.550463');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (221, 'Holy See (the)', 'VA', 'VAT', '336', '039', true, true, '1', '2024-06-03 12:09:51.550463', '1', '2024-06-03 12:09:51.550463');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (222, 'Venezuela (Bolivarian Republic of)', 'VE', 'VEN', '862', '058', true, true, '1', '2024-06-03 12:09:51.550463', '1', '2024-06-03 12:09:51.550463');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (223, 'Wallis and Futuna', 'WF', 'WLF', '876', '681', true, true, '1', '2024-06-03 12:09:51.550463', '1', '2024-06-03 12:09:51.550463');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (224, 'Samoa', 'WS', 'WSM', '882', '685', true, true, '1', '2024-06-03 12:09:51.550463', '1', '2024-06-03 12:09:51.550463');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (225, 'Yemen', 'YE', 'YEM', '887', '967', false, true, '1', '2024-06-03 12:09:51.550463', '1', '2024-06-03 12:09:51.550463');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (226, 'Zambia', 'ZM', 'ZMB', '894', '260', true, true, '1', '2024-06-03 12:09:51.550463', '1', '2024-06-03 12:09:51.550463');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (227, 'Zimbabwe', 'ZW', 'ZWE', '716', '263', false, true, '1', '2024-06-03 12:09:51.550463', '1', '2024-06-03 12:09:51.550463');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (234, 'Guernsey', 'GG', 'GGY', '831', '044', true, true, '1', '2024-06-03 12:09:51.550463', '1', '2024-06-03 12:09:51.550463');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (236, 'Isle Of Man', 'IM', 'IMN', '833', '044', true, true, '1', '2024-06-03 12:09:51.550463', '1', '2024-06-03 12:09:51.550463');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (237, 'Jersey', 'JE', 'JEY', '832', '044', true, true, '1', '2024-06-03 12:09:51.550463', '1', '2024-06-03 12:09:51.550463');
INSERT INTO public.com_country OVERRIDING SYSTEM VALUE VALUES (238, 'Northern Mariana Islands (the)', 'MP', 'MNP', '580', '670', true, true, '1', '2024-06-03 12:11:17.667271', '1', '2024-06-03 12:11:17.667271');


	   INSERT INTO com_version (version_number,version_deployment_date) 
		VALUES(Versions
		,now()) ON CONFLICT (version_id) DO NOTHING;
  ELSE
      RAISE NOTICE 'Version,common_db_1_02,Already Deployed...';
   END IF;
END $procedure$
;
