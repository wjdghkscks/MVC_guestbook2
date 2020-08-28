<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>방명록</title>
<style type="text/css">
	h2 { text-align: center; }
	div { text-align: center; margin: 20px auto; }
	table { width: 550px; margin: 0px auto; border-collapse: collapse; }
	table, tr, th, td { border: 1px solid black; padding: 10px; }
	fieldset { width: 300px; }
	.link { text-align: center; }
	.content { margin: 10px; }
	.pre { text-align: justify; }
</style>
<script type="text/javascript">
	function write_ok(f) {
		// 유효성 검사
		var name = f.name.value;
		if(name == "") {
			alert("작성자 이름을 입력하세요.");
			f.name.value="";
			f.name.focus();
			return;
		}
		var subject = f.subject.value;
		if(subject == "") {
			alert("제목을 입력하세요.");
			f.subject.value="";
			f.subject.focus();
			return;
		}
		var email = f.email.value;
		if(email == "") {
			alert("이메일을 입력하세요.");
			f.email.value="";
			f.email.focus();
			return;
		}
		var pwd = f.pwd.value;
		if(pwd == "") {
			alert("비밀번호를 입력하세요.");
			f.pwd.value="";
			f.pwd.focus();
			return;
		}
		f.action="write_ok.do";
		f.submit();
	}
</script>
</head>

<body>

	<div>
		<h2>방명록</h2>
		<p>
			[<a href="list.do">목록으로 돌아가기</a>]
		</p>
	</div>
	<div>
		<form method="post" enctype="multipart/form-data">
			<table>
				<tbody>
					<tr>
						<td style="background-color: #55aaff;">작성자</td>
						<td><input type="text" name="name" size="20"></td>
					</tr>
					<tr>
						<td style="background-color: #55aaff;">제목</td>
						<td><input type="text" name="subject" size="20"></td>
					</tr>
					<tr>
						<td style="background-color: #55aaff;">이메일</td>
						<td><input type="text" name="email" size="20"></td>
					</tr>
					<tr>
						<td style="background-color: #55aaff;">비밀번호</td>
						<td><input type="password" name="pwd" size="20"></td>
					</tr>
					<tr>
						<td style="background-color: #55aaff;">파일</td>
						<td><input type="file" name="file_name" size="20"></td>
					</tr>
					<tr class="content">
						<td colspan="2">
							<script src="//cdn.ckeditor.com/4.14.1/standard/ckeditor.js"></script>
								<textarea name="content"></textarea>
		                		<script>
		                        	CKEDITOR.replace("content");
		                		</script>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="button" value="저장" onclick="write_ok(this.form)"> 
							<input type="reset" value="취소">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>

</body>
</html>