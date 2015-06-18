/**
 * AjReq
 * mener des requêtes ajax
 * =============================================================================
 * @author Erwan Lefèvre
 * @copyright Erwan Lefèvre, 2010
 * @license reative Commons - Paternité 2.0 France - http://creativecommons.org/licenses/by/2.0/fr/
 * @version v1.1 - 2010-04-29 
 * @compatible	au 9 avril 2010, compatibilité assurée pour :
 *				Firefox, Internet Explorer 5.5+, Opéra, Safari, Chrome
 * @see			http://www.webbricks.org/bricks/AjReq/
 */

/*
exemple d'utilisation :
-----------------------

// Envoi simple d'une requête, sans se soucier de la réponse

	var data = new AjReq();
	data.send('script.php');
	
// Envoi d'une requête de type post, avec paramètres et interprétation des données retournées

	var data = new AjReq();
	var options = {
		method : 'POST',
		params : var1=val1&var2=val2,
		onSuccess : function () {
			alert(data.back.response); // affiche le résultat de la requête ds un alertbox
		} 
	};
	data.send('script.php',options);
	
// Mise à jour le contenu d'un élément html (innerHTML)

	var data = new AjReq();
	var options = {
		update : document.getElementById('update_me')
		}
	};
	data.send('script.php',options);
	
// Pour récupérer un objet json, il faudra parfois forcer le type mime

	var data = new AjReq();
	var options = {
		forceMime : 'text/json',
		onSuccess : function() { dosomething(); }
		}
	};
	data.send('script.php',options);
	
// Pour la liste des options disponibles, voir AjReq.defSettings
*/





/**
 * transfer
 * =============================================================================
 * retourne un objet contenant les propriétés et méthodes de l'objet /dest/,
 * complétées et/ou écrasées par celles de l'objet /source/
 *
 * @param       source       {object}        l'objet source
 * @param       dest         {object}        l'objet de destination
 * @return      {object}
 *
 */
function transfer (source, dest) {
    var prop;
    var transfered={};
    for ( prop in dest ) { transfered[prop] = dest[prop]; }
    for ( prop in source ) { transfered[prop] = source[prop]; }
    return transfered; 
}





/**
 * AjReq
 * mener des requêtes ajax
 * =============================================================================
 *
 * @requires    transfer		http://sitesweb.abondance.free.fr/copyleft/admin/billet-fiche.php?idBillet=21
 *
 */
var AjReq = function() {

	/** defSettings
	 * 
	 * paramètres par défaut pour la fonction
	 * 
	 * -------------------------------------------------------------------------
	 */
	this.defSettings = {
		async : true, // asynchrone ou non ( true|false )
		encType : "application/x-www-form-urlencoded", // type de contenu
		encoding : "utf-8", // encodage
		forceMime : null, // permet de forcer à interpréter la réponse selon un type mime (notamment si pas de mime retourné)
		method : "GET", // méthode de transmission des données ( 'GET'|'POST'|'HEAD' )
		params : null, // variables transmises par http ( var1=val1&var2=val2 etc.)
		abortAfter : 5000, // délai avant abandon de la requête (en millisecondes)
		onAbort : function () {}, // fonction callback en cas d'abandon de la requête
		onSuccess : function () {}, // fonction callback en cas de succès de la requête
		update : null // élément ou collection d'éléments à mettre à jour en cas de succès (par innerHTML, selon retour "responseText")
	};
	
	/** abort()
	 * 
	 * abandonne la requête en cours
	 * 
	 * @return	void
	 * 
	 * -------------------------------------------------------------------------
	 */
	this.abort = function () {
		this.xhr.abort();
		clearTimeout(this.prog);
		this.options.onAbort();
	};
	
	


	/** getErrorLog()
	 * 
	 * retourne un rapport d'erreurs
	 *
	 * @return	string
	 * 
	 * -------------------------------------------------------------------------
	 */
	this.getErrorLog = function () {
		var report = "URL : \n\t" + this.options.url;
		
		// rappel des options
		var options = this.options;
		report += "\n\nOPTIONS :" ;
		for (var opt in options) {
			if (options.hasOwnProperty(opt)) {
				report += "\n\t" + opt + " : " + (opt!='response'&&opt!='params'?options[opt]:'oui ('+typeof options[opt]+')');
			}
		}
		
		// état du xhr
		var log = this.errorLog;
		report 	+=	"\n\nXHR :" +
					"\n\treadystate : " + log.readyState +
					"\n\tstatut : " + log.status + ' ('+log.statusText+')';
		
		return report;
	};
	
	
	

	/** getXhr()
	 * 
	 * crée et retourne un objet XMLHttpRequest
	 *
	 * @return	XMLHttpRequest
	 * 
	 * -------------------------------------------------------------------------
	 */
	this.getXhr = function () {
		var xhr = null; 
		if (window.XMLHttpRequest) { xhr = new XMLHttpRequest(); } // Navigateurs dignes de ce nom
		else if(window.ActiveXObject){ // Internet Explorer 
			try { xhr = new ActiveXObject("Msxml2.XMLHTTP"); }
			catch (e) { xhr = new ActiveXObject("Microsoft.XMLHTTP"); }
		}
		else { xhr = false; alert("Votre navigateur ne supporte pas les objets XMLHTTPRequest..."); } 
		return xhr ;
	};
	
	
	
	
	/** update()
	 * 
	 * met à jour un ou plusieurs éléments du document, par innerHTML
	 *
	 * @param		mixed		targets			élément html ou collection d'éléments html à mettre à jour (même contenu pour tous)
	 * @param		string		resp			le contenu html à intégrer dans le(s) élément(s)
	 * 
	 * @return		void
	 * 
	 * -------------------------------------------------------------------------
	 */
	this.update = function (targets, resp) {
		if (targets.nodeType==1) { targets = [targets]; } // si un seul élément pour cible, le placer ds un tableau
		var i, max = targets.length;
		for (i=0;i<max;i++) { targets[i].innerHTML = resp; }
	};
	
	
	
	
	/** resetXhr()
	 * 
	 * réinitialise l'objet xhr et son rapport d'erreurs
	 *
	 * @return		void
	 * 
	 * -------------------------------------------------------------------------
	 */		
	this.resetXhr = function () {
		// initialisation du errorLog
		this.errorLog = {
			readyState : false, // avancement de la requête
			status : false, // statut de la requête
			statusText : false // satuts de la requête, sous forme de texte
		};

		// création d'un objet Xhr
		this.xhr = this.getXhr() ;
		
		// se préparer à recevoir les données
		this.back = {
			contentType : null,
			response : null
		};
	};
	
	
	
	/** send()
	 * 
	 * traitement d'une requête ajax
	 *
	 * @param		String		url			url du fichier interrogé
	 * @param		Object		options		tableau de paramètres optionnels (voir this.defSettings)
	 * @return		void
	 * 
	 * -------------------------------------------------------------------------
	 */		
	this.send = function (url, options) {

	// (ré)initialisation
		this.resetXhr();
		
	// lecture des paramètres
		this.options = this.errorLog.options = options = transfer(options, this.defSettings);
		this.options.url = url;
	
	// pour les fonctions imbriquées
		var self = this;
	
	// réactions aux réponses du serveur
		this.xhr.onreadystatechange = function () {
			
			// relevé de l'état de la requête
				// gestion différenciée selon navigateur
				var ieVer = (navigator.appName == "Microsoft Internet Explorer") ? parseFloat(navigator.appVersion.replace(/.*MSIE ([^;]+);.*/i, "$1")) : null;
				var min = !ieVer ? (window.opera?3:0) : (ieVer<8?4:3);
				// relevé
				self.errorLog = {
					readyState : this.readyState,
					status : this.readyState>=min ? this.status : null,
					statusText : this.readyState>=min ? this.statusText : null
				};

			// une fois réponse obtenue
			if (self.xhr.readyState===4) {
				// abandon de l'abandon programmé de la requête
				clearTimeout(self.prog);
				
				// chargement de la réponse
				self.back.contentType = (options.forceMime || self.xhr.getResponseHeader("Content-Type")) || "text/plain";
				if (self.back.contentType.indexOf("text/xml")>=0) { self.back.response = self.xhr.responseXML ; }
				else if (self.back.contentType.indexOf("text/json")>=0) { self.back.response = eval('(' + self.xhr.responseText + ')'); }
				else { self.back.response = self.xhr.responseText ; }
				
				// mises à jour automatiques (optionnel)
				var update = options.update;
				if (update) { self.update(update, self.back.response); }
				
				// callback (optionnel)
				options.onSuccess() ;
			}
		};
		
	
	// lancement de la requête
		// préparation des paramètres de query
		if ( options.method !== 'GET' ) { 
			var parts = url.split('?');
			url = parts[0] ;
			options.params = parts[1] ? options.params + parts[1] : options.params ;
		}
		else if (options.params) { url += '?' + options.params; } // mais normalement, en GET, ont met directement les param dans l'url
		
		// envoi
		this.xhr.open( options.method , url , options.async ) ;
		if ( options.method === 'POST' ) { this.xhr.setRequestHeader( "Content-Type" , options.encType ) ; }
		this.xhr.send(options.params) ;
				
		// programmation de l'abandon de la requête
		if (options.abortAfter) {
			this.prog = setTimeout(
				function(){self.abort();},
				options.abortAfter
			);
		}
	};
};