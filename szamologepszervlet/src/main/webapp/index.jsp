<html>
 <head>
 <title>Számológép</title>
 </head>
<body>
<h2>Számológép</h2>
	<form method="POST" action="/szamologep.do">
		<input type="text" name="a"/>
		<input type="text" name="b"/>
		<select name="operator">
			<option value="+"/> +
			<option value="-"/> -
			<option value="*"/> *
			<option value="/"/> /
		</select><br>
		
		<input type="submit"/><br>
	</form>
</body>
</html>
