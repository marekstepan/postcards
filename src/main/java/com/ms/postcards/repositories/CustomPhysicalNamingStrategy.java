package com.ms.postcards.repositories;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.stereotype.Repository;

@Repository
public class CustomPhysicalNamingStrategy extends PhysicalNamingStrategyStandardImpl {

  private static final String postfix = "s";

  @Override
  public Identifier toPhysicalTableName(final Identifier identifier, final JdbcEnvironment jdbcEnv) {
    if (identifier == null) {
      return null;
    }

    final String newName = identifier.getText().toLowerCase() + postfix;
    return Identifier.toIdentifier(newName);
  }
}
