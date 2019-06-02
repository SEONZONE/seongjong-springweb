<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<!-- p.291 [리스트 11.18] main 화면 -->
<html>
<head>
<base href="${pageContext.request.contextPath }/" />
<title>메인</title>
</head>
<body>
	<p>환영합니다.</p>
	<!-- 로그인 여부에 따라 분기 -->
	<c:choose>

		<c:when test="${!empty sessionScope.MEMBER }">
			<!--  sessionScope가 존재하면 when 은 if 문 과 같다 session 영역에 로그인이 안되면 로그인 화면으로 빠진다..  -->
			<!-- 로그인 했을 경우 -->
			<p>
				memberId: ${MEMBER.memberId }, email: ${MEMBER.email }, name:
				<!-- 밑에서부터 찾아 올라온다 . when 문은 한번에 찾는다. 교수님은 session attribute 는 when 으로 하는것을 선호 한다.  -->
				${MEMBER.name }
			</p>
			<p>
				<a href="./app/logout">[로그아웃]</a>
			</p>
		</c:when>
		<c:otherwise>
			<!-- 로그인 하지 않았을 경우 -->
			<p>
				<a href="./app/loginForm">[로그인]</a>
			</p>
			<p>
				<a href="./app/register/step1">[회원 가입]</a>
			</p>
		</c:otherwise>
	</c:choose>
	<p>
		<a href="./app/members">[회원 목록]</a>
	</p>
	<p>

		<a href="./app/article/list">[게시판]</a>
	</p>
</body>
</head>
</html>