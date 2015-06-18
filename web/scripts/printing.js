function printAttestation(nifParam, taxPayerNoParam){
	window.open('attestation.pdf?nif='+nifParam+'&taxPayerNo='+taxPayerNoParam+'&type=attestation','attestation','location=no, menubar=no, status=no, scrollbars=no');
}

function printFicheRenseignement(nifParam, taxPayerNoParam){
	window.open('renseignement.pdf?nif='+nifParam+'&taxPayerNo='+taxPayerNoParam+'&type=fiche','renseignement','location=no, menubar=no, status=no, scrollbars=no');
}	
