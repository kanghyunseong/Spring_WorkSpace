<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../include/header.jsp" />
	<div class="innerOuter">
		<button class="btn btn-sm btn-info" onclick="beef();">안심식당정보
			보기</button>
		<table class="table">
			<thead>
				<tr>
					<th>식당명</th>
					<th>주소</th>
					<th>전화번호</th>
				</tr>
			</thead>
			<tbody>

			</tbody>
		</table>
	</div>

	<script>
	function beef() {
		$.ajax({
			url : 'api/beef',
			success : result => {
				// console.log(result);
				// console.log(result.Grid_20200713000000000605_1.row);
				const resultEl = result.Grid_20200713000000000605_1.row;
				const el = resultEl.map(e => `
												<tr>
														<td>\${e.RELAX_RSTRNT_NM}</td>
														<td>\${e.RELAX_ADD1}</td>
														<td>\${e.RELAX_RSTRNT_TEL}</td>
												</tr>
											`).join('');
				document.querySelector('tbody').innerHTML = el;
			}
		});
	}
	</script>

	<jsp:include page="../include/footer.jsp" />
</body>
</html>