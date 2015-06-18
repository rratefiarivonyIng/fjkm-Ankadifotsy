
<%@page import="mg.fjkm.ankadifotsy.util.ConstantUtils"%>
<script language="javascript">
	function evalInnerHTML(){
		var div = document.getElementById('msgContent');
		eval(div.innerHTML);
	}

	function evalScript(){
		var div = document.getElementById('msgBox');
		var x = div.getElementsByTagName("script");
		for(var i=0;i<x.length;i++){
		    eval(x[i].text);
		}
	}
	
	function ajaxSubmitReq(){
		var req = new AjReq();
		var opts = {
			method : 'POST',
			params : 'laharana='+document.getElementById('laharanaTranga').value+'&daty='+document.getElementById('datyTranga').value+'&fitandremana='+document.getElementById('fitandremanaTranga').value,
			update : document.getElementById('msgContent'),
			abortAfter : 15000,
			onSuccess : function(){evalInnerHTML();}
		};
		req.send('editTranga.htm', opts);
	};

	<!-- Script pour l'edition d'un Batisa -->
	function editBatisaAjax(){
		var options = {
			ajaxContent:'editTranga.htm?<%=ConstantUtils.sfTRANGA_BATISA%>',
			modal:true,
			button:null
		}
		msg.open('Miandry kely', options);
		return false;
	};

	function editBatisa(){
		if (fjkmAnkadifotsyIsNavigatorIE()){
			if (fjkmAnkadifotsyVerIE() >= 8){
				editBatisaAjax();
			}
			else{
				editTranga('editTranga.htm?<%=ConstantUtils.sfTRANGA_BATISA%>&popup', 'Batisa', 360, 280);
			}
		}
		else{
			editBatisaAjax();
		}
	};
	
	<!-- script pour l'edition d'un Mpandray -->
	function editMpandrayAjax(){
		var options = {
			ajaxContent:'editTranga.htm?<%=ConstantUtils.sfTRANGA_MPANDRAY%>',
			modal:true,
			button:null
		}
		msg.open('Miandry kely', options);
		return false;
	};

	function editMpandray(){
		if (fjkmAnkadifotsyIsNavigatorIE()){
			if (fjkmAnkadifotsyVerIE() >= 8){
				editMpandrayAjax();
			}
			else{
				editTranga('editTranga.htm?<%=ConstantUtils.sfTRANGA_MPANDRAY%>&popup', 'Mpandray', 360, 280);
			}
		}
		else{
			editMpandrayAjax();
		}
	};
	
</script>