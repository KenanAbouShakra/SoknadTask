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
function validerSoknadstekst(){
    const soknadstekst = $("#soknadstekst").val();
    const regexp = /^[0-9a-zA-ZæøåÆØÅ. \-]{0,10000}$/;
    const ok = regexp.test(soknadstekst);
    if(!ok){
        $("#feilSoknadstekst").html("Søknadsteksten må bestå av 0 til 10000 bokstaver og tall");
        return false;
    }
    else{
        $("#feilSoknadstekst").html("");
        return true;}
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

