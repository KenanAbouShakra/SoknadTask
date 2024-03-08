package com.example.soknadtask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class SoknadTaskController {


        @Autowired
        private SoknadTaskRepository rep;

        private Logger logger = LoggerFactory.getLogger(SoknadTaskController.class);

        @PostMapping("/lagre")
        public boolean lagreSoknad(Soknad soknad) {
            if(validerSoknadOK(soknad)){
                return rep.lagreSoknad(soknad);
            } else {
                logger.error("Valideringsfeil -prøv igjen senere");
                return false;
            }
        }

        @GetMapping("/hentAlle")
        public List<Soknad> hentAlleSoknader() {
            List<Soknad> alleSoknader = rep.hentAlleSoknader();
            if(alleSoknader == null){
                logger.error("Feil i DB -prøv igjen senere");
            }
            return alleSoknader;
        }

        @GetMapping("/henteEnSoknad")
        public Soknad henteEnSoknad(int soknadId) {
            Soknad enSoknad = rep.henteEnSoknad(soknadId);
            if(enSoknad == null){
                logger.error("Feil i DB -prøv igjen senere");
            }
            return enSoknad;
        }

        @PostMapping("/endre")
        public boolean endre(Soknad soknad) {
            if(validerSoknadOK(soknad)){
                return rep.endreSoknad(soknad);
            } else {
                logger.error("Valideringsfeil -prøv igjen senere");
                return false;
            }
        }

        @GetMapping("/slettEnSoknad")
        public boolean slettEnSoknad(int soknadId) {
            return rep.slettEnSoknad(soknadId);
        }

        @GetMapping("/slettAlle")
        public boolean slettAlleSoknader() {
            return rep.slettSoknader();
        }

        private boolean validerSoknadOK(Soknad soknad){
            String regexPersonnr = "[0-9]{11}";
            String regexforNavn = "[a-zA-ZæøåÆØÅ. \\-]{2,20}";
            String regexEtternavn = "[a-zA-ZæøåÆØÅ. \\-]{2,20}";
            String regexTel = "[0-9]{8}";
            String regexBelop = "[0-9]{4,7}";
            String regexSoknadstekst = "[0-9a-zA-ZæøåÆØÅ. \\-]{0,10000}";
            boolean personnrOK = soknad.getPersonnr().matches(regexPersonnr);
            boolean fornavnOK = soknad.getFornavn().matches(regexforNavn);
            boolean etternavnOK = soknad.getEtternavn().matches(regexEtternavn);
            boolean belopOK = String.valueOf(soknad.getBelop()).matches(regexBelop);
            boolean telOK = soknad.getTel().matches(regexTel);
            boolean soknadtekstOK = soknad.getSoknadstekst().matches(regexSoknadstekst);

            return personnrOK && fornavnOK && etternavnOK && telOK && belopOK && soknadtekstOK;
        }


}
