package entities;

import java.sql.Timestamp;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Country.class)
public class Country_ {
	public static volatile SingularAttribute<Country, Integer> countryId;
    public static volatile SingularAttribute<Country, String> country;
    public static volatile SingularAttribute<Country, Timestamp> lastUpdate;
}
