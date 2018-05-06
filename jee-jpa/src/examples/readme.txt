#1
String innerJoinQuery="select a.countryId, a.country, b.cityId from Country a inner join City b on a.countryId=b.country where a.countryId=:country_id";
>>Can't use ON operator if the relationship is already defined on the entity object. The ORM already knows how two entities are linked together using the mapping of the association.
so the syntaxically correct query is:
select a.countryId, a.country, b.cityId from Country a inner join City b where a.countryId=:country_id;

#2
String innerJoinQuery="select a.countryId, a.country, b.city from Country a join city b where a.countryId=:country_id";
>> wrong syntax error: can't use "... join city", it must be "...join a.cities"

