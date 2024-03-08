
$(function(){  // kjøres når dokumentet er ferdig lastet
    hentAlle();
});

function hentAlle() {

    const url = "/hentAlle";
    $.get( url, function( soknader) {
        formaterData(soknader);
    })
        .fail(function(jqXHR) {
            const json = $.parseJSON(jqXHR.responseText);
            $("#feil").html(json.message);
        });
}

function formaterData(soknader) {
    let ut = "<table class='table table-striped'><tr><th>Personnr</th><th>Fornavn</th><th>Etternavn</th><th>Telfonnr</th><th>Beløpet</th>" +
        "<th>Søknadstekst</th><th></th><th></th></tr>";
    for (const soknad of soknader) {
        ut += "<tr><td>" + soknad.personnr + "</td><td>" + soknad.fornavn + "</td><td>" + soknad.etternavn + "</td><td>" + soknad.tel + "</td><td>" + soknad.belop+ "</td>" +
            "<td>" + soknad.soknadstekst +"</td>" +
            "<td> <button class='btn btn-primary' onclick='idTilEndring("+soknad.soknadId+")'>Endre</button></td>"+
            "<td> <button class='btn btn-danger' onclick='slettEnSoknad("+soknad.soknadId+")'>Slett</button></td>"+
            "</tr>";
    }
    ut += "</table>";
    $("#soknadene").html(ut);
}

function idTilEndring(soknadId) {
    window.location.href = "/endre.html?"+soknadId;
}

function slettEnSoknad(soknadId) {
    const url = "/slettEnSoknad?soknadId="+soknadId;
    $.get( url, function() {
        window.location.href = "/";
    });
}

function slettAlle() {

    const url = "/slettAlle";
    $.get( url, function() {
        hentAlle();
    });
}
