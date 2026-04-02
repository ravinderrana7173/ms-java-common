package com.common.rest.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Map;

@JsonInclude(Include.NON_NULL)
@JsonPropertyOrder({"state", "migrations_versions"})
@JsonIgnoreProperties(
   ignoreUnknown = true
)
public class DatabaseDetails {
   private String state;
   @JsonProperty("migrations_versions")
   private Map<String, String> migrationsversions;

   public String getState() {
      return this.state;
   }

   public void setState(final String state) {
      this.state = state;
   }

   public Map<String, String> getMigrationsversions() {
      return this.migrationsversions;
   }

   public void setMigrationsversions(final Map<String, String> migrationsversions) {
      this.migrationsversions = migrationsversions;
   }
}
