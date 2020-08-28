<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	button {
		text-align: center;
		font-size: 3vw;
		padding: 1vw;
		margin: 0 auto;
	}
</style>
<script type="text/javascript">
	function list_go() {
		location.href = "list.do";
	}
</script>
</head>
<body>
	<button onclick="list_go()">방명록 리스트</button>
</body>
</html>