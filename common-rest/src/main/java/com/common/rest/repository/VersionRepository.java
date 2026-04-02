package com.common.rest.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Repository;

import com.cloud.api.common.exception.HealthCheckException;
import com.cloud.api.common.exception.KeyNotFoundException;
import com.cloud.api.common.util.ValidatorUtil;
import com.common.rest.common.HealthCheckProperties;

@Repository
@DependsOn({"dataSource", "authProperties"})
public class VersionRepository {
   private static final Logger _log = LoggerFactory.getLogger(VersionRepository.class);
   private static final String QUERY = "SELECT VersionNumber FROM ";
   @Autowired
   private DataSource dataSource;
   @Autowired
   private HealthCheckProperties healthCheckProperties;

   public String getLatestVersion() throws KeyNotFoundException {
      _log.info("[getLatestVersion] - Start");
      String versionNumber = null;
      Connection connection = null;

      try {
         connection = this.dataSource.getConnection();
         PreparedStatement pstmt = connection.prepareStatement("SELECT version_number FROM " + this.healthCheckProperties.versionTableName + " ORDER BY version_deployment_date DESC");
         ResultSet rs = pstmt.executeQuery();
         if (rs.next()) {
            versionNumber = rs.getString(1);
         }
      } catch (Exception var12) {
         _log.error("[getLatestVersion] Exception: " + var12.getMessage(), var12);
         throw new HealthCheckException(var12.getMessage(), var12);
      } finally {
         if (!ValidatorUtil.isNull(connection)) {
            try {
               connection.close();
            } catch (SQLException var11) {
               _log.error("[getLatestVersion] Exception: " + var11.getMessage(), var11);
            }
         }

      }

      _log.info("[getLatestVersion] - End");
      return versionNumber;
   }
}
