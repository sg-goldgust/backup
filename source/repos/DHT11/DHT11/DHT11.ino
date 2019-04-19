/*
 Name:		DHT11.ino
 Created:	2019-01-17 오후 1:51:36
 Author:	student
*/
#include <DHT11_library/DHT11.h>

DHT11 dht11(2);
// the setup function runs once when you press reset or power the board
void setup() {
	Serial.begin(9600);
}

// the loop function runs over and over again until power down or reset
void loop() {
	delay(2000);
	int err;
	float temp, humi;
	err = dht11.read(humi, temp);
	if (err == 0) {
		//읽기 서옥
		Serial.print("온도: ");
		Serial.print(temp);
		Serial.print("습도: ");
		Serial.print(humi);
	}
	else {
		Serial.print(err);
	}
	delay(2000);


  
}
