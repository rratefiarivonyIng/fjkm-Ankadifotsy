/**
 * bubulle
 * =============================================================================
 * permet de cr�er des infobulles acceptant le html et css
 * 
 * @author      Erwan Lef�vre <erwan.lefevre@aposte.net>
 * @copyright   Erwan Lef�vre 2009
 * @license     Creative Commons - Paternit� 2.0 France - http://creativecommons.org/licenses/by/2.0/fr/
 * @version     2.1.1 / 2010-06-02
 * @see			http://www.webbricks.org/bricks/bubulle/
 * 
 * @compatible	au 2 juin 2010, compatibilit� assur�e pour :
 *				Firefox 1.5+, Internet Explorer 5.5+, Safari 3.2.3., Op�ra 10.53, Chrome 4.1 
 *				Autres versions et navigateurs non test�s
 */


/* exemple

-	dans le html :

		<a href="#" onmouseover="bubulle.hop('patatie et patata', {classe:'ma_classe_css'})" onmouseout="bubule.php();">une bulle ici</a>
		
		
-	ou en javascript non intrusif (plus pratique pour passer plusieurs options)

		var contenu = 'patatie et patata';
		var actionneur = document.getElementById('mon_element');
		var options = {
			classe : 'ma_classe_css',
			persistance : -1,
			delai : 0,
			fixe apr�s : 0
		};
		bubulle.apply( actionneur , contenu , options );
		
-	astuce : copier le contenu de la bulle depuis un �l�ment cach� dans le dom (display:none)

		var contenu = document.getElementById('modele').innerHTML;
		var actionneur = document.getElementById('mon_element');
		bubulle.apply( actionneur , contenu );

*/





/**
 * byId()
 * raccourci pour document.getElementById()
 * retourne l'�l�ment html dont l'attribut id vaut /id/
 *
 * @param		id		{String}		L'attribut id de l'�l�ment recherch�
 *
 * @returns		{HTMLElement}
 * 
 * =============================================================================
 */
function byId(id) {
	return document.getElementById(id) ;
}





/**
 * addEvent()
 * 
 * ajoute la fonction /fn/ � la pile de r�solution de l'�v�nement /evenType/ de
 * l'objet /obj/
 * 
 * merci � : http://www.scottandrew.com/weblog/articles/cbs-events
 *
 * @param		{Mixed}				obj			window, ou document, ou un �l�ment HTML
 * @param		{String}			evType		type d'event (click, mouseover, mouseout, etc.)
 * @param		{String}			fn			la fonction � ajouter
 * @param		{Boolean}			useCapture	"useCapture un bool�en : true pour la phase de capture, ou false pour la phase de bouillonnement et la cible. On utilise quasiment toujours la valeur false."
 * 
 * @returns		void
 * 
 * =============================================================================
 */
function addEvent (obj, evType, fn, useCapture){
	if (obj.addEventListener) { obj.addEventListener(evType, fn, useCapture); }
	else { obj.attachEvent("on"+evType, fn); }
}




/**
 * remEvent()
 * 
 * retire la fonction /fn/ de la pile de r�solution de l'�v�nement /evenType/ de
 * l'objet /obj/
 * 
 * merci � : http://www.scottandrew.com/weblog/articles/cbs-events
 * 
 * @param		{Mixed}			obj			window, ou document, ou un �l�ment HTML
 * @param		{string}		evType		type d'event (click, mouseover, mouseout, etc.)
 * @param		{string}		fn			la fonction � supprimer
 * @param		{boolean}		useCapture	"useCapture un bool�en : true pour la phase de capture, ou false pour la phase de bouillonnement et la cible. On utilise quasiment toujours la valeur false."
 * 
 * @returns		void
 * 
 * =============================================================================
 */
function remEvent(obj, evType, fn, useCapture){
	if (obj.removeEventListener) { obj.removeEventListener(evType, fn, useCapture); }
	else { obj.detachEvent("on"+evType, fn); }
}




var mousePos = {'x':0,'y':0};
function getMousePos(e) {
	var d = document,
		de = d.documentElement,
		db = document.body;
	
	e = e || window.event;
	if (e.pageX || e.pageY) {
		mousePos.x = e.pageX;
		mousePos.y = e.pageY;
	}
	else if (e.clientX || e.clientY) {
		mousePos.x = e.clientX + db.scrollLeft + de.scrollLeft;
		mousePos.y = e.clientY + db.scrollTop + de.scrollTop;
	}
}
/**
 * mise en place du relev� de coordon�es de la souris, en cas de d�placement de la souris
 */
addEvent(document, 'mousemove', getMousePos);




/** scrolled() 
 * =============================================================================
 * retoune les valeurs (horizontale et verticale) de d�filement de la fen�tre
 * (en tenant compte du navigateur)
 *
 * @return          Object      {'x','y'}         
 */
function scrolled () {
    var x,y;
    
    // vrais navigateurs
    if ( window.pageXOffset!==undefined) {
        x = window.pageXOffset;
        y = window.pageYOffset;
    }
    // ie
    else {
        x = document.documentElement.scrollLeft ? document.documentElement.scrollLeft : (document.body.scrollLeft?document.body.scrollLeft:0) ;
        y = document.documentElement.scrollTop ? document.documentElement.scrollTop : (document.body.scrollTop?document.body.scrollTop:0) ;
    }
    
    return {'x':x, 'y':y};
}





/**
 * transfer
 * =============================================================================
 * retourne un objet contenant les propri�t�s et m�thodes de l'objet /dest/,
 * compl�t�es et/ou �cras�es par celles de l'objet /source/
 *
 * @param       source       {object}        l'objet source
 * @param       dest         {object}        l'objet de destination
 * @return      {object}
 *
 */
function transfer (source, dest) {
    var prop, transfered={};
    for ( prop in dest ) { transfered[prop] = dest[prop]; }
    for ( prop in source ) { transfered[prop] = source[prop]; }
    return transfered; 
}




/** 
 * winDim() 
 * -----------------------------------------------------------------------------
 * retourne les dimentions int�rieurs de la fen�tre
 *
 * @return		{Object}
 */

function winDim() {
	var w,h,
		i = window,
		d = document,
		de = d.documentElement,
		db = d.body;
		
	if ( i.innerWidth ) { // autres que IE
		w = i.innerWidth;
		h = i.innerHeight;
	} else if ( de.clientWidth ) { // IE8
		w = de.clientWidth;
		h = de.clientHeight;
	}
	else { // IE6
		w = db.clientWidth;
		h = db.clientHeight;
	}

	return {'w':w, 'h':h} ;
}





/**
 * bubulle 2.1.1
 * =============================================================================
 * permet de cr�er des infobulles acceptant le html et les css
 * 
 * @uses	addEvent
 * @uses	byId
 * @uses	mousePos
 * @uses	remEvent
 * @uses	scrolled
 * @uses	transfer
 * @uses	winDim
 * @optionnal		AjReq		pour charger le contenu de la bulle par ajax
 * @optionnal		setOpacity	pour faire appara�tre la bulle en fondu
 * @optionnal		fade		pour faire appara�tre la bulle en fondu
 * 
 */
var bubulle = {
	/**
	 * parDefaut
	 * -------------------------------------------------------------------------
	 * r�glages par d�faut
	 * 
	 */
	parDefaut : {
		classe : null,			// classe css � appliquer � la bulle
		contenuAjax : null,		// en cas de chargement du contenu de la bulle par ajax, url du fichier � interroger (requiert AjReq.js)
		fonduOpt : {			// options du fondu (requiert fade.js. Voir ce fichier pour le d�tail des options)
			duration : 500
		},
		fixeApres : 200,		// avant ce d�lai (en milliseconde), la bulle bouge avec la souris.
								//		ce d�lai est diminu� du montant de l'option "delai"
								//		-1 fait que la bulle bougera tout le temps avec la souris
								//		avec survolBulle:true + delai:0, je pr�conise de ne pas mettre fixeApres � 0, car il faut laisser un peut de temps � l'utilisateur pour stabiliser sa main (200ms peuvent faire l'affaire)
		
		// options li�es � la persistance de la bulle
		actionneur : null,		// rappel de l'�l�ment actionnant la bulle (factultatif avec bubulle.apply)
		survolBulle : 0,		// indique si survoler la bulle la maintient ouverte
		persistance : 0,		// dur�e pdt laquelle la bulle reste affich�e, m�me apr�s mouseout. (-1 pour qu'elle ne disparaisse pas sur mouseout),
		delai : 200,			// d�lai avant affichage de la bulle ()
		
		rien : 0				// pour pas me prendre la t�te avec les vigules
	},
	
	/**
	 * parici()
	 * -------------------------------------------------------------------------
	 * positionne la bulle
	 * 
	 */
	parici : function() {
		var bulle = byId('bubulle');
		if (bulle) {
			var winDims = winDim();
			var winPos = scrolled();
			
			// position horizontale
			var bordDroit = mousePos.x + bulle.offsetWidth ;
			bulle.style.left = ( (bordDroit>winDims.w) ? mousePos.x - (bordDroit - winDims.w) : mousePos.x) + "px";
	
			// position verticale
			var auDessus = mousePos.y - (bulle.offsetHeight + 5);
			bulle.style.top = ( (auDessus<winPos.y) ? mousePos.y + 10 : auDessus) + "px";
		}
	},
	
	
	
	
	/**
	 * hop()
	 * -------------------------------------------------------------------------
	 * programme l'ouverture d'une infobulle avec le message /blabla/ et les options /options/
	 *
	 * @param		{mixed}		blabla		voir bubulle.open()
	 * @param		{object}	options		(facultatif) voir bubulle.open()
	 * 
	 */
	hop : function (blabla, options) {
		
		// lectude du d�lai avant ouverture
		options = transfer(options, this.parDefaut);
		if (options.fixeApres>0) {
			var diff = options.fixeApres-options.delai;
			options.fixeApres = diff<0 ? 0 : diff;
		}
		this.options = options;
				
		// programmation de l'ouverture
		this.prog = setTimeout(function(){
			bubulle.creer(blabla, options);
		},options.delai||1);
	},
	
	
	
	
	/**
	 * creer()
	 * -------------------------------------------------------------------------
	 * ouvre (imm�diatement) une infobulle avec le message /blabla/ et les options /options/
	 * (normalement, cette m�thode ne doit �tre activ�e que par l'interm�diaire de "hop")
	 *
	 * @param		{String}	blabla		le message � afficher dans la bulle.
	 * @param		{object}	options		(facultatif) les options pour cette bulle (voir this.parDefaut)
	 */
	creer : function (blabla, options) {
		
		this.hover = true;
		
		// si on est toujours sur le m�me actionneur
		if (this.actionneur==options.actionneur){
			this.pop(); // reprogrammer la fermeture de la bulle
		}
		// si on est sur un nouvel actionneur
		else {
			// une seule bulle � la fois : s'il en existe une, on la ferme
			
				this.hover=0;
				this.achever(); 
				this.actionneur = options.actionneur;
			
			// cr�ation de la bulle + param�tres de base
			
				var bulle = document.createElement("div");
				bulle.id = "bubulle"; // pour la retrouver facilement
				bulle.innerHTML = blabla; // contenu de la bulle
				bulle.style.position = "absolute";
				bulle.style.top = bulle.style.left = '0px'; bulle.style.zIndex = -9; // temporaire. Evite des probl�mes d'affichages avec les syst�mes un peu lents
				document.getElementsByTagName("body")[0].appendChild(bulle); // pour ie, je suis contraint d'ins�rer ma bulle ds la page avant d'appeler parici()
				bulle.className = options.classe; // classe : design de la bulle (doit �tre trait� avant le positionnement de la bulle)
				bubulle.parici(); // positionnement initial
				bulle.style.zIndex = '';
				if (window.setOpacity) {setOpacity(bulle,0);} // pr�pare l'apparition en fondu, si le script existe
				
			// gestion des options (autres que la classe css)
				
				// lecture des options
				options = transfer(options, this.parDefaut);
				this.options = options;
				
				// survolBulle : reporter fermeture tant qu'on survolle la bulle
				if (options.survolBulle) {
					bulle.onmouseover=function(){bubulle.hover=1;};
					bulle.onmouseout=this.pop;
				}
				
				// contenuAjax : chargement du contenu ajax
				if (options.contenuAjax && window.AjReq) { // n'activer que si le script AjReq a �t� d�clar�
					this.ajax = new AjReq();
					this.ajax.send(options.contenuAjax,{ // lancer un requ�te ajax
						forceMime : 'text/html',
						onSuccess : function(){ // si la requ�te aboutit...
							var b = byId('bubulle');
							if (b) { b.innerHTML=bubulle.ajax.back.response; } // ...modifier le contenu de labulle...
							bubulle.parici(); // ...puis la repositionner.
						}
					});
				}
				
				// fonduOpt : apparition en fondu
				if (window.fade) {
					options.fonduOpt.duration = options.fonduOpt.duration||1;
					fade(bulle,1,0,options.fonduOpt);
				}
				
				// fixeApres : mobilit� de la bulle
				var fixeApres = options.fixeApres;
				remEvent(window, 'mousemove', bubulle.parici);
				addEvent(window, 'mousemove', bubulle.parici);
				if (fixeApres>=0) {
					setTimeout(
						function(){ remEvent(window, 'mousemove', bubulle.parici);},
						fixeApres||1
					);
				}
		}
	},
	
	
	
	
	/**
	 * deprog()
	 * -------------------------------------------------------------------------
	 * annule la programmation de fermeture (acherver) ou d'ouverture (creer) de la bulle
	 *
	 */
	deprog : function () {
		if(this.prog){
			clearTimeout(this.prog);
			this.prog=0;
		}
	},
	
	
	
	
	/**
	 * achever()
	 * -------------------------------------------------------------------------
	 * ferme l'infobulle pour de bon
	 *
	 */
	achever : function () {
		var bulle = byId("bubulle");
		if (bulle && !bubulle.hover) {
			bubulle.deprog();
			bubulle.actionneur=0;
			if (bulle) { document.getElementsByTagName("body")[0].removeChild(bulle); }
			if (bubulle.ajax) { bubulle.ajax.abort(); bubulle.ajax=0; }
		}
	},
	
	
	
	
	/**
	 * pop()
	 * -------------------------------------------------------------------------
	 * programme la fermeture de l'infobulle
	 *
	 */
	pop : function () {
		bubulle.hover=0;
		bubulle.deprog();
		bubulle.prog = setTimeout( bubulle.achever , bubulle.options.persistance );
	},
	
	
	
	
	/**
	 * apply()
	 * -------------------------------------------------------------------------
	 * met en place une infobulle sur l'�l�ment /elem/, contenant le texte /blabla/,
	 * avec les options /options/
	 *
	 * @param		elem		{HMLTElement}		l'�l�ment auquel appliquer l'infobulle
	 * @param		blabla		{String}			le message � afficher dans la bulle.
	 * @param		options		{Object}			les options pour cette bulle (voir this.parDefaut)
	 */
	apply : function (elem, blabla, options) {
		// pr�paration des options
		options = transfer(options, this.parDefaut); // lecture des options
		options.actionneur = options.actionneur || elem; // une option � part
		
		// mise en place des events sur l'�l�ment HTML
		addEvent(elem,'mouseover',function(){bubulle.hop(blabla,options);});
		if (options.persistance>=0) { addEvent(elem,'mouseout',bubulle.pop); }
	}
};