<html>
 <head>
 <title>Sz�mol�g�p</title>
 </head>
<body style="text-align:center; margin:auto;">
<h2>Sz�mol�g�p</h2>
	<%
	//ha servettol jott, akkor van, ha elso keres, akkor nincs
	szamologepszervlet.ResultDto result = (request.getAttribute("result") != null) ? 
			(szamologepszervlet.ResultDto) request.getAttribute("result") :
				new szamologepszervlet.ResultDto();
	
	String resultText = (result == null) ? "az eredm�ny null!":"result: " +result.toString(); 
	%>
	<form method="POST" action="/szamologepszervlet/szamologep.do">
		<input type="text" name="a"/><br>
		<input type="text" name="b"/><br>
		<select name="operator">
			<option value="+" /> +
			<option value="-" /> -
			<option value="*" /> *
			<option value="/" /> /
		</select><br>
		
		<%= resultText %>
		<br><input type="submit"/><br>
	</form>
	ver0.5
</body>
</html>
