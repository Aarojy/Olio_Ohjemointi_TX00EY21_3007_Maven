-- 1. A query that retrieves all the currencies from the database.
SELECT * FROM currencyconverterdb.currencies;

-- 2. A query that retrieves the currency with the abbreviation EUR (or other abbreviation, if you don't have EUR in your database).
SELECT * FROM currencyconverterdb.currencies WHERE abbreviation = 'EUR';

-- 3. A query that retrieves the number of currencies in the database.
SELECT COUNT(currencyName) FROM currencyconverterdb.currencies;

-- 4. A query that retrieves the currency with the highest exchange rate.
SELECT * FROM currencyconverterdb.currencies
WHERE conversionRate = (SELECT MAX(conversionRate) FROM currencyconverterdb.currencies);