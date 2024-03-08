package com.example.soknadtask;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class SoknadTaskRepository {

    @Autowired
    private JdbcTemplate db;
    private Logger logger = LoggerFactory.getLogger(SoknadTaskRepository.class);
    public boolean lagreSoknad(Soknad s) {
        String sql = "INSERT INTO Soknad ( personnr,fornavn, etternavn,tel, belop, soknadstekst) VALUES(?,?,?,?,?,?)";
        try{
            db.update(sql, s.getPersonnr(),s.getFornavn(),s.getEtternavn(),s.getTel() , s.getBelop(), s.getSoknadstekst());
            return true;
        }
        catch(Exception e){
            logger.error("Feil i lagre motorvogn "+e);
            return false;
        }
    }

    public List<Soknad> hentAlleSoknader() {
        String sql = "SELECT * FROM Soknad ";
        try{
            return db.query(sql,new BeanPropertyRowMapper(Soknad.class));
        }
        catch(Exception e){
            logger.error("Feil i hent alle søknader "+e);
            return null;
        }
    }

    public Soknad henteEnSoknad(int soknadId){
        String sql = "SELECT * FROM Soknad WHERE soknadId=?";
        try{
            List<Soknad> enSoknad  = db.query(sql,new BeanPropertyRowMapper(Soknad.class),soknadId);
            return enSoknad.get(0);
        }
        catch(Exception e){
            logger.error("Feil i hent en søknad "+e);
            return null;
        }
    }

    public boolean endreSoknad(Soknad s){
        String sql = "UPDATE Soknad SET  personnr=?, fornavn=?,etternavn=?, tel=?, belop=?, soknadstekst=? WHERE soknadId=?";
        try{
            db.update(sql, s.getSoknadId(), s.getPersonnr(),s.getFornavn(),s.getEtternavn(), s.getTel() ,s.getBelop(),s.getSoknadstekst());
            return true;
        }
        catch(Exception e){
            logger.error("Feil i endre en søknad "+e);
            return false;
        }
    }

    public boolean slettEnSoknad(int soknadId) {
        String sql = "DELETE FROM Soknad WHERE soknadId=?";
        try{
            db.update(sql,soknadId);
            return true;
        }
        catch(Exception e){
            logger.error("Feil i slett en søknad"+e);
            return false;
        }
    }
    public boolean slettSoknader () {
        String sql = "DELETE FROM Soknad ";
        try{
            db.update(sql);
            return true;
        }
        catch(Exception e){
            logger.error("Feil i slett alle søknader"+e);
            return false;
        }
    }
}
