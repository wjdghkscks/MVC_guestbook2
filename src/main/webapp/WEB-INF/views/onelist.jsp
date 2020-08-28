<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	function update_go(f) {
		f.action = "update.do";
		f.submit();
	}
	function delete_go(f) {
		f.action = "delete.do";
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
						<td>${vo.name}</td>
					</tr>
					<tr>
						<td style="background-color: #55aaff;">제목</td>
						<td>${vo.subject}</td>
					</tr>
					<tr>
						<td style="background-color: #55aaff;">파일</td>
						<td><a href="down.do">${vo.file_name}</a></td>
					</tr>
					<tr>
						<td style="background-color: #55aaff;">이메일</td>
						<td>${vo.email}</td>
					</tr>
					<tr>
						<td colspan="2" style="background-color: #55aaff;">내 용</td>
					</tr>
					<tr class="content">
						<td colspan="2" style="text-align: left; padding-left: 50px">
								<pre>${vo.content}</pre>
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2">
							<input type="button" value="수정" onclick="update_go(this.form)"> 
							<input type="reset" value="삭제" onclick="delete_go(this.form)">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>

</body>
</html>