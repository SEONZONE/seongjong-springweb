<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<!-- 
회원 목록
-->
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>편지 목록</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<td>편지번호</td>
				<td>제목</td>
				<td>보낸사람</td>
				<td>받는사람</td>
				<td>날짜</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="receive" items="${receiveList}">
				<tr>
					<td><a href="./app/letter/view?letterId=${receiver.articleId}">${receiver.articleId}</a></td>
					<td>${receive.title }</td>
					<td>${receive.senderName }</td>
					<td>${receive.receiverName }</td>
					<td>${receive.cdate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</head>
</html>