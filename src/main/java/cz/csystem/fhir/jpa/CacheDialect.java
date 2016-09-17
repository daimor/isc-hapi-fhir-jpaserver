package cz.csystem.fhir.jpa;

import java.sql.Types;
import org.hibernate.dialect.Cache71Dialect;
import org.hibernate.hql.spi.id.IdTableSupportStandardImpl;
import org.hibernate.hql.spi.id.MultiTableBulkIdStrategy;
import org.hibernate.hql.spi.id.local.AfterUseAction;
import org.hibernate.hql.spi.id.local.LocalTemporaryTableBulkIdStrategy;

public class CacheDialect extends Cache71Dialect {

    public CacheDialect() {
        super();
        this.registerColumnType(Types.BOOLEAN, "bit");
    }

    @Override
    public MultiTableBulkIdStrategy getDefaultMultiTableBulkIdStrategy() {
        return new LocalTemporaryTableBulkIdStrategy(
            new IdTableSupportStandardImpl() {
                @Override
                public String generateIdTableName(String baseName) {
                    final String name = super.generateIdTableName( baseName );
                    return name.length() > 25 ? name.substring( 1, 25 ) : name;
                }

                @Override
                public String getCreateIdTableCommand() {
                    return "create global temporary table";
                }
            },
            AfterUseAction.DROP,
            null
        );

    }

}
