package com.example.soknadtask;

import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class SoknadTaskController {

    @Autowired
    private SoknadTaskRepository rep;

    private Logger logger = LoggerFactory.getLogger(SoknadTaskController.class);

    // Lagrer ny søknad
    @PostMapping("/lagre")
    public void lagreSoknad(Soknad soknad, HttpServletResponse response) throws IOException {
        if (validerSoknadOK(soknad)) {
            boolean resultat = rep.lagreSoknad(soknad);
            if (!resultat) {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Feil ved lagring av søknad i databasen.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Valideringsfeil for søknaden.");
        }
    }

    // Henter alle søknader
    @GetMapping("/hentAlle")
    public List<Soknad> hentAlleSoknader(HttpServletResponse response) throws IOException {
        List<Soknad> alleSoknader = rep.hentAlleSoknader();
        if (alleSoknader == null) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Feil ved henting av søknader fra databasen.");
            return null;
        }
        return alleSoknader;
    }

    // Henter en spesifikk søknad
    @GetMapping("/henteEnSoknad")
    public Soknad henteEnSoknad(int soknadId, HttpServletResponse response) throws IOException {
        Soknad enSoknad = rep.henteEnSoknad(soknadId);
        if (enSoknad == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Søknad med ID " + soknadId + " ble ikke funnet.");
            return null;
        }
        return enSoknad;
    }

    // Oppdaterer en eksisterende søknad
    @PostMapping("/endre")
    public void endreSoknad(Soknad soknad, HttpServletResponse response) throws IOException {
        if (validerSoknadOK(soknad)) {
            boolean resultat = rep.endreSoknad(soknad);
            if (!resultat) {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Feil ved oppdatering av søknad i databasen.");
            }
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Valideringsfeil for søknaden.");
        }
    }

    // Sletter en spesifikk søknad
    @GetMapping("/slettEnSoknad")
    public void slettEnSoknad(int soknadId, HttpServletResponse response) throws IOException {
        boolean resultat = rep.slettEnSoknad(soknadId);
        if (!resultat) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Feil ved sletting av søknad fra databasen.");
        }
    }

    // Sletter alle søknader
    @GetMapping("/slettAlle")
    public void slettAlleSoknader(HttpServletResponse response) throws IOException {
        boolean resultat = rep.slettSoknader();
        if (!resultat) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Feil ved sletting av alle søknader fra databasen.");
        }
    }

    // Validerer søknadsdata
    private boolean validerSoknadOK(Soknad soknad){
        // Regex for validering
        String regexPersonnr = "[0-9]{11}";
        String regexforNavn = "[a-zA-ZæøåÆØÅ. \\-]{2,20}";
        String regexEtternavn = "[a-zA-ZæøåÆØÅ. \\-]{2,20}";
        String regexTel = "[0-9]{8}";
        String regexBelop = "[0-9]{4,7}";

        // Validering av hvert felt
        boolean personnrOK = soknad.getPersonnr().matches(regexPersonnr);
        boolean fornavnOK = soknad.getFornavn().matches(regexforNavn);
        boolean etternavnOK = soknad.getEtternavn().matches(regexEtternavn);
        boolean belopOK = String.valueOf(soknad.getBelop()).matches(regexBelop);
        boolean telOK = soknad.getTel().matches(regexTel);

        return personnrOK && fornavnOK && etternavnOK && telOK && belopOK ;
    }

}
