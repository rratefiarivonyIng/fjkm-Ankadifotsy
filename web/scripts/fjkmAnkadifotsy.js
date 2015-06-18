function fjkmAnkadifotsySubmitForm(formName, actionName, printing){
	var form = document.forms[formName];
	form.action = actionName;
	form.method = "post";
	if(typeof ( form.printing ) != "undefined")
		form.printing.value = printing;
	form.submit();
}

function fjkmAnkadifotsyReloadForm(formName, actionName){
	var form = document.forms[formName];
	form.action = actionName;
	form.method = "post";
	form.submitted.value = "false";
	form.submit();
}

function fjkmAnkadifotsyIsNavigatorIE(){
	if (navigator.appName == "Microsoft Internet Explorer") { 
		return true;
	}
	return false;
}

function fjkmAnkadifotsyVerIE(){
	var ieReg = /.*MSIE ([^;]+);.*/i ;
	return parseFloat(navigator.appVersion.replace(ieReg, "$1"));
}

function editTranga(url, title, w,h){
       var left = (screen.width/2)-(w/2);
       var top = (screen.height/2)-(h/2);
	var targetWin = window.open(url, title,'history=no,resizable=no,scrollbars=no,toolbar=no,location=no,width='+w+', height='+h+', top='+top+', left='+left);
	targetWin.focus();
}