

function regSoknad() {
    const soknad = {
        personnr : $("#personnr").val(),
        fornavn : $("#fornavn").val(),
        etternavn : $("#etternavn").val(),
        tel : $("#tel").val(),
        belop : $("#belop").val(),
        soknadstekst : $("#soknadstekst").val(),
    };

    if(ingenValideringsFeil()){
        alert("Søknaden er motatt")
        $.post("/lagre", soknad, function(){
            hentAlle();
        });

        window.location.href="index.html";
    }
}


