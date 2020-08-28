<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>방명록 - 작성하기</title>
<style type="text/css">
	h2 { text-align: center; }
	div { text-align: center; margin: 20px auto; }
	table { width: 550px; margin: 0px auto; border-collapse: collapse; }
	table, tr, th, td { border: 1px solid black; padding: 10px; }
	thead { background-color: #55aaff; }
	fieldset { width: 300px; }
	.link { text-align: center; }
	.content { margin: 10px; }
	.pre { text-align: justify; }
</style>
<script type="text/javascript">
	function delete_ok(f) {
		// 비밀번호 검사
		if("${vo.pwd}" == f.pwd.value) {
			var chk = confirm("정말 삭제하시겠습니다?");
			if (chk) {
				f.action="delete_ok.do";
				f.submit();
			} else {
				history.go(-1);
			}
		} else {
			alert("비밀번호가 틀렸습니다. 다시 입력해주세요");
			f.pwd.value="";
			f.pwd.focus();
			return;
		}
	}
</script>
</head>

<body>
	<div align="center">
		<h2>방명록 : 작성화면</h2>
		<hr />
		<p>
			[<a href="list.do">목록으로 이동</a>]
		</p>
		<form method="post">
			<table>
				<tr align="center">
					<td bgcolor="#99ccff">비밀번호 입력</td>
					<td><input type="password" name="pwd" size="20"></td>
				</tr>
				<tfoot>
					<tr align="center">
						<td colspan="2">
							<input type="button" value="삭제" onclick="delete_ok(this.form)"> &nbsp; 
							<input type="reset" value="취소">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>