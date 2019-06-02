<!doctype html>
<!-- 
p.277 [리스트 11.9] 회원가입 화면
 -->
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>글 쓰기</title>
</head>
<body>
	<h2>글 쓰기</h2>
	<form action="./app/letter/send" method="post">
		<p>
			받는 사람:<br> <input type="text" name="receiverId"
				value="${param.receiverId }" required autofocus>
		</p>
		<p>
			제목:<br> <input type="text" name="title" value="${param.title }"
				required autofocus>
		</p>
		<p>
			내용:<br>
			<textarea name="content" style="width: 100%; height: 200px;" required></textarea>
		</p>
		<button type="submit">Send</button>
		<button type="submit" onclick="history.back()">취소</button>
	</form>
</body>
</html>