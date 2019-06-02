<!--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>-->
<!doctype html>
<!-- 
회원 목록
-->
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>글 정보</title>
</head>
<body>
	<%@ include file="/WEB-INF/jsp/header.jsp"%>
	<table>
		<tbody>
			<tr>
				<td>편지 번호</td>
				<td>${LETTER.letterId }</td>
			</tr>
			<tr>
				<td>편지 제목</td>
				<td>${LETTER.title }</td>
			</tr>
			<tr>
				<td>편지 내용</td>
				<td><p>${LETTER.getContentHtml() }</p></td>
			</tr>
			<tr>
				<td>보낸 시람</td>
				<td>${LETTER.senderName }</td>
			</tr>
			<tr>
				<td>받는 시람</td>
				<td>${LETTER.receiverName}</td>
			</tr>
			<tr>
				<td>작성 시간</td>
				<td>${LETTER.cdate }</td>
			</tr>
		</tbody>
	</table>
	<c:if
		test="${LETTER.senderId==sessionScope.MEMBER.memberId || LETTER.receiverId==sessionScope.MEMBER.memberId}">
		<a href="./app/letter/delete?letterId=${LETTER.letterId}">삭제하기</a>
	</c:if>
	<p>
		<button type="submit" onclick="history.back()">[뒤로 돌아가기]</button>
	</p>
</body>
</html>