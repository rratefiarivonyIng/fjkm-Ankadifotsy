<link rel="stylesheet" href="css/autocompletion/dropdown.css" type="text/css" media="all"/>
<link rel="stylesheet" href="css/autocompletion/page.css" type="text/css" media="all"/>
<link rel="stylesheet" href="css/autocompletion/SyntaxHighlighter.css" type="text/css" media="all"/>

<script type="text/javascript" src="scripts/autocompletion/acdropdown.js"></script>
<script type="text/javascript" src="scripts/autocompletion/getobject2.js"></script>
<script type="text/javascript" src="scripts/autocompletion/modomevent3.js"></script>
<script type="text/javascript" src="scripts/autocompletion/modomext.js"></script>
<script type="text/javascript" src="scripts/autocompletion/modomt.js"></script>
<script type="text/javascript" src="scripts/autocompletion/shCore.js"></script>
<script type="text/javascript" src="scripts/autocompletion/shBrushXML.js"></script>
<script type="text/javascript" src="scripts/autocompletion/tabs2.js"></script>
<script type="text/javascript" src="scripts/autocompletion/xmlextras.js"></script>
<script language="javascript">
    function toggleCode( hEvent )
    {
      cDomEvent.init( hEvent );
      var hLink = cDomEvent.target;
      var hREX = new RegExp( 'codeblock:(.*)', 'ig' );
      hLink.getAttribute( 'target' ).match( hREX );
      var sBlockId = RegExp.$1;
      var hCodeBlock = document.getElementById( sBlockId );
      hCodeBlock.style.display = hCodeBlock.style.display == 'block' ? 'none' : 'block';
      hLink.blur();
      return false;
    }
    function attachToggleCode( hLink )
    {
      hLink.onclick = toggleCode;
      hLink.className = 'codeToggle';
    }
    cDomExtensionManager.register( new cDomExtension( document, [ 'a[target*=codeblock]' ], attachToggleCode ) );
    function onLoadInit()
    {
      dp.SyntaxHighlighter.HighlightAll('code');
    }
    cDomEvent.addEvent( window, 'load', onLoadInit );
</script>
