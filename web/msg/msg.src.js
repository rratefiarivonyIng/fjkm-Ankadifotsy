/**
 *
 * @author      Erwan Lefèvre <erwan.lefevre@aposte.net>
 * @copyright   Erwan Lefèvre 2009
 * @license     Creative Commons - Paternité 2.0 France - http://creativecommons.org/licenses/by/2.0/fr/
 * @version     2.1
 * @see			http://www.webbricks.org/bricks/msg/
 * 
 */

/**
 * @class       msg
 * =============================================================================================
 * 
 * affichage de message d'interface
 * @author      Erwan Lefèvre <erwan.lefevre@aposte.net>
 * @compatible	au 20 octobre 2009, compatibilité assurée pour :
 *				Firefox 1.5+, Internet Explorer 5.5+, Opéra 10, Safari 3.2.3. 
 *				Autres versions et navigateurs non testés
 * 
 */
 
/**
 * mise à jour
 * 2009-11-15 : ajout de l'option "remember"
 * 2009-11-15 : révision du design, et ouverture de la marge de manoeuvre des skins css
 * 2009-10-20 : amélioration de la div modale (n'est plus le parent de la boîte de message + options de couleur et d'opacité)
 * 2009-10-19 : dans la feuille de styles css, absorbsion du style .notice par le style standard .msgBox
 * 2009-10-15 : révision du positionnement
 * 2009-10-16 : remise en place des contenus mis à jour par ajax
 */
 
/**
 * améliorations à apporter :
 *     -   positionnement : gérer les valeurs en "em" et "%"
 */
  
var msg = ({
	
	/* quelques variables à initialiser 
	-------------------------------------------------------------------------------------------- */
	// variables publiques
	"def" : { // paramètres par défaut
		"className" : null, // classe css à attribuer au message d'interface (\0|error|success)
		"style" : {}, // styles css à donner à la boîte (description javascript)
		"delay" : 0, // int delay : délai (secondes) avt fermeture auto (0 = pas de fermeture auto) 
		"modal" : false, // bolean modal : mettre un écran bloquant l'accès au reste de la page
		"modalColor" : '#fff', // string modalColor : la courleur de l'écran modal
		"modalOpacity" : 0.7, // float modalOpacity : l'opacité de l'écran modal (de 0 à 1)
		"title" : null, // string title : titre de la boîte de message (vide = pas de titre)
		"context" : null, // string context : code html autour du message $msg$ (vide = pas de contexte) (intéressant surtout pour les réglages enregistrables)
		"button" : "ok", // string button : ce qui est écrit sur le bouton de fermeture (vide = pas de bouton)
		"positon" : null, // string position : position de la boîte de message dans la fenêtre, sous la forme horizontale:verticale. Voir les valeurs acceptés dans la doc de msg.setPosition()
		"onOpen" : null, // callback onOpen : fonction exécutée à l'ouverture du message
		"onClose" : null, // callback onClose : fonction exécutée à la fermeture du message
		"ieMaxWidth" : 400, // integer ieMaxWidth : pour forcer ie<7 à traiter la propriété css maxWidth. Donner une valeur en px
		"ajaxContent" : null, // string ajaxContent : l'adresse url pour une requête ajax dont la réponse viendra remplacer le contenu du message
		"ajaxAbortDelay" : 20, // integer ajaxAbortDelay : délai (en secondes) avant abandon d'une requête ajax
		"remember" : true, // boolean remember : indique s'il faut mémoriser le message et ses options, pour un éventuel réaffichage ultérieur
		"faitesmoipaschieraveclesvirgules" : null
	},
	
	// variables privées
	"closeMsgIn" : null, // dans combien de temps fermera le message
	"msgContentRec" : "Pas de message", // enregistrement du dernier message (initialisation avec une valeur par défaut)
	"msgOptionsRec" : {"position":false}, // enregistrement des dernières options utilisées
	"presets" : {}, // préréglages (doivent être enregistrés via la méthode "msg.preset()")
	
	// constantes
	"modalId" : "modalObj", // IE<8 n'accepte pas que l'id de mon écran corresponde à un nom de variable
	
	
	/** ieVer() 
	 * --------------------------------------------------------------------------------------------
	 * attribue le n° de version d'IE (ou null) à la variable this.ie
	 * 
	 * @return		float				le n° de version de IE, ou null
	 * @access		private
	 *
	 */     
	"ieVer" : function() {
		if (navigator.appName == "Microsoft Internet Explorer") { 
			var ieReg = /.*MSIE ([^;]+);.*/i ;
			msg.ie = parseFloat(navigator.appVersion.replace(ieReg, "$1"));
		}
		else { msg.ie = null ; }
	},
		
	
	/** mousePos() 
	 * --------------------------------------------------------------------------------------------
	 * relève la position de la souris
	 *
	 * @return		void
	 * @access		private
	 * @param		event		event		l'événement auquel on attribue cette f°
	 *
	 */       
    "mousePos" : function (event) {
        if (!msg.ie) { // Si on est pas sous IE
			msg.mouseX = event.pageX;
			msg.mouseY = event.pageY;
		}
		else if (msg.ie<8) {
			msg.mouseX = event.x+document.documentElement.scrollLeft;
			msg.mouseY = event.y+document.documentElement.scrollTop;
		}
		else {
			msg.mouseX = event.x+document.body.scrollLeft;
			msg.mouseY = event.y+document.body.scrollTop;
		}
    },
	
	
	/** getCoords() 
	 * --------------------------------------------------------------------------------------------
	 * détermine la valeurs de différentes coordonnées, en f° du navigateur
	 *
	 * @return		void
	 * @access		private
	 *
	 */
	"getCoords" : function () {
		this.coords = {} ;
		if ( !this.ie ) {
		    //RIJA alert(' getCoords 1 : !this.ie');
			this.coords.posX = window.pageXOffset;
			this.coords.posY = window.pageYOffset;
			this.coords.visibleW = window.innerWidth;
			this.coords.visibleH = window.innerHeight;
		}
		else if (this.ie>6) {
		    //RIJA alert(' getCoords 2 : this.ie >= 6');
		    if (this.ie < 8){
		    	//RIJA alert(' getCoords 4 : this.ie < 8');
				this.coords.posX = document.documentElement.scrollLeft;
				this.coords.posY = document.documentElement.scrollTop;
				this.coords.visibleW = document.documentElement.clientWidth;
				this.coords.visibleH = document.documentElement.clientHeight;
			}
			else{
		    	//RIJA alert(' getCoords 5 : this.ie < 8');
				this.coords.posX = document.body.scrollLeft;
				this.coords.posY = document.body.scrollTop;
				this.coords.visibleW = document.body.clientWidth;
				this.coords.visibleH = document.body.clientHeight;
			}
		}
		else {
		    //RIJA alert(' getCoords 3 : else ');
			this.coords.posX = document.body.scrollLeft;
			this.coords.posY = document.body.scrollTop;
			this.coords.visibleW = document.body.clientWidth;
			this.coords.visibleH = document.body.clientHeight;
		}
	},
	
	
	/** setPosition() 
	 * --------------------------------------------------------------------------------------------
	 * positionne la boîte de message au centre de la fenêtre
	 *
	 * @return		void
	 * @access		private
	 * @param		boolean		delayed		indique si le positionnement a déjà été reporté
	 * @param		string		pos			positionnement du message : 
	 *											accepte des valeurs sous forme "horizontale:verticale" (l'un et/ou l'autre pouvant être ignorés)
	 *												les valeurs verticale peuvent être :
	 *													- un nombre de pixels positif : positionne par rapport au haut de l'écran
	 *													- un nombre de pixels négatif : positionne par rapport au bas de l'écran
	 *												- mouse : positionne à la position verticale de la souris (en faisant en sorte que ça ne déborde pas de l'écran)
	 *													- m ou tout autre valeur : positionne au milieu de l'écran
	 *												les valeurs horizontale peuvent être :
	 *													- un nombre de pixels positif : positionne par rapport à la gauche de l'écran
	 *													- un nombre de pixels négatif : positionne par rapport à la droite de l'écran
	 *													- mouse : positionne à la position horizontale de la souris (en faisant en sorte que ça ne déborde pas de l'écran)
	 *													- c ou tout autre valeur : positionne au centre de l'écran
	 *
	 */
	"setPosition" : function (pos, delayed) {
	    //RIJA alert('setPosition pos :'+pos +', delayed '+delayed); => undefined, undefined
		var msgBoxObj = document.getElementById('msgBox');
		
		if ( msgBoxObj ) { // seulement si un message est ouvert
			
			// pour les positionnement relatifs à la souris, renouveler le positionnement 0.1 sec plus tard, 
			//    afin que l'utilisateur ait le temps de finir le déplacement de sa souris
			if (!delayed) 
			{
			  //RIJA alert('setPosition if (!delayed) :'+ (!delayed));  => true
			  setTimeout(function(){msg.setPosition(pos,true);},100); 
			}
			
			// relever des différentes coordonnées de la fenêtre
			this.getCoords();
			
			// séparer les coordonnées horiz et vert
			var coords = pos ? pos : ':' ;
			coords = coords.split(/:/);
			if (typeof(coords[1])=='undefined')
			{coords[1]='';}
			
			var X = coords[0],
				Y = coords[1],
				px = /^-?[0-9]+(px)?$/i,
				negative ;
			//RIJA alert('X: '+X+', Y: '+Y); => undefined , undefined (2fois)
			// postionner à l'horizontale
				// position relative à la souris
				if (X==='mouse') {
				    //RIJA alert('1 : (X===mouse)');
					// position relative à la souris
					var bordDroit = msg.mouseX + msgBoxObj.offsetWidth + 10 ;
					msgBoxObj.style.left = ( (bordDroit>this.coords.visibleW) ? msg.mouseX - (bordDroit - this.coords.visibleW) -10 : msg.mouseX + 10) + "px";
				}	
				// valeurs en pixels
				else if ( px.test(X) ) {
				    //RIJA alert('2 : (px.test(X))');
					negative = /-/.test(X) ;
					X = parseInt(X,10); // pour avoir un nombre plutôt qu'un chaîne
					if (negative) 
					{ 
					  //RIJA alert('3 : negative ');
					  msgBoxObj.style.right = ( Math.abs(X) - this.coords.posX ) + 'px'; 
					} // positionnement par rapport à la droite
					else 
					{ 
					  //RIJA alert('4 : negative ');
					  msgBoxObj.style.left = ( this.coords.posX + X) + 'px'; 
					} // positionnement par rapport à la gauche
				}
				// au centre (par défaut)
				else 
				{ 
				  //RIJA alert('5 : (px.test(X))');
				  //RIJA alert('this.coords.visibleW : '+this.coords.visibleW+', msgBoxObj.offsetWidth :'+msgBoxObj.offsetWidth+', this.coords.posX :'+this.coords.posX);
				  msgBoxObj.style.left = (this.coords.visibleW - msgBoxObj.offsetWidth)/2 + this.coords.posX + "px"; 
				  //RIJA alert('(this.coords.visibleW - msgBoxObj.offsetWidth)/2 + this.coords.posX + "px" => '+msgBoxObj.style.left);
				}
			
			// postionner à la verticale
				// position relative à la souris
				if (Y==='mouse') {
				    //RIJA alert('6 : Y===mouse');
					var auDessus = msg.mouseY - (msgBoxObj.offsetHeight + 5);
					msgBoxObj.style.top = ( (auDessus<this.coords.posY) ? msg.mouseY + 10 : auDessus) + "px";
				}
				else if ( px.test(Y) ) {
				    //RIJA alert('7 : px.test(Y)');
					negative = /-/.test(Y) ; 
					Y = parseInt(Y,10); // pour avoir un nombre plutôt qu'un chaîne
					if (negative) 
					{ 
					  //RIJA alert('8 : negative');
					  msgBoxObj.style.bottom = ( Math.abs(Y) - this.coords.posY ) + 'px'; 
					} // positionnement par au haut
					else 
					{ 
					  //RIJA alert('9 : negative');
					  msgBoxObj.style.top = ( this.coords.posY + Y ) + 'px'; 
					} // positionnement par rapport au bas
				}
				// milieu (par défaut)
				else 
				{ 
				  //RIJA alert('10 : px.test(Y)');
				  //RIJA alert('this.coords.visibleH : '+this.coords.visibleH+', msgBoxObj.offsetHeight :'+msgBoxObj.offsetHeight+', this.coords.posY :'+this.coords.posY);
				  msgBoxObj.style.top = (this.coords.visibleH - msgBoxObj.offsetHeight)/2 + this.coords.posY + "px"; 
				  //RIJA alert('(this.coords.visibleH - msgBoxObj.offsetHeight)/2 + this.coords.posY + "px" => '+msgBoxObj.style.top);
				}
		}
	},
	
	
	/** autoSetPosition() 
	 * --------------------------------------------------------------------------------------------
	 * appliquer la fonction msg.setPosition() aux événements de redimentionnement et de scrolling de la fen^rtre
	 *
	 * @return		void
	 * @access		private
	 *
	 */
	"autoSetPosition" : function () {
		if (window.attachEvent) { // pour IE
			window.attachEvent('onresize', function () {msg.setPosition(msg.msgOptionsRec.position);});
			window.attachEvent('onscroll', function () {msg.setPosition(msg.msgOptionsRec.position);});
		}
		else { // pour les autres
			window.addEventListener('resize', function () {msg.setPosition(msg.msgOptionsRec.position);}, false);
			window.addEventListener('scroll', function () {msg.setPosition(msg.msgOptionsRec.position);}, false);
		}
	},
	
	
	/** transfer() 
	 * --------------------------------------------------------------------------------------------
	 * copie des propriétés et méthodes de l'objet A dans l'objet B
	 *
	 * @param		object		A		l'objet source
	 * @param		object		B		l'objet de destination
	 * @return		void
	 * @access		private
	 *
	 */
	"transfer" : function (A, B) {
		if (typeof(A)=='object' && typeof(B)=='object') {
			var prop = null;
			for ( prop in A ) { B[prop] = A[prop]; }
		}
	},
	
	
	/** checkOptions() 
	 * --------------------------------------------------------------------------------------------
	 * vérifie la syntaxe des options, et retourne des options corrigées
	 *
	 * @param		object		options			Les options de la boîte de message (optionnel)
	 * @return		object						Les mêmes options, mais sans erreurs de syntaxe
	 *
	 */
	"checkOptions" : function (options) {
		if (!options) { options={}; }
		if (!options.modalOpacity && options.modalOpacity!==0) { delete options.modalOpacity; }
		if (options.modalOpacity) {
			if (options.modalOpacity<0) { options.modalOpacity=0; }
			else if (options.modalOpacity>1) { options.modalOpacity=1; }
		}
		
		return options;
	},
	
	
	/** checkContent() 
	 * --------------------------------------------------------------------------------------------
	 * vérifie la syntaxe des options, et retourne des options corrigées
	 *
	 * @param		mixed		msgContent		le message à vérifier
	 * @return		string						le contenu du message sous forme de chaine
	 *
	 */
	"checkContent" : function (msgContent, options) {
		if (msgContent) {
			if ( msgContent.innerHTML ) { msgContent = msgContent.innerHTML ; } // copie du contenu depuis le contenu d'un élément
			else { msgContent += "" ; } // convertir tout ce qui n'a pas de innerHTML en chaine
		}
		
		return msgContent;
	},
	
	
	/** preset() 
	 * --------------------------------------------------------------------------------------------
	 * enregistre un paramétrage
	 *
	 * @param		string		settingName		Le nom sous lequel enregistrer le paramétrage
	 * @param		string		msgContent		Le message par défaut pour ce paramétrage
	 * @param		object		settings		Les options par défaut pour ce paramétrage
	 * @return		void
	 * @access		public
	 */
	"preset" : function (settingName, msgContent, settings) {
		msgContent = this.checkContent(msgContent);
		settings = this.checkOptions(settings);
		this.presets[settingName] = {
			"msgContent" : msgContent,
			"settings" : settings
		};
	},
	
	
	/** reload() 
	 * --------------------------------------------------------------------------------------------
	 * affiche un message sur la base d'un paramétrage préenregistré
	 *
	 * @param		string		settingName		Le nom du paramétrage à charger
	 * @param		string		msgContent		Le message à afficher (optionnel)
	 * @param		object		settings		Les options de la boîte de message (optionnel)
	 * @return		void
	 * @access		public
	 *
	 */
	"reload" : function (settingName, msgContent, options) {
		// si nom de paramétrage incorrect, afficher une erreur (pour éviter des conflits d'options)
		if (!this.presets[settingName]) { this.open('param&eacute;trage "'+settingName+'" inconnu.',{"button" : "ok"}); }
		// sinon
		else {
			// le message et les options passés dans la fonction prévalent sur les paramètres enregistrés
			var finalMsgContent = msgContent ? msgContent : this.presets[settingName].msgContent;
			var finalOptions = {};
			this.transfer(this.presets[settingName].settings, finalOptions);
			this.transfer(options, finalOptions);
			this.open(finalMsgContent, finalOptions);
		}
	},
	
	
	/** replaceAlert() 
	 * --------------------------------------------------------------------------------------------
	 * pour que msg remplace la fonction alert() normale
	 *
	 * @return		void
	 * @access		public
	 *
	 */
	"replaceAlert" : function () {
		if (document.getElementById) {
			window.alert = function (msgContent, options) {
				msg.reload ( 'alert', msgContent, options);
			};
		}
	},
	
	
	/** close() 
	 * --------------------------------------------------------------------------------------------
	 * ferme le message
	 *
	 * @return		void
	 * @access		public
	 *
	 */
	 "close" : function () {
		if (document.getElementById(this.modalId) || document.getElementById("msgBox")) { // un message existe déjà
			// cas où l'écran est activé
			if ( document.getElementById(this.modalId) ) 
			{ 
				document.getElementsByTagName("body")[0].removeChild(document.getElementById(this.modalId)); 
			}
				
			// cas contraire (où on peut cliquer hors de l'alert)
			document.getElementsByTagName("body")[0].removeChild(document.getElementById("msgBox"));
			
			// vider le compte à rebour
			clearTimeout(this.closeMsgIn); 
			
			if (typeof(this.msgOptionsRec.onClose)=='function') 
			{
				this.msgOptionsRec.onClose();
			}	
		}
	},
	
	
	/** ajaxUpdate() 
	 * --------------------------------------------------------------------------------------------
	 * met à jour le contenu du message par requête ajax
	 *
	 * @return		void
	 * @access		private
	 *
	 */
	"ajaxUpdate" : function (url, options) {
		// créer l'objet xhr
		var xhr = null; 
		if (window.XMLHttpRequest) { xhr = new XMLHttpRequest(); } // Firefox et autres
		else if(window.ActiveXObject){ // Internet Explorer 
			try { xhr = new ActiveXObject("Msxml2.XMLHTTP"); }
			catch (e) { xhr = new ActiveXObject("Microsoft.XMLHTTP"); }
			}
		else { xhr = false; alert("Votre navigateur ne supporte pas les objets XMLHTTPRequest..."); } 
                   
		// exécuter la requête
		var abort ;
		xhr.onreadystatechange=function() {
			if(xhr.readyState==4) {
				clearTimeout(abort);
				document.getElementById('msgContent').innerHTML = xhr.responseText;
				msg.setPosition();
			} 
		};
		xhr.open( 'GET' , url , true ) ;
		abort = setTimeout( function(){
			var errorMsg = 
						"readyState = " + xhr.readyState + '<br >' +
						"status = " + xhr.status + '<br >' +
						"statusText = " + xhr.statusText + '<br >' +
						"";
			msg.open(errorMsg,{title:'abandon de la requ&ecirc;te ajax',delay:0});
			xhr.abort();
		}, options.ajaxAbortDelay*1000 );
		xhr.send(null) ;
	},
	
	
	
	/** build() 
	 * --------------------------------------------------------------------------------------------
	 * crée la boîte message dans le dom
	 *
	 * @param		string		msgContent		Le message à afficher (optionnel)
	 * @param		object		allOptions		Les options de la boîte de message (optionnel)
         * @return		void
	 * @access		private
	 *
	 */
	"build" : function (msgContent, allOptions) {

		// créer l'écran modal par dessus la page (optionnel)
			if (allOptions.modal) {
				// crée l'écran en tant que div, enfant du body
				var modalObj = document.getElementsByTagName("body")[0].appendChild(document.createElement("div"));
				modalObj.id = this.modalId;
				// s'assurer que l'écran couvre bien toute la hauteur de la page
				//RIJA alert('this.ie > 0 && this.ie<6 : '+ eval('this.ie > 0 && this.ie<6'));
				if (this.ie>0 && this.ie<6) 
				{ 
				  modalObj.style.height = document.body.scrollHeight + "px"; 
				}
				else 
				{ 
				  //RIJA alert('AV modalObj.style.height : '+modalObj.style.height);
				  if (this.ie < 8)
				  {  modalObj.style.height = document.documentElement.scrollHeight + "px"; }
				  else
				  {  modalObj.style.height = document.body.scrollHeight + "px"; }
				  //RIJA alert('AP modalObj.style.height : '+modalObj.style.height);
				}
				
				// appliquer la couleur et l'opacité du modal
				modalObj.style.backgroundColor=allOptions.modalColor;
				if (this.ie) 
				{  modalObj.style.filter ="alpha(opacity="+parseInt(allOptions.modalOpacity*100,10)+")"; }
				else 
				{ modalObj.style.opacity=allOptions.modalOpacity; }
			}

		// créer la boîte de message, en tant que div enfant du body
			var msgBoxObj = document.getElementsByTagName("body")[0].appendChild(document.createElement("div"));
			msgBoxObj.id = "msgBox";
			msgBoxObj.className='msgBox';
			if (allOptions.className) 
			{ msgBoxObj.className+=' '+allOptions.className; } // appliquer une classe css de success|error|notice au message

		// préparer le contenu de la boîte
			// intégration du message dans le contexte demandé (optionnel)
			if (allOptions.context) {
				var contentReg = /(\$msg\$)/g;
				msgContent = allOptions.context.replace(contentReg, msgContent);
			}
			
			// intégration du message dans son block div
			var msgContentObj = '<div id="msgContent">'+msgContent+'</div>';
			
			// titre du message (optionnel)
			var titleObj = '';
			if (allOptions.title) { titleObj = '<div id="msgTitle">'+allOptions.title+'</div>'; }
			
			// bouton de fermeture (optionnel)
			var btn = '';
			if (allOptions.button || allOptions.button===0) { btn = '<div id="closeBtn"><a href="#" onclick="msg.close();return false;">' + allOptions.button + '</a></div>'; }
		
		// intégrer tout ça dans la boîte
		msgBoxObj.innerHTML = titleObj + "\n" + msgContentObj + "\n" + btn;
                
        // appliquer les options de style à la boîte
        this.transfer(allOptions.style, msgBoxObj.style);
        if (this.ie && this.ie<7 && msgBoxObj.offsetWidth>allOptions.ieMaxWidth) 
        {  msgBoxObj.style.width = allOptions.ieMaxWidth + 'px'; } // cheat max-width pour IE<7

		// positionner la boîte de message à l'endroit voulu de la fenêtre
		this.setPosition(allOptions.position);
                
        // charger le contenu ajax (optionnel)
        if (allOptions.ajaxContent) { this.ajaxUpdate(allOptions.ajaxContent, allOptions); }
	},
	
	
	/** open() 
	 * --------------------------------------------------------------------------------------------
	 * paramètre et déclenche l'affichage et le masquage du mesage
	 *
	 * @param		string		msgContent		Le message à afficher (optionnel)
	 * @param		object		allOptions		Les options de la boîte de message (optionnel)
	 * @return		void
	 * @access		public
	 *
	 */
	"open" : function (msgContent, options) {
		// vérifications syntaxiques
			msgContent = this.checkContent(msgContent);
			options = this.checkOptions(options);
			
		// si un message est déjà ouvert, le fermer
		if (document.getElementById('msgBox')) { msg.close(); }
		
		// écrasement (ponctuel) éventuel des paramètres par défaut
			var allOptions = {};
			this.transfer(this.def, allOptions);
			this.transfer(options, allOptions);

		// contenu du msg : nouveau (si donné) ou précédent (par défaut)
			if (msgContent) 
			{ if (allOptions.remember) { this.msgContentRec = msgContent; } }
			else 
			{ msgContent = this.msgContentRec; }

		// options du msg : nouvelles (si données) ou précédentes (par défaut)
			if (msgContent) 
			{ 
				if (allOptions.remember) 
			    	{ this.msgOptionsRec = allOptions; } 
			}
			else { 
				this.transfer(this.msgOptionsRec, allOptions);
				allOptions.modal = false;
				allOptions.delay = 0;
				allOptions.button = 'ok';
				allOptions.remember = false;
			}
		
		// affichage du message
			this.build(msgContent, allOptions);
		
		// programmer la disparition du message
			var delay = allOptions.delay; // ce sera plus lisible
			
			clearTimeout(this.closeMsgIn); // remet le chorno à zéro
			delay = delay*1000; // conversion des secondes en millisecondes
			if (delay>0) { this.closeMsgIn = setTimeout( function () {msg.close();} , delay ); } // lancer le compte à rebours, à moins qu'il ne soit négatif
			
		// lancer l'éventuelle fonction callBack
		if (typeof(allOptions.onOpen)=='function') 
		{allOptions.onOpen();}
	},
	
	
	/** init() 
	 * --------------------------------------------------------------------------------------------
	 * initialise la f°
	 * 
	 * @return		void
	 * @access		public
	 *
	 */     
	"init" : function() {
		this.ieVer();
		msg.autoSetPosition();
		//document.onmousemove = msg.mousePos;
		if (window.attachEvent) { // pour IE
			document.attachEvent('onmousemove', msg.mousePos);
		}
		else { // pour les autres
			window.addEventListener('mousemove', msg.mousePos, false);
		}
	},
		
	
	"faitesmoipaschieraveclesvirgules" : null
});


/* mise en place
------------------------------------------------------------- */
	 
// initialisation (indispensable)

msg.init();

// quelques préréglages (pas indispensables)

msg.preset( // message de type alert(), en plus joli
	"alert", // nom du réglage
	"!", // message par défaut
	{ // options par défaut
		"modal" : true,
		"title" : "attention !",
		"button" : "ok",
		"context" : '<img style="float:left;padding:0 .5em 0 0" src="msg.v2/alert.gif" />$msg$'
	}
);

msg.preset( // indiquer un chargement en cours (pense à fermer le message quand le chargement est terminé)r
	"loading", // nom du réglage
	"veuillez patienter...", // message par défaut
	{ // options par défaut
		"modal" : true,
		"button" : null,
		"title" : "chargement en cours",
		"context" : '<span style="padding-left:20px;background:transparent url(msg.v2/loader.gif) no-repeat left center;">$msg$</span>'
	}
);

msg.preset( // message sous forme d'infobulle
	"tip", // nom du réglage
	null, // message par défaut
	{ // options par défaut
		"delay" : 0,
		"button" : null,
		"position" : "mouse:mouse",
		"remember" : false
	}
);