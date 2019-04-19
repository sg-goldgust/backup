<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<!-- naver map api -->
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=rbeyz68rf5">
	
</script>
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=your_client_id&submodules=geocoder"></script>

<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">

<script>
	$(function() {
		$(".direction").click(function() {
			direction = $(this).data('direction')
			msg = JSON.stringify({
				msgType : 'CONTROL',
				target : 1,
				direction : direction
			});
			socket.send(msg)
		})

		var mapOptions = {
			center : new naver.maps.LatLng(37.3595704, 127.105399),
			zoom : 10
		};

		var map = new naver.maps.Map('map', mapOptions);

		var carMarker = new naver.maps.Marker({
			map : map,
			position : new naver.maps.LatLng(37.3595704, 127.105399)
		})

		if (!window.WebSocket) {
			alert('웹 소켓을 지원하지 않습니다.');
			return;
		}

		var socket = new WebSocket("ws://localhost:8080/naverApi/echo");
		socket.onopen = function() {
			console.log('접속 성공');

			var carMsg = {
				msgType : "POSITION_SUB",
				target : 1
			};

			var car_str = JSON.stringify(carMsg);
			socket.send(car_str);
		}

		socket.onclose = function() {
			console.log('접속 헤제');
		}

		socket.onmessage = function(msg) {
			console.log('데이터 수신 : ', msg.data);
			carMsg = JSON.parse(msg.data)
			if (carMsg.msgType == "POSITION") {
				position = new naver.maps.LatLng(carMsg.lat, carMsg.lng);
				map.setCenter(position)
				carMarker.setPosition(position)
			}
		}
		socket.onerror = function(err) {
			console.log('에러 ', err);
		}

		$('#send-btn').click(function() {
			var msg = $('#send-message').val();
			socket.send(msg);
		})

	});
</script>

<body>
	<div class="mx-auto" style="width: 500px">
		<h1>원격 조정</h1>
		<div id="map" style="width: 80%; height: 400px"></div>
		<div class="mt-5">
			<table>
				<tr>
					<td></td>
					<td>
					<button class = "direction" data-direction="UP"><i class="fas fa-angle-up"></i></button>
					</td>
					<td></td>
				</tr>
			</table>
		</div>
	</div>
</body>

</html>