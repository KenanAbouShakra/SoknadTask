$(function(){
    henteEnSoknad();
});
function henteEnSoknad(){
    const soknadId=window.location.search.substring(1); // kommer fra kallet i index.js
    const url = "/henteEnSoknad?soknadId="+soknadId;
    $.get( url, function(enSoknad) {
        // overfør til input-feltene i skjemaet
        $("#soknadId").val(enSoknad.soknadId)
        $("#personnr").val(enSoknad.personnr);
        $("#fornavn").val(enSoknad.fornavn);
        $("#etternavn").val(enSoknad.etternavn);
        $("#tel").val(enSoknad.tel);
        $("#belop").val(enSoknad.belop);
        $("#soknadstekst").val(enSoknad.soknadstekst);
    })
        .fail(function(jqXHR) {
            const json = $.parseJSON(jqXHR.responseText);
            $("#feil").html(json.message);
        });
}

function endreSoknad() {
    const soknaden={
        soknadId : $("#soknadId").val(),
        personnr : $("#personnr").val(),
        fornavn : $("#fornavn").val(),
        etternavn : $("#etternavn").val(),
        tel : $("#tel").val(),
        belop : $("#belop").val(),
        soknadstekst : $("#soknadstekst").val(),
    };

    if(ingenValideringsFeil()){
        $.post("/endre", soknaden, function(){
            window.location.href="/"
        })
            .fail(function(jqXHR) {
            const json = $.parseJSON(jqXHR.responseText);
            $("#feil").html(json.message);
        });


    }
}


