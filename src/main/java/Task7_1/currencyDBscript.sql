DROP DATABASE IF EXISTS CurrencyConverterDB;
CREATE DATABASE CurrencyConverterDB;
USE CurrencyConverterDB;

CREATE TABLE Currencies (
    id INT NOT NULL AUTO_INCREMENT,
    currencyName VARCHAR(50) NOT NULL,
    abbreviation VARCHAR(50) NOT NULL,
    conversionRate DECIMAL(15,6) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO Currencies (currencyName, abbreviation, conversionRate) VALUES
    ('US Dollar', 'USD', 1.00),
    ('Euro', 'EUR', 0.941434),
    ('British Pound', 'GBP', 0.781589),
    ('Russian Ruble', 'RUB', 89.632194),
    ('Japanese Yen', 'JPY', 149.852447),
    ('Chinese Yuan Renminbi', 'CNY', 7.265366),
    ('Swedish Krona', 'SEK', 10.418393),
    ('Iranian Rial', 'IRR', 42173.524706),
    ('Canadian Dollar', 'CAD', 1.441013);

DROP USER IF EXISTS 'appuser'@'localhost';
CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'currency123';
GRANT SELECT ON currencyconverterdb.* TO 'appuser'@'localhost';