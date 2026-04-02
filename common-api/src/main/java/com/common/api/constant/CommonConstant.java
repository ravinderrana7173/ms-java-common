package com.common.api.constant;

/**
 * The Class CommonConstant.
 */
public class CommonConstant {

    /**
     * The Interface Header.
     */
    public interface Header {

        /** The authorization. */
        public static final String AUTHORIZATION = "Auth";

        /** The correlation id. */
        public static final String CORRELATION_ID = "correlationid";

        /** The basic auth. */
        public static final String BASIC_AUTH = "BasicAuth";
    }

    /**
     * The Interface RequestUrl.
     */
    public interface RequestUrl {

        /** The Constant COUNTRY_URL. */
        public static final String COUNTRY_URL = "/country";

        /** The Constant STATES_URL. */
        public static final String STATES_URL = "/states";

        /** The Constant CITY_URL. */
        public static final String CITY_URL = "/city";

        /** The Constant COUNTRY_NAME_URL. */
        public static final String COUNTRY_NAME_URL = "/country_name";

        /** The Constant STATE_NAME_URL. */
        public static final String STATE_NAME_URL = "/state_name";

        /** The Constant CITY_NAME_URL. */
        public static final String CITY_NAME_URL = "/city_name";
        
        public static final String CITY_URLS = "/city_names";

		public static final String FETCH_LOCATION = "/bulkLocationFetch";


        /**
         * The Interface System.
         */
        public interface System {
            /** The Constant SYSTEM_URL. */
            public static final String SYSTEM_ROOT_CONTEXT_URL = "/system";
            /** The Constant SYSTEM_CAPABILITIES_URL. */
            public static final String SYSTEM_CAPABILITIES_URL = "/capabilities";

            /** The Constant GET_SYSTEM_URL. */
            public static final String SYSTEM_UUID_URL = "/{system_uuid}";
        }
    }


    /**
     * The Interface RequestBody.
     */
    public interface RequestBody {

    }

    /**
     * The Interface PermissionConstant.
     */
    public interface PermissionConstant {

        /** The Constant GET_ALL_STATES. */
        public static final String GET_STATES = "get_states";

        /** The Constant GET_COUNTRIES. */
        public static final String GET_COUNTRIES = "get_countries";

        /** The Constant GET_CITYS. */
        public static final String GET_CITYS = "get_city";

        /** The Constant VIEW_SYSTEM_CAPABILITIES. */
        public static final String VIEW_SYSTEM_CAPABILITIES = "view_system_capabilities";

        /** The Constant REGISTER_SYSTEM. */
        public static final String REGISTER_SYSTEM = "register_system";

        /** The Constant VIEW_SYSTEM. */
        public static final String VIEW_SYSTEM = "view_system";

        /** The Constant DELETE_SYSTEM. */
        public static final String DELETE_SYSTEM = "delete_system";

        /** The Constant UPDATE_SYSTEM. */
        public static final String UPDATE_SYSTEM = "update_system";

    }

    /**
     * The Interface DatabaseConstant.
     */
    public interface DatabaseConstant {

    }

    /**
     * The Interface RequestParam.
     */
    public interface RequestParam {

        /** The Constant COUNTRY. */
        public static final String COUNTRY = "country";

        /** The country code. */
        String COUNTRY_CODE = "country_code";

        /** The Constant UUID. */
        static final String UUID = "uuid";

        /** The Constant CODE. */
        static final String CODE = "code";

        /** The Constant STATE. */
        public static final String STATE = "state";

        /** The Constant STATE_CODE. */
        public static final String STATE_CODE = "state_code";

        /** The Constant CITY_ID. */
        public static final String CITY_ID = "city_id";
        
        public static final String CITY_NAME = "city_name";

    }

    /**
     * The Interface Attributes.
     */
    public interface SystemAttributes {

        /** The Constant SYSTEM_NAME. */
        String SYSTEM_NAME = "system name";
        
        /** The Constant NAME. */
        String NAME = "name";

        /** The Constant SYSTEM_DESCRIPTION. */
        String SYSTEM_DESCRIPTION = "system description";

        /** The Constant SYSTEM_UUID. */
        String SYSTEM_UUID = "system uuid";
        
        /** The system capabilities. */
        String SYSTEM_CAPABILITIES = "capabilities";
        
        
    }


    /**
     * The Interface ValidationConstatnt.
     */
    public interface ValidationConstatnt {
        /** The system name special characters. */
        String SYSTEM_NAME_SPECIAL_CHARACTERS = "[A-Za-z0-9,_,-,]";

        /** The system desc special characters. */
        String SYSTEM_DESC_SPECIAL_CHARACTERS = "[<>]";

        /** The system name length. */
        String SYSTEM_NAME_LENGTH = "100";

        /** The system description length. */
        String SYSTEM_DESCRIPTION_LENGTH = "500";
    }
}
