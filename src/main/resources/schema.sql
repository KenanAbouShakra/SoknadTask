
CREATE TABLE Soknad
(
    soknadId INTEGER AUTO_INCREMENT NOT NULL,
    personnr VARCHAR(255) NOT NULL,
    fornavn VARCHAR(255) NOT NULL,
    etternavn VARCHAR(255) NOT NULL,
    tel VARCHAR(255) NOT NULL,
    belop INTEGER NOT NULL,
    soknadstekst TEXT,
    PRIMARY KEY (soknadId)
);