	<!--
	function getElementToolTipById(id)
	{
		return document.getElementById(id);
	}

	var toolTipVisible = false; // La variable i nous dit si la bulle est visible ou non
	
	function move(e) {
		if(toolTipVisible) {  // Si la bulle est visible, on calcul en temps reel sa position ideale
			if (navigator.appName!="Microsoft Internet Explorer") { // Si on est pas sous IE
	    		getElementToolTipById("curseur").style.left=e.pageX + 5+"px";
	    		getElementToolTipById("curseur").style.top=e.pageY + 10+"px";
	    	}
	    	else { // Modif proposé par TeDeum, merci à lui
	    		if(document.documentElement.clientWidth>0) {
	        		getElementToolTipById("curseur").style.left=20+event.x+document.documentElement.scrollLeft+"px";
	        		getElementToolTipById("curseur").style.top=10+event.y+document.documentElement.scrollTop+"px";
	    		}
	    		else {
	        		getElementToolTipById("curseur").style.left=20+event.x+document.body.scrollLeft+"px";
	        		getElementToolTipById("curseur").style.top=10+event.y+document.body.scrollTop+"px";
	    		}
	    	}
	  	}
	}
	
	function showToolTip(text) {
		if(toolTipVisible==false) {
			getElementToolTipById("curseur").style.visibility="visible"; // Si il est cacher (la verif n'est qu'une securité) on le rend visible.
			getElementToolTipById("curseur").innerHTML = text; // Cette fonction est a améliorer, il parait qu'elle n'est pas valide (mais elle marche)
			toolTipVisible=true;
		}
	}
	
	function hideToolTip() {
		if(toolTipVisible==true) {
			getElementToolTipById("curseur").style.visibility="hidden"; // Si la bulle etais visible on la cache
			toolTipVisible=false;
		}
	}
	
	document.onmousemove=move; // des que la souris bouge, on appelle la fonction move pour mettre a jour la position de la bulle.
	//-->
