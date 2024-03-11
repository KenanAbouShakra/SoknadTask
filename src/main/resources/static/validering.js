function validerPersonnr(){
    const personnr = $("#personnr").val();
    const regexp = /^[0-9]{11}$/;
    const ok = regexp.test(personnr);
    if(!ok){
        $("#feilPersonnummer").html("Personnummeret må bestå av 11 siffer");
        return false;
    }
    else{
        $("#feilPersonnummer").html("");
        return true;
    }
}

function validerFornavn(){
    const fornavn = $("#fornavn").val();
    const regexp = /^[a-zA-ZæøåÆØÅ. \-]{2,20}$/;
    const ok = regexp.test(fornavn);
    if(!ok){
        $("#feilFornavn").html("" +
            "Fornavnet må bestå av 2 til 20 bokstaver");
        return false;
    }
    else{
        $("#feilFornavn").html("");
        return true;}
}
function validerEtternavn(){
    const etternavn = $("#etternavn").val();
    const regexp = /^[a-zA-ZæøåÆØÅ. \-]{2,20}$/;
    const ok = regexp.test(etternavn);
    if(!ok){
        $("#feilEtternavn").html("" +
            "Etternavnet må bestå av 2 til 20 bokstaver");
        return false;
    }
    else{
        $("#feilEtternavn").html("");
        return true;}
}

function validerBelop(){
    const belop = $("#belop").val();
    const regexp = /^[0-9]{4,7}$/;
    const ok = regexp.test(belop);
    if(!ok){
        $("#feilBelop").html("Belopet må ha tall mellom 10^3, 9999999");
        return false;
    }
    else{
        $("#feilBelop").html("");
        return true;}
}
function validerSoknadstekst() {
    const soknadstekst = $("#soknadstekst").val();
    // Splitter teksten inn i ord basert på mellomrom, og filtrerer ut tomme strenger for å unngå å telle "falske" ord
    const ord = soknadstekst.split(/\s+/).filter(function(n) { return n !== ''; });
    const antallOrd = ord.length;

    // Sjekker om antallet ord er mellom 0 og 500
    if (antallOrd > 500) {
        $("#feilSoknadstekst").html("Søknadsteksten må bestå av mellom 0 og 500 ord");
        return false;
    } else {
        $("#feilSoknadstekst").html("");
        return true;
    }
}

function validerTel(){
    const tel = $("#tel").val();
    const regexp = /^[0-9]{8}$/;
    const ok = regexp.test(tel);
    if(!ok){
        $("#feilTel").html("telefonnummeret må bestå av 8 siffer");
        return false;
    }
    else{
        $("#feilTel").html("");
        return true;
    }
}
function ingenValideringsFeil(){
    return ( validerPersonnr() && validerFornavn() && validerEtternavn() && validerTel()&& validerBelop() && validerSoknadstekst());
}

